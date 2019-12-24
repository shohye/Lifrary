package ksmart.pentagon.bookcarry;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookRequest;
import ksmart.pentagon.vo.User;

@Mapper
public interface BookCarryMapper {

	// 오더리스트 출력
	List<BookCarry> getOrderList(String lCode);
	// 오더 도서 한개정보출력 =>수정화면	
	BookCarry getOrderUpdate(String boCode);
	// 오더 도서 업데이트
	int updateOrder(BookCarry bookCarry);
	int updateBookInformation(BookInformation bookInformation);
	// 오더 도서 인서트  ver1(insert+insert)
	// insertBookInformation 사용
	// 오더 도서 인서트  ver2(update+insert)
	int insertOrderBookCarry(BookCarry bookCarry);
		
	/*************************************************************/	
	
	
	// 구매 리스트 출력
	List<BookCarry> getPurchaseList(String lCode);
	// 구매 도서 한개정보출력 =>수정화면	
	BookCarry getPurchaseUpdate(String bpCode);
	// 구매 도서 업데이트
	int updatePurchase(BookCarry bookCarry);
	// 구매도서 인서트 ver2(update+insert)
	// int updatePurchase2(BookInformation bookInformation);
	int insertPurchaseBookCarry(BookCarry bookCarry);

	// 구매도서 인서트 ver1(insert+insert)
	// int insertPurchaseBookCarry(BookCarry bookCarry);
	// int insertBookInfo(BookInformation bookInformation);
	
	/*************************************************************/	
	
	
	// 기부자 리스트 출력
	List<BookCarry> getDonationList(String lCode);				
	// 기부자 한개정보출력 =>수정화면	
	BookCarry getDonationUpdate(String bdnCode);
	// 기부자 업데이트
	int updateDonation(BookCarry bookCarry);
	// 기부자 인서트
	int insertDonation(BookCarry bookCarry);
	// 기부자 리스트 버튼으로 상태변경
	//1. 기부자스티커
	int updateStickerO(String bdnCode);
	int updateStickerX(String bdnCode);
	
	/*************************************************************/	
	
	
	// 희망도서신청 리스트 출력
	List<BookRequest> getRequestList(String lCode);
	// 희망도서 한개정보 출력 => 상세정보 화면
	BookRequest getRequestDatail(String brCode);
	// 희망도서 인서트
	int insertRequest(BookRequest bookRequest);
	//( 도서관 ) 사용자 id를 기준으로 하는 희망도서 신청 리스트
	List<BookRequest> getMyRequestList(String uid);
	
	
	/*************************************************************/	
	
	
	// 도서정보 가지고 오기 AJAX	
	BookInformation getBookInfo(String biIsbn);
	
	// Api를 통해 가져온 도서정보 인서트	
	int insertBookInfo(BookInformation bookInformation);
	
	// delete AJAX( 사서  비번과 비교 후 맞으면 삭제 )
	// book_order
	int deleteOrder(String said, String write, String boCode);
	// book_purchase
	int deletePurchase(String said, String write, String bpCode);
	// book_donation
	int deleteDonation(String said, String write, String bdnCode);
	
	
	
}
