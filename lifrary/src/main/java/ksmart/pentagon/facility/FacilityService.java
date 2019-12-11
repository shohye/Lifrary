package ksmart.pentagon.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @file   facilityService.java 
 * @name   facility service
 * @brief  공공시설 관련 기능 메서드 처리 로직 구현
 * @author 김상협 
 */

@Service
public class FacilityService {

	@Autowired private FacilityMapper facilityMapper;
}
