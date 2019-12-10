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

}
