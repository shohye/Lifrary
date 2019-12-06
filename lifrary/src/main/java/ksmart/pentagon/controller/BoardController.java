package ksmart.pentagon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("adminpage/board/noticeSearchList")
	public String noticeInsert() {
		return "adminpage/board/noticeSearchList";
	}
}
