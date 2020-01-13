package ksmart.pentagon.booklend;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.User;
@Mapper
public interface BookLendMapper {
	//대출도서 리스트
	public List<BookLend> bookSearchList(String libNum);
	//대출기록 확인
	public int bookLendCheck(String libNum, String svBook);
	//도서정보
	public BookStock bookInfo(String libNum, String svBook);
	//대출기록 있는 도서정보 
	public BookStock bookInfoStock(String libNum, String svBook);
	//회원정보 	
	public User userInfo(String libNum, String svUser);
	//대출도서 등록
	public int lendInsert(BookLend booklend);
	//대출상태 수정
	public int stockUpdate(String bsCode, String lendState);
	//반납일 등록
	public int returnUpdate(String blCode);
	//예약도서 대출 등록
	public int holdUpdate(String saId, String blCode, String ulLendDay);
	//연장일 등록
	public int extensionUpdate(String blCode) ;
	//예약도서 리스트
	public List<BookLend> holdSearchList(String libNum);
	//예약취소
	public int holdDelete(String blCode);
	//회원 대출 도서 리스트 카운트
	public int myLendListCnt(Map<String,Object> params);
	//회원 대출 도서 리스트
	public List<BookLend> myLendList(Map<String,Object> params);
	//회원 예약 도서 리스트 카운트
	public int myHoldListCnt(Map<String,Object> params);
	//회원 예약 도서 리스트
	public List<BookLend> myHoldList(Map<String,Object> params);
}
