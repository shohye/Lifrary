package ksmart.pentagon.bookcarry;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookRequest;

@Mapper
public interface BookCarryMapper {

	// 오더리스트 출력
	List<BookCarry> getOrderList();
	// 오더 도서 한개정보출력 =>수정화면	
	BookCarry getOrderUpdate(String boCode);
	// 오더 도서 업데이트
	int updateOrder1(BookCarry bookCarry);
	int updateOrder2(BookInformation bookInformation);
	
		
	/*************************************************************/	
	
	
	// 구매 리스트 출력
	List<BookCarry> getPurchaseList();
	// 구매 도서 한개정보출력 =>수정화면	
	BookCarry getPurchaseUpdate(String bpCode);
	// 구매 도서 업데이트
	int updatePurchase1(BookCarry bookCarry);
	int updatePurchase2(BookInformation bookInformation);
	
	
	/*************************************************************/	
	
	
	// 기부자 리스트 출력
	List<BookCarry> getDonationList();				
	// 기부자 한개정보출력 =>수정화면	
	BookCarry getDonationUpdate(String bdnCode);
	// 기부자 업데이트
	int updateDonation(BookCarry bookCarry);
	
	
	/*************************************************************/	
	
	
	// 희망도서신청 리스트 출력
	List<BookRequest> getRequestList();
	
	// 희망도서 한개정보 출력 => 상세정보 회면
	BookRequest getRequestDatail(String uId);
	
	/*************************************************************/	
	
	
	// 도서정보 가지고 오기 AJAX	
	BookInformation getBookInfo(String biIsbn);
	
	// Api를 통해 가져온 도서정보 인서트	
	int insertBookInfo(BookInformation bookInformation);
	
	
	
	
}
