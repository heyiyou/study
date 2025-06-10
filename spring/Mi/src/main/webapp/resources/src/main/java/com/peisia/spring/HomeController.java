package com.peisia.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//쿠키 꺼내기
		Cookie [] cs = request.getCookies();
		if (cs != null) {					
			for (Cookie cc : cs) {				
				if ("cookieSavedId".equals(cc.getName())) {			
					String n = cc.getValue();		
					System.out.println("==== 쿠키 값 찍기: "+n);
					model.addAttribute("cookieSavedId",n);
					break;		
				}			
			}				
		}
		
		return "home";
	}
	
}
