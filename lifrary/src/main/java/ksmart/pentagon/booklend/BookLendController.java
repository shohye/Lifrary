package ksmart.pentagon.booklend;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.pentagon.vo.BookStock;

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
	public String LendSearchList(Model model){
		
		model.addAttribute("lendList", bookLendService.bookSearchList());
		 
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
								,@RequestParam(value="svUser", required=false) String svUser
								, RedirectAttributes redirectAttributes){
		
		System.out.println("svBook: " + svBook);
		System.out.println("svUser: " + svBook);
		
		//도서정보만 검색
		if(svUser == null || svUser.equals("")) {

			Map<String, Object> bookInfoMap = bookLendService.bookInfo(svBook);
			
			//결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchBook", bookInfoMap.get("searchBook"));
			redirectAttributes.addFlashAttribute("resultBook", bookInfoMap.get("resultBook"));
			
			//예약도서인 경우 예약자 아이디포함하여 보내기
			if(bookInfoMap.get("holdId") != null) {
				redirectAttributes.addFlashAttribute("holdId", bookInfoMap.get("holdId"));
			}
			
			//반납안된 도서인 경우 회원정보포함하여 보내기
			if(bookInfoMap.get("resultUser") != null) {
				redirectAttributes.addFlashAttribute("resultUser", bookInfoMap.get("resultUser"));	
			}
		
		}
		//도서+회원정보 검색
		else {
			//도서
			Map<String, Object> bookInfoMap = bookLendService.bookInfo(svBook);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchBook", bookInfoMap.get("searchBook"));
			redirectAttributes.addFlashAttribute("resultBook", bookInfoMap.get("resultBook"));
			
			//회원
			Map<String, Object> userInfoMap = bookLendService.userInfo(svUser);
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
								,@RequestParam(value="svBook", required=false) String svBook
								, RedirectAttributes redirectAttributes){
		
		System.out.println("svUser: " + svUser);
		System.out.println("svBook: " + svBook);
		
		//회원정보만 검색
		if(svBook == null || svBook.equals("")) {
			
			Map<String, Object> userInfoMap = bookLendService.userInfo(svUser);
			
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchUser", userInfoMap.get("searchUser"));
			redirectAttributes.addFlashAttribute("resultUser", userInfoMap.get("resultUser"));
			
		}
		
		//도서+회원정보 검색
		else {
			//도서
			Map<String, Object> bookInfoMap = bookLendService.bookInfo(svBook);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("resultBook", bookInfoMap.get("resultBook"));
			
			//예약도서인 경우 예약자 아이디포함하여 보내기
			if(bookInfoMap.get("holdId") != null) {
				redirectAttributes.addFlashAttribute("holdId", bookInfoMap.get("holdId"));
			}
			
			//회원
			Map<String, Object> userInfoMap = bookLendService.userInfo(svUser);
			//검색결과 리다이렉트로 보내기
			redirectAttributes.addFlashAttribute("searchUser", userInfoMap.get("searchUser"));
			redirectAttributes.addFlashAttribute("resultUser", userInfoMap.get("resultUser"));
		}

		
		return "redirect:/admin/lendSearchList";
	}
	
	/**
	 * @brief 예약도서리스트
	 * @return /adminpage/bookLend/reservationSearchList
	 * @author 최지혜
	 */
	@GetMapping("/admin/reservationSearchList")
	public String reservationSearchList() {
		return "/adminpage/bookLend/reservationSearchList";
		
	}
	
	/**
	 * 
	 * @param session
	 * @brief 마이페이지 대출도서리스트
	 * @return
	 * @author 최지혜
	 */
	@GetMapping("/lifrary/myLendList")
	public String myLendList(HttpSession session) {
		//회원 아이디 넘기기!
		
		return "/librarypage/book/myLendList.html";
		
	}
	
	@GetMapping("/lifrary/myReservationList")
	public String myReservationList(HttpSession session) {
		//회원 아이디 넘기기!
		
		return "/librarypage/book/myReservationList";
		
	}
	
	
	
	

}
