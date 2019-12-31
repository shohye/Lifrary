package ksmart.pentagon.facility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.Facility;
import ksmart.pentagon.vo.FacilityReservation;

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

	// 시설 수정하기.
	public void updateFacility(Facility facility) {
		facilityMapper.updateFacility(facility);
	}

	// 시설코드 하나를 받아 공공시설 삭제하기
	public void deleteFacility(String fCode) {
		facilityMapper.deleteFacility(fCode);
	}

	// 시설코드를 하나 받아 (예약시작 < 현재시간 < 예약종료) 시작과 종료 사이에 있는지 체크후 사이에 해당되는것을 카운트.
	public List<String> getReservationSeat(String fCode) {
		List<FacilityReservation> frList = facilityMapper.getReservationSeat(fCode); // 결과를 frList에 담는다.
		List<String> frStringList = new ArrayList<String>();
		for (int i = 0; i < frList.size(); i++) {
			System.out.println(frList.get(i));
			frStringList.add(frList.get(i).getFrSelectNum()); // frList에서 사용중인 자리만 뽑아서 frStringList에 add한다.
		}
		return frStringList;
	}

	// 공공시설 예약 처리
	public String reserveFacility(FacilityReservation fr, String fKinds) {
		FacilityReservation frResult =  getRevserVation(fr.getuId(), fr.getlCode()); // 결과값이 나오면 오늘 한번이라도 예약한것.
		String result = null;
		if(frResult == null) { // 객체가 없으면 오늘 예약을 한번도 안한것.
			facilityMapper.reserveFacility(fr, fKinds);
			result = "예약을 완료하였습니다.";
		} else {
			result = "당일 예약을 한 기록이 있어 예약이 불가합니다.";
		}
		return result;
	}

	// 공공시설 당일에 예약했는지 확인 , 공공시설 예약 처리에서 메서드를 사용합니다.
	public FacilityReservation getRevserVation(String uId, String libNum) {
		FacilityReservation frResult = facilityMapper.getRevserVation(uId, libNum);
		return frResult;
	}
}
