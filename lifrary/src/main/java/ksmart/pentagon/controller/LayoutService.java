package ksmart.pentagon.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	public ArrayList<ArrayList> getAreaOpenApi(@RequestParam(value = "startDt")String startDt,
			@RequestParam(value = "endDt")String endDt,
			@RequestParam(value = "area")String area){
		System.out.println("service 33 : " + startDt + endDt + area);
		AreaOpenApi OpenApi = new AreaOpenApi();
		ArrayList<ArrayList> list = OpenApi.OpenApi(startDt,endDt,area);
		System.out.println("Service72 : " + list);
		return list;
	}
	
	public ArrayList<ArrayList> getAge( @RequestParam(value = "startDt")String startDt,
										@RequestParam(value = "endDt")String endDt,
										@RequestParam(value = "fromAge")String fromAge,
										@RequestParam(value = "toAge")String toAge){
		String gender = "2";
		String aera = "0";
		AgeOpenApi ageOpenApi = new AgeOpenApi();
		ArrayList<ArrayList> List = ageOpenApi.OpenApi(startDt, endDt, gender, fromAge, toAge, aera);
		
	return List;	
	}
	
	public ArrayList<ArrayList> getAera(@RequestParam(value = "gender")String gender,
										@RequestParam(value = "fromAge")String fromAge,
										@RequestParam(value = "toAge")String toAge,
										@RequestParam(value = "area")String area
			){
		Calendar sum = Calendar.getInstance();
        DateFormat newendDt = new SimpleDateFormat("yyyy-MM-dd");
        sum.add(Calendar.MONTH, -1);
        String startDt = newendDt.format(sum.getTime());
        sum.setTime(new Date());
        String endDt = newendDt.format(sum.getTime());
        AgeOpenApi ageOpenApi = new AgeOpenApi();
		ArrayList<ArrayList> List = ageOpenApi.OpenApi(startDt, endDt, gender, fromAge, toAge, area);
		return List;
	}

}
