package ksmart.pentagon.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Board;
import ksmart.pentagon.vo.BoardComment;

@Mapper
public interface BoardMapper {
	
	//bard테이블 리스트 가저오는 메서드
	public List<Board> getBoard(Board board);
	
	//board테이블 board_code 컬럼max번호 가져오는 메서드
	public String maxBoardCode();
	
	//board테이블 insert 메서드
	public void boardInsert(Board board);
	
	//board테이블 한개 row가져오는 메서드
	public Board getBoardDatail(Board Dboard);
	
	//board테이블 조회수 +1 시켜주는 메서드
	public void boardPageViewUp(Board board);
	
	//board테이블 있던 date를 update하는 메서드
	public void setBoardUpdate(Board board);
	
	//board테이블 row값 삭제 하는 메서드
	public void boardDelete(String boardCode);
	
	//board 문의 댓글 상태 확인
	public BoardComment commentCheck(String boardCCode);
	
	//board 문의 댓글 테이블 가져오기
	public BoardComment getComment(Board board);
	
	//문의 댓글 등록
	public void inquiryCommentInsert(BoardComment boardComment);
	
	//문의 댓글등록 pk 맥스번호 가져오는 쿼리실행
	public String maxCommentCode();
	
	//댓글 업데이트 쿼리문 실행
	public void inquiryCommentUpdate(BoardComment boardComment);
	
	public void inquiryCommentDelete(BoardComment boardComment);
	
	//라이브러리 문의리스트 가져오는 메서드
	public List<Board> lifraryInquirySearchList(Board board);
	
	//라이브러리 문의(공지사항) 디테일 가져오는 메서드
	public Board lifraryInquiryDetail(Board board);
	
	//라이브러리 문의하기 검색후 데이타 가져오는 메서드
	public List<Board> inquirySearchListAjax(Board board);
	
	//라이브러리 문의 등록
	public void libraryInquiryInsert(Board board);
	
	//마이페이지 내 문의 신청 내역 이동
	public List<Board> myinquiryList(Board board);
}
