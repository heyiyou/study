package com.peisia.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.MemberDto;
import com.peisia.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/member/*")
//@AllArgsConstructor
@Controller
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@GetMapping("/reg")
	public void reg() {
		
	}

	
	
	
	@GetMapping("/login")
	public String login(MemberDto m, HttpSession session, 
				@RequestParam(value="saveId", defaultValue = "") String saveId, 
				HttpServletResponse response, HttpServletRequest request) {
		log.info("==== 로그인 저장 체크:"+saveId);
		if(saveId.equals("on")) {
			Cookie c = new Cookie("cookieSavedId",m.getId());
			c.setPath("/");			// *중요* 쿠기를 불러오는 경로를 루트이하 모든 경로에서 불러오도록 설정하는 부분
			response.addCookie(c);	//쿠키 굽기	
		}
		
		log.info("==== 로그인 컨트롤러 진입");
		String id = service.login(m);
		if(id != null) {
			session.setAttribute("savedId", id);
			log.info("==== 컨트롤러: 로그인 성공");
		} else {
			log.info("==== 컨트롤러: 로그인 실패");
		}
		return "redirect:/";
	}
	
	@GetMapping("/regProc")
	public String regProc(MemberDto m) {
		service.reg(m);
		return "redirect:/";
	}
}
