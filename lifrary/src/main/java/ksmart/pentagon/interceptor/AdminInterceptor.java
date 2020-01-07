package ksmart.pentagon.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class AdminInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		
        HttpSession session = request.getSession(false);
      
        if(session != null) {
   
            String SAID = (String) session.getAttribute("SAID");
            //사서 로그인된 경우 요청한 url로 이동
            if(SAID != null) {
                return true;
                }
            //사서 로그인 안된 경우
            else {
            	response.setContentType("text/html;charset=UTF-8");
            	
            	PrintWriter out = response.getWriter();
            	 
            	out.println("<script>alert('잘못된 접근입니다'); location.href='/admin/login';</script>");
            	 
            	out.flush();

            	return false;
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
