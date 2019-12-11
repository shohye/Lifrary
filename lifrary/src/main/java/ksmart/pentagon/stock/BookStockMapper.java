package ksmart.pentagon.stock;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookStock;

@Mapper
public interface BookStockMapper {

	// 전체 소장도서 리스트 출력
	public List<BookStock> getStockList();
	
	// 소장도서중 한개도서 상세정보 가져오기
	public BookStock getStockdetail(String bsCode);
}
