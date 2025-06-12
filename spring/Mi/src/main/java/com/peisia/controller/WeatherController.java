package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.CatDto;
import com.peisia.dto.KWeatherDto;
import com.peisia.dto.SkillDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/weather/*")
//@AllArgsConstructor
@Controller
public class WeatherController {

	@RequestMapping("/w")
	public void w() {
		//// 우리나라 공공 api ////
		// 인코딩 인증키
		String API_KEY = "TDf%2Fho9nOMC2Ho71ocCWLwhwgKl9KBhSyyX67Pylaw%2BN0V7GQsIt%2B7UaJQsN9X%2FrpsIc%2FJJR%2Bltqo30nKyUXjA%3D%3D";
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20250609&endDt=20250610&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey="
				+ API_KEY;
		// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.
		RestTemplate restTemplate = new RestTemplate();

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String s = restTemplate.getForObject(uri, String.class); // JSON 문자열로도 테스트 가능
		log.info("====== 우리나라 날씨 잘 나오나? " + s);

		KWeatherDto kw = restTemplate.getForObject(uri, KWeatherDto.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : " + kw.response.body.dataType);
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : " + kw.response.body.dataType);
		String location = kw.response.body.items.item.get(0).stnNm;
		String tMin = kw.response.body.items.item.get(0).minTa;
		String tMax = kw.response.body.items.item.get(0).maxTa;
		String ddara = String.format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location,
				tMin, tMax);
		log.info(ddara);
	}

	@RequestMapping("/getCat")
	public void getCat(Model model) {
		//// 우리나라 공공 api ////
		// 인코딩 인증키
		String API_URL = "http://localhost:8080/api/cat";
		// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.
		RestTemplate restTemplate = new RestTemplate();

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String s = restTemplate.getForObject(uri, String.class); //
		log.info("====== 내 고양이 api 요청으로 받은 json 문자열 잘 나오나? " + s);

		CatDto catDto = restTemplate.getForObject(uri, CatDto.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 고양이 이름 잘 나오냐? : " + catDto.name);
		log.info("==== json ==== : 고양이 나이 잘 나오냐? : " + catDto.age);
		log.info("==== json ==== : 고양이 취미 잘 나오냐? : " + catDto.hobby.get(0));
		log.info("==== json ==== : 고양이 취미 잘 나오냐? : " + catDto.hobby.get(1));
		for(SkillDto sd : catDto.skills) {
			log.info("==== json ==== : 고양이 스킬 목록과 레벨 잘 나오냐? : "+sd.name+" 레벨:"+sd.level);
		}
		model.addAttribute("catName", catDto.skills);
	}							
	
}