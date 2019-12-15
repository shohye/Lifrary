package ksmart.pentagon.board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import ksmart.pentagon.vo.Board;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	//공지사항 리스트화면이동
	@GetMapping("/admin/noticeSearchList")
	public String adminNoticeSearchList(Board board ,Model model) {
		System.out.println("공지사항리스트 컨트롤러  /admin/noticeSearchList ##Mapping경로 ");
		//boardList 공지사항 전체 리스트
		System.out.println(board);
		List<Board> boardList = boardService.getBoard(board);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("boardList : "+boardList);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//공지사항 전체 리스트 갯수만큼 리스트 Num에 추가하여 리스트에 번호출력
		for(int i= 0; i < boardList.size(); i++) {
			boardList.get(i).setlNum(i+1);
		}
		String boardLCode = boardList.get(0).getBoardLCode();
		String boardMCode = boardList.get(0).getBoardMCode();
		System.out.println("boardLName : "+ boardLCode);
		System.out.println("boardMName : "+ boardMCode);	
		model.addAttribute("boardLCode", boardLCode);
		model.addAttribute("boardMCode", boardMCode);
		model.addAttribute("boardList", boardList);
		return "adminpage/board/noticeSearchList";
	}
	
	//공지사항 등록화면이동 컨트롤
	@GetMapping("/admin/noticeInsert")
	public String adminNoticeInsert(@RequestParam(value = "boardLCode")String boardLCode,@RequestParam(value = "boardMCode")String boardMCode,Model model) {
		System.out.println("공지사항 등록 컨트롤러  /admin/noticeInsert ##Mapping경로 ");
		model.addAttribute("boardLCode", boardLCode);
		model.addAttribute("boardMCode", boardMCode);
		return "adminpage/board/noticeInsert";
	}
	//공지사항 등록 컨트롤
	@PostMapping("/admin/noticeInsert")
	public String adminNoticeInsert(Board board, Model model) {
		System.out.println("공지사항 등록 컨트롤러  /admin/noticeInsert ##Mapping경로 ");
		System.out.println(board);
		boardService.noticeInsert(board);
		List<Board> boardList = boardService.getBoard(board);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("boardList : "+boardList);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//공지사항 전체 리스트 갯수만큼 리스트 Num에 추가하여 리스트에 번호출력
		for(int i= 0; i < boardList.size(); i++) {
			boardList.get(i).setlNum(i+1);
		}
		String boardLCode = boardList.get(0).getBoardLCode();
		String boardMCode = boardList.get(0).getBoardMCode();
		System.out.println("boardLCode : "+ boardLCode);
		System.out.println("boardMCode : "+ boardMCode);	
		model.addAttribute("boardLCode", boardLCode);
		model.addAttribute("boardMCode", boardMCode);
		model.addAttribute("boardList", boardList);
		
		return "adminpage/board/noticeSearchList";
	}
	
	//공지사항 사서 상세 화면
	@GetMapping("/admin/noticeDetail")
	public String adminNoticeDetail(@RequestParam(value = "boardCode", required = false ) String boardCode, Model model) {
		System.out.println("공지사항 상세보기 컨트롤러 /admin/noticeDetail ##Mapping경로");
		System.out.println("공지사항 상세보기 겟방식 코드 : " + boardCode);
		Board board = boardService.getBoardDetail(boardCode);
		System.out.println("상세 Board 결과 : "+ board);
		model.addAttribute("board", board);
		return "adminpage/board/noticeDetail";
	}
	
	//공지사항 삭제 후 리스트로 이동
	@GetMapping("/admin/noticeDelete")
	public String adminNoticeDelete() {
		System.out.println("공지사항 삭제 컨트롤러 /admin/noticeDelete ##Mapping경로");
		return "adminpage/board/noticeSearchList";
	}
	
	//공지사항 수정화면으로 이동
	@GetMapping("/admin/noticeUpdate")
	public String adminNoticeUpdate() {
		System.out.println("공지사항 수정 컨트롤러 /admin/noticeUpdate ##Mapping경로");
		return "adminpage/board/noticeUpdate";
	}
	
	
	//문의 리스트 화면으로 이동
	@GetMapping("/admin/inquirySearchList")
	public String adminInquirySearchList() {
		System.out.println("사서 문의 리스트 컨트롤러 /adminInquirySearchList ##Mapping경로");
		return "adminpage/board/adminInquirySearchList";
	}
	
	
	
	
	
	
}
