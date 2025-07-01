package com.peisia.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.CardDto;
import com.peisia.service.CardService;

import lombok.Setter;

@CrossOrigin(origins = "http://localhost:3000") // 3000포트에서의 요청 허용
@RequestMapping("/card")
@RestController
public class CardController {
	
	@GetMapping("/gacha")
	public CardDto gacha() {
	    System.out.println("==== 가챠 요청 도착 ====");
	    CardDto c = new CardDto();
	    c.setJob("전사");  // 테스트용 고정값
	    c.setGrade("UR"); // 테스트용 고정값
	    return c;
	}
	
	// 파티 초기화
    @PostMapping("/clearParty")
    public void clearParty() {
    	 System.out.println("==== 파티 초기화 요청 도착 ====");
         service.clearParty();  // 실제로 파티 비우는 로직
    	
    }
	
	@Setter(onMethod_ = @Autowired)
	private CardService service;	
	
	//카드 전체 리스트
	@RequestMapping("/getMyCards")			
	public ArrayList<CardDto> getMyCards() {
		ArrayList<CardDto> n = service.getList();
		System.out.println("==== 총 카드 수:"+n.size());
		
		return n;
	}
	
	// 파티 등록			
	@RequestMapping("/partyAdd")			
	public void partyAdd(@RequestBody CardDto c) {
		service.partyAdd(c);
		System.out.println("==== 데이터 잘 오나?: job:"+c.getJob());
		System.out.println("==== 데이터 잘 오나?: grade:"+c.getGrade());
	}				
	
	  // 파티 목록 조회
    @GetMapping("/getParty")
    public ArrayList<CardDto> getParty() {
        return service.getParty();
    }
	
}
