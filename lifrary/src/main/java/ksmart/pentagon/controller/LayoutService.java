package ksmart.pentagon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.pentagon.vo.LayoutStats;

@Service
public class LayoutService {
	
	@Autowired private LayoutMapper layoutMapper;
	
	public LayoutStats statsCount(@RequestParam(value = "libnum")String libnum) {
		LayoutStats layoutStats = new LayoutStats();
		layoutStats.setBsStockState(layoutMapper.bookStockCount(libnum));
		layoutStats.setBlLendDate(layoutMapper.bookLendCount(libnum));
		layoutStats.setLibrarian(layoutMapper.librarianCount(libnum));
		layoutStats.setMember(layoutMapper.memberCount(libnum));
		System.out.println("service20 : " + layoutStats);
		return layoutStats;
	}

}
