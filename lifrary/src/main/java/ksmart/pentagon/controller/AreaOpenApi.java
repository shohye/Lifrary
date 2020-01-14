package ksmart.pentagon.controller;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
 
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class AreaOpenApi {
		
		
	private static String PHARM_URL;	
	private static ArrayList<ArrayList> list;
	private static ArrayList<String> book;
    public ArrayList<ArrayList> OpenApi(String startDt , String endDt, String aera) {
    	System.out.println("Api 실행");
    	if(aera != "0") {
    	PHARM_URL = "http://data4library.kr/api/loanItemSrch?authKey="
		  		+ "86b2aa39b6cd044028fdadb621d0907b5982a7b8a9f5e77514e3bebd85cfccb5"
		  		+ "&startDt="+startDt				
		  		+ "&endDt="+endDt
		  		+ "&region="+aera;
    	}else if(aera == "0") {
		PHARM_URL = "http://data4library.kr/api/loanItemSrch?authKey="
		  		+ "86b2aa39b6cd044028fdadb621d0907b5982a7b8a9f5e77514e3bebd85cfccb5"
		  		+ "&startDt="+startDt				
		  		+ "&endDt="+endDt;
    	}
        try {
            apiParserSearch();
        } catch (Exception q) {
            q.printStackTrace();
        }
        return list;
    }
 
    
    /**
     * 
     * @throws Exception
     */
    public void apiParserSearch() throws Exception {
        URL url = new URL(getURLParam(null));
        
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        xpp.setInput(bis, "utf-8");
        
        String tag = null;
        int event_type = xpp.getEventType();
        System.out.println("xpp : " +xpp.getEventType());
         list = new ArrayList<ArrayList>();
         
        
        int i = 0;
        String bookname = "";
        String bookImageURL = "";
        while (event_type != XmlPullParser.END_DOCUMENT) {
            if (event_type == XmlPullParser.START_TAG) {
                tag = xpp.getName();
            } else if (event_type == XmlPullParser.TEXT) {
                /**
                 * 책의 이름을 가져온다.
                 */
                if(tag.equals("bookname")){
                	if(i < 10) {
                		book = new ArrayList<String>();
                		System.out.println("bookname 담김 : " + bookname);
                    bookname = xpp.getText();
                    book.add(bookname);
                	}
                }
                if(tag.equals("bookImageURL")){
                	if(i < 10) {
                		i += 1;
                		System.out.println("bookImageURL 담김 : " + bookImageURL);
                		bookImageURL = xpp.getText();
                		book.add(bookImageURL);
                		list.add(book);
                	}
                }
            } 
 
            event_type = xpp.next();
        }
        printList(list);
    }
    
    /**
     * 결과 값을 출력해본다.
     * @param list
     */
    private void printList(ArrayList<ArrayList> list){
        for(ArrayList entity : list){
            System.out.println(entity);
        }
        
        
    }
    
    
    
    private String getURLParam(String search){
        String url = PHARM_URL;
        if(search != null){
        url = url+"&yadmNm"+search;
        }
        return url;
    }
	 
	    

}
