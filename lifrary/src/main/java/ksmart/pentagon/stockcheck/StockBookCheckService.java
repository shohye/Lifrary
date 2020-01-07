package ksmart.pentagon.stockcheck;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.StockBookTimes;

@Service
public class StockBookCheckService {

	@Autowired 
	private StockBookCheckMapper stockBookCheckMapper;
	
	public List<StockBookTimes> stockCheckList(String SAID, String libNum) {
		System.out.println("stockCheckList 서비스진입");
		
		return stockBookCheckMapper.stockCheckList(SAID, libNum);
	}
}
