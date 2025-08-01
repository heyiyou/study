package com.peisia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.service.TestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
//@AllArgsConstructor 
@Controller
public class TestController {
		
	@Setter(onMethod_ = @Autowired)
	private TestService service;
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two); 
		
		log.info("(여기 컨트롤러임) 1 더하기 2는 = " + sum);
		
		model.addAttribute("sum",sum);
	}
	

	@GetMapping("/updateVisitantCount")       //문1
	public void updateVisitantCount() {
		log.info("========================================== : 컨트롤러에서 updateVisitantCount() 실행중");
		service.updateVisitantCount();
		
		log.info("(여기 컨트롤러임) 업데이트 잘 됐음");
	}
	
	
	@GetMapping("/insertDoodle")              //문2
	public void insertDoodle() {
		log.info("========================================== : 컨트롤러에서 insertDoodle() 실행중");
		service.insertDoodle();
		log.info("(여기 컨트롤러임) insert 잘 됐음");
	}
	

	@GetMapping("/delTest")                   //문3
	public void delTest() {
		log.info("========================================== : 컨트롤러에서 delTest() 실행중");
		service.delTest();
		log.info("(여기 컨트롤러임) delTest 잘 됐음");
	}	
}