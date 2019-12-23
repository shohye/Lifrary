package ksmart.pentagon.bookstock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookCate;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookStock;

/****
 * @file   BookStockController.java
 * @name   bookStock controller 
 * @brief  소장도서 관리기능 처리
 * @author 신다은
 */

@Controller
public class BookStockController {
	
	@Autowired private BookStockService bookStockService;
	
	// (어드민) 소장도서 리스트
	/****
	 * @param model
	 * @brief  (어드민) 소장도서 리스트  
	 * @return  /adminpage/bookStock/stockSearchList
	 * @author 신다은
	 */
	@GetMapping("/admin/stockSearchList")
    public String stockSearchList(Model model,HttpSession session){
		
		String lCode = (String) session.getAttribute("LIBNUM");
		model.addAttribute("stockList", bookStockService.getStockList(lCode));
		
    	return "/adminpage/bookStock/stockSearchList";
    }
	
	// (어드민) 소장도서 인서트 화면
	/****
	 * @brief  (어드민) 소장도서 인서트 화면 
	 * @return  /adminpage/bookStock/stockDetailInsert
	 * @author 신다은
	 */
	@GetMapping("/admin/stockDetailInsert")
    public String stockDetailInsert() {
	
    	return "/adminpage/bookStock/stockDetailInsert";
    }
	// (어드민) 소장도서 인서트 처리
	/****
	 * @brief   (어드민) 소장도서 인서트 처리
	 * @return  redirect:/admin/stockSearchLis
	 * @author 신다은
	 */
	@PostMapping("/admin/stockDetailInsert")
    public String stockDetailInsert2(HttpSession session , BookInformation bookInformation, BookStock bookStock , BookCate bookCate) {
		String lCode = (String) session.getAttribute("LIBNUM");
		String uId = (String) session.getAttribute("SAID");
		
		System.out.println("stockDetailInsert2 lCode=>"+lCode);
		bookStock.setlCode(lCode);
		bookStock.setuId(uId);
		bookStockService.insertStock(bookInformation, bookStock, bookCate);
		
    	return "redirect:/admin/stockSearchList";
    }
		
	// (어드민) 소장도서 상세내용
	/****
	 * @param model / bsCode 소장도서 코드
	 * @brief   (어드민) 소장도서 상세내용
	 * @return  /adminpage/bookStock/stockDetail
	 * @author 신다은
	 */
	@GetMapping("/admin/stockDetail")
    public String stockDetail(Model model , @RequestParam(value="bsCode",required=false) String bsCode) {
		
	    if(bsCode == null) {
	    	return "redirect:/admin/stockSearchList";
	    }
		model.addAttribute("stockDetail",bookStockService.getStockdetail(bsCode));
		
    	return "/adminpage/bookStock/stockDetail";
    }
	
	// (어드민) 소장도서 상세수정 화면
	/****
	 * @param model / bsCode 소장도서 코드
	 * @brief  (어드민) 소장도서 상세수정 화면 
	 * @return  /adminpage/bookStock/stockDetailUpdate
	 * @author 신다은
	 */
	@GetMapping("/admin/stockDetailUpdate")
    public String stockDetailUpdate(Model model , @RequestParam(value="bsCode",required=false) String bsCode) {
		if(bsCode == null) {
			return "redirect:/admin/stockSearchList";
	    }  
		model.addAttribute("stockDetail",bookStockService.getStockdetail(bsCode));
		
    	return "/adminpage/bookStock/stockDetailUpdate";
    }
	// (어드민) 소장도서 상세수정 처리
	@PostMapping("/admin/stockDetailUpdate")
	public String stockDetailUpdate(BookInformation bookInformation, BookStock bookStock , BookCate bookCate) {
		
		System.out.println("stockDetailUpdate bookInformation=>"+bookInformation.toString());
		System.out.println("stockDetailUpdate bookStock=>"+bookStock.toString());
		System.out.println("stockDetailUpdate bookCate=>"+bookCate.toString());
		
		bookStockService.updateStock(bookInformation, bookStock, bookCate);
		
		return "redirect:/admin/stockSearchList";
	}
	
	
	
