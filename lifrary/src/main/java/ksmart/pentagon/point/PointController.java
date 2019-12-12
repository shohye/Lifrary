package ksmart.pentagon.point;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * @file PointController.java
 * @name PointController
 * @brief 포인트 관련 주소요청 처리
 * @author 최지혜
 */
@Controller
public class PointController {

	
	/***
	 * @param 
	 * @brief 포인트리스트 
	 * @return adminpage/point/pointList
	 * @author 최지혜
	 * @date 19.12.12
	 */
	@GetMapping("/admin/pointList")
	public String pointList() {
		
		
		return "adminpage/point/pointList";
		
	}
	/***
	 * @param 
	 * @brief 포인트사용이력리스트 
	 * @return adminpage/point/pointHistorySearchList
	 * @author 최지혜
	 * @date 19.12.12
	 */
	@GetMapping("/admin/pointHistoryList")
	public String pointHistorySearchList() {
		
		
		return "adminpage/point/pointHistorySearchList";
		
		}
}
