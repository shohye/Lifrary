package ksmart.pentagon.stock;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookStock;

@Mapper
public interface BookStockMapper {

	//유저 레벨 전체 가져오기.
	public List<BookStock> getStockList();
}
