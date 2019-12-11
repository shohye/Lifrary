package ksmart.pentagon.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.Board;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	//공지사항 리스트화면이동
	@GetMapping("/adminNoticeSearchList")
	public String adminNoticeSearchList(Model model) {
		System.out.println("공지사항리스트 컨트롤러  /adminNoticeSearchList ##Mapping경로 ");
		List<Board> boardList = boardService.getBoard();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("boardList : "+boardList);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		model.addAttribute("boardList", boardList);
		return "adminpage/board/noticeSearchList";
	}
	
	//공지사항 등록화면이동
	@GetMapping("/adminNoticeInsert")
	public String adminNoticeInsert() {
		System.out.println("공지사항 등록 컨트롤러  /adminNoticeInsert ##Mapping경로 ");
		
		return "adminpage/board/noticeInsert";
	}
	
	//공지사항 사서 상세 화면
	@GetMapping("/adminNoticeDetail")
	public String adminNoticeDetail() {
		System.out.println("공지사항 상세보기 컨트롤러 /adminNoticeDetail ##Mapping경로");
		return "adminpage/board/noticeDetail";
	}
	
	//공지사항 삭제 후 리스트로 이동
	@GetMapping("/adminNoticeDelete")
	public String adminNoticeDelete() {
		System.out.println("공지사항 삭제 컨트롤러 /adminNoticeDelete ##Mapping경로");
		return "adminpage/board/noticeSearchList";
	}
	
	//공지사항 수정화면으로 이동
	@GetMapping("/adminNoticeUpdate")
	public String adminNoticeUpdate() {
		System.out.println("공지사항 수정 컨트롤러 /adminNoticeUpdate ##Mapping경로");
		return "adminpage/board/noticeUpdate";
	}
	
	
	//문의 리스트 화면으로 이동
	@GetMapping("/adminInquirySearchList")
	public String adminInquirySearchList() {
		System.out.println("사서 문의 리스트 컨트롤러 /adminInquirySearchList ##Mapping경로");
		return "adminpage/board/adminInquirySearchList";
	}
	@GetMapping("/list1")
	public String list(@RequestParam(value="b01",required=false) String b01,Model model) {
		System.out.println("@@@list : " + b01);
		System.out.println("공지사항리스트 컨트롤러  /adminNoticeSearchList ##Mapping경로 ");
		List<Board> boardList = boardService.getBoard();
		model.addAttribute("boardList", boardList);
		return "adminpage/board/noticeSearchList";
	}
	
	
	
	
	
}
