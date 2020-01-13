package ksmart.pentagon.point;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Point;

@Mapper
public interface PointMapper {
	//포인트 사용 내역 리스트
	public List<Point> pointHistorySearchList(String libNum);
	//포인트 사용 내역 등록
	public int pointHistoryInsert(Point Point);
	//포인트 사용 내역 삭제
	public int pointHistoryDelete(String phCode);
	//포인트 리스트
	public List<Point> getPointList(String libNum);
	//포인트 등록
	public int pointInsert(Point point);
	//포인트 정보
	public Point getPoint(String pCode);
	//포인트 수정
	public int updatePoint(Point point);
	//포인트 삭제
	public int pointDelete(String pCode);
	//회원 포인트 리스트 카운트
	public int myPointListCnt(String uId);
	//회원 포인트 리스트
	public List<Point> myPointList(Map<String,Object> params);
	//회원 총포인트
	public String myTotalPoint(String uId);
	//사용 포인트 리스트
	public List<Point> getUsePointList(String libNum);
	//포인트 사용 내역 등록
	public int myPointInsert(Point point);
	
}
