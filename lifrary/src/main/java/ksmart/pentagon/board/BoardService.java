package ksmart.pentagon.board;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.codeup.CodeUp;
import ksmart.pentagon.vo.Board;
import ksmart.pentagon.vo.BookInformation;

@Service
public class BoardService {

	@Autowired private BoardMapper boardmapper;

//		공지사항 리스트 data 가져오기
		public List<Board> getBoard(Board board){
			System.out.println("BoardService 파일");
			return boardmapper.getBoard(board);
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
		
		
		
}
