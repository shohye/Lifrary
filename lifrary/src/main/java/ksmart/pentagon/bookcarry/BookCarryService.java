package ksmart.pentagon.bookcarry;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookRequest;

@Service
public class BookCarryService {
	
	@Autowired BookCarryMapper bookCarryMapper;
	
	// 오더리스트 출력
	public List<BookCarry> getOrderList(){
		return bookCarryMapper.getOrderList();	
	}
	
	// 구매리스트 출력
	public List<BookCarry> getPurchaseList(){
		return bookCarryMapper.getPurchaseList();
	}

	public List<BookCarry> getDonationList(){
		return bookCarryMapper.getDonationList();
	}
	
	// 오더 도서 한개정보출력/ 수정화면	
	public BookCarry getOrderUpdate(String boCode) {
		return bookCarryMapper.getOrderUpdate(boCode);
		
	}
		
	// 구매 도서 한개정보출력/ 수정화면	
	public BookCarry getPurchaseUpdate(String bpCode) {
		return bookCarryMapper.getPurchaseUpdate(bpCode);
		
	}		
		
	// 기부자 한개정보출력/ 수정화면	
	public BookCarry getDonationUpdate(String bdnCode) {
		return bookCarryMapper.getDonationUpdate(bdnCode);
		
	}
	
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
				cancelReason = "";	
				br.get(i).setBrCancelReason(cancelReason);
			
			}
			
			if(opinion == null) {
				opinion = "";
				br.get(i).setBrOpinion(opinion);
			}
			
		}
				
		
		
		
		
		System.out.println("opinion=>"+opinion);
		
		
	
		return br;
		
	}
		
}
