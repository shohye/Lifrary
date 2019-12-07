package ksmart.pentagon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LayoutController {

	@GetMapping("/")
	public String index() {
		return "librarypage/index";
	}

	@GetMapping("/adminIndex")
	public String adminIndex() {
		return "adminpage/index";
	}
	
	/* 아래로는 테스트 */
	@GetMapping("/woriworiwori")
	public String index2() {
		return "woriworiwori";
	}
	
	
	
	
}







