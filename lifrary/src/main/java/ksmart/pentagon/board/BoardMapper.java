package ksmart.pentagon.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Board;

@Mapper
public interface BoardMapper {
	
	//bard테이블 리스트 가저오는 메서드
	public List<Board> getBoard(Board board);
	
	//board테이블 board_code 컬럼max번호 가져오는 메서드
	public String maxBoardCode();
	
	//board테이블 insert 메서드
	public void boardInsert(Board board);
	
	//board테이블 한개 row가져오는 메서드
	public Board getBoardDatail(String boardCode);
	
	//board테이블 조회수 +1 시켜주는 메서드
	public void boardPageViewUp(String boardCode);
	
	//board테이블 있던 date를 update하는 메서드
	public void setBoardUpdate(Board board);
	
	//board테이블 row값 삭제 하는 메서드
	public void boardDelete(String boardCode);
}
