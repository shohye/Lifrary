package ksmart.pentagon.booklend;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.Point;


/***
 * @file BookLendController.java
 * @name BookLendController
 * @brief 대출,반납,예약도서관련 주소요청 처리
 * @author 최지혜
 */
@Controller
public class BookLendController {
	@Autowired private BookLendService bookLendService;
	
	//대출도서리스트
	/***
	 * @param model
	 * @brief 대출도서리스트
	 * @return /adminpage/bookLend/lendSearchList
	 * @author 최지혜
	 */
	@GetMapping("/admin/lendSearchList")
	public String LendSearchList(Model model, HttpSession session){
		
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("lendList", bookLendService.bookSearchList(libNum));
		 
		return "/adminpage/bookLend/lendSearchList";
	}
	

	/**
	 * @param svBook 도서검색 값
	 * @param svUser 회원검색 값
	 * @param redirectAttributes
	 * @brief 도서정보 검색
	 * @return /admin/lendSearchList
	 * @author 최지혜
	 */
	@PostMapping("/admin/lendBookInfo")
	public String lendBookInfo(  @RequestParam(value="svBook" ) String svBook
								, @RequestParam(value="svUser", required=false) String svUser
								, HttpSession session
								, RedirectAttributes redirectAttributes){
		
		System.out.println("svBook: " + svBook);
		System.out.println("svUser: " + svBook);
		String libNum = (String) session.getAttribute("LIBNUM");
		
		//도서정보만 검색
		if(svUser == null || svUser.equals("")) {

			Map<String, Object> bookInfoMap = bookLendService.bookInfo(libNum,svBook);
			
			//결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchBook", bookInfoMap.get("searchBook"));
			redirectAttributes.addFlashAttribute("resultBook", bookInfoMap.get("resultBook"));
					
			//반납안된 도서인 경우 회원정보포함하여 보내기
			if(bookInfoMap.get("resultUser") != null) {
				redirectAttributes.addFlashAttribute("resultUser", bookInfoMap.get("resultUser"));	
			}
		
		}
		//도서+회원정보 검색
		else {
			//도서
			Map<String, Object> bookInfoMap = bookLendService.bookInfo(libNum, svBook);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchBook", bookInfoMap.get("searchBook"));
			redirectAttributes.addFlashAttribute("resultBook", bookInfoMap.get("resultBook"));
			
			//회원
			Map<String, Object> userInfoMap = bookLendService.userInfo(libNum, svUser);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("resultUser", userInfoMap.get("resultUser"));
			
		}
		
		return "redirect:/admin/lendSearchList";
	}
	
	
	/**
	 * @param svUser 회원검색 값
	 * @param svBook 도서검색 값
	 * @param redirectAttributes
	 * @brief 회원정보검색
	 * @return /admin/lendSearchList
	 * @author 최지혜
	 */
	@PostMapping("/admin/lendUserInfo")
	public String lendUserInfo(  @RequestParam(value="svUser" ) String svUser
								, @RequestParam(value="svBook", required=false) String svBook
								, HttpSession session
								, RedirectAttributes redirectAttributes){
		
		System.out.println("svUser: " + svUser);
		System.out.println("svBook: " + svBook);
		String libNum = (String) session.getAttribute("LIBNUM");
			
		//회원정보만 검색
		if(svBook == null || svBook.equals("")) {
			
			Map<String, Object> userInfoMap = bookLendService.userInfo(libNum, svUser);
			
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchUser", userInfoMap.get("searchUser"));
			redirectAttributes.addFlashAttribute("resultUser", userInfoMap.get("resultUser"));
			
		}
		
		//도서+회원정보 검색
		else {
			//도서
			Map<String, Object> bookInfoMap = bookLendService.bookInfo(libNum, svBook);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchBook", bookInfoMap.get("searchBook"));
			redirectAttributes.addFlashAttribute("resultBook", bookInfoMap.get("resultBook"));
			
	
			//회원
			Map<String, Object> userInfoMap = bookLendService.userInfo(libNum, svUser);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchUser", userInfoMap.get("searchUser"));
			redirectAttributes.addFlashAttribute("resultUser", userInfoMap.get("resultUser"));
		}

		return "redirect:/admin/lendSearchList";
	}
	/**
	 * @param booklend 대출도서정보
	 * @param session
	 * @param redirectAttributes
	 * @brief 대출도서 등록
	 * @return /admin/lendSearchList
	 * @author 최지혜
	 */
	@PostMapping("/admin/lendInsert")
	public String lendInsert(BookLend booklend
							 , HttpSession session
							 , RedirectAttributes redirectAttributes){
		
		//도서관번호, 사서아이디 
		String libNum = (String) session.getAttribute("LIBNUM");
		String saId = (String) session.getAttribute("SAID");
		
		booklend.setlCode(libNum);
		booklend.setuId(saId);
		
		int result = bookLendService.lendInsert(booklend);
		System.out.println(result);
		
		redirectAttributes.addFlashAttribute("resultInsert", result);
	
		return "redirect:/admin/lendSearchList";
		
	}	

