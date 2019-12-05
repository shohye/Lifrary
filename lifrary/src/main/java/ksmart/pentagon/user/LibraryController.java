package ksmart.pentagon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @file   LibraryController.java 
 * @name   library controller 
 * @brief  도서관 관련 매핑된 경로로 이동
 * @author 김상협 
 */

@Controller
public class LibraryController {
	@Autowired private LibraryService libraryService;
	
	/**
	 * 도서관 로그인 페이지로 진입
	 * 
	 * @return libraryLogin페이지
	 * @author 김상협
	 * @date 19/12/05
	 */	
	@GetMapping("/login")
	public String login() {
		
		return "librarypage/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(value = "uId")String uId, @RequestParam(value = "uPw")String uPw) {
		System.out.println(uId + " <== uId");
		System.out.println(uPw + " <== uPw");
		
		
		return null;
	}
	
}
