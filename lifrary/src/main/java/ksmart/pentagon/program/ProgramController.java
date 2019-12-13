package ksmart.pentagon.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.ProgramApply;

/*
 * @file   ProgramController.java 
 * @name   program controller 
 * @brief  프로그램(행사, 강좌)  관련 기능들 
 * @author 김상협 
 */

@Controller
public class ProgramController {

	@Autowired private ProgramService programService;
	
	/**
	 * 프로그램(행사, 강좌) 전체 리스트 가져오기 
	 * @param model
	 * @return
	 */
	@GetMapping("/lifrary/programSearchList")
	public String programListView(Model model) {
			model.addAttribute("menu", "프로그램 리스트");
			model.addAttribute("programList", programService.getProgramList());					
		return "librarypage/program/programSearchList";
	}
	
	/**
	 * 선택한 프로그램(행사, 강좌) 하나 가져오기
	 * @param pmCode
	 * @param model
	 * @return
	 */
	@GetMapping("/lifrary/programDetail")
	public String programDetail(@RequestParam(value = "pmCode")String pmCode, Model model) {
		
		model.addAttribute("menu", "프로그램 상세보기");
		model.addAttribute("program", programService.getProgram(pmCode));
		
		return "librarypage/program/programDetail";
	}
	
	/**
	 * 프로그램(행사, 강좌) 신청 페이지로 이동
	 * @param pmCode (프로그램 종합 코드) pmName (프로그램명) model
	 * 
	 * @return
	 */
	@GetMapping("/lifrary/programApply")
	public String programApply(@RequestParam(value = "pmCode")String pmCode, 
							   @RequestParam(value = "pmName")String pmName, 
							   Model model) {
		model.addAttribute("menu", "프로그램 신청하기");
		model.addAttribute("pmCode", pmCode);
		model.addAttribute("pmName", pmName);
		
		return "librarypage/program/programApply";
	}
	
	/**
	 * 프로그램(행사, 강좌) 신청하기
	 * 
	 * @param pa
	 * @return
	 */
	@PostMapping("/lifrary/programApply")
	public String programApply(ProgramApply pa) {
	System.out.println(pa + " <== pa");
		programService.insertProgram(pa);
		return "redirect:/programSearchList";
	}

	/*========================================================================*/
	// 아래는 사서채널
	
	@GetMapping("/admin/programSearchList")
	public String programSearchList() {
		return "adminpage/program/programSearchList";
	}
	
	
	/**
	 * 프로그램(행사, 강좌) 등록 페이지로 이동
	 * @return
	 */
	@GetMapping("/admin/programInsert")
	public String programInsert() {
		return "adminpage/program/programInsert";
	}
	
}
