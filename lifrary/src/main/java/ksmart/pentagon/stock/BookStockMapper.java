package ksmart.pentagon.stock;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;

@Mapper
public interface BookStockMapper {

	// (어드민) 전체 소장도서 리스트 출력
	public List<BookStock> getStockList(String lCode);
	
	// (어드민) 소장도서중 한개도서 상세정보 가져오기
	public BookStock getStockdetail(String bsCode);
	
	// (도서관) 대분류, 도서명으로 검색된 소장도서 리스트 출력
	public List<BookStock> getSearchStockList(String bclCode,String biName,String lCode);
	
	// (도서관) 도서 상세페이지 - 반납예정일 계산하는 메서드
	public BookLend getReturnDate(String bsCode);
	
	
/*************************************************************/	
	
	
	// 도서정보 가지고 오기 AJAX	
	BookInformation getBookInfoStock(String biIsbn);
	
	// Api를 통해 가져온 도서정보 인서트	
	int insertBookInfoStock(BookInformation bookInformation);

	
}
