package ksmart.pentagon.bookcarry;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookCarry;

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
		
}
