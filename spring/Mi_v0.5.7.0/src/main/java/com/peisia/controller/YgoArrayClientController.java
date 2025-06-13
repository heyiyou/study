package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.YgoCardItemDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/ygo/*")          // <-- /ygo 로 시작하는 모든 URL 담당     중요
@Controller
public class YgoArrayClientController {
    @RequestMapping("/paged")        // /ygo/paged?page=1
    public String showPaged(Model model) {

        // 내부 API 호출
        String apiUrl = "http://localhost:8080/api/ygo-api";
        RestTemplate rest = new RestTemplate();
        URI uri = null;
        try { uri = new URI(apiUrl); }
        catch (URISyntaxException e) { throw new RuntimeException(e); }

        YgoCardItemDto result = rest.getForObject(uri, YgoCardItemDto.class);

        // 카드·페이지 정보를 뷰로 전달
        model.addAttribute("cards", result);

        return "ygo/paged";      // /WEB-INF/views/ygo/paged.jsp 로 forward
    }
}
