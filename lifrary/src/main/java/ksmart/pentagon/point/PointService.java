package ksmart.pentagon.point;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Paging;
import ksmart.pentagon.vo.Point;

@Service
public class PointService {
	@Autowired private PointMapper pointMapper;
	//포인트 사용 내역 리스트
	public List<Point> pointHistorySearchList(String libNum){
		
		return pointMapper.pointHistorySearchList(libNum);
	
	}
	//포인트 사용 내역 삭제
	public int pointHistoryDelete(String phCode) {
		
		return pointMapper.pointHistoryDelete(phCode);

	}
	//포인트 리스트
	public List<Point> getPointList(String libNum){
		
		return pointMapper.getPointList(libNum);
	
	}
	//포인트 등록
	public int pointInsert(Point point) {
		
		return pointMapper.pointInsert(point);

	}
	//포인트 정보
	public Point getPoint(String pCode) {
		
		return pointMapper.getPoint(pCode);
	}
	//포인트 수정
	public int updatePoint(Point point) {
		return pointMapper.updatePoint(point);
	}
	//포인트 삭제
	public int pointDelete(String pCode) {
		return pointMapper.pointDelete(pCode);
	}
	//회원 포인트 리스트
	public Map<String, Object> myPointList(String uId, String currentPageStr){
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("uId", uId);
		
		int myPointCnt = pointMapper.myPointListCnt(uId);
        Paging paging =  new Paging(myPointCnt, currentPageStr);
        int currentPage = paging.getCurrentPage();
        int lastPage = paging.getLastPage();
        int startPageNum = paging.getStartPageNum();
        int lastPageNum = paging.getLastPageNum();
        
        int startRow = paging.getStartRow();
        int ROW_PER_PAGE = Paging.getRowPerPage();
        
        params.put("startRow", startRow);
        params.put("rowPerPage", ROW_PER_PAGE);
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("myPointList", pointMapper.myPointList(params));
        resultMap.put("currentPage", currentPage);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	}
	//회원 총포인트
	public String myTotalPoint(String uId) {

		return pointMapper.myTotalPoint(uId);
	}
	//사용 포인트 리스트
	public List<Point> getUsePointList(String libNum){
		return pointMapper.getUsePointList(libNum);
	}
	//포인트 사용 내역 등록
	public int myPointInsert(Point point) {
		
		return pointMapper.myPointInsert(point);
		
	}

}
