package ksmart.pentagon.point;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {

	//포인트사용이력리스트
	@GetMapping("/admin/pointList")
	public String pointList() {
		
		
		return "adminpage/point/pointList";
		
	}
}
