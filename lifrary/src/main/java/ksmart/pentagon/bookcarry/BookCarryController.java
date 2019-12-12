package ksmart.pentagon.bookcarry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public String bookDonationInsert() {
    	return "/adminpage/bookCarry/bookDonationInsert";
    }
	// 기부신청자 리스트
    @GetMapping("/admin/bookDonationList")
    public String bookDonationList(Model model) {
    	model.addAttribute("donationList",bookCarryService.getDonationList());
    	return "/adminpage/bookCarry/bookDonationList";
    }
    // 기부신청자 수정
    @GetMapping("/admin/bookDonationUpdate")
    public String bookDonationUpdate(@RequestParam(value="bdnCode",required=false)String bdnCode, Model model) {
    	
    	if(bdnCode == null) {
    		bdnCode ="bdn-19120500001";
	    }
    	model.addAttribute("donationUpdate",bookCarryService.getDonationUpdate(bdnCode));
    	return "/adminpage/bookCarry/bookDonationUpdate";
    }
    
    
    /***************************************************************************/
    
    // 도서 구매 입력
    @GetMapping("/admin/bookPurchaseInsert")
    public String bookPurchaseForm() {
    	return "/adminpage/bookCarry/bookPurchaseInsert";
    }
    // 도서 구매 리스트
    @GetMapping("/admin/bookPurchaseList")
    public String bookPurchaseList(Model model) {
    	model.addAttribute("purchaseList", bookCarryService.getPurchaseList());
    	return "/adminpage/bookCarry/bookPurchaseList";
    }
    // 도서 구매 수정
    @GetMapping("/admin/bookPurchaseUpdate")
    public String bookPurchaseUpdate( @RequestParam(value="bpCode",required=false)String bpCode, Model model) {
    	if(bpCode == null) {
    		bpCode ="bp-19120500002";
	    }
    	
    	model.addAttribute("purchaseUpdate",bookCarryService.getPurchaseUpdate(bpCode));
    	
    	return "/adminpage/bookCarry/bookPurchaseUpdate";
    }
    

    
    /***************************************************************************/
    
    // 도서 주문 입력
    @GetMapping("/admin/bookOrderInsert")
    public String bookOrderForm() {
    	return "/adminpage/bookCarry/bookOrderInsert";
    }
    // 도서 주문 리스트
    @GetMapping("/admin/bookOrderList")
    public String bookOrderList(Model model) {
    	
    	model.addAttribute("orderList", bookCarryService.getOrderList());
    		
    	return "/adminpage/bookCarry/bookOrderList";
    }
    // 도서 주문 수정
    @GetMapping("/admin/bookOrderUpdate")
    public String bookOrderUpdate(@RequestParam(value="boCode",required=false)String boCode, Model model) {
    	if(boCode == null) {
    		boCode ="bo-19120500002";
	    }
    	model.addAttribute("orderUpdate",bookCarryService.getOrderUpdate(boCode));
    	return "/adminpage/bookCarry/bookOrderUpdate";
    }
    

    
    /***************************************************************************/
    
    // 희망도서 신청 리스트
    @GetMapping("/admin/requestSearchList")
    public String requestSearchList(Model model) {
    	
    	
    	model.addAttribute("requestList", bookCarryService.getRequestList());
    	return "/adminpage/bookCarry/requestSearchList";
    }
    
    // 희망도서 상세내용 
    @GetMapping("/admin/requestDetail")
    public String requestDetail(Model model, @RequestParam(value="uId",required=false)String uId) { 	
    	if(uId == null) {
    		uId ="id003";
	    }
    	model.addAttribute("requestDetail",bookCarryService.getRequestDatail(uId));
    	return "/adminpage/bookCarry/requestDetail";
    }
    
   
}
