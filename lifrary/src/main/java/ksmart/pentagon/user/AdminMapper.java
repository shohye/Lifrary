package ksmart.pentagon.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import ksmart.pentagon.vo.LibrarianLevel;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserAuthorityHistory;
import ksmart.pentagon.vo.UserAuthoritySet;
import ksmart.pentagon.vo.UserLevel;
import ksmart.pentagon.vo.UserLevelHistory;

/*
 * @file   AdminMapper.java 
 * @name   Admin mapper
 * @brief  어드민 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface AdminMapper {

	
	//사서 채널 로그인 처리 / 회원 정보 유무 확인후 로그인 , 도서관코드에 맞는 아이디 로그인.
	public User adminLoginCheck(String uId);
	
	//유저 회원 전체 가져오기.
	public List<User> getUserList(String libNum);
	
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
	public int adUserLevelInsert(UserLevel userLevel);
	
	//관리자가 회원등급 리스트
	public List<UserLevel> adUserLevelList(String libNum);
	
	//관리자가 회원등급수정-getmapping
	public UserLevel getAdUserLevelUpdate(String ulLevel, String getSAID);
	
	//관리자가 회원등급수정 postmapping
	public int adUserLevelUpdate(UserLevel userLevel);  
	
	//회원등급내역리스트
	public List<UserLevelHistory> adUserLevelHistorySearchList(String libNum);
	
	//회원등급내역리스트
	public List<UserLevelHistory> adUserLevelHistorySearch();
	
	
	/**********************************************************/
	
	
	//관리자가 회원권한 등록하기.
	public int adUserAuthorityInsert(UserAuthoritySet userAuthoritySet);
	
	//관리자가 회원 권한 리스트보기
	public List<UserAuthoritySet> adUserAuthorityList(String libNum);
	
	//관리자가 회원 권한 수정하기 getmapping
	public UserAuthoritySet getAdUserAuthorityUpdate(String uasCode, String getSAID);
	 
	//관리자가 회원 권한 수정하기 postmapping
	public int adUserAuthorityUpdate(UserAuthoritySet userAuthoritySet);
	
	//회원등급내역리스트
	public List<UserAuthorityHistory> adUserAuthorityHistorySearchList(String libNum);
	
	//회원등급내역리스트
	public List<UserAuthorityHistory> adUserAuthorityHistorySearch();
	
	
	/**********************************************************/
	
	
	//관리자가라는  사서 등록
	public int librarianInsert1(User user);
	public int librarianInsert2(LibrarianLevel librarianLevel);

	//관리자가보는  사서 리스트
	public List<User> librarianLevelList1(String libNum);
	public List<User> librarianLevelList2(String libNum);
	
	
	//관리자가 회원정보&권한 수정 - 한개정보만 가져오기
	public User getLibrarianLevelUpdate(String uId, String libNum);
	//관리자가 회원정보&권한 수정
	public int librarianLevelUpdate1(User user);
	public int librarianLevelUpdate2(LibrarianLevel librarianLevel);
	
	//관리자가 사서 회원 상세보기.
	public User librarianDetail(String uId);
	
	
	//사서 - 사서 내 정보 수정하기.
	public User getLibrarianMyUpdate(String getSAID, String libNum);
	//사서 - 사서 내정보 수정후 상세페이지로 이동
	public int librarianMyUpdate(User user);
	
	//사서 - 사서 내 정보 상세보기.
	public User librarianMyDetail(String getSAID, String libNum);
	
	
	/***************************************************************/
	
	//삭제 Ajax
	
	// delete AJAX( 사서  비번과 비교 후 맞으면 삭제 )
	// 사서 아이디 ,비번 확인
	public User checkPw(String said, String write);
	//userSearchList - 관리자가 회원 삭제
	public int deleteUser(String uId); 
	//adUserLevelList - 관리자가 회원등급 삭제
	public int deleteLevel(String ulLevel);
	
	
}
