package com.cal.service;

import org.springframework.stereotype.Service;
import com.cal.dto.MemberDto;
import com.cal.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mapper;

    @Override
    public void register(MemberDto member) {
        mapper.insertMember(member);
    }

    @Override
    public String login(MemberDto member) {
        MemberDto dbMember = mapper.findById(member.getId());
        System.out.println("로그인 시도 id: " + member.getId());
        System.out.println("DB에서 찾은 member: " + dbMember);

        if (dbMember != null) {
            System.out.println("DB 패스워드: " + dbMember.getPassword());
            System.out.println("입력한 패스워드: " + member.getPassword());
        }
        if (dbMember != null && dbMember.getPassword().equals(member.getPassword())) {
        	return dbMember.getNickname();
        }
        return null;
    }
    
    @Override
    public boolean isIdTaken(String id) {
        return mapper.findById(id) != null;
    }
    
    
    @Override
    public boolean isNicknameTaken(String nickname) {
        return mapper.findByNickname(nickname) != null;
    }

    public boolean isEmailTaken(String email) {
        return mapper.findByEmail(email) != null;
    }

	
    //로그인   회원 수정 버튼쪽
	public boolean updateMember(MemberDto dto) {
	    // 비밀번호 비워져 있으면 기존 값 유지
	    if (dto.getPassword() == null || dto.getPassword().trim().isEmpty()) {
	        MemberDto existing = mapper.findById(dto.getId());
	        if (existing != null) {
	            dto.setPassword(existing.getPassword());
	        }
	    }
	    return mapper.updateMember(dto) > 0;
	}

	@Override
	public MemberDto findById(String id) {
	    return mapper.findById(id);
	}
	
    
}