	//(어드민) 삭제 도서 리스트
	@GetMapping("/admin/stockDeleteList")
	public String stockDeleteList(Model model , HttpSession session) {
		String lCode = (String) session.getAttribute("LIBNUM");
		model.addAttribute("deleteList",bookStockService.getStockDeleteList(lCode));
		
		return "/adminpage/bookStock/stockDeleteList";
	}
	//(어드민) 삭제 도서 상세
		@GetMapping("/admin/stockDeleteDetail")
		public String stockDeleteDetail(Model model , @RequestParam(value="bsCode",required=false) String bsCode) {
			
			model.addAttribute("deleteDetail",bookStockService.getStockDeleteDetail(bsCode));
			
			return "/adminpage/bookStock/stockDeleteDetail";
		}
	
	
				
	/************************************************************************/
   
    // (도서관) 상세 검색후 결과 도서 리스트
    @GetMapping("/lifrary/bookDataSearchList")
    public String bookDataDetailSearchList(Model model
    		, @RequestParam(value="bclCode",required=false) String bclCode
    		, @RequestParam(value="biName",required=false) String biName
    		, @RequestParam(value="biPublisher",required=false) String biPublisher
    		, @RequestParam(value="biIsbn",required=false) String biIsbn
    		, @RequestParam(value="biAuthor",required=false) String biAuthor
    		, @RequestParam(value="biDtail",required=false) String biDtail
    		, @RequestParam(value="biYearStart",required=false) String biYearStart
    		, @RequestParam(value="biYearEnd",required=false) String biYearEnd
    		, HttpSession session) {
    	
    	String lCode = (String)session.getAttribute("LIBNUM");    	
    	
    	BookInformation bookInformation = new BookInformation();
    	bookInformation.setBclCode(bclCode);
    	bookInformation.setlCode(lCode);
    	bookInformation.setBiName(biName);
    	bookInformation.setBiPublisher(biPublisher);
    	bookInformation.setBiIsbn(biIsbn);
    	bookInformation.setBiAuthor(biAuthor);
    	bookInformation.setBiDtail(biDtail);
    	bookInformation.setBiYearStart(biYearStart);
    	bookInformation.setBiYearEnd(biYearEnd);
    	
    	model.addAttribute("searchList", bookStockService.getDetailSearchStockList(bookInformation));
    	model.addAttribute("bclCode", bclCode);
    	model.addAttribute("biName", biName);
    	model.addAttribute("biIsbn", biIsbn);
    	model.addAttribute("biPublisher", biPublisher);
    	model.addAttribute("biAuthor", biAuthor);
    	model.addAttribute("biDtail", biDtail);
    	model.addAttribute("biYearStart", biYearStart);
    	model.addAttribute("biYearEnd", biYearEnd);
    	
    	return "/librarypage/bookData/bookDataSearchList";
    }
    
