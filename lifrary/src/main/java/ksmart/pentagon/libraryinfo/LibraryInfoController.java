package ksmart.pentagon.libraryinfo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryInfoController {
	
	@GetMapping("/lifrary/libraryInfomation")
	public String libraryInfomation() {
		return "librarypage/libraryInfo/libraryInformation";
	}

}
