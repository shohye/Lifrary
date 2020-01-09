package ksmart.pentagon.bookcarry;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookRequest;
import ksmart.pentagon.vo.User;


/*
 * @file   BookCarryController.java
 * @name   bookCarry controller 
 * @brief  수서 모든 기능 처리
 * @author 신다은
 */


@Controller
public class BookCarryController {
	
	@Autowired BookCarryService bookCarryService;
	
	// 기부신청자 입력
	@GetMapping("/admin/bookDonationInsert")
    public String bookDonationInsert(HttpSession session) {
		String lCode = (String) session.getAttribute("LIBNUM");
    	return "adminpage/bookCarry/bookDonationInsert";
    }
	// 기부신청자 파일 업로드 화면
	@GetMapping("/admin/bookDonationFile")
    public String bookDonationFile(HttpSession session) {
		String lCode = (String) session.getAttribute("LIBNUM");
    	return "adminpage/bookCarry/bookDonationFile";
    }
	// 기부신청자 리스트
    @GetMapping("/admin/bookDonationList")
    public String bookDonationList(Model model,HttpSession session) {
    	
    	String lCode = (String) session.getAttribute("LIBNUM");
		
    	model.addAttribute("donationList",bookCarryService.getDonationList(lCode));
    	return "adminpage/bookCarry/bookDonationList";
    }
    // 기부신청자 수정 화면
    @GetMapping("/admin/bookDonationUpdate")
    public String bookDonationUpdate(@RequestParam(value="bdnCode",required=false)String bdnCode, 
    		Model model) {
    	
    	if(bdnCode == null) {
    		bdnCode ="bdn-19120500001";
	    }
    	model.addAttribute("donationUpdate",bookCarryService.getDonationUpdate(bdnCode));
    	return "adminpage/bookCarry/bookDonationUpdate";
    }
    
    // 기부신청자 수정 처리
    @PostMapping("/admin/bookDonationUpdate")
    public String bookDonationUpdate(BookCarry bookCarry){
    	bookCarryService.updateDonation(bookCarry);
		return "redirect:/admin/bookDonationList";   	
    }
   // 기부신청자 입력 처리
    @PostMapping("/admin/bookDonationInsert")
    public String bookDonationInsert2(HttpSession session, BookCarry bookCarry){
    	String lCode = (String) session.getAttribute("LIBNUM");
    	String saId = (String) session.getAttribute("SAID");
    	
    	bookCarry.setUid(saId);
    	bookCarry.setlCode(lCode);
    	
    	System.out.println(bookCarry.toString());
    	
    	bookCarryService.insertDonation(bookCarry);
    	
		return "redirect:/admin/bookDonationList";   	
    }
    // 기부자 리스트 버튼으로 상태변경
 	//1. 기부자스티커
    
    @GetMapping("/updateSticker")
    public String updateSticker(@RequestParam(value="bdnCode",required=false)String bdnCode
    						   , @RequestParam(value="bdnSticker",required=false)String bdnSticker) {
    	if( "O".equals(bdnSticker) ) {   		
    		 bookCarryService.updateStickerX(bdnCode);
    	}else if("X".equals(bdnSticker) ) {    		
    		 bookCarryService.updateStickerO(bdnCode);
    	}   
    	return "redirect:/admin/bookDonationList";
    }
    //2.명예전당
    
    @GetMapping("/updateHonor")
    public String updateHonor(@RequestParam(value="bdnCode",required=false)String bdnCode
    						   , @RequestParam(value="bdnHonorAgree",required=false)String bdnHonorAgree) {
    	if( "O".equals(bdnHonorAgree) ) {   		
    		 bookCarryService.updateHonorX(bdnCode);
    	}else if("X".equals(bdnHonorAgree) ) {    		
    		 bookCarryService.updateHonorO(bdnCode);
    	}   
    	return "redirect:/admin/bookDonationList";
    }
    
    
    /***************************************************************************/
    
