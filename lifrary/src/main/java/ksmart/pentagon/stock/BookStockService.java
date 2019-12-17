package ksmart.pentagon.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.UserLevel;

@Service
public class BookStockService {
	
	@Autowired private BookStockMapper bookStockMapper;
	
	//소장도서 전체 리스트 가져오기
	public List<BookStock> getStockList(){		
		List<BookStock> stockList = bookStockMapper.getStockList();		
		String bsCallNum = "";		
		if(stockList!= null) {			
			for(int i=0; i<stockList.size(); i++) {				
				String aliasMark = stockList.get(i).getBsAliasMark();
				String kdc = stockList.get(i).getBookInformation().getBiKdc();
				String writerMark = stockList.get(i).getBsWriterMark();
				String bsSecondaryMark = stockList.get(i).getBsSecondaryMark();
			
				bsCallNum = "";
				
				if(aliasMark != null ) {
					bsCallNum += aliasMark;
				}				
				bsCallNum += kdc.trim();
				bsCallNum += writerMark;			
				if(bsSecondaryMark != null) {					
					bsCallNum += bsSecondaryMark;
				}								
				stockList.get(i).setBsCallNum(bsCallNum);				
			}						
		}		
		return stockList;		
	}
	
	// 소장도서중 한개도서 상세정보 가져오기
	public BookStock getStockdetail(String bsCode) {
		BookStock bs = bookStockMapper.getStockdetail(bsCode);
		String bsCallNum = "";		
		if(bs != null) {		
			String aliasMark = bs.getBsAliasMark();
			String kdc = bs.getBookInformation().getBiKdc();
			String writerMark = bs.getBsWriterMark();
			String bsSecondaryMark = bs.getBsSecondaryMark();
		
			bsCallNum = "";
			
			if(aliasMark != null ) {
				bsCallNum += aliasMark;
			}			
			bsCallNum += kdc.trim();
			bsCallNum += writerMark;		
			if(bsSecondaryMark != null) {					
				bsCallNum += bsSecondaryMark;
			}							
			bs.setBsCallNum(bsCallNum);			
		}
		return bs;	
	}
	
	// (도서관) 대분류, 도서명으로 검색된 소장도서 리스트 출력
	public List<BookStock> getSearchStockList(String bclCode,String biName){
			
		List<BookStock> stockList=bookStockMapper.getSearchStockList(bclCode, biName);
		
		String bsCallNum = "";		
		if(stockList!= null) {			
			for(int i=0; i<stockList.size(); i++) {				
				String aliasMark = stockList.get(i).getBsAliasMark();
				String kdc = stockList.get(i).getBookInformation().getBiKdc();
				String writerMark = stockList.get(i).getBsWriterMark();
				String bsSecondaryMark = stockList.get(i).getBsSecondaryMark();
			
				bsCallNum = "";
				
				if(aliasMark != null ) {
					bsCallNum += aliasMark;
				}				
				bsCallNum += kdc.trim();
				bsCallNum += writerMark;			
				if(bsSecondaryMark != null) {					
					bsCallNum += bsSecondaryMark;
				}								
				stockList.get(i).setBsCallNum(bsCallNum);				
			}						
		}		
		return stockList;	
	}
		
    // (도서관) 도서 상세페이지 - 반납예정일 계산하는 메서드
    public BookLend getReturnDate(String bsCode) {
    	
    	BookLend bl = bookStockMapper.getReturnDate(bsCode);
    	
    	System.out.println("bl=>"+bl);
    	
    	String result ="";
    	if(bl == null) {
    		bl = new BookLend();
    		result = "-";
    		bl.setBlScheduleDate(result);
    	}else if(bl != null) {  		
    		if(bl.getBlHoldDate()!= null) {
    			result = "당일 예약 완료";
        		bl.setBlScheduleDate(result);
    		}
    	}
	  return bl;		  
    }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
}
