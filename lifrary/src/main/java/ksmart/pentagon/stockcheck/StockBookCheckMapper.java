package ksmart.pentagon.stockcheck;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ksmart.pentagon.vo.StockBookTimes;

/*
 * @file   StockBookCheckMapper.java 
 * @name   admin StockBookCheck Mapper
 * @brief  장서점검 기능 추상메서드 작성 
 * @author 한우리
 */

@Mapper
public interface StockBookCheckMapper {

	//장서점검 회차 리스트
	public List<StockBookTimes> stockCheckList(String SAID, String libNum);
	
	
}
