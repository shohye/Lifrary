package ksmart.pentagon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("noticeSearch")
	public String noticeSearch() {
		return "adminpage/board/noticeSearch";
	}
	@GetMapping("noticeSearchList")
	public String noticeSearchList() {
		return "adminpage/board/noticeSearchList";
	}
}
