package ksmart.pentagon.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthoritySet;
import ksmart.pentagon.vo.UserLevel;

/*
 * @file   AdminMapper.java 
 * @name   Admin mapper
 * @brief  어드민 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface AdminMapper {

	
	//사서 채널 로그인 처리 / 회원 정보 유무 확인후 로그인 , 도서관코드에 맞는 아이디 로그인.
	public User adminLoginCheck(String uId, String libNum);
	
	//유저 회원 전체 가져오기.
	public List<User> getUserList();
	
	//유저 회원 검색조건 가져오기.
	public List<User> getUserSearch();
	
	//유저 회원 수정처리. (리턴타입이 int -정상반환이 1 아니면 0 이기때문)
	public int adminUserUpdate(User user); 
	
	//유저 회원 수정하기위해 uid로 정보 다 가져오기
	public User getAdminUserUpdate(String uId);
	
	//유저 회원 상세보기.
	public User adminUserDetail (String uId);
	 
	/**********************************************************/
	 
	//관리자가 회원등급 등록하기
	public int userLevelInsert(UserLevel userLevel);
	
	//관리자가 회원등급 리스트
	public List<UserLevel> adUserLevelList();
		
	/**********************************************************/
	
	
	//관리자가 회원권한 등록하기.
	public int adUserAuthorityInsert(UserAuthoritySet userAuthoritySet);
	
	//관리자가 사서 등록
	public int librarianInsert(LibrarianLevel librarianLevel);

	
}
