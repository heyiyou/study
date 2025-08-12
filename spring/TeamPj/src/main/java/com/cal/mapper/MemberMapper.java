package com.cal.mapper;

import com.cal.dto.MemberDto;

public interface MemberMapper {
    void insertMember(MemberDto member);
    MemberDto findById(String id);
    MemberDto findByNickname(String nickname);
    MemberDto findByEmail(String email);
	int updateMember(MemberDto dto);
}
