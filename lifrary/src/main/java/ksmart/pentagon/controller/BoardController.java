package ksmart.pentagon.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ksmart.pentagon.vo.Board;

@Controller
public class BoardController {
	
	@GetMapping("/adminNoticeSearch")
	public String noticeSearch() {
		return "adminpage/board/noticeSearch";
	}
	@PostMapping("/adminNoticeSearch")
	public String noticeSearch(Board board,Model model ) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@"+board);
		return "adminpage/board/noticeSearch";
	}
	@GetMapping("/adminNoticeSearchList")
	public String noticeSearchList(Model model) {
		System.out.println("공지사항리스트 컨트롤러  /adminNoticeSearchList 메서드 ");
		return "adminpage/board/noticeSearchList";
	}
}
