package ksmart.pentagon.stock;

import java.io.IOException;
import java.util.List;

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

import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookLend;
import ksmart.pentagon.vo.BookStock;
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
	
	// (도서관) 대분류, 도서명으로 검색된 소장도서 리스트 출력
	public List<BookStock> getSearchStockList(String bclCode,String biName,String lCode){
			
		List<BookStock> stockList=bookStockMapper.getSearchStockList(bclCode, biName,lCode);
		
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