    // (도서관) 검색후 도서 리스트(그리드 버전)
    /****
	 * @brief   (도서관) 검색후 도서 리스트(그리드 버전)
	 * @return  /librarypage/bookData/bookDataSearchGrid
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookDataSearchGrid")
    public String bookDataSearchGrid(Model model
    		, @RequestParam(value="bclCode",required=false) String bclCode
    		, @RequestParam(value="biName",required=false) String biName
    		, @RequestParam(value="biPublisher",required=false) String biPublisher
    		, @RequestParam(value="biIsbn",required=false) String biIsbn
    		, @RequestParam(value="biAuthor",required=false) String biAuthor
    		, @RequestParam(value="biDtail",required=false) String biDtail
    		, @RequestParam(value="biYearStart",required=false) String biYearStart
    		, @RequestParam(value="biYearEnd",required=false) String biYearEnd
    		, HttpSession session) {
    	
    	String lCode = (String)session.getAttribute("LIBNUM");    	
    	
    	BookInformation bookInformation = new BookInformation();
    	bookInformation.setBclCode(bclCode);
    	bookInformation.setlCode(lCode);
    	bookInformation.setBiName(biName);
    	bookInformation.setBiPublisher(biPublisher);
    	bookInformation.setBiIsbn(biIsbn);
    	bookInformation.setBiAuthor(biAuthor);
    	bookInformation.setBiDtail(biDtail);
    	bookInformation.setBiYearStart(biYearStart);
    	bookInformation.setBiYearEnd(biYearEnd);
    	
    	model.addAttribute("searchList", bookStockService.getDetailSearchStockList(bookInformation));
    	model.addAttribute("bclCode", bclCode);
    	model.addAttribute("biName", biName);
    	model.addAttribute("biIsbn", biIsbn);
    	model.addAttribute("biPublisher", biPublisher);
    	model.addAttribute("biAuthor", biAuthor);
    	model.addAttribute("biDtail", biDtail);
    	model.addAttribute("biYearStart", biYearStart);
    	model.addAttribute("biYearEnd", biYearEnd);
    	
    	return "/librarypage/bookData/bookDataSearchGrid";
    }
    
    
    
    
    
    
    
    // (도서관) 도서 상세페이지
    /****
	 * @brief   (도서관) 도서 상세페이지
	 * @return  /librarypage/bookData/bookDetail
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookDetail")
    public String bookDetail(Model model , @RequestParam(value="bsCode",required=false) String bsCode) {
		
	    if(bsCode == null) {
	    	bsCode = "bs-12092200005";
	    }
		model.addAttribute("stockDetail",bookStockService.getStockdetail(bsCode));		
		model.addAttribute("returnDate",bookStockService.getReturnDate(bsCode));
		
		
    	return "/librarypage/bookData/bookDetail";
    }
    
    // (도서관) 검색창만 있는 페이지
    /****
	 * @brief (도서관) 검색창만 있는 페이지  
	 * @return  /librarypage/bookData/bookDataSearch
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookDataSearch")
    public String bookDataSearch() {
    	return "/librarypage/bookData/bookDataSearch";
    }
    
	 // (도서관) 상세 검색창만 있는 페이지
    /****
	 * @brief (도서관) 상세 검색창만 있는 페이지  
	 * @return  /librarypage/bookData/bookDataSearchDetail
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookDataSearchDetail")
    public String bookDataSearchDetail() {
    	return "/librarypage/bookData/bookDataSearchDetail";
    }

    
    
    
    /***********************************************************************/
    
    
  //도서정보 가져오기 AJAX
    @RequestMapping(value="/getBookInfoStock", produces = "application/json")
	public @ResponseBody BookInformation Ajax(
			  Model model
			, @RequestParam(value="biIsbn",required=false)String biIsbn) 
	{
    	
    	System.out.println("*****************************biIsbn=>"+biIsbn);
    	
		return bookStockService.getBookInfoStock(biIsbn);	
	}
    
  // stock 삭제 결과값 가져오는 ajax
    @RequestMapping(value="/updateStockDelete", produces = "text/plain")
    public @ResponseBody String updateStockDelete( Model model
    	   , @RequestParam(value="said",required=false)String said
    	   , @RequestParam(value="write",required=false)String write
    	   , @RequestParam(value="bsCode",required=false)String bsCode
    	   , @RequestParam(value="bsDeleteReason",required=false)String bsDeleteReason) {
    	
    	String text = "";
    	int result = bookStockService.updateStockDelete(said, write, bsCode, bsDeleteReason);
    	if(result == 1) {
    		text = "비밀번호가 틀렸습니다";
		}else if(result == 2) {
			text = "도서 삭제가 완료되었습니다";
		}		   	
 		return text;
    }
    
    // stock 삭제 결과값 가져오는 ajax
    @RequestMapping(value="/resetStock", produces = "text/plain")
    public @ResponseBody String resetStock( Model model
    	   , @RequestParam(value="said",required=false)String said
    	   , @RequestParam(value="write",required=false)String write
    	   , @RequestParam(value="bsCode",required=false)String bsCode) {
   	
    	
    	System.out.println("resetStock bsCode=>"+bsCode);
    	String text = "";
    	int result = bookStockService.updateStockReset(said, write, bsCode);
    	if(result == 1) {
    		text = "비밀번호가 틀렸습니다";
		}else if(result == 2) {
			text = "도서 복구가 완료되었습니다";
		}		   	
 		return text;
    }

}
