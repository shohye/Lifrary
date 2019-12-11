package ksmart.pentagon.booklend;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart.pentagon.vo.BookStock;


@Controller
public class BookLendController {
	@Autowired private BookLendService bookLendService;
	
	@GetMapping("/admin/lendSearchList.do")
	public String bookLendSearchList(Model model){
		
		model.addAttribute("lendList", bookLendService.bookSearchList());
		 
		return "adminpage/bookLend/lendSearchList";
	}
		
	@PostMapping("/admin/lendBookInfo.do")
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
		
		
		return "redirect:/admin/lendSearchList.do";
	}
	
	@PostMapping("/admin/lendUserInfo.do")
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

		
		return "redirect:/admin/lendSearchList.do";
	}
	
	

}
