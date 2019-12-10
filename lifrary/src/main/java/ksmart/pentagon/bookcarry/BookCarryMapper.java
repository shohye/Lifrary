package ksmart.pentagon.bookcarry;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookCarry;

@Mapper
public interface BookCarryMapper {

	// 오더리스트 출력
	List<BookCarry> getOrderList();
	
	// 구매 리스트 출력
	List<BookCarry> getPurchaseList();
	
	// 기부자 리스트 출력
	
}
