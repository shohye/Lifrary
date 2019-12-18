package ksmart.pentagon.user;



import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserLevel;


/*
 * @file   LibraryService.java 
 * @name   library mapper 
 * @brief  도서관 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface LibraryMapper {
	//입력한 uId에 해당하는    uPw, uDivision 리턴 / 도서관코드에 따른 세션 분리
	public User loginCheck(String uId, String libNum);
	
	//회원가입
	public int userInsert(User user);
}