	/**
	 * 
	 * @param blCode 대출도서코드
	 * @param bsCode 소장도서코드
	 * @param redirectAttributes
	 * @brief 반납 등록
	 * @return /admin/lendSearchList
	 * @author 최지혜
	 */
	@PostMapping("/admin/returnUpdate")
	public String returnUpdate(	 @RequestParam(value="blCode" ) String blCode
								, @RequestParam(value="bsCode" ) String bsCode
								, @RequestParam(value="blId" ) String blId
								, HttpSession session
			 					, RedirectAttributes redirectAttributes) {

		String libNum = (String) session.getAttribute("LIBNUM");

		//포인트 생성
		Point point = new Point();
		point.setlCode(libNum);
		point.setuId(blId);
		point.setpCode("p001");
				
		int result = bookLendService.returnUpdate(blCode, bsCode, point);
		System.out.println(result);
		
		redirectAttributes.addFlashAttribute("resultUpdate", result);
		
		return "redirect:/admin/lendSearchList";
	}
	/**
	 * @param blCode
	 * @param ulLendDay
	 * @param session
	 * @param redirectAttributes
	 * @brief 예약도서 대출
	 * @return /admin/lendSearchList
	 * @author 최지혜
	 */
	@PostMapping("/admin/holdUpdate")
	public String holdUpdate(	 @RequestParam(value="blCode" ) String blCode
								, @RequestParam(value="ulLendDay" ) String ulLendDay 
								, HttpSession session
			 					, RedirectAttributes redirectAttributes) {

		String saId = (String) session.getAttribute("SAID");
		
		int result = bookLendService.holdUpdate(saId, blCode, ulLendDay);
		
		redirectAttributes.addFlashAttribute("resultInsert", result);
		
		return "redirect:/admin/lendSearchList";
	}
	
	/**
	 * @param blCode 대출도서코드
	 * @param redirectAttributes
	 * @brief 연장일 등록
	 * @return /admin/extensionUpdate
	 */
	@GetMapping("/{page}/extensionUpdate")
	public String extensionUpdate( @PathVariable(value="page") String page
								   ,@RequestParam(value="blCode") String blCode
								   , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("resultextension", bookLendService.extensionUpdate(blCode));
		
		if(("admin").equals(page)) {	
			return "redirect:/admin/lendSearchList";		
		}else {
			return "redirect:/lifrary/myLendList";	
		}
	}
	
	/**
	 * @param session
	 * @param model
	 * @brief 예약도서리스트
	 * @return /adminpage/bookLend/reservationSearchList
	 * @author 최지혜
	 */
	@GetMapping("/admin/holdSearchList")
	public String holdSearchList(HttpSession session
								 , Model model) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		
		model.addAttribute("holdList", bookLendService.holdSearchList(libNum));
			
		return "/adminpage/bookLend/holdSearchList";
		
	}
	
	/**
	 * 
	 * @param blCode
	 * @param bsCode
	 * @param redirectAttributes
	 * @brief 예약도서 취소
	 * @return /admin/holdSearchList
	 * @author 최지혜
	 */
	@GetMapping("/{page}/holdDelete")
	public String holdDelete(@PathVariable(value="page") String page
							,@RequestParam(value="blCode") String blCode
							, @RequestParam(value="bsCode") String bsCode
							, RedirectAttributes redirectAttributes) {

		int result = bookLendService.holdDelete(blCode, bsCode);		
		redirectAttributes.addFlashAttribute("resultDelete", result);
			
		if(("admin").equals(page)) {	
			return "redirect:/admin/holdSearchList";		
		}else {
			return "redirect:/lifrary/myHoldList";	
		}		
	}
	
	/** 
	 * @param session
	 * @param model
	 * @brief 마이페이지 대출도서리스트
	 * @return /librarypage/book/myLendList.html
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myLendList")
	public String myLendList(@RequestParam Map<String,Object> params
							 ,@RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPageStr
							 , HttpSession session
							 , Model model) {
		
	 	String libNum = (String) session.getAttribute("LIBNUM");
		String blId = (String) session.getAttribute("SID");
		
		params.put("libNum", libNum);
		params.put("blId", blId);
		
		Map<String, Object> map = bookLendService.myLendList(params, currentPageStr);
		model.addAttribute("myLendList", map.get("myLendList"));
		
		model.addAttribute("currentPage", map.get("currentPage"));
    	model.addAttribute("lastPage", map.get("lastPage"));
    	model.addAttribute("startPageNum", map.get("startPageNum"));
    	model.addAttribute("lastPageNum", map.get("lastPageNum"));
    	model.addAttribute("pageViewBlock", map.get("pageViewBlock"));
    	model.addAttribute("pageViewArray", map.get("pageViewArray"));
		 
		
		return "/librarypage/book/myLendList";
		
	}	
	/**
	 * 
	 * @param session
	 * @param model
	 * @brief 마이페이지 예약도서리스트
	 * @return /librarypage/book/myHoldList
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myHoldList")
	public String myHoldList(@RequestParam Map<String,Object> params
							 ,@RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPageStr
							 , HttpSession session
							 , Model model) {
		
		String libNum = (String) session.getAttribute("LIBNUM");
		String blId = (String) session.getAttribute("SID");
		
		params.put("libNum", libNum);
		params.put("blId", blId);
		
		Map<String, Object> map = bookLendService.myHoldList(params, currentPageStr);
		
		model.addAttribute("myHoldList", map.get("myHoldList"));
		
		model.addAttribute("currentPage", map.get("currentPage"));
    	model.addAttribute("lastPage", map.get("lastPage"));
    	model.addAttribute("startPageNum", map.get("startPageNum"));
    	model.addAttribute("lastPageNum", map.get("lastPageNum"));
    	model.addAttribute("pageViewBlock", map.get("pageViewBlock"));
    	model.addAttribute("pageViewArray", map.get("pageViewArray"));
		
		return "/librarypage/book/myHoldList";
		
	}
	
	
	
	

}
