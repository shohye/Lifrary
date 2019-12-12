package ksmart.pentagon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LayoutController {

	@GetMapping("/")
	public String index() {
		
		return "intro";
	}


	@GetMapping("/{lib}/index") 
	public String index(@PathVariable(value="lib") String lib, HttpSession session) {
	
		if("pentagon".equals(lib)) { //도서관코드가져오기~~ }
	  
			session.setAttribute("LIBNUM",000000); }
	  
		return "librarypage/index";
		  
	}

	@GetMapping("/admin/index")
	public String adminIndex() {
		return "adminpage/index";
	}
}
