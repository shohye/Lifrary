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

	@Autowired
	private StockBookCheckService stockBookCheckService;

	/**
	 * 장서점검 페이지로 진입
	 * 
	 * @param model
	 * @return adminLogin페이지
	 * @author 한우리
	 **/

	// 장서 점검회차 리스트
	@GetMapping("/admin/stockCheckList")
	public String stockCheckList(Model model, HttpSession session) {
		String SAID = (String) session.getAttribute("SAID");
		String libNum = (String) session.getAttribute("LIBNUM");

		model.addAttribute("stockCheckList", stockBookCheckService.stockCheckList(SAID, libNum));

		return "/adminpage/stockCheck/stockCheckList";
	}

}
