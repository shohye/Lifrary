package ksmart.pentagon.controller;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
 
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class OpenApi {
		
		
		private static String PHARM_URL;	
	  
	    public void OpenApi(String startDt , String endDt, String gender, String fromAge, String toAge) {
		  PHARM_URL = "http://data4library.kr/api/loanItemSrch?authKey="
			  		+ "86b2aa39b6cd044028fdadb621d0907b5982a7b8a9f5e77514e3bebd85cfccb5"
			  		+ "&startDt="+startDt				
			  		+ "&endDt="+endDt				
			  		+ "&gender="+gender						
			  		+ "&from_age="+fromAge						
			  		+ "&to_age="+toAge;	
	        try {
	            apiParserSearch();
	        } catch (Exception q) {
	            q.printStackTrace();
	        }
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
	        
	        ArrayList<String> list = new ArrayList<String>();
	        
	        String bookname = null;
	        while (event_type != XmlPullParser.END_DOCUMENT) {
	            if (event_type == XmlPullParser.START_TAG) {
	                tag = xpp.getName();
	            } else if (event_type == XmlPullParser.TEXT) {
	                /**
	                 * 책의 이름을 가져온다.
	                 */
	                if(tag.equals("bookname")){
	                    bookname = xpp.getText();
	                    list.add("bookname : " +bookname);
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
	    private void printList(ArrayList<String> list){
	        for(String entity : list){
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
