package ksmart.pentagon.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LibraryInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();
               
        if(session != null) {
        	if(("/lifrary/myUserDetail").equals(uri)||("/lifrary/myPointList").equals(uri)||
        			("/lifrary/myLendList").equals(uri)||("/lifrary/myHoldList").equals(uri)||
        			("/lifrary/myCalender").equals(uri)||("/lifrary/myBookReportSearchList").equals(uri)||
        			("/lifrary/myStudyList").equals(uri)||("/lifrary/programApplyList").equals(uri)||
        			("/lifrary/myReadingRoomReserveList").equals(uri)||("/lifrary/myStudyRoomReserveList").equals(uri)||
        			("/lifrary/myLectureRoomReserveList").equals(uri)||("/lifrary/myLockerReserveList").equals(uri)) {
	            String SID = (String) session.getAttribute("SID");
	            //로그인 한 경우
	            if(SID != null) {
	                return true;
	                }
	            //로그인 안한 경우
	            else {
	            	response.setContentType("text/html;charset=UTF-8");
	            	
	            	PrintWriter out = response.getWriter();
	            	 
	            	out.println("<script>alert('로그인 후 이용가능 합니다'); location.href='/lifrary/login';</script>");
	            	 
	            	out.flush();
	
	            	return false;
	            }
        	}else {
        		return true;
        	}
        }
        
        else {
        	
        	response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
       	 
        	out.println("<script>alert('잘못된 접근입니다'); location.href='/';</script>");
        	 
        	out.flush();
        	
			return false;
		
        }
	}
}
