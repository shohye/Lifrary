package ksmart.pentagon.program;

import javax.servlet.http.HttpSession;

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
	public String programListView(Model model, HttpSession session) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("menu", "프로그램 리스트");
		model.addAttribute("programList", programService.getProgramList(libNum));
		model.addAttribute("latelyProgram", programService.getLatelyProgram(libNum)); // 최근 등록된 3개 프로그램 뿌려주기
		return "librarypage/program/programSearchList";
	}

	
	/**
	 * 키워드, 대상 검색리스트 가져오기.
	 * @param keywords
	 * @param target
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/lifrary/programSearchList")
	public String programList(@RequestParam(value = "keywords", required = false) String keywords, @RequestParam(value = "target") String target,
			Model model, HttpSession session) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("menu", "프로그램 리스트");
		model.addAttribute("programList", programService.getSearchProgramList(keywords, target,libNum));
		model.addAttribute("latelyProgram", programService.getLatelyProgram(libNum)); // 최근 등록된 3개 프로그램 뿌려주기
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
	public String programDetail(@RequestParam(value = "pmCode") String pmCode, Model model, HttpSession session) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("menu", "프로그램 상세보기");
		model.addAttribute("program", programService.getProgram(pmCode));
		model.addAttribute("latelyProgram", programService.getLatelyProgram(libNum)); // 최근 등록된 3개 프로그램 뿌려주기
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
			@RequestParam(value = "pmName") String pmName, Model model, HttpSession session) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("menu", "프로그램 신청하기");
		model.addAttribute("pmCode", pmCode);
		model.addAttribute("pmName", pmName);
		model.addAttribute("latelyProgram", programService.getLatelyProgram(libNum)); // 최근 등록된 3개 프로그램 뿌려주기
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
		programService.applyProgram(pa);
		return "redirect:/lifrary/programSearchList";
	}

	/**
	 * 현재 세션에 저장되어있는 아이디를 받아, 해당 아이디가 신청한 프로그램의 리스트를 보여준다.
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/lifrary/programApplyList")
	public String programApplyList(Model model, HttpSession session) {
		String getSID = (String) session.getAttribute("SID");
		String libNum = (String) session.getAttribute("LIBNUM");
		model.addAttribute("applyList", programService.getProgramApplyList(getSID));
		return "librarypage/program/myProgramApplyList";
	}

	/**
	 * paCode에 맞는 pm 상세보기
	 * 
	 * @param paCode
	 * @param model
	 * @return
	 */
	@GetMapping("/lifrary/programApplyDetail")
	public String programApplyDetail(@RequestParam(value = "paCode") String paCode, Model model) {
		model.addAttribute("program", programService.getProgramDetail(paCode));
		return "librarypage/program/myProgramApplyDetail";
	}

	/**
	 * 프로그램 취소 / 상태가 신청완료일때만 취소 가능하다 . (취소, 종료, 진행중 상태에서는 취소 불가능)
	 * 
	 * @param paCode
	 * @return
	 */
	@GetMapping("/lifrary/programCancle")
	public String programCancle(@RequestParam(value = "paCode") String paCode,
			@RequestParam(value = "pmCode") String pmCode) {
		programService.cancleProgram(paCode, pmCode);
		return "redirect:/lifrary/programApplyList";
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
	public String adminProgramSearchList(Model model, HttpSession session) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("programList", programService.getProgramList(libNum));
		return "adminpage/program/programSearchList";
	}

	/**
	 * 프로그램 신청 내역 리스트 페이지로 이동 / 출력
	 * 
	 * @return
	 */
	@GetMapping("/admin/programApplySearchList")
	public String adminProgramApplySearchList(Model model, HttpSession session) {
		String libNum = (String)session.getAttribute("LIBNUM");
		model.addAttribute("applyList", programService.adminGetProgramApplyList(libNum));
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
	 * 프로그램(행사, 강좌) 등록처리후 프로그램 리스트로 이동
	 * @param pm
	 * @return
	 */
	@PostMapping("/admin/programInsert")
	public String programInsert(ProgramManager pm) {
		programService.insertProgram(pm);
		return "redirect:/admin/programSearchList";
	}

	/**
	 * 프로그램 1개 상세보기
	 * 
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
	 * 
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
	 * 프로그램 수정 처리후, 상세보기 페이지로 redirect. pmCode를 다시 get방식으로 보내준다.
	 * 
	 * @param pm
	 * @return
	 */
	@PostMapping("/admin/programUpdate")
	public String adminProgramUpdate(ProgramManager pm) {
		programService.updateProgram(pm);
		return "redirect:/admin/programDetail?pmCode=" + pm.getPmCode();
	}

	@GetMapping("/admin/programDelete")
	public String adminProgramDelete(@RequestParam(value = "pmCode") String pmCode) {
		System.out.println(pmCode + "<== pmCode");
		programService.deleteProgram(pmCode);
		return "redirect:/admin/programSearchList";
	}
}
