package ksmart.pentagon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AdminInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if(session != null) {
            String SAID = (String) session.getAttribute("SAID");
            if(SAID != null) {
            	System.out.println("******관리자*******");
                return true;
                }
            else {
            	System.out.println("******관리자아님 로그인창으로 이동*******");	
            	response.sendRedirect("/admin/login");
            	return false;
            }
        }
        else {
	        response.sendRedirect("/intro.html");
			return false;
		
        }
	}
}
