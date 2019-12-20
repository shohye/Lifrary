package ksmart.pentagon.point;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Point;

@Mapper
public interface PointMapper {

	public List<Point> pointHistorySearchList(String libNum);
	
	public int pointHistoryDelete(String phCode);
	
	public List<Point> pointList(String libNum);
}
