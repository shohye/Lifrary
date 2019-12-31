package ksmart.pentagon.board;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.xml.ws.Response;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.codeup.CodeUp;
import ksmart.pentagon.vo.Board;
import ksmart.pentagon.vo.BoardComment;
import ksmart.pentagon.vo.BookInformation;

@Service
public class BoardService {

	@Autowired private BoardMapper boardmapper;

//		공지사항 리스트 data 가져오기
		public List<Board> getBoard(Board board){
			List<Board> boardList = boardmapper.getBoard(board);
			System.out.println("BoardService 파일");
			for(int i = 0; i < boardList.size(); i++) {
				System.out.println("service28"+boardList.get(i).getBoardCode());
				System.out.println("service29"+boardmapper.commentCheck(boardList.get(i).getBoardCode()));
				boardList.get(i).setBoardComment(boardmapper.commentCheck(boardList.get(i).getBoardCode()));	
				System.out.println("boardList.size() : "+ boardList.size());
				System.out.println("service31"+boardList.get(i).getBoardComment());
			}
			System.out.println("service35"+boardList);
			return boardList;
		}
		
//		공지사항 data 등록 후 리스트 data 가져오기
		public Board noticeInsert(Board board){
			String max = boardmapper.maxBoardCode();
			String returnCode = CodeUp.codeMaker(max);
			board.setBoardCode(returnCode);
			System.out.println("service36: "+returnCode);
			System.out.println("boardmapper.boardInsert() 메서드 실행");
			boardmapper.boardInsert(board);
			return boardmapper.getBoardDatail(board);
			
		}
//		공지사항 상세페이지 data가져오기
		public Board getBoardDetail(Board Dboard) {
			boardmapper.boardPageViewUp(Dboard);
			System.out.println();
			Board board = boardmapper.getBoardDatail(Dboard);
			System.out.println("service46 : "+board);
			return board;
		}
		
		public void setBoardUpdate(Board board) {
			System.out.println("service67 board : "+board);
			boardmapper.setBoardUpdate(board);
		}
		
		public void boardDelete(String boardCode) {
			boardmapper.boardDelete(boardCode);
		}
		
		public Board getInquiryDetail(Board Dboard) {
			 Board board = boardmapper.getBoardDatail(Dboard);
			 board.setBoardComment(boardmapper.getComment(Dboard));
			return board;
		}
		
		public BoardComment inquiryCommentInsert(BoardComment boardComment) {
			String max = boardmapper.maxCommentCode();
			String returnCode = CodeUp.codeMaker(max);
			boardComment.setBoardCCode(returnCode);
			System.out.println("service80"+boardComment);
			Board board = new Board();
			boardmapper.inquiryCommentInsert(boardComment);
			board.setBoardCode(boardComment.getBoardCode());
			return boardmapper.getComment(board);
		}
		
		public BoardComment inquiryCommentUpdate(BoardComment boardComment) {
			boardmapper.inquiryCommentUpdate(boardComment);
			Board board = new Board();
			board.setBoardCode(boardComment.getBoardCode());
			return boardmapper.getComment(board);			
		}
		
		public void inquiryCommentDelete(BoardComment boardComment) {
			boardmapper.inquiryCommentDelete(boardComment);
		}
		
}
