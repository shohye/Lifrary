package ksmart.pentagon.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Calender;

@Mapper
public interface BookCalenderMapper {

	public List<Calender> getMyCalenderList(String libNum, String uId);
}
