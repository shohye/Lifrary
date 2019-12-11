package ksmart.pentagon.point;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {

	@GetMapping("/admin/pointList")
	public String pointList() {
		
		
		return "adminpage/point/pointList";
		
	}
}
