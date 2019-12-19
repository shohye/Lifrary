package ksmart.pentagon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired  private AdminInterceptor adminInterceptor; 
	
	@Override 
	public void addInterceptors(InterceptorRegistry registry) { 
		registry.addInterceptor(adminInterceptor) 
				.addPathPatterns("/admin/*") 
				.excludePathPatterns("/admin/login"); 
		
	}



}
