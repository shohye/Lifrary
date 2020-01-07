package ksmart.pentagon.bookstock;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.User;

@Mapper
public interface BookStockMapper {

	// (어드민) 전체 소장도서 리스트 출력
	public List<BookStock> getStockList(String lCode);
	
	// (어드민) 소장도서중 한개도서 상세정보 가져오기
	public BookStock getStockdetail(String bsCode);	
	
	// (어드민) 소장도서에서 삭제된 도서 리스트 출력( 상태를 삭제로 바꾼 도서 리스트)
	public List<BookStock> getStockDeleteList(String lCode);
	// (어드민) 소장도서에서 삭제중 한개도서 상세정보 가져오기
	public BookStock getStockDeleteDetail(String bsCode);
			
	// (어드민) 소장도서 인서트 ( book_stock insert/ book_information update)
	// information에 해당도서가 있는지 확인하는 메서드
	public BookInformation checkBookInfo(String biIsbn);
	public void insertStock(Map<String , Object> insertMap);
	public void updateBookInfoStock(BookInformation bookInformation);
	// api정보 없을때 +insertBookInfoStock
	
	// (도서관) 검색된 소장도서 리스트 출력
	public List<BookStock> getDetailSearchStockList(Map<String,Object> params);
	// 검색 시 결과 리스트목록 갯수 세는 메서드 
	public int getStockAllCount(Map<String,Object> params);
	
	
	// (도서관) 도서 상세페이지 - 반납예정일 계산하는 메서드
	public BookLend getReturnDate(String bsCode);
	
	// (어드민) 도서 정보 업데이트하는 메서드
	public void updateStock(Map<String , Object> stockMap);
	
	
	// (도서관) 회원 대출,예약 가능여부확인
	public User userInfoCheck(String lCode, String sid);	
	// (도서관) 홈페이지에서 도서 예약등록 
	public int holdInsert(String lCode, String sid , String bsCode );
	
	public void updateStockHoldLendState(String bsCode);
	
	
	
/*************************************************************/	
	
	
	// 도서정보 가지고 오기 AJAX	
	BookInformation getBookInfoStock(String biIsbn);
	
	// Api를 통해 가져온 도서정보 인서트	
	int insertBookInfoStock(BookInformation bookInformation);

	// deleteStock update ajax
	User checkPw(String said,String write);
	int updateStockDelete(String said,String bsCode, String bsDeleteReason);
	
	// resetStock update ajax
	// 아이디 ,비번체크 사용
	int updateStockReset(String bsCode);

	
}
