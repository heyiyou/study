package com.cal.mapper;

import com.cal.dto.MemberDto;

public interface MemberMapper {
    void insertMember(MemberDto member);
    MemberDto findById(String id);
	Object findByNickname(String nickname);
	Object findByEmail(String email);
	int updateMember(MemberDto dto);
}
