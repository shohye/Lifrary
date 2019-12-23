package ksmart.pentagon.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart.pentagon.interceptor.AdminInterceptor;



@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired  private AdminInterceptor adminInterceptor; 
	
	
	@Value("${resources.notload.list}") private List<String> notLoadList;
	
	
	@Override 
	public void addInterceptors(InterceptorRegistry registry) { 
		registry.addInterceptor(adminInterceptor) 
				.addPathPatterns("/admin/*") 
				.excludePathPatterns(notLoadList); 
	}
}
