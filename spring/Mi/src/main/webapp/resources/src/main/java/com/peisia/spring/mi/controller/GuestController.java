package com.peisia.spring.mi.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.spring.mi.service.BoardListProcessor;
import com.peisia.spring.mi.service.GuestService;
import com.peisia.spring.mi.vo.GuestVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class GuestController {
	private GuestService service;
	
	@GetMapping("/getList")
	public void getList(@RequestParam(value="currentPage", defaultValue = "1") int currentPage, Model model) {
		model.addAttribute("blp", service.getList(currentPage));
	}	
	
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("컨트롤러 ==== 글번호 ==============="+bno);
		service.del(bno);
		return "redirect:/guest/getList";	// 책 p.245 참고
	}
	
	@PostMapping("/write")
	public String write(GuestVO gvo) {
		service.write(gvo);
		return "redirect:/guest/getList";	// 책 p.245 참고
	}
	
	@GetMapping("/write")	// 책 p.239 /write 중복이지만 이건 글쓰기 화면을 위한 url 매핑
	public void write() {
		
	}
	
	@PostMapping("/modify")
	public String modify(GuestVO gvo) {
		service.modify(gvo);
		return "redirect:/guest/getList";
	}
	
	@GetMapping("/test")
	public void test(HttpServletResponse rs,HttpServletRequest rq) {
		Cookie c = new Cookie("cat","야옹이");
		rs.addCookie(c);
		
		Cookie [] cs = rq.getCookies();
        if (cs != null) {
            for (Cookie cc : cs) {
                if ("cat".equals(cc.getName())) {
                    String n = cc.getValue();
                    System.out.println("==== 쿠키 값 찍기: "+n);
                    break;
                }
            }
        }		
	}
}