package com.peisia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peisia.dto.CardDto;
import com.peisia.mapper.CardMapper;
import com.peisia.mapper.ShopMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class CardServiceImpl implements CardService{

	@Setter(onMethod_ = @Autowired)
	private CardMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private ShopMapper mapperShop;

	@Override
	public ArrayList<CardDto> getList() {
		ArrayList<CardDto> n = mapper.getList();
		return n;
	}

	@Transactional	//트랜잭션 처리함
	@Override
	public void addCard(CardDto c) {
		mapper.addCard(c);
		mapperShop.payDice();	//다이스박스 차감 까지해야함
	}

	@Override
	public void partyAdd(CardDto c) {
		mapper.partyAdd(c);
	}

	@Override
	public ArrayList<CardDto> getParty() {
		ArrayList<CardDto> n = mapper.getParty();
		return n;		
	}	
	@Override
	public void clearParty() {
		mapper.clearParty();
	}

	@Override
	public CardDto getRandomCard() {
		// TODO Auto-generated method stub
		return null;
	}	
}