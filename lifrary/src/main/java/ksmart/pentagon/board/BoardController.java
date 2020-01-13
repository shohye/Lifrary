package ksmart.pentagon.board;

import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.Board;
import ksmart.pentagon.vo.BoardComment;
/*
 * @file   BoardController.java
 * @name   boardController
 * @brief  게시판 관련 주소요청 처리
 * @author 정진영
 */
@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	/**
	 * 사이드메뉴에서 공지사항 클릭시 겟방식으로 "대분류명"을 받아 온 값으로 값에맞는 리스트 뽑는 메서드
	 * 사이드메뉴바 공지사항,문의 클릭시 => 리스트로 이동
	 * @param board
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/noticeSearchList")
	public String adminNoticeSearchList(Board board,Model model, HttpSession session) {
		System.out.println("board 컨트롤러  /admin/noticeSearchList ##Mapping경로 ");
		//boardList 공지사항 전체 리스트
		board.setlCode((String)session.getAttribute("LIBNUM"));
		System.out.println("controller31"+board);
		List<Board> boardList = boardService.getBoard(board);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("boardList : "+boardList);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//공지사항 전체 리스트 갯수만큼 리스트 Num에 추가하여 리스트에 번호출력
		model.addAttribute("boardList", boardList);
		String returnUrl = null;
		if("공지사항".equals(board.getBoardLName())) {
			model.addAttribute("boardLName", board.getBoardLName());
			System.out.println("공지사항 리스트");
			returnUrl = "adminpage/board/noticeSearchList";
			
		}else if("문의하기".equals(board.getBoardLName())) {
			model.addAttribute("boardLName", board.getBoardLName());
			System.out.println("문의하기 리스트");
			returnUrl =  "adminpage/board/adminInquirySearchList";
		}else{
			System.out.println("실패 ");
		}
		return returnUrl;
	}
	
	/**
	 * 공지사항 리스트에서 대분류,중분류 코드를 파라미터로 받아서 공지사항 등록 화면으로 값을 넘겨준다.
	 * @param boardLCode
	 * @param boardMCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/noticeInsert")
	public String adminNoticeInsert(@RequestParam(value = "boardLName")String boardLName,@RequestParam(value = "boardMName")String boardMName,Model model) {
		System.out.println("공지사항 등록 컨트롤러  /admin/noticeInsert ##Mapping경로 ");
		model.addAttribute("boardLName", boardLName);
		model.addAttribute("boardMName", boardMName);
		return "adminpage/board/noticeInsert";
	}
	
	
	/**
	 * 공지사항 등록 화면에서 board테이블에 들어갈 값들을 board 객체에 담아 db에 등록하는 메서드
	 * @param insertBoard
	 * @param model
	 * @return
	 */
	@PostMapping("/admin/noticeInsert")
	public String adminNoticeInsert(Board insertBoard, Model model) {
		System.out.println("board 등록 컨트롤러  /admin/noticeInsert ##Mapping경로 ");
		System.out.println(insertBoard);
		Board board = boardService.noticeInsert(insertBoard);
		model.addAttribute("board", board);
		
		return "adminpage/board/noticeDetail";
	}
	
	/**
	 * 공지사항 리스트에서 제목을 클릭시 board테이블에 board_code를 겟방식으로 받아서 조회하여 상세 페이지 화면으로 이동하는 메서드
	 * @param boardCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/noticeDetail")
	public String adminNoticeDetail(Board Dboard,HttpSession session, Model model) {
		Dboard.setlCode((String)session.getAttribute("LIBNUM"));
		Board board = boardService.getBoardDetail(Dboard);
		model.addAttribute("board", board);
		return "adminpage/board/noticeDetail";
	}
	
	/**
	 * 문의하기 리스트에서 제목클릭시 board테이블 board_code를 겟방식으로 받아서 조회하여 상세 페이지 화면으로 이동하는 메서드
	 * @param boardCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/inquiryDetail")
	public String adminInquiryDetail(Board Dboard,HttpSession session ,Model model) {
		Dboard.setlCode((String	)session.getAttribute("LIBNUM"));
		Board board = boardService.getInquiryDetail(Dboard);
		model.addAttribute("board", board);
		return "adminpage/board/adminInquiryDetail";
	}
	
	/**
	 * 상세페이지에서 수정버튼 클릭시 겟방식으로 board테이블 board_code를 겟방식으로 받아 조회후 수정페이지로 값을 넘겨준다.
	 * @param boardCode
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/noticeUpdate")
	public String adminNoticeUpdate(Board Dboard,HttpSession session , Model model) {
		Dboard.setlCode((String)session.getAttribute("LIBNUM"));	
		Board board = boardService.getBoardDetail(Dboard);
		model.addAttribute("board", board);
		return "adminpage/board/noticeUpdate";
	}
	
	/**
	 * 공지사항 수정페이지에서 보낸값을 board객체에 담아 수정후 상세페이지로 이동 메서드
	 * @param board
	 * @return
	 */
	@PostMapping("/admin/noticeUpdate")
	public String adminNoticeUpdate(Board board) {
			System.out.println("공지사항 수정완료후 등록 /admin/noticeUpdate 경로 adminNoticeUpdate메서드 실행 ");
			System.out.println("controller105board : " + board);
			boardService.setBoardUpdate(board);
			boardService.getBoardDetail(board);
			return "adminpage/board/noticeDetail";
	}
	
	/**
	 * 공지사항 상세 페이지에서 삭제버튼 클릭시 board테이블 board_code를 겟방식으로 받아 테이블 row를 삭제후 리스트로 이동해준다.
	 * @param board
	 * @param boardCode
	 * @param boardLName
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/noticeDelete")
	public String boardDelete(Board board,@RequestParam(value = "boardCode")String boardCode,@RequestParam(value = "boardLName") String boardLName, Model model) {
		boardService.boardDelete(boardCode);
		System.out.println("controller117"+boardLName);
		System.out.println("controller118"+boardCode);
		String URLboardLName = URLEncoder.encode(boardLName);
		return "redirect:/admin/noticeSearchList?boardLName="+URLboardLName;
	}
	
	/**
	 * 문의 상세페이지 댓글 불러오는 메서드
	 * @param Dboard
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/admin/adminInquiryComment")
	public String adminInquiryComment(Board Dboard,HttpSession session,Model model) {
		Dboard.setlCode((String)session.getAttribute("LIBNUM"));
		Board board = boardService.getBoardDetail(Dboard);
		System.out.println("Controller187 : " + board);
		model.addAttribute("board",board);
		return "/adminpage/board/adminInquiryComment";
	}
	
	/**
	 * 문의 상세페이지에서 댓글누른후 댓글입력후 
	 * @param boardComment
	 * @param session
	 * @return
	 */
	@PostMapping("/admin/inquiryCommentInsert")
	public @ResponseBody BoardComment inquiryCommentInsert(BoardComment boardComment, HttpSession session) {
		boardComment.setlCode((String)session.getAttribute("LIBNUM"));
		boardComment.setuId((String)session.getAttribute("SAID"));
		System.out.println("service189"+boardComment);
		BoardComment comment = boardService.inquiryCommentInsert(boardComment);
		return comment;
	}
	
	/**
	 * 문의 상세페이지에서 댓글 수정후 수정값 리턴
	 * @param boardComment
	 * @param session
	 * @return
	 */
	@PostMapping("/admin/inquiryCommentUpdate")
	public @ResponseBody BoardComment inquiryCommentUpdate(BoardComment boardComment, HttpSession session) {
		boardComment.setuId((String)session.getAttribute("SAID"));
		System.out.println("controller188 : " + boardComment);
		BoardComment commentUpdate = boardService.inquiryCommentUpdate(boardComment);
		return commentUpdate;
	}
	
	/**
	 * 문의 상세페이지에서 댓글 삭제누르면 삭제후 문의상세페이지로 이동
	 * @param board
	 * @param boardComment
	 * @return
	 */
	@GetMapping("/admin/inquiryCommentDelete")
	public String inquiryCommentDelete(Board board,BoardComment boardComment) {
		System.out.println("controller195 : " + board +boardComment);
		boardService.inquiryCommentDelete(boardComment);
		String boardCode = board.getBoardCode();
		String URLboardCode = URLEncoder.encode(boardCode);
		return "redirect:/admin/inquiryDetail?boardCode="+URLboardCode;
	}
	
	//라이브러리 공지사항 리스트
	@GetMapping("/lifrary/noticeList")
	public String lifraryNoticeList(Model model, Board board, HttpSession session) {
		board.setlCode((String)session.getAttribute("LIBNUM"));
		List<Board> boardList = boardService.lifraryNoticeList(board);
		System.out.println("controller231 : " + boardList);
		model.addAttribute("boardList", boardList);
		return "/librarypage/board/noticeList";
	}
	
	//라이브러리 문의 리스트
	@GetMapping("/lifrary/inquirySearchList")
	public String lifraryInquirySearchList(Model model, Board board, HttpSession session) {
		board.setlCode((String)session.getAttribute("LIBNUM"));
		List<Board> boardList = boardService.lifraryInquirySearchList(board);
		System.out.println("controller236 : " + boardList);
		model.addAttribute("boardList", boardList);
		return "/librarypage/board/inquirySearchList";
	}
	
	@GetMapping("/lifrary/inquiryDetail")
	public String lifraryInquiryDetail(Model model,Board board, HttpSession session) {
		board.setlCode((String)session.getAttribute("LIBNUM"));
		Board boardDetail = boardService.lifraryInquiryDetail(board);
		model.addAttribute("board", boardDetail);
		return "/librarypage/board/inquiryDetail";
	}
	
	@PostMapping("/inquirySearchListAjax")
	public @ResponseBody List<Board> inquirySearchListAjax(Board board, HttpSession session){
		board.setlCode((String)session.getAttribute("LIBNUM"));
		System.out.println("controller251" + board);
		List<Board> boardList = boardService.inquirySearchListAjax(board);
		
		return boardList;
	}
	
	@GetMapping("/library/inquiryInsert")
	public String libraryInquiryInsert(Model model , Board board) {
		System.out.println("controller260 : " + board);
		model.addAttribute("boardLName", board.getBoardLName());
		return "/librarypage/board/inquiryInsert";
	}
	
	@GetMapping("/lifrary/noticeDetail")
	public String lifraryNoticeDetail(Model model,Board board, HttpSession session) {
		board.setlCode((String)session.getAttribute("LIBNUM"));
		Board boardDetail = boardService.lifraryNoticeDetail(board);
		model.addAttribute("board", boardDetail);
		return "/librarypage/board/noticeDetail";
	}
	
	@GetMapping("/lifrary/myinquiryList")
	public String myinquiryList(Model model,Board board, HttpSession session) {
		board.setuId((String)session.getAttribute("SID"));
		board.setlCode((String)session.getAttribute("LIBNUM"));
		return "/librarypage/board/myInquiryList";
	}
	
}
