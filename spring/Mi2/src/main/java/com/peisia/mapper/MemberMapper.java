package com.peisia.mapper;

import com.peisia.dto.MemberDto;

public interface MemberMapper {

	public void reg(MemberDto m);

	public MemberDto login(MemberDto m);
}
