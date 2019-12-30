package ksmart.pentagon.stockcheck;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @file   StockBookCheckController.java //파일
 * @name   StockBookCheck Controller //이름
 * @brief  관리자페이지 장서점검  //기능
 * @author 한우리 //작성자
 */

@Controller
public class StockBookCheckController {

	@Autowired private StockBookCheckService stockBookCheckService;
	
	/**
	 * 장서점검 페이지로 진입
	 * @param  model                            
	 * @return adminLogin페이지
	 * @author 한우리
	 **/
	
	//장서 점검회차 리스트 
	@GetMapping("/admin/stockCheckList")
	public String stockCheckList(Model model, HttpSession session) {
		System.out.println("stockCheckList 장서점검 회차리스트 ");
		String SAID = (String)session.getAttribute("SAID");
		String libNum = (String)session.getAttribute("LIBNUM");
		System.out.println("SAID 세션에서가져온 관리자 코드  >>>" + SAID );
		System.out.println("libNum 세션에서가져온 도서관 코드  >>>" + libNum );
		
		model.addAttribute("stockCheckList", stockBookCheckService.stockCheckList(SAID, libNum));
		System.out.println("장서점검리스트 stockCheckList 확인바람 =>> "+ stockBookCheckService.stockCheckList(SAID, libNum));
		
		return "/adminpage/stockCheck/stockCheckList";
	}
	
	
}
