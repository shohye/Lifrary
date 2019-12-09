package ksmart.pentagon.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @file   BookStockController.java
 * @name   bookStock controller 
 * @brief  소장도서 관리기능 처리
 * @author 신다은
 */

@Controller
public class BookStockController {
	
	// (어드민) 소장도서 리스트
	@GetMapping("/admin/stockSearchList")
    public String stockSearchList() {
    	return "/adminpage/bookStock/stockSearchList";
    }

    // (도서관) 검색후 결과 도서 리스트
    @GetMapping("/library/bookDataSearchList")
    public String bookDataSearchList() {
    	return "/librarypage/bookData/bookDataSearchList";
    }
    
    // (도서관) 검색후 도서 리스트(그리드 버전)
    @GetMapping("/library/booksGridView")
    public String booksGridView() {
    	return "/librarypage/bookData/booksGridView";
    }
    
    // (도서관) 도서 상세페이지
    @GetMapping("/library/bookDetail")
    public String bookDetail() {
    	return "/librarypage/bookData/bookDetail";
    }
    
    
    // (도서관) 검색창만 있는 페이지
    @GetMapping("/library/bookDataSearch")
    public String bookDataSearch() {
    	return "/librarypage/bookData/bookDataSearch";
    }
    
    
    // (도서관) 희망도서 신청 폼
    @GetMapping("/library/bookRequestInsert")
    public String bookRequestInsert() {
    	return "/librarypage/book/bookRequestInsert";
    }
    

}
