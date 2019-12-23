package ksmart.pentagon.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Calender;

@Service
public class BookCalenderService {
	@Autowired private BookCalenderMapper bookCalenderMapper;
	public List<Calender> getMyCalenderList(String libNum, String uId){
		
		return bookCalenderMapper.getMyCalenderList(libNum, uId);
	}
}