    // 도서 구매 입력
    @GetMapping("/admin/bookPurchaseInsert")
    public String bookPurchaseForm(HttpSession session) {
    	String lCode = (String) session.getAttribute("LIBNUM");
    	String saId = (String) session.getAttribute("SAID");
    	return "adminpage/bookCarry/bookPurchaseInsert";
    }
    // 도서 구매 리스트
    @GetMapping("/admin/bookPurchaseList")
    public String bookPurchaseList(Model model,HttpSession session) {
    	String lCode = (String) session.getAttribute("LIBNUM");
    	model.addAttribute("purchaseList", bookCarryService.getPurchaseList(lCode));
    	return "adminpage/bookCarry/bookPurchaseList";
    }
    // 도서 구매 수정 화면
    @GetMapping("/admin/bookPurchaseUpdate")
    public String bookPurchaseUpdate( @RequestParam(value="bpCode",required=false)String bpCode, Model model) {
    	if(bpCode == null) {
    		bpCode ="bp-19120500002";
	    }
    	
    	model.addAttribute("purchaseUpdate",bookCarryService.getPurchaseUpdate(bpCode));
    	
    	return "adminpage/bookCarry/bookPurchaseUpdate";
    }
    // 도서구매 수정 처리
    @PostMapping("/admin/bookPurchaseUpdate")
    public String bookPurchaseUpdate(BookCarry bookCarry,BookInformation bookInformation) {
    	bookCarryService.updatePurchase1(bookCarry);
    	bookCarryService.updatePurchase2(bookInformation);
		return "redirect:/admin/bookPurchaseList"; 	
    }
   // 도서구매 입력 처리
    @PostMapping("/admin/bookPurchaseInsert")
    public String bookPurchaseInsert(HttpSession session,BookCarry bookCarry,BookInformation bookInformation){
    	String lCode = (String) session.getAttribute("LIBNUM");
    	String saId = (String) session.getAttribute("SAID");
    	bookCarry.setlCode(lCode);
    	bookCarry.setUid(saId);
    	
    	bookCarryService.insertPurchase(bookCarry, bookInformation);
    	
		return "redirect:/admin/bookPurchaseList";   	
    }

    
    /***************************************************************************/
    
    // 도서 주문 입력
    @GetMapping("/admin/bookOrderInsert")
    public String bookOrderForm(HttpSession session) {
    	String lCode = (String) session.getAttribute("LIBNUM");
    	return "adminpage/bookCarry/bookOrderInsert";
    }
    // 도서 주문 리스트
    @GetMapping("/admin/bookOrderList")
    public String bookOrderList(Model model,HttpSession session) {
    	String lCode = (String) session.getAttribute("LIBNUM");
    	model.addAttribute("orderList", bookCarryService.getOrderList(lCode));
    		
    	return "adminpage/bookCarry/bookOrderList";
    }
    // 도서 주문 수정 화면
    @GetMapping("/admin/bookOrderUpdate")
    public String bookOrderUpdate(@RequestParam(value="boCode",required=false)String boCode, Model model) {
    	if(boCode == null) {
    		boCode ="bo-19120500002";
	    }
    	model.addAttribute("orderUpdate",bookCarryService.getOrderUpdate(boCode));
    	return "adminpage/bookCarry/bookOrderUpdate";
    }
    // 도서 주문 수정 처리
    @PostMapping("/admin/bookOrderUpdate")
    public String bookOrderUpdate(BookCarry bookCarry,BookInformation bookInformation) {
    	bookCarryService.updateOrder1(bookCarry);
    	bookCarryService.updateOrder2(bookInformation);
		return "redirect:/admin/bookOrderList";  	
    }
    // 도서 주문 입력 처리
    @PostMapping("/admin/bookOrderInsert")
    public String bookOrderInsert(HttpSession session,BookCarry bookCarry,BookInformation bookInformation){
    	
    	String lCode = (String) session.getAttribute("LIBNUM");
    	String saId = (String) session.getAttribute("SAID");
    	bookCarry.setlCode(lCode);
    	bookCarry.setUid(saId);
    	
    	bookCarryService.insertOrder(bookCarry, bookInformation);
    
		return "redirect:/admin/bookOrderList";   	
    }

