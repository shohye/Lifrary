package ksmart.pentagon.bookstock;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ksmart.pentagon.vo.BookStock;

@Controller
public class CallNumberController {
	
	@Autowired CallNumberService callNumberService;

	
	@RequestMapping(value="/getCallName", produces = "application/json")
	public @ResponseBody Map<String,String> Ajax(
			 Model model
			,@RequestParam(value="biAuthor",required=false)String biAuthor
			,@RequestParam(value="biName",required=false)String biName
			,@RequestParam(value="bsAliasMark",required=false)String bsAliasMark
			,@RequestParam(value="biKdc",required=false)String biKdc 
			,@RequestParam(value="bsSecondaryMark",required=false)String bsSecondaryMark 
			,HttpSession session) 
	{
		
		Map<String,String> map = new HashMap<String, String>();
		String lCode = (String) session.getAttribute("LIBNUM");
		
		System.out.println("getCallName lCode=>"+lCode);
		
		String bsMark ="";     // 청구기호  ex) 810-글43ㅈ
		String author = "";    // 저자기호  ex) 글43
		String writer = "-";   // 저작기호  ex) -글43ㅈ
		System.out.println("biAuthor=>"+biAuthor);
		System.out.println("biName=>"+biName);
		
		author = callNumberService.makeBsmarkAuthor(biAuthor,lCode);
		String name = callNumberService.makeBsmarkName(biName);
		System.out.println("author=>"+author);
		System.out.println("name=>"+name);
		writer += author + name ;
		
		List<String> bs = callNumberService.checkWriterMark(writer,lCode);		
		if(bs.size() > 0) {
			name="";
			writer="-";
			name = callNumberService.makeBsmarkName2(biName);
			writer += author + name ;
			bsMark+=  bsAliasMark + biKdc + writer + bsSecondaryMark;
			
		}else {
			
			bsMark+=  bsAliasMark + biKdc + writer + bsSecondaryMark;
		}
		
		
		map.put("author", author);
		map.put("bsMark", bsMark);
		map.put("writer", writer);
		
		return map;	
	}
}
