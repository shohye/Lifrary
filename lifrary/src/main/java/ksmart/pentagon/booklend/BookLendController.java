package ksmart.pentagon.booklend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookLendController {
	@Autowired private BookLendService booklendservice;
	
	@GetMapping("/lendsearchlist.do")
	public String bookLendSearchList(Model model){
		
		model.addAttribute("lendList", booklendservice.bookSearchList());
		

		return "adminpage/bookLend/lendSearchList";
	}
		
	@PostMapping("/lendbookinfo.do")
	public String lendbookinfo( @RequestParam(value="svBook" ) String svBook){
		
		System.out.println("svBook: " + svBook);
		booklendservice.bookInfo(svBook);
		
		return "adminpage/bookLend/lendSearchList";
	}
	
	

}
