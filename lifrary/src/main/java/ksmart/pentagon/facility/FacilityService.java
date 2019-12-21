package ksmart.pentagon.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Facility;

/*
 * @file   facilityService.java 
 * @name   facility service
 * @brief  공공시설 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class FacilityService {

	@Autowired
	private FacilityMapper facilityMapper;

	// 시설종류, 시설코드를 받아 리스트 받아오는 메서드
	public List<Facility> getFacilityList(String fKinds, String libNum) {
		return facilityMapper.getFacilityList(fKinds, libNum);
	}

	// 선택한 시설의 코드를 이용하여 , 해당 시설의 상세정보 리스트 보여주기
	public Facility getFacility(String fCode, String libNum) {
		return facilityMapper.getFacility(fCode, libNum);
	}

	// 시설 등록하기.
	public void insertFacility(Facility facility) {
		facilityMapper.insertFacility(facility);
	}
}
