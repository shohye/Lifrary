package ksmart.pentagon.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.Calender;

@Mapper
public interface BookCalenderMapper {

	public List<Calender> getMyCalenderList(String libNum, String uId);
	
	public List<BookInformation> getBooKInfo(String libNum, String biName);
}
