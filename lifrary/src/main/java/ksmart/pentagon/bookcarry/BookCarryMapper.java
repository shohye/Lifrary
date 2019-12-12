package ksmart.pentagon.bookcarry;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookRequest;

@Mapper
public interface BookCarryMapper {

	// 오더리스트 출력
	List<BookCarry> getOrderList();
	
	// 구매 리스트 출력
	List<BookCarry> getPurchaseList();
	
	// 기부자 리스트 출력
	List<BookCarry> getDonationList();
	
	// 오더 도서 한개정보출력 =>수정화면	
	BookCarry getOrderUpdate(String boCode);
	
	// 구매 도서 한개정보출력 =>수정화면	
	BookCarry getPurchaseUpdate(String bpCode);
		
		
	// 기부자 한개정보출력 =>수정화면	
	BookCarry getDonationUpdate(String bdnCode);
	
	// 희망도서신청 리스트 출력
	List<BookRequest> getRequestList();
	
	// 희망도서 한개정보 출력 => 상세정보 회면
	BookRequest getRequestDatail(String uId);
	
}
