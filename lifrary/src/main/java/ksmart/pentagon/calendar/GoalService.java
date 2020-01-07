package ksmart.pentagon.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Goal;

@Service
public class GoalService {
	@Autowired private GoalMapper goalMapper;
	//목표량 등록
	public int goalInsert(Goal goal) {
		return goalMapper.goalInsert(goal);		
	}
	public List<Goal> getGoalList(String uId, String gEndDate){
		List<Goal> list = goalMapper.getGoalList(uId, gEndDate);
		
		for(int i = 0; i<list.size(); i++) {
			Goal goal = list.get(i);
			int gNum = goal.getgNum();
			int lendCnt = goal.getLendCount();
			int percent =(int)((double) lendCnt / (double) gNum * 100.0);
			if(percent > 100) {
				percent = 100;
			}
			goal.setPercent(percent);
		}
		return list;
	}

}
