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

	@Autowired
	private LayoutService layoutService;

	@Autowired
	private ProgramService programService;

	@GetMapping("/")
	public String intro() {

		return "intro";
	}

	@GetMapping("/{lib}/index")
	public String index(@PathVariable(value = "lib") String lib, HttpSession session, Model model) {
		String libNum = "";

		if (session.getAttribute("SAID") != null) {
			session.removeAttribute("SAID");
			session.removeAttribute("SADIV");
			session.removeAttribute("SANAME");
			session.removeAttribute("SALI");
			session.removeAttribute("SALC");
			session.removeAttribute("SALBA");
			session.removeAttribute("SALS");
			session.removeAttribute("SALBS");
		}
		session.removeAttribute("LIBNUM");

		if ("pentagon".equals(lib)) {
			libNum = "000000";
			session.setAttribute("LIBNUM", libNum);
			model.addAttribute("programList", programService.getLatelyProgram(libNum));
			// 프로그램 가져와서 뿌려주기. 000000
		} else if ("square".equals(lib)) {
			libNum = "111111";
			session.setAttribute("LIBNUM", libNum);
			model.addAttribute("programList", programService.getLatelyProgram(libNum));
			// 프로그램 가져와서 뿌려주기. 111111

		}

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

		String libnum = (String) session.getAttribute("LIBNUM");
		LayoutStats layoutStats = layoutService.statsCount(libnum);
		model.addAttribute("list", list);
		model.addAttribute("startDt", startDt);
		model.addAttribute("count", layoutStats);
		return "adminpage/index";
	}

	@PostMapping("/getAge")
	public @ResponseBody ArrayList<ArrayList> getAge(@RequestParam(value = "fromAge") String fromAge,
			@RequestParam(value = "toAge") String toAge) {
		Calendar sum = Calendar.getInstance();
		DateFormat newendDt = new SimpleDateFormat("yyyy-MM-dd");
		sum.add(Calendar.MONTH, -1);
		String startDt = newendDt.format(sum.getTime());
		sum.setTime(new Date());
		String endDt = newendDt.format(sum.getTime());
		String aera = "0";

		ArrayList<ArrayList> list = layoutService.getAge(startDt, endDt, fromAge, toAge);
		return list;
	}

	@PostMapping("/getAera")
	public @ResponseBody ArrayList<ArrayList> getAera(@RequestParam(value = "gender") String gender,
			@RequestParam(value = "fromAge") String fromAge, @RequestParam(value = "toAge") String toAge,
			@RequestParam(value = "area") String area) {
		ArrayList<ArrayList> List = layoutService.getAera(gender, fromAge, toAge, area);
		return List;
	}
}
