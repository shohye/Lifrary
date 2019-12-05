package ksmart.pentagon.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}
