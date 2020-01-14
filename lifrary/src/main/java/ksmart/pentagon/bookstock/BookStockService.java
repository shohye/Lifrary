package ksmart.pentagon.bookstock;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ksmart.pentagon.codeup.CodeUp;
import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookCate;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
import ksmart.pentagon.vo.Paging;
import ksmart.pentagon.vo.User;
import ksmart.pentagon.vo.UserLevel;

@Service
public class BookStockService {
	
	@Autowired private BookStockMapper bookStockMapper;
	
	//소장도서 전체 리스트 가져오기
	public List<BookStock> getStockList(String lCode){		
		List<BookStock> stockList = bookStockMapper.getStockList(lCode);		
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
	
	
	//(어드민) 삭제 도서 리스트 가져오기
	public List<BookStock> getStockDeleteList(String lCode){
		return bookStockMapper.getStockDeleteList(lCode);
	}
	
	// (어드민) 소장도서에서 삭제중 한개도서 상세정보 가져오기
	public BookStock getStockDeleteDetail(String bsCode) {
		BookStock bs =bookStockMapper.getStockDeleteDetail(bsCode);
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
	
	
	
	
	// (도서관) 검색된 소장도서 리스트 출력
	public Map<String, Object> getDetailSearchStockList(Map<String,Object> params, String currentPageStr){
		int boardCount = bookStockMapper.getStockAllCount(params);
		
		System.out.println("서비스단 currentPageStr ====>"+currentPageStr);
		 
		
		// 페이징
		Paging paging =  new Paging(boardCount, currentPageStr);
		// DB 행의 총 개수를 구하는 getStockAllCount() 메서드를 호출하여 int Date Type의 boardCount 변수에 대입
       
        System.out.println("boardCount===>"+boardCount);
        
        
        // 페이징vo에 있는거 가져오는거임,,,
        int currentPage = paging.getCurrentPage();
        int lastPage = paging.getLastPage();
        int startPageNum = paging.getStartPageNum();
        int lastPageNum = paging.getLastPageNum();
       
        
        int startRow = paging.getStartRow();
        int ROW_PER_PAGE = Paging.getRowPerPage();
       
        params.put("startRow", startRow);
        params.put("rowPerPage", ROW_PER_PAGE);
        
        List<BookStock> stockList = bookStockMapper.getDetailSearchStockList(params);
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
		
		// 가져온거 맵으로 컨트롤러에 전달
		// bookDataSearchList.html 아래부분  nav보면 사용한 방식이 나옵니다. 그것을 보세용
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", stockList);
        resultMap.put("currentPage", currentPage);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("lastPageNum", lastPageNum);
    
     
        
        return resultMap;	
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
    
     // ( 어드민 ) 소장도서 업데이트  
    public void updateStock(BookInformation bookInformation, BookStock bookStock , BookCate bookCate) {
 
    	Map<String,Object> stockMap = new HashMap<String,Object>();
    	
    	stockMap.put("bsCode",bookStock.getBsCode());
    	stockMap.put("biName",bookInformation.getBiName());
    	stockMap.put("biAuthor",bookInformation.getBiAuthor());
    	stockMap.put("biPublisher",bookInformation.getBiPublisher());
    	stockMap.put("biKdc",bookInformation.getBiKdc());
    	stockMap.put("biDtail",bookInformation.getBiDtail());
    	stockMap.put("bclCode",bookStock.getBclCode());
    	stockMap.put("bcmName",bookCate.getBcmName());
    	stockMap.put("bsAliasMark",bookStock.getBsAliasMark());
    	stockMap.put("bsWriterMark",bookStock.getBsWriterMark());
    	stockMap.put("bsSecondaryMark",bookStock.getBsSecondaryMark());
    	stockMap.put("bsTotalPage",bookStock.getBsTotalPage());    	
    	stockMap.put("bsCarryRoute",bookStock.getBsCarryRoute()); 
    	stockMap.put("bsBookState",bookStock.getBsBookState());
    	stockMap.put("bsLendState",bookStock.getBsLendState());
    	stockMap.put("bsCarryRoute",bookStock.getBsCarryRoute());  
    	
    	bookStockMapper.updateStock(stockMap);
		
    }
    
    
    // ( 어드민 ) 소장도서 인서트
    public void insertStock(BookInformation bookInformation, BookStock bookStock , BookCate bookCate) {
    	
    	String biIsbn =  bookInformation.getBiIsbn();
    	
    	BookInformation bi =  bookStockMapper.checkBookInfo(biIsbn);
    	
    	Map<String,Object> insertMap = new HashMap<String,Object>();
    	
    	insertMap.put("bsCode",bookStock.getBsCode());
    	insertMap.put("lCode",bookStock.getlCode());
    	insertMap.put("uId",bookStock.getuId());
    	insertMap.put("bclCode",bookStock.getBclCode());
    	insertMap.put("bcmName",bookCate.getBcmName());
    	insertMap.put("biIsbn",bookStock.getBiIsbn());
    	insertMap.put("bsAliasMark",bookStock.getBsAliasMark());
    	insertMap.put("bsAuthorMark",bookStock.getBsAuthorMark());
    	insertMap.put("bsWriterMark",bookStock.getBsWriterMark());
    	insertMap.put("bsSecondaryMark",bookStock.getBsSecondaryMark());
    	insertMap.put("bsTotalPage",bookStock.getBsTotalPage());
    	insertMap.put("bsBookState",bookStock.getBsBookState());
    	insertMap.put("bsLendState",bookStock.getBsLendState());
    	insertMap.put("bsCarryRoute",bookStock.getBsCarryRoute());  
    	
        if(bi == null) {
        	bookStockMapper.insertBookInfoStock(bookInformation);
        	bookStockMapper.updateBookInfoStock(bookInformation);        	
        }else {       	
        	bookStockMapper.insertStock(insertMap);   	
        	bookStockMapper.updateBookInfoStock(bookInformation);
        }    	
    }
	  
	  
    
    
    
	/****************************************************************************/
    
    // (도서관) 회원 대출,예약 가능여부확인 + 홈페이지에서 도서 예약등록 
    public int bookHold(String lCode, String sid, String bsCode) {
		
		int result = 0;
		
		String sidTrim =sid.trim(); //앞뒤공백제거
		User user = bookStockMapper.userInfoCheck(lCode,sidTrim);
		
		if(user != null) {
			//대출가능권수 구하기
			int bookLendNum = 0;
			int lendNum = user.getUserLevel().getUlLendNum();
			int lendCnt = user.getuLendCnt();
			
			String uasLendLimit = user.getUasLendLimit();
			
			if ("O".equals(uasLendLimit)) {
				if(lendNum > lendCnt) {				
					bookLendNum = lendNum-lendCnt;
					// (도서관) 홈페이지에서 도서 예약등록 
					bookStockMapper.holdInsert(lCode, sid ,bsCode);
					bookStockMapper.updateStockHoldLendState(bsCode);
					result = 1;  // 예약 가능
				}else {
					bookLendNum = 0;
					result = 0;     // 권한은 있는데 이번달 예약권수 다 차서 예약불가
				}
			}else {
				result = 2;   // 대출제한 상태로 대출 불가
			}

		}else {
			result = 3;   // 유저가 없음
		}
	
		
		return result;
		
	}
    
    
    // deleteStock update ajax
    // id,pw 확인하는 메서드 1개 & 삭제상태 업데이트하는 메서드 1개( 복구도 같음, 복구는 다 공백으로 업데이트하는 메서드)
 	public int updateStockDelete(String said, String write, String bsCode, String bsDeleteReason) {
 		
 		User user = bookStockMapper.checkPw(said, write);
 		int result = 0;
 		
 		if( user == null) {
 			result = 1;
 		}else { 			
 			bookStockMapper.updateStockDelete(said, bsCode, bsDeleteReason);
 			result = 2;
 		}
 	
 		return result;	
 	}
 	// resetStock update ajax
 	// 아이디 ,비번체크 사용
 	public int updateStockReset(String said, String write, String bsCode) {
 		User user = bookStockMapper.checkPw(said, write);
 		int result = 0;
 		
 		if( user == null) {
 			result = 1;
 		}else { 
 			result = 2;
 			bookStockMapper.updateStockReset(bsCode);
 		}		
 		return result;
 	}
    
    
    /**
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException *********************************************************/
	
	//// 도서정보 가지고 오기 AJAX	
	public BookInformation getBookInfoStock(String biIsbn) {
		
		System.out.println("++++++++++++++++++ 서비스 메서드 시작  +++++++++++++++++++++++");
		
		BookInformation bi = bookStockMapper.getBookInfoStock(biIsbn);		
		if ( bi != null ) {

		}else if(bi == null){
			
	       String url="http://data4library.kr/api/srchDtlList?"
		   +"authKey=86b2aa39b6cd044028fdadb621d0907b5982a7b8a9f5e77514e3bebd85cfccb5&"
		   +"isbn13="+biIsbn+"&loaninfoYN=Y";
			
	 		try{
	 			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	 			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	 			
	 			Document doc = dBuilder.parse(url);
	 			doc.getDocumentElement().normalize();
	 			
	 			System.out.println("최상위 테그 노드네임 =>"+doc.getDocumentElement().getNodeName());
	 			
	 			NodeList nList = doc.getElementsByTagName("book");
	 			System.out.println("파싱할 리스트 수 =>"+ nList.getLength() );
	 			
	 			for(int temp=0; temp<nList.getLength(); temp++) {
	 				Node nNode = nList.item(temp);
	 				
	 				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
	 					
	 					bi = new BookInformation();
	 					
	 					Element eElement = (Element)nNode;
	 					
	 					String biName      = getTagValue("bookname",eElement).trim();
	 					String biYear      = getTagValue("publication_year",eElement).trim();
	 					String biAuthor    = getTagValue("authors",eElement).trim();
	 					String biPublisher = getTagValue("publisher",eElement).trim();
	 					String biKdc       = getTagValue("class_no",eElement).trim();
	 					String biImg       = getTagValue("bookImageURL",eElement).trim();
	 					String biDtail     = getTagValue("description",eElement);
	 					
	 					
	 					bi.setBiIsbn(biIsbn);
	 					bi.setBiYear(biYear);
	 					bi.setBiName(biName);
	 					bi.setBiAuthor(biAuthor);
	 					bi.setBiPublisher(biPublisher);
	 					bi.setBiDtail(biDtail);
	 					bi.setBiImg(biImg);
	 					bi.setBiKdc(biKdc);
	 					
	 					
	 					
	 					bookStockMapper.insertBookInfoStock(bi);
	 					
	 				}
	 			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		 		      
		}
		return bi;

	}
	
	private static String getTagValue(String tag, Element eElement) {
		String val = "";
		if(eElement!=null) {
			NodeList nlList = eElement.getElementsByTagName(tag);
			Element el = (Element)nlList.item(0);
			if( el != null) {
				Node nValue = el.getChildNodes().item(0);
				if(nValue!=null) {
					val = nValue.getNodeValue();									
				}
			}

		}		
		return val;
	 }  
	  

	
	  
	  
	  
	  
	  
	  
	  
	
}