    // 주문상태 변경
    @GetMapping("/updateOrderState")
    public String updateOrderState(
    		@RequestParam(value="bosState",required=false)String bosState
    	  , @RequestParam(value="boCode",required=false)String boCode) {
    	if( "주문완료".equals(bosState) ) {   		
    		bookCarryService.updateOrderState2(boCode);
    	}else if("수령완료".equals(bosState) ) {    		
    		bookCarryService.updateOrderState1(boCode);
    	}   
    	return "redirect:/admin/bookOrderList";
    }
    
    /***************************************************************************/
    
    // 희망도서 신청 리스트
    @GetMapping("/admin/requestSearchList")
    public String requestSearchList(Model model,HttpSession session) {
    	String lCode = (String) session.getAttribute("LIBNUM");
    	
    	model.addAttribute("requestList", bookCarryService.getRequestList(lCode));
    	return "adminpage/bookCarry/requestSearchList";
    }
    
    // 희망도서 상세내용 
    @GetMapping("/admin/requestDetail")
    public String requestDetail(Model model, @RequestParam(value="brCode",required=false)String brCode) { 	
    	if(brCode == null) {
    		brCode ="br-19121100002";
	    }
    	model.addAttribute("requestDetail",bookCarryService.getRequestDatail(brCode));
    	return "adminpage/bookCarry/requestDetail";
    }
    
  // (도서관) 도서기부 안내 화면
    /****
	 * @brief  (도서관)  도서기부 안내 화면
	 * @return  /librarypage/book/bookDonationGuide
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookDonationGuide")
    public String bookDonationGuide() {
    	return "librarypage/book/bookDonationGuide";
    }
    
 // (도서관) 희망도서 신청 안내 화면
    /****
	 * @brief  (도서관) 희망도서 신청 안내 화면
	 * @return  /librarypage/book/bookRequestIntro
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookRequestIntro")
    public String bookRequestIntro() {
    	return "librarypage/book/bookRequestIntro";
    }
    
    // (도서관) 희망도서 신청 폼
    /****
	 * @brief (도서관) 희망도서 신청 폼  
	 * @return  /librarypage/book/bookRequestInsert
	 * @author 신다은
	 */
    @GetMapping("/lifrary/bookRequestInsert")
    public String bookRequestInsert() {
    	return "librarypage/book/bookRequestInsert";
    }
    
    // (도서관) 마이페이지 희망도서 신청 리스트
    /****
	 * @brief   (도서관) 마이페이지 희망도서 신청 리스트
	 * @return /librarypage/book/myBookRequestList 
	 * @author 신다은
	 */
    @GetMapping("/lifrary/myBookRequestList")
    public String myBookRequestList(Model model,HttpSession session
    		, @RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPageStr) {
    	
    	String uid = (String) session.getAttribute("SID");
    	
    	Map<String, Object> map =  bookCarryService.getMyRequestLists(uid,currentPageStr);
    	
    	model.addAttribute("myRequestList", map.get("list"));
    	
    	model.addAttribute("currentPage", map.get("currentPage"));
    	model.addAttribute("lastPage", map.get("lastPage"));
    	model.addAttribute("startPageNum", map.get("startPageNum"));
    	model.addAttribute("lastPageNum", map.get("lastPageNum"));
    	model.addAttribute("pageViewBlock", map.get("pageViewBlock"));
    	model.addAttribute("pageViewArray", map.get("pageViewArray"));
    	
    	return "librarypage/book/myBookRequestList";
    }
    
