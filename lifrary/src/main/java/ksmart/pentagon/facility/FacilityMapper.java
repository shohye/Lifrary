package ksmart.pentagon.facility;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Facility;

/*
 * @file   facilityMapper.java 
 * @name   facility mapper 
 * @brief  공공시설 관련 기능 추상메서드 작성 
 * @author 김상협 
 */

@Mapper
public interface FacilityMapper {

	//리스트 클릭시 기본적으로 열람실 리스트가 출력.
	//시설종류 문자열을 받아 해당되는 시설 출력. +도서관 코드 추가
	public List<Facility> getFacilityList(String fKinds, String libNum);
	
	//선택한 시설의 코드를 이용하여 , 해당 시설의 상세정보 보여주기
	public Facility getFacility(String fCode, String libNum);
	
	//시설 등록하기.
	public void insertFacility(Facility facility);
	
	//시설 수정하기.
	public void updateFacility(Facility facility);
	
}
