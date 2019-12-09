package ksmart.pentagon.user;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.User;

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
		
		return "librarypage/user/login";
	}
	
	/**
	 * 로그인 처리후 인덱스로 이동
	 * @param uId
	 * @param uPw
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping("/login")
	public String login(@RequestParam(value = "uId")String uId, @RequestParam(value = "uPw")String uPw, HttpSession session, Model model) {
		System.out.println(uId + " <== uId");
		System.out.println(uPw + " <== uPw");
		
		Map<String,Object> map = libraryService.loginCheck(uId, uPw);
		User user = (User)map.get("user");
		String result = (String)map.get("result");
		System.out.println(result + " <== result controller");
		if(!result.equals("로그인성공")) {
			//경고창 출력을 위해 result보내주기
			return "librarypage/user/login";
		}


		session.setAttribute("SID", user.getuId());
		session.setAttribute("SNAME", user.getuName());
		session.setAttribute("SDIV", user.getuDivision());
		
		
		return "redirect:/";
	}
	/**
	 * 로그아웃으로 세션 종료
	 * @param session
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