    // 희망도서 신청 입력처리
    @PostMapping("/lifrary/bookRequestInsert")
    public String bookRequestInsert(HttpSession session, BookRequest bookRequest){
    	String lCode = (String) session.getAttribute("LIBNUM");
    	String sId = (String) session.getAttribute("SID");
    	
    	bookRequest.setuId(sId);
    	bookRequest.setlCode(lCode);
    	
    	System.out.println(bookRequest.toString());
    	
    	bookCarryService.insertRequest(bookRequest);
    	
		return "redirect:/lifrary/myBookRequestList";   	
    }
    
    
    
    
    
    /***************************************************************************/
    
    
    //도서정보 가져오기 AJAX
    @RequestMapping(value="/getBookInfo", produces = "application/json")
	public @ResponseBody BookInformation getBookInfo(
			  Model model
			, @RequestParam(value="biIsbn",required=false)String biIsbn) 
	{
    	
    	System.out.println("*****************************biIsbn=>"+biIsbn);
    	
		return bookCarryService.getBookInfo(biIsbn);	
	}
    
    
    // order 삭제 결과값 가져오는 ajax
    @RequestMapping(value="/deleteOrder", produces = "text/plain")
    public @ResponseBody String deleteOrder( Model model
    	   , @RequestParam(value="said",required=false)String said
    	   , @RequestParam(value="write",required=false)String write
    	   , @RequestParam(value="boCode",required=false)String boCode) {
    	
    	int result = bookCarryService.deleteOrder(said, write, boCode);	
    	String text ="";
    	if(result == 0) {
    		text = "비밀번호가 틀렸습니다";
		}else if(result == 1) {
			text = "도서 삭제가 완료되었습니다";
		}			
 		return text;
    }
    
    // purchase 삭제 결과값 가져오는 ajax
    @RequestMapping(value="/deletePurchase", produces = "text/plain")
    public @ResponseBody String deletePurchase( Model model
    	   , @RequestParam(value="said",required=false)String said
    	   , @RequestParam(value="write",required=false)String write
    	   , @RequestParam(value="bpCode",required=false)String bpCode) {
    	
    	int result = bookCarryService.deletePurchase(said, write, bpCode);	
    	String text ="";
    	if(result == 0) {
    		text = "비밀번호가 틀렸습니다";
		}else if(result == 1) {
			text = "도서 삭제가 완료되었습니다";
		}				
 		return text;
    }
    // donation 삭제 결과값 가져오는 ajax
    @RequestMapping(value="/deleteDonation", produces = "text/plain")
    public @ResponseBody String deleteDonation( Model model
    	   , @RequestParam(value="said",required=false)String said
    	   , @RequestParam(value="write",required=false)String write
    	   , @RequestParam(value="bdnCode",required=false)String bdnCode) {
    	
    	System.out.println( "deleteDonation said    ===> "+ said);
    	System.out.println( "deleteDonation write   ===> "+ write);
    	System.out.println( "deleteDonation bdnCode ===> "+ bdnCode);
    	int result = bookCarryService.deleteDonation(said, write, bdnCode);	
    	String text ="";
    	if(result == 0) {
    		text = "비밀번호가 틀렸습니다";
		}else if(result == 1) {
			text = "신청자 삭제가 완료되었습니다";
		}				
 		return text;
    }
    
    //희망도서 상태변경 Ajax    
    @RequestMapping(value="/updateProgress", produces = "application/json")
    public @ResponseBody int updateProgress( Model model
    	   , @RequestParam(value="brCode",required=false)String brCode
    	   , @RequestParam(value="brProgress",required=false)String brProgress
    	   , @RequestParam(value="brCancelReason",required=false)String brCancelReason) {
    	
    	System.out.println("brCode===========>"+brCode);
    	System.out.println("brProgress=======>"+brProgress);
    	System.out.println("brCancelReason===>"+brCancelReason);
    	
    	int result = 0;
    	result = bookCarryService.updateProgress(brCode, brProgress, brCancelReason);
    	
		return result;
    }
}
