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

import ksmart.pentagon.vo.Board;

@Service
public class BoardService {

	@Autowired private BoardMapper boardmapper;

//		공지사항 리스트 date 가져오기
		public List<Board> getBoard(Board board){
			System.out.println("BoardService 파일");
			return boardmapper.getBoard(board);
		}
		
//		공지사항 date 등록 후 리스트 date 가져오기
		public void noticeInsert(Board board){
			String total = null;
			String max = boardmapper.maxBoardCode();
			Date today = new Date();
			SimpleDateFormat simpleFormat = new SimpleDateFormat("yyMMdd");
			int nowDate = Integer.parseInt(simpleFormat.format(today));
			String count = null;
			System.out.println(nowDate);
			System.out.println(count = String.format("%05d", 1));
			String name = max.substring(0, max.indexOf("-"));
			String date = max.substring(max.lastIndexOf("-")+1, max.lastIndexOf("-")+7);
			String subMax = max.substring(max.lastIndexOf("-")+7,max.lastIndexOf("-")+7+5);
			int intMax = Integer.parseInt(subMax);
			int intDate = Integer.parseInt(date);
			System.out.println("코드이름"+name);
			System.out.println("날짜"+date);
			System.out.println("맥스번호"+intMax);
			if(intDate < nowDate) {
				total = name+"-"+nowDate+count;
				System.out.println(total);
			}else {
				String intMaxFormat = null;
				total= name+"-"+intDate+(intMaxFormat = String.format("%05d",intMax+1 ));
				System.out.println(total);
			}
			board.setBoardCode(total);
			System.out.println("boardmapper.boardInsert() 메서드 실행");
			boardmapper.boardInsert(board);
			
		}
//		공지사항 상세페이지 date가져오기
		public Board getBoardDetail(String boardCode) {
			boardmapper.boardPageViewUp(boardCode);
			System.out.println();
			return boardmapper.getBoardDatail(boardCode);
		}
		
		public void setBoardUpdate(Board board) {
			boardmapper.setBoardUpdate(board);
		}
		
		
		
}
