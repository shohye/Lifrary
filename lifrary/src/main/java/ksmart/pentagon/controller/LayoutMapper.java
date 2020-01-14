package ksmart.pentagon.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface LayoutMapper {

	//소장도서 카운트	
	public String bookStockCount(@RequestParam(value = "libnum")String libnum);
	
	//금일 대출도서 카운트
	public String bookLendCount(@RequestParam(value = "libnum")String libnum);
	
	//사서 카운트
	public String librarianCount(@RequestParam(value = "libnum")String libnum);
	
	//회원 카운트
	public String memberCount(@RequestParam(value = "libnum")String libnum);
}
