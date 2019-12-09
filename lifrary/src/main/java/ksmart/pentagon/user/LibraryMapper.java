package ksmart.pentagon.user;



import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.User;


/*
 * @file   LibraryService.java 
 * @name   library mapper 
 * @brief  도서관 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface LibraryMapper {
	//입력한 uId에 해당하는    uPw, uDivision 리턴
	public User loginCheck(String uId);
}
