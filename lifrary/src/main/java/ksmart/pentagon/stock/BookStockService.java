package ksmart.pentagon.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				String kdc = stockList.get(i).getBookinformation().getBiKdc();
				String writerMark = stockList.get(i).getBsWriterMark();
				String bsSecondaryMark = stockList.get(i).getBsSecondaryMark();
				
				System.out.println("bsSecondaryMark long =>"+stockList.get(i).getBsSecondaryMark());
				System.out.println("bsSecondaryMark =>"+bsSecondaryMark);
				
				bsCallNum = "";
				
				if(aliasMark != null ) {
					bsCallNum += aliasMark;
				}
				System.out.println("bsCallNum 1=>"+bsCallNum);
				
				bsCallNum += kdc.trim();
				System.out.println("bsCallNum 2=>"+bsCallNum);
				bsCallNum += writerMark;
				System.out.println("bsCallNum 3=>"+bsCallNum);
				
				if(bsSecondaryMark != null) {
					
					bsCallNum += bsSecondaryMark;
				}
				
				
				System.out.println("bsCallNum 4=>"+bsCallNum);
				
				stockList.get(i).setBsCallNum(bsCallNum);
				

			}
			
			
		}
		
		
		return stockList;
		
	}
	
}
