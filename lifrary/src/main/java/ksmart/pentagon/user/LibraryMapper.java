package ksmart.pentagon.user;



import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.StudyCate;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthorityHistory;
import ksmart.pentagon.vo.UserLevelHistory;


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
	public int userInsertUser(User user);
	public int userInsertUserLevelHistory(UserLevelHistory userLevelHistory);
	public int userInsertUserAuthorityHistory(UserAuthorityHistory userAuthorityHistory);
	public int userInsertStudyCate(StudyCate studyCate);
	
	//마이페이지 - 내정보
	public User myUserDetail(String getSID ,String libNum);
	
	public User getMyUserUpdate(String getSID ,String libNum);
	//내정보 수정후 상세페이지로 이동
	public int myUserUpdate(User user);
	
	
	//회원 존재 check
	public User deleteUserCheck(String SID, String uPw, String libNum);
	// 회원 삭제 Ajax 
	public void deleteUser(String SID);
}
