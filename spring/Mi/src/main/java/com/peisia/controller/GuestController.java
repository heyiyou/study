package com.peisia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.peisia.dto.GuestDto;
import com.peisia.service.GuestService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/guest/*")
@AllArgsConstructor
@Controller
public class GuestController {
		
	private GuestService service;
	
	@GetMapping("/getList")
	public void getList(@RequestParam("currentPage") int currentPage, Model model) {
		model.addAttribute("list",service.getList(currentPage));
	}
	
	@GetMapping({"/read", "/modify"})
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ==============="+bno);
		service.del(bno);
		return "redirect:/guest/getList?currentPage=1";	// å p.245 ����
	}
	
	@PostMapping("/write")
	public String write(GuestDto gvo) {
		service.write(gvo);
		return "redirect:/guest/getList?currentPage=1";	// å p.245 ����
	}
	
	@GetMapping("/write")	// å p.239 /write �ߺ������� �̰� �۾��� ȭ���� ���� url ����
	public void write() {
		
	}
	
	@PostMapping("/modify")
	public String modify(GuestDto dto) {
		service.modify(dto);
		return "redirect:/guest/getList?currentPage=1";
	}
	
	
}
