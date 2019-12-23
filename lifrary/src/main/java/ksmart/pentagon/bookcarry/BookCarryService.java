package ksmart.pentagon.bookcarry;

import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import ksmart.pentagon.vo.BookCarry;
import ksmart.pentagon.vo.BookInformation;
import ksmart.pentagon.vo.BookRequest;
import ksmart.pentagon.vo.User;

@Service
public class BookCarryService {
	
	@Autowired BookCarryMapper bookCarryMapper;
	
	
	/**********************************************************/
	 // 도서 정보 있는지 확인
	public int checkBookInfo(String biIsbn) {
		BookInformation bi = bookCarryMapper.getBookInfo(biIsbn); 		
		if(bi == null) {
			return 1;   // book_information 테이블에 해당 isbn없는 경우
		}else {
			return 2;   // book_information 테이블에 해당 isbn있는 경우
		}
				
	}
	
		
	/**********************************************************/
		
		
	// 오더리스트 출력
	public List<BookCarry> getOrderList(String lCode){
		return bookCarryMapper.getOrderList(lCode);	
	}
	// 오더 도서 한개정보출력/ 수정화면	
	public BookCarry getOrderUpdate(String boCode) {
		return bookCarryMapper.getOrderUpdate(boCode);		
	}
	// 오더 도서 업데이트
	public int updateOrder1(BookCarry bookCarry) {
		return bookCarryMapper.updateOrder(bookCarry);
	}
	public int updateOrder2(BookInformation bookInformation) {
		return bookCarryMapper.updateBookInformation(bookInformation);
	}
	// 오더 도서 인서트
		public void insertOrder(BookCarry bookCarry,BookInformation bookInformation) {
			int result = checkBookInfo(bookInformation.getBiIsbn());
			
			if(result == 1) {
				// 오더도서 인서트 ver1
				bookCarryMapper.insertBookInfo(bookInformation);
				bookCarryMapper.insertOrderBookCarry(bookCarry);
				
			}else if(result == 2) {
				// 오더도서 인서트 ver2
				bookCarryMapper.updateBookInformation(bookInformation);
				bookCarryMapper.insertOrderBookCarry(bookCarry);
			}

		}
	
	
	
	/*************************************************************/	
	
	
	// 구매리스트 출력
	public List<BookCarry> getPurchaseList(String lCode){
		return bookCarryMapper.getPurchaseList(lCode);
	}
	// 구매 도서 한개정보출력/ 수정화면	
	public BookCarry getPurchaseUpdate(String bpCode) {
		return bookCarryMapper.getPurchaseUpdate(bpCode);
		
	}
	// 구매 도서 업데이트
	public int updatePurchase1(BookCarry bookCarry) {
		return bookCarryMapper.updatePurchase(bookCarry);
	}
	public int updatePurchase2(BookInformation bookInformation) {
		return bookCarryMapper.updateBookInformation(bookInformation);
	}
	
	
	// 구매도서 인서트 
	public void insertPurchase(BookCarry bookCarry,BookInformation bookInformation) {
		int result = checkBookInfo(bookInformation.getBiIsbn());
		
		if(result == 1) {
			// 구매도서 인서트 ver1
			bookCarryMapper.insertBookInfo(bookInformation);
			bookCarryMapper.insertPurchaseBookCarry(bookCarry);
			
		}else if(result == 2) {
			// 구매도서 인서트 ver2
			bookCarryMapper.updateBookInformation(bookInformation);
			bookCarryMapper.insertPurchaseBookCarry(bookCarry);
		}

	}
		
	/*************************************************************/		
	
	
	// 기부자리스트 출력
	public List<BookCarry> getDonationList(String lCode){
		return bookCarryMapper.getDonationList(lCode);
	}				
	// 기부자 한개정보출력/ 수정화면	
	public BookCarry getDonationUpdate(String bdnCode) {
		return bookCarryMapper.getDonationUpdate(bdnCode);		
	}
	// 기부자 업데이트
	public int updateDonation(BookCarry bookCarry) {
		return bookCarryMapper.updateDonation(bookCarry);
	}
	// 기부자 인서트
	public int insertDonation(BookCarry bookCarry) {
		return bookCarryMapper.insertDonation(bookCarry);
	}
	// 기부자 리스트 버튼으로 상태변경
	//1. 기부자스티커
	public int updateStickerO(String bdnCode) {
		return bookCarryMapper.updateStickerO(bdnCode);
	}
	public int updateStickerX(String bdnCode) {
		return bookCarryMapper.updateStickerX(bdnCode);
	}
	
	
	/*************************************************************/	
	
	
	// 희망도서신청 리스트 출력
	public List<BookRequest> getRequestList(String lCode) {
		
		System.out.println("서비스 출력 --------------------------");
		List<BookRequest> br = bookCarryMapper.getRequestList(lCode);
		String cancelReason =null;
		String opinion =null;
		for(int i =0; i<br.size(); i++) {			
			cancelReason = br.get(i).getBrCancelReason();
			opinion = br.get(i).getBrOpinion();
			
			if(cancelReason == null) {
				cancelReason = "-";	
				br.get(i).setBrCancelReason(cancelReason);			
			}			
			if(opinion == null) {
				opinion = "-";
				br.get(i).setBrOpinion(opinion);
			}			
		}
		System.out.println("opinion=>"+opinion);
			
		return br;		
	}
	
	// 희망도서 한개정보 출력 => 상세정보 회면
	public BookRequest getRequestDatail(String brCode) {
		BookRequest br = bookCarryMapper.getRequestDatail(brCode);
		
		String cancelReason =null;
		String opinion =null;
		String uid = null;
		
		if(br.getUser().getuId() == null) {
			uid = "공백";
			br.getUser().setuId(uid);
		}
		
		if(br.getBrCancelReason() == null) {
			cancelReason ="공백";
			br.setBrCancelReason(cancelReason);
		}
		
		if(br.getBrOpinion() == null) {
			opinion = "공백";
			br.setBrOpinion(opinion);
		}
		
		return br;		
	}
	// 희망도서 인서트
	public int insertRequest(BookRequest bookRequest) {
		return bookCarryMapper.insertRequest(bookRequest);		
	}
	//( 도서관 ) 사용자 id를 기준으로 하는 희망도서 신청 리스트
	public List<BookRequest> getMyRequestList(String uid){
		return bookCarryMapper.getMyRequestList(uid);	
	}
	

    /*************************************************************/	
	// order 삭제
	public int deleteOrder(String said, String write , String boCode) {
		int result = bookCarryMapper.deleteOrder(said, write, boCode);
		System.out.println("deleteOrder result=>"+result);
		return result;
	}
	// purchase 삭제
	public int deletePurchase(String said, String write , String bpCode) {
		int result = bookCarryMapper.deletePurchase(said, write, bpCode);
		System.out.println("deletePurchase result=>"+result);
		return result;
	}
	// purchase 삭제
	public int deleteDonation(String said, String write , String bdnCode) {
		int result = bookCarryMapper.deleteDonation(said, write, bdnCode);
		System.out.println("deletePurchase result=>"+result);
		return result;
	}
		
		
	/**
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException *********************************************************/
	
	//// 도서정보 가지고 오기 AJAX	
	public BookInformation getBookInfo(String biIsbn) {
		
		System.out.println("++++++++++++++++++ 서비스 메서드 시작  +++++++++++++++++++++++");
		
		BookInformation bi = bookCarryMapper.getBookInfo(biIsbn);		
		if ( bi != null ) {

		}else if(bi == null){
			
	       String url="http://data4library.kr/api/srchDtlList?"
		   +"authKey=a4bc8d9739b4123747517ab223a62c1d1efa993902db2c95725a3e95171e27f4&"
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
 					
	 					bookCarryMapper.insertBookInfo(bi);
	 					
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
