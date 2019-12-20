package ksmart.pentagon.point;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Point;

@Service
public class PointService {
	@Autowired private PointMapper pointMapper;
	
	public List<Point> pointHistorySearchList(String libNum){
		
		return pointMapper.pointHistorySearchList(libNum);
	
	}
	
	public int pointHistoryDelete(String phCode) {
		
		return pointMapper.pointHistoryDelete(phCode);

	}
	
public List<Point> pointList(String libNum){
		
		return pointMapper.pointList(libNum);
	
	}

}
