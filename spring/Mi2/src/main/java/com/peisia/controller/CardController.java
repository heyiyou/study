package com.peisia.controller;

import java.util.ArrayList;
import java.util.Random;

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

// ✅ CORS 허용 (React용)
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/card")
public class CardController {

    @Setter(onMethod_ = @Autowired)
    private CardService service;

    // ✅ 랜덤 카드 뽑기 (가챠)
    @GetMapping("/gacha")
    public CardDto gacha() {
        System.out.println("==== 가챠 요청 도착 ====");

        String[] jobs = {"전사", "마법사", "도적", "궁수", "사제"};
        String[] grades = {"N", "R", "SR", "UR"};

        Random rand = new Random();
        String randomJob = jobs[rand.nextInt(jobs.length)];
        String randomGrade = grades[rand.nextInt(grades.length)];

        CardDto c = new CardDto();
        c.setJob(randomJob);
        c.setGrade(randomGrade);

        System.out.println("뽑힌 카드: " + randomJob + " - " + randomGrade);
        return c;
    }

    // ✅ 파티 초기화
    @PostMapping("/clearParty")
    public void clearParty() {
        System.out.println("==== 파티 초기화 요청 도착 ====");
        service.clearParty();
    }

    // ✅ 카드 전체 리스트
    @RequestMapping("/getMyCards")
    public ArrayList<CardDto> getMyCards() {
        ArrayList<CardDto> n = service.getList();
        System.out.println("==== 총 카드 수: " + n.size());
        return n;
    }

    // ✅ 파티 등록
    @RequestMapping("/partyAdd")
    public void partyAdd(@RequestBody CardDto c) {
        service.partyAdd(c);
        System.out.println("==== 데이터 잘 오나?: job: " + c.getJob());
        System.out.println("==== 데이터 잘 오나?: grade: " + c.getGrade());
    }

    // ✅ 파티 목록 조회
    @GetMapping("/getParty")
    public ArrayList<CardDto> getParty() {
        return service.getParty();
 
    
    }

}


