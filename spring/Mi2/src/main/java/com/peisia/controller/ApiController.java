package com.peisia.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.dto.CardDto;

@RequestMapping("/card")
public class ApiController {

    @GetMapping("/play")
    public List<CardDto> getMyCards() {
        List<CardDto> myCards = new ArrayList<>();
        myCards.add(new CardDto("DarkMagician", "SSR"));
        myCards.add(new CardDto("Kuriboh", "SR"));
        return myCards;
	}			
}								