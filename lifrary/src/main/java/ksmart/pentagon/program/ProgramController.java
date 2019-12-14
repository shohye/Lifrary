package ksmart.pentagon.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.ProgramApply;
import ksmart.pentagon.vo.ProgramManager;

/*
 * @file   ProgramController.java 
 * @name   program controller 
 * @brief  프로그램(행사, 강좌)  관련 기능들 
 * @author 김상협 
 */

@Controller
public class ProgramController {

	@Autowired
	private ProgramService programService;

	/**
	 * 프로그램(행사, 강좌) 전체 리스트 가져오기
	 * 
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
	 * 
	 * @param pmCode
	 * @param model
	 * @return
	 */
	@GetMapping("/lifrary/programDetail")
	public String programDetail(@RequestParam(value = "pmCode") String pmCode, Model model) {

		model.addAttribute("menu", "프로그램 상세보기");
		model.addAttribute("program", programService.getProgram(pmCode));

		return "librarypage/program/programDetail";
	}

	/**
	 * 프로그램(행사, 강좌) 신청 페이지로 이동
	 * 
	 * @param pmCode (프로그램 종합 코드) pmName (프로그램명) model
	 * 
	 * @return
	 */
	@GetMapping("/lifrary/programApply")
	public String programApply(@RequestParam(value = "pmCode") String pmCode,
			@RequestParam(value = "pmName") String pmName, Model model) {
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
		return "redirect:/lifrary/programSearchList";
	}

	/* ======================================================================== */
	// 아래는 사서채널
	/**
	 * 등록 프로그램 리스트 페이지 이동 / 출력해주기.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/programSearchList")
	public String adminProgramSearchList(Model model) {
		model.addAttribute("programList", programService.getProgramList());
		return "adminpage/program/programSearchList";
	}
	
	/**
	 * 프로그램 신청 내역 리스트 페이지로 이동 / 출력
	 * @return
	 */
	@GetMapping("/admin/programApplySearchList")
	public String adminProgramApplySearchList(Model model) {
		
		model.addAttribute("applyList", programService.getProgramApplyList());
		
		return "adminpage/program/programApplySearchList";
	}
	
	
	
	/**
	 * 프로그램(행사, 강좌) 등록 페이지로 이동
	 * 
	 * @return
	 */
	@GetMapping("/admin/programInsert")
	public String programInsert() {
		return "adminpage/program/programInsert";
	}

	/**
	 * 프로그램 1개 상세보기
	 * @param pmCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/programDetail")
	public String adminProgramDetail(@RequestParam(value = "pmCode") String pmCode, Model model) {
		model.addAttribute("program", programService.getProgram(pmCode));

		return "adminpage/program/programDetail";
	}
	
	/**
	 * 프로그램 수정페이지로 이동
	 * @param pmCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/programUpdate")
	public String adminProgramUpdate(@RequestParam(value = "pmCode") String pmCode, Model model) {
		model.addAttribute("program", programService.getProgram(pmCode));
		return "adminpage/program/programUpdate";
	}
	
	/**
	 * 프로그램 수정 처리후, 상세보기 페이지로 redirect.
	 * pmCode를 다시 get방식으로 보내준다.
	 * @param pm
	 * @return
	 */
	@PostMapping("/admin/programUpdate")
	public String adminProgramUpdate(ProgramManager pm) {
		programService.updateProgram(pm);
		return "redirect:/admin/programDetail?pmCode="+pm.getPmCode();
	}
}
