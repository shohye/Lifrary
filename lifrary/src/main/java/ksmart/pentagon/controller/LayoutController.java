package ksmart.pentagon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {

	@GetMapping("/")
	public String index() {
		return "librarypage/index";
	}
	
	@GetMapping("/intro")
	public String intro() {
		return "intro";
	}

	@GetMapping("/admin/index")
	public String adminIndex() {
		return "adminpage/index";
	}
}
