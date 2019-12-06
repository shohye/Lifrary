package ksmart.pentagon.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @file   ProgramController.java 
 * @name   program controller 
 * @brief  프로그램(행사, 강좌)  관련 기능들 
 * @author 김상협 
 */

@Controller
public class ProgramController {

	@Autowired private ProgramService programService;
	
	@GetMapping("/programSearchList")
	public String programListView() {
		
		return "librarypage/program/programSearchList";
	}
	
	@GetMapping("/programDetail")
	public String programDetail() {
		
		return "librarypage/program/programDetail";
	}
}
