package ksmart.pentagon.facility;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Facility;
import ksmart.pentagon.vo.FacilityReservation;

/*
 * @file   facilityMapper.java 
 * @name   facility mapper 
 * @brief  공공시설 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface FacilityMapper {

	// 리스트 클릭시 기본적으로 열람실 리스트가 출력.
	// 시설종류 문자열을 받아 해당되는 시설 출력. +도서관 코드 추가
	public List<Facility> getFacilityList(String fKinds, String libNum);

	// myPage 내가 신청한 공공시설 리스트 보기.
	public List<FacilityReservation> getFacilityReservationList(String uId, String libNum, String fKinds);

	// 선택한 시설의 코드를 이용하여 , 해당 시설의 상세정보 보여주기
	public Facility getFacility(String fCode, String libNum);

	// 시설 등록하기.
	public void insertFacility(Facility facility);

	// 시설 수정하기.
	public void updateFacility(Facility facility);

	// 시설코드를 하나 받아 (예약시작 < 현재시간 < 예약종료) 시작과 종료 사이에 있는지 체크후 사이에 해당되는것을 가져오기
	public List<FacilityReservation> getReservationSeat(String fCode);

	// 시설 예약코드를 하나 받아 (예약시작 < 현재시간 < 예약종료) 시작과 종료 사이에 있는지 체크후 사이에 해당되는것을 가져오기
	public FacilityReservation getReservation(String frCode);

	// 연장버튼 클릭시, getReservation 메서드를 실행후 본 메서드를 실행할것. X인 상태를 O로 변경함.
	public void extensionChange(String frCode);

	// 퇴실버튼 클릭시, 예약 종료시간을 현재시간으로 바꿔준다.
	public void frEndDateChange(String frCode);

	// 시설코드 하나를 받아 공공시설 삭제하기
	public void deleteFacility(String fCode);

	// 공공시설 예약 처리 fKinds를 매개변수로 받아, 예약시 시간을 다르게 해줄것.
	public void reserveFacility(FacilityReservation fr);

	// 공공시설 당일에 예약했는지 확인
	public List<String> getRevserVation(String uId, String libNum, String fKinds);

	// 공공시설 예약 리스트 출력
	public List<FacilityReservation> getFacilityReservation(String fKinds, String libNum);

}
