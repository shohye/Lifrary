package ksmart.pentagon.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		
		Calendar sum = Calendar.getInstance();
        DateFormat newendDt = new SimpleDateFormat("yyyy-MM-dd");
        sum.add(Calendar.MONTH, -1);
        String startDt = newendDt.format(sum.getTime());
        sum.setTime(new Date());
        String endDt = newendDt.format(sum.getTime());
        String aera = "0";
        ArrayList list = layoutService.getAreaOpenApi(startDt, endDt, aera);
		
		String libnum = (String)session.getAttribute("LIBNUM");
		LayoutStats layoutStats = layoutService.statsCount(libnum);
		System.out.println("Controller86 : "+ list);
		model.addAttribute("list", list);
		model.addAttribute("startDt", startDt);
		model.addAttribute("count", layoutStats);
		return "adminpage/index";
	}
	
	@PostMapping("/getAge")
	public @ResponseBody ArrayList<ArrayList> getAge(@RequestParam(value = "fromAge")String fromAge,@RequestParam(value = "toAge")String toAge){
		System.out.println("/getAge");
		Calendar sum = Calendar.getInstance();
        DateFormat newendDt = new SimpleDateFormat("yyyy-MM-dd");
        sum.add(Calendar.MONTH, -1);
        String startDt = newendDt.format(sum.getTime());
        sum.setTime(new Date());
        String endDt = newendDt.format(sum.getTime());
        String aera = "0";
        
        ArrayList<ArrayList> list = layoutService.getAge(startDt, endDt, fromAge, toAge);
        System.out.println("Controller107 : " + list);
		return list;
	}
	@PostMapping("/getAera")
	public @ResponseBody ArrayList<ArrayList> getAera(@RequestParam(value = "gender")String gender,
													  @RequestParam(value = "fromAge")String fromAge,
													  @RequestParam(value = "toAge")String toAge,
													  @RequestParam(value = "area")String area){
		System.out.println("gender : " + gender);
		System.out.println("fromAge : " + fromAge);
		System.out.println("toAge : " + toAge);
		System.out.println("area : " + area);
		ArrayList<ArrayList> List = layoutService.getAera(gender, fromAge, toAge, area);
		return List;
	}
}
