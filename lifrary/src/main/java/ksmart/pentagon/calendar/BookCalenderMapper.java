package ksmart.pentagon.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.Calender;

@Mapper
public interface BookCalenderMapper {
	//캘린더 리스트
	public List<Calender> getMyCalenderList(String libNum, String uId);
	//도서정보
	public List<BookInformation> getBooKInfo(String libNum, String biName);
	//캘린더 등록
	public int myCalenderInsert(Calender calender);
}
