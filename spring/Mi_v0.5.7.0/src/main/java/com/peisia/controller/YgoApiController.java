package com.peisia.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.YgoCardItemDto;

@RestController
@RequestMapping("/api")
public class YgoApiController {
	@GetMapping("/ygo-api")
    public YgoCardItemDto getAllCards() {

            YgoCardItemDto card = new YgoCardItemDto();
            card.cardId = "C";
            card.cardName = "카드 ";
            card.cardType = "몬스터";
            card.attribute =  "빛" ;
            card.level =  10;
            card.atk = 1000  * 100;
            card.def = 800  * 80;
            card.desc = "설명 " ;
            return card;
    }
}
