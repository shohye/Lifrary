package ksmart.pentagon.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.Calender;

@Service
public class BookCalenderService {
	@Autowired private BookCalenderMapper bookCalenderMapper;
	//내 캘린더 리스트 
	public List<Calender> getMyCalenderList(String libNum, String uId){
		
		return bookCalenderMapper.getMyCalenderList(libNum, uId);
	}
	//도서정보
	public List<BookInformation> getBooKInfo(String libNum, String biName) {
		
		return bookCalenderMapper.getBooKInfo(libNum, biName);
	}
	public int myCalenderInsert(Calender calender) {
		
		return bookCalenderMapper.myCalenderInsert(calender);
	}
}
