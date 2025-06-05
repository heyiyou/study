package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.KWeatherDto;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/weather/*")
//@AllArgsConstructor
@Controller
public class WeatherController {

	@RequestMapping("/w")							
	public void w() {							
		//// �츮���� ���� api ////						
		//���ڵ� ����Ű						
		String API_KEY = "TDf%2Fho9nOMC2Ho71ocCWLwhwgKl9KBhSyyX67Pylaw%2BN0V7GQsIt%2B7UaJQsN9X%2FrpsIc%2FJJR%2Bltqo30nKyUXjA%3D%3D";						
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20250603&endDt=20250604&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;						
				// * ���� * https �ƴ� http ��. https �� �������� ������ ó���� �ؾ���.				
		RestTemplate restTemplate = new RestTemplate();						
								
		//// **** �߿� **** uri						
		URI uri = null; //java.net.URI ����Ʈ �ϼ�						
		try {						
			uri = new URI(API_URL); // URI Ŭ������ URL�� ���� ��ȿ�� �˻�, ������� ����, ����(Ư������, ���� ó�� ��)�� ������					
		} catch (URISyntaxException e) {						
			e.printStackTrace();					
		}						
								
		String s = restTemplate.getForObject(uri, String.class); //					 	
		log.info("====== �츮���� ���� �� ������? "+s);		
		
		KWeatherDto kw = restTemplate.getForObject(uri, KWeatherDto.class); // �ڱ� Ŭ������ �ٲٽÿ�..												
		log.info("==== json ==== : �츮���� ���� �� ������? : "+kw.response.body.dataType);												
		log.info("==== json ==== : �츮���� ���� �� ������? : "+kw.response.body.dataType);												
		String location = kw.response.body.items.item.get(0).stnNm;												
		String tMin = kw.response.body.items.item.get(0).minTa;												
		String tMax = kw.response.body.items.item.get(0).maxTa;												
		String ddara = String.format("==== json ==== : ������ �����Դϴ�~ ���� %s �� ��������� %s �� �ְ� ����� %s �����ϴ�. ���������ϴ�.", location, tMin, tMax);												
		log.info(ddara);												
	}							
	
}
