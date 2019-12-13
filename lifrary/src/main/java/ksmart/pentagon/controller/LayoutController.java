package ksmart.pentagon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LayoutController {

	@GetMapping("/")
	public String intro() {
		
		return "intro";
	}


	@GetMapping("/{lib}/index") 
	public String index(@PathVariable(value="lib") String lib, HttpSession session) {
		
		if (session.getAttribute("SAID") != null) {
			System.out.println("세션에 SAID값이 있습니다");
			session.removeAttribute("SAID");
			session.removeAttribute("SADIV");
			session.removeAttribute("SANAME");
			session.removeAttribute("SALI");
			session.removeAttribute("SALC");
			session.removeAttribute("SALBA");
			session.removeAttribute("SALS");
			session.removeAttribute("SALBS");
			System.out.println("세션이 잘 종료되었습니다.");
		} else {
			System.out.println("(사서)세션값이 없습니다.");
		}
		if("pentagon".equals(lib)) { 
			
			session.setAttribute("LIBNUM",000000);
			
		} else if("square".equals(lib)) {
			session.setAttribute("LIBNUM",111111);
		}
	  
		return "librarypage/index";
		  
	}

	@GetMapping("/admin/index")
	public String adminIndex() {
		return "adminpage/index";
	}
}
