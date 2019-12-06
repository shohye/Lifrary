package ksmart.pentagon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @file   AdminController.java //파일
 * @name   admin controller //이름
 * @brief  어드민 관련 기능들 //기능
 * @author 김상협 //작성자
 */


@Controller
public class AdminController {

	@Autowired private AdminService adminService;
	
	@GetMapping("/test")
	public String test(Model model) {
		System.out.println("@@@@@@@@@@@@@@@@@컨트롤러 진입@@@@@@@@@@@@@@@@@@");
		model.addAttribute("getUserLevel", adminService.getUserLevel());
		System.out.println("@@@@@@@@@@@@@@@@@서비스 탈출@@@@@@@@@@@@@@@@@@");
		return "test";
	}
	/**
	 * 어드민 로그인 페이지로 진입
	 * @param model
	 * @return adminLogin페이지
	 * @author 김상협
	 * @date 19/12/05
	 */
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "adminpage/librarian/adminLogin";
	}
	
}
