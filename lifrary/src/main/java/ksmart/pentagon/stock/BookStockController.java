package ksmart.pentagon.stock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @file   BookStockController.java
 * @name   bookStock controller 
 * @brief  소장도서 관리기능 처리
 * @author 신다은
 */

@Controller
public class BookStockController {
	
	@Autowired private BookStockService bookStockService;
	
	// (어드민) 소장도서 리스트
	@GetMapping("/admin/stockSearchList")
    public String stockSearchList(Model model) {
		
		model.addAttribute("stockList", bookStockService.getStockList());
		
    	return "/adminpage/bookStock/stockSearchList";
    }
	
	// (어드민) 소장도서 상세내용
	@GetMapping("/admin/stockDetail")
    public String stockDetail(Model model , @RequestParam(value="bsCode",required=false) String bsCode) {
		
	    if(bsCode == null) {
	    	return "redirect:/admin/stockSearchList";
	    }
		model.addAttribute("stockDetail",bookStockService.getStockdetail(bsCode));
		
    	return "/adminpage/bookStock/stockDetail";
    }
	
	// (어드민) 소장도서 상세수정 화면
	@GetMapping("/admin/stockDetailUpdate")
    public String stockDetailUpdate(Model model , @RequestParam(value="bsCode",required=false) String bsCode) {
		if(bsCode == null) {
			return "redirect:/admin/stockSearchList";
	    }  
		model.addAttribute("stockDetail",bookStockService.getStockdetail(bsCode));
		
    	return "/adminpage/bookStock/stockDetailUpdate";
    }
				

    // (도서관) 검색후 결과 도서 리스트
    @GetMapping("/lifrary/bookDataSearchList")
    public String bookDataSearchList() {
    	return "/librarypage/bookData/bookDataSearchList";
    }
    
    // (도서관) 검색후 도서 리스트(그리드 버전)
    @GetMapping("/lifrary/booksGridView")
    public String booksGridView() {
    	return "/librarypage/bookData/booksGridView";
    }
    
    // (도서관) 도서 상세페이지
    @GetMapping("/lifrary/bookDetail")
    public String bookDetail() {
    	return "/librarypage/bookData/bookDetail";
    }
    
    
    // (도서관) 검색창만 있는 페이지
    @GetMapping("/lifrary/bookDataSearch")
    public String bookDataSearch() {
    	return "/librarypage/bookData/bookDataSearch";
    }
    
    
    // (도서관) 희망도서 신청 폼
    @GetMapping("/lifrary/bookRequestInsert")
    public String bookRequestInsert() {
    	return "/librarypage/book/bookRequestInsert";
    }
    

}