package ksmart.pentagon.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Goal;

@Mapper
public interface GoalMapper {
	//목표량 리스트
	public List<Goal> getGoalList(String uId, String gEndDate);
	//목표량 등록
	public int goalInsert(Goal goal);
}
