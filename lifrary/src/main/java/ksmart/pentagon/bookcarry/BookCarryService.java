package ksmart.pentagon.bookcarry;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookRequest;

@Service
public class BookCarryService {
	
	@Autowired BookCarryMapper bookCarryMapper;
	
	// 오더리스트 출력
	public List<BookCarry> getOrderList(){
		return bookCarryMapper.getOrderList();	
	}
	// 오더 도서 한개정보출력/ 수정화면	
	public BookCarry getOrderUpdate(String boCode) {
		return bookCarryMapper.getOrderUpdate(boCode);		
	}
	// 오더 도서 업데이트
	public int updateOrder1(BookCarry bookCarry) {
		return bookCarryMapper.updateOrder1(bookCarry);
	}
	public int updateOrder2(BookInformation bookInformation) {
		return bookCarryMapper.updateOrder2(bookInformation);
	}
	
	
	/*************************************************************/	
	
	
	// 구매리스트 출력
	public List<BookCarry> getPurchaseList(){
		return bookCarryMapper.getPurchaseList();
	}
	// 구매 도서 한개정보출력/ 수정화면	
	public BookCarry getPurchaseUpdate(String bpCode) {
		return bookCarryMapper.getPurchaseUpdate(bpCode);
		
	}
	// 구매 도서 업데이트
	public int updatePurchase1(BookCarry bookCarry) {
		return bookCarryMapper.updatePurchase1(bookCarry);
	}
	public int updatePurchase2(BookInformation bookInformation) {
		return bookCarryMapper.updatePurchase2(bookInformation);
	}
	
	/*************************************************************/		
	
	
	// 기부자리스트 출력
	public List<BookCarry> getDonationList(){
		return bookCarryMapper.getDonationList();
	}				
	// 기부자 한개정보출력/ 수정화면	
	public BookCarry getDonationUpdate(String bdnCode) {
		return bookCarryMapper.getDonationUpdate(bdnCode);		
	}
	// 기부자 업데이트
	public int updateDonation(BookCarry bookCarry) {
		return bookCarryMapper.updateDonation(bookCarry);
	}
	
	
	/*************************************************************/	
	
	
	// 희망도서신청 리스트 출력
	public List<BookRequest> getRequestList() {
		
		System.out.println("서비스 출력 --------------------------");
		List<BookRequest> br = bookCarryMapper.getRequestList();
		String cancelReason =null;
		String opinion =null;
		for(int i =0; i<br.size(); i++) {			
			cancelReason = br.get(i).getBrCancelReason();
			opinion = br.get(i).getBrOpinion();
			
			if(cancelReason == null) {
				cancelReason = "-";	
				br.get(i).setBrCancelReason(cancelReason);			
			}			
			if(opinion == null) {
				opinion = "-";
				br.get(i).setBrOpinion(opinion);
			}			
		}
		System.out.println("opinion=>"+opinion);
			
		return br;		
	}
	
	// 희망도서 한개정보 출력 => 상세정보 회면
	public BookRequest getRequestDatail(String uId) {
		BookRequest br = bookCarryMapper.getRequestDatail(uId);
		
		String cancelReason =null;
		String opinion =null;
		String uid = null;
		
		if(br.getUser().getuId() == null) {
			uid = "공백";
			br.getUser().setuId(uid);
		}
		
		if(br.getBrCancelReason() == null) {
			cancelReason ="공백";
			br.setBrCancelReason(cancelReason);
		}
		
		if(br.getBrOpinion() == null) {
			opinion = "공백";
			br.setBrOpinion(opinion);
		}
		
		return br;		
	}
}
