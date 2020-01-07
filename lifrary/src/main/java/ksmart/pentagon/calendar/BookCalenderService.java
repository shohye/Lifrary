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
	//캘린더 일정 등록
	public int myCalenderInsert(Calender calender) {
		
		return bookCalenderMapper.myCalenderInsert(calender);
	}
	//수정할 캘린더 데이터
	public Calender getMyCalender(String cCode) {
		return bookCalenderMapper.getMyCalender(cCode);
	}
	//캘린더 일정 수정
	public int myCalenderUpdate(Calender calender) {
		return bookCalenderMapper.myCalenderUpdate(calender);
	}
	//캘린더 일정 삭제
	public int myCalenderDelete(String cCode) {
		
		return bookCalenderMapper.myCalenderDelete(cCode);
	}
	
}
