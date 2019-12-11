package ksmart.pentagon.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Board;

@Service
public class BoardService {

	@Autowired private BoardMapper boardmapper;
	
		public List<Board> getBoard(){
			System.out.println(boardmapper.getBoard() + "@@@@@@@@@@@보드리스트");
			return boardmapper.getBoard();
		}
}
