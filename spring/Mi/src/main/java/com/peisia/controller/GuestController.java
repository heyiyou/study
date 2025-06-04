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
@RequestMapping("/guest/*")	//������Ʈ ��Ʈ ��� ���� /guest ���������� ���� �� ����� �����ϰ� ��.  
@AllArgsConstructor	//�ʵ� ���� �Ű������� �ϴ� �����ڸ� �������� �˾Ƽ� ����� ��. �׸��� �׷� ������ �����ڸ� �߰��ϸ� �������� �˾Ƽ� ��ü���� ����(@Auto.. ó��)
@Controller
public class GuestController {

//	���� @AllArgsConstructor �̰� ����
//	�Һ����̺귯���� �Ʒ� �ڵ带 �ڵ����� ��������
	
	//
//	public GuestController(GuestService service){
//		this.service = service;
//	}
	
	private GuestService service;
	
	@GetMapping("/getList")	// ������Ʈ ��Ʈ ��� ���� /guest/getList url ���� �� ����� �����ϰ� ��.
	public void getList(Model model) {	// �Ű������� Model m ������ �ۼ��ϰ� �Ǹ�, �������� �˾Ƽ� �� ��ü�� ���� �Ѱ���.
		model.addAttribute("list",service.getList());
	}	// �� /getList �� ������ jsp������ ��. ���� ��� ����(/guest). �� PJ��Ʈ/guest/getList.jsp ������ ��.
	// �׸��� �� ������ 
	// PJ\src\main\webapp\WEB-INF\views\guest\getList.jsp
	// �� ����� ������ ��.
	
	@GetMapping("/read")
	public void read(@RequestParam("bno") Long bno, Model model) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ==============="+bno);
		model.addAttribute("read",service.read(bno));
	}
	
	// �̷������� url ȣ��� ���� �����ϰ�..
	// >>> Ȩ������/spring/guest/del?bno=2	
	@GetMapping("/del")
	public String del(@RequestParam("bno") Long bno) {
		log.info("��Ʈ�ѷ� ==== �۹�ȣ ==============="+bno);
		service.del(bno);
		return "redirect:/guest/getList";	//sendRedirect �� �̵��ϰ� ��.
	}
	
	
	// >>> Ȩ������/spring/guest/write (Post ������� ���� ����� ��)	
	@PostMapping("/write")
	//�� �±��� �ؽ�Ʈ����� �±׿� btext ������ �����Ͱ� �Ѿ�Դµ�
	//�Ű������� (GuestVO gvo) �̷� Ŭ������ �����س��� �Ǹ�
	//�ش� ��ü�� ��������� �������� �˾Ƽ� ä����.
	public String write(GuestDto dto) {
		service.write(dto);
		return "redirect:/guest/getList";	//sendRedirect �� �̵��ϰ� ��. // å p.245 ����
	}	
	
	// >>> Ȩ������/spring/guest/write (get ������� ���� ����� ��. �Ϲݸ�ũ�̵�=get�����)	
	@GetMapping("/write")	// å p.239 /write �ߺ������� �̰� �۾��� ȭ���� ���� url ����
	public void write() {
		
	}	
	
}