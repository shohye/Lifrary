package ksmart.pentagon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import ksmart.pentagon.vo.LayoutStats;
import ksmart.pentagon.program.ProgramService;

@Controller
public class LayoutController {
	
	@Autowired private LayoutService layoutService;

	@Autowired private ProgramService programService;
	
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
		session.removeAttribute("LIBNUM");
		
		if("pentagon".equals(lib)) { 
			
			session.setAttribute("LIBNUM","000000");
			
		} else if("square".equals(lib)) {
			session.setAttribute("LIBNUM","111111");
		}
	    //도서관 페이지 세션 찍기 테스트.
		System.out.println(session.getAttribute("SID") + "<== 현재 세션 SID");
		System.out.println(session.getAttribute("SNAME") + "<== 현재 세션 SNAME");
		System.out.println(session.getAttribute("SDIV") + "<== 현재 세션 SDIV");
		System.out.println(session.getAttribute("LIBNUM")+ "<== 현재 세션 LIBNUM");
		
		
		return "librarypage/index";
		  
	}

	@GetMapping("/admin/index")
	public String adminIndex(Model model, HttpSession session) {
		String libnum = (String)session.getAttribute("LIBNUM");
		LayoutStats layoutStats = layoutService.statsCount(libnum);
		model.addAttribute("count", layoutStats);
		return "adminpage/index";
	}
}
