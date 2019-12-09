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
	 * 프로그램 전체 리스트 가져오기 
	 * @param model
	 * @return
	 */
	@GetMapping("/programSearchList")
	public String programListView(Model model) {
			model.addAttribute("menu", "프로그램 리스트");
			model.addAttribute("programList", programService.getProgramList());					
		return "librarypage/program/programSearchList";
	}
	
	/**
	 * 선택한 프로그램 하나 가져오기
	 * @param pmCode
	 * @param model
	 * @return
	 */
	@GetMapping("/programDetail")
	public String programDetail(@RequestParam(value = "pmCode")String pmCode, Model model) {
		
		model.addAttribute("menu", "프로그램 상세보기");
		model.addAttribute("program", programService.getProgram(pmCode));
		
		return "librarypage/program/programDetail";
	}
	
	/**
	 * 프로그램 신청 페이지로 이동
	 * @param pmCode (프로그램 종합 코드) pmName (프로그램명) model
	 * SID는 가정을 하기 위해 써놓은것으로, 로그인 / 세션처리를 마치면 지워줄것.
	 * 
	 * @return
	 */
	@GetMapping("/programApply")
	public String programApply(@RequestParam(value = "pmCode")String pmCode, 
							   @RequestParam(value = "pmName")String pmName, 
							   Model model) {
		model.addAttribute("menu", "프로그램 신청하기");
		model.addAttribute("pmCode", pmCode);
		model.addAttribute("pmName", pmName);
		
		model.addAttribute("SID", "id002");
		// 세션으로 값을 받는다는 가정.
		
		return "librarypage/program/programApply";
	}
	
	/**
	 * 프로그램 신청하기
	 * 
	 * @param pa
	 * @return
	 */
	@PostMapping("/programApply")
	public String programApply(ProgramApply pa) {
	System.out.println(pa + " <== pa");
		programService.insertProgram(pa);
		return "redirect:/programSearchList";
	}
	
}
