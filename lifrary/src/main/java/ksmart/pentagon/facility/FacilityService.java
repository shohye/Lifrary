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
	public String reserveFacility(FacilityReservation fr) {
		List<String> frResult = getReserVation(fr.getuId(), fr.getlCode(), fr.getfKinds()); // 결과값이 나오면 오늘 한번이라도 예약한것.
		String result = null;
		if (frResult.size() == 0) { // 객체가 없으면 오늘 예약을 한번도 안한것.
			facilityMapper.reserveFacility(fr);
			result = "예약을 완료하였습니다.";
		} else {
			result = "예약을 한 기록이 있어 예약이 불가합니다.";
		}
		return result;
	}

	// 공공시설 당일에 예약했는지 확인 , 공공시설 예약 처리에서 메서드를 사용합니다.
	public List<String> getReserVation(String uId, String libNum, String fKinds) {
		System.out.println(uId + "     " + libNum + "     " + fKinds);
		List<String> frResult = facilityMapper.getRevserVation(uId, libNum, fKinds);
		return frResult;
	}

	// 공공시설 예약 리스트 출력
	public List<FacilityReservation> getFacilityReservation(String fKinds, String libNum) {
		return facilityMapper.getFacilityReservation(fKinds, libNum);
	}

	// myPage 내가 신청한 공공시설 리스트 보기.
	public List<FacilityReservation> getFacilityReservationList(String uId, String libNum, String fKinds) {

		return facilityMapper.getFacilityReservationList(uId, libNum, fKinds);
	}

	// 시설 예약코드를 하나 받아 (예약시작 < 현재시간 < 예약종료) 시작과 종료 사이에 있는지 체크후 사이에 해당되는것을 가져온후
	// 객체가 있다면 ( 연장 가능한것 ) extensionChange 메서드를 호출하여 X를 O로 바꿔준다. 처리 완료라는 문자열을 보내준다.
	// 객체가 없다면 ( 시간이 지나 연장이 불가능 ) 불가능하다는 문자열을 컨트롤러로 보내준다.
	public String getReservation(String frCode){
		FacilityReservation fr = facilityMapper.getReservation(frCode);
		String frExtension = fr.getFrExtension();
		String result = "";
		
			if (frExtension.equals("X")) { // 연장 여부가 X인 경우, 연장해주는 쿼리를 실행. 
				facilityMapper.extensionChange(frCode);
				result = "연장완료";
			} 
			else if (frExtension.equals("O")) { // 연장 여부가 O인경우, 연장이 안된다는 문자열 보낼것.
				result = "연장불가";
			} 		
		
		return result;
	}
	
	// 퇴실버튼 클릭시, 예약 종료시간을 현재시간으로 바꿔준다.
		public void frEndDateChange(String frCode) {
			facilityMapper.frEndDateChange(frCode);
		}
}
