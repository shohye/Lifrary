package ksmart.pentagon.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserLevel;

/*
 * @file   AdminMapper.java 
 * @name   Admin mapper
 * @brief  어드민 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface AdminMapper {

	//유저 레벨 전체 가져오기.
	public List<UserLevel> getUserLevel();
	
	//유저 회원 전체 가져오기.
	public List<User> getUserList();
	
	//유저 회원 검색조건 가져오기.
	public List<User> getUserSearch();
	
	//유저 회원 수정처리. (리턴타입이 int -정상반환이 1 아니면 0 이기때문)
	public int adminUserUpdate(User user);
	
	//유저 회원 수정하기위해 uid로 정보 다 가져오기
	public User getAdminUserUpdate(String uId);
	
	//관리자가 사서 등록
	public int librarianInsert(LibrarianLevel librarianLevel); 
	
}
