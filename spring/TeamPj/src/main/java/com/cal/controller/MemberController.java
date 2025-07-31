package com.cal.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cal.dto.MemberDto;
import com.cal.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/member/") // 고정 요청 경로
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class MemberController {

	private final MemberService service;

	@PutMapping("/register")
	public ResponseEntity<String> register(@RequestBody MemberDto member) {
		service.register(member);
		return ResponseEntity.ok().body("회원가입 성공");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody MemberDto m, HttpSession session,
			@RequestParam(value = "saveId", required = false) String saveId, HttpServletResponse response) {
		log.info("==== 로그인 저장 체크: " + saveId);
		log.info("==== 로그인 API 호출됨 ====");
		log.info("Request id: " + m.getId());
		log.info("Request password: " + m.getPassword());

		String nickname = service.login(m);
		if (nickname != null) {
			session.setAttribute("loggedInUser", nickname);
			if ("on".equals(saveId)) {
				Cookie c = new Cookie("cookieSavedId", m.getId()); // 여기 로그인 쿠키
				c.setPath("/");
				c.setHttpOnly(true);
				c.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(c);
			}
			return ResponseEntity.ok("로그인 성공");
		} else {
			return ResponseEntity.status(401).body("로그인 실패");
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session, HttpServletResponse response) {
		session.invalidate();
		// 🔹 cookieSavedId 쿠키 삭제
		Cookie deleteCookie = new Cookie("cookieSavedId", null);
		deleteCookie.setPath("/"); // 반드시 동일한 path
		deleteCookie.setMaxAge(0); // 0 → 즉시 삭제
		response.addCookie(deleteCookie);

		return ResponseEntity.ok("로그아웃 성공");
	}

	@GetMapping("/status")
	public ResponseEntity<String> loginStatus(HttpSession session) {
		String loggedInUser = (String) session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			return ResponseEntity.ok().header("Content-Type", "text/plain; charset=UTF-8") // charset 지정!
					.body("현재 로그인한 사용자: " + loggedInUser);
		} else {
			return ResponseEntity.status(401).header("Content-Type", "text/plain; charset=UTF-8").body("로그인하지 않음");
		}
	}

	@GetMapping("/check-id")
	public ResponseEntity<String> checkId(@RequestParam String id) {
		boolean exists = service.isIdTaken(id);

		if (exists) {
			return ResponseEntity.status(409).header("Content-Type", "text/plain; charset=UTF-8")
					.body("이미 사용 중인 아이디입니다.");
		} else {
			return ResponseEntity
					.ok()
					.header("Content-Type", "text/plain; charset=UTF-8")
					.body("사용 가능한 아이디입니다.");
		}
	}

	@GetMapping("/check-nickname")
	public ResponseEntity<String> checkNickname(@RequestParam String nickname) {
		boolean exists = service.isNicknameTaken(nickname); // isNicknameTaken = is → **"인지?+nickname+Taken 사용중이다

		if (exists) {
			return ResponseEntity.status(409)
					.header("Content-Type", "text/plain; charset=UTF-8")
					.body("이미 사용 중인 닉네임입니다.");
		} else {
			return ResponseEntity
					.ok()
					.header("Content-Type", "text/plain; charset=UTF-8")
					.body("사용 가능한 닉네임입니다.");
		}
	}

	@GetMapping("/check-email")
	public ResponseEntity<String> checkEmail(@RequestParam String email) {
		boolean exists = service.isEmailTaken(email); // MemberService에 구현해야 함

		if (exists) {
			return ResponseEntity.status(409)
					.header("Content-Type", "text/plain; charset=UTF-8")
					.body("이미 사용 중인 이메일입니다.");
		} else {
			return ResponseEntity
					.ok()
					.header("Content-Type", "text/plain; charset=UTF-8")
					.body("사용 가능한 이메일입니다.");
		}
	}

	@PostMapping("/update")
	public ResponseEntity<String> update(@RequestBody MemberDto dto) {
	    boolean result = service.updateMember(dto);
	    if (result) {
	        return ResponseEntity
	                .ok()
	                .header("Content-Type", "text/plain; charset=UTF-8")
	                .body("회원정보가 수정되었습니다");
	    } else {
	        return ResponseEntity
	                .status(500)
	                .header("Content-Type", "text/plain; charset=UTF-8")
	                .body("회원정보 수정 실패");
	    }
	}
	
	@GetMapping("/find-by-id")
	public ResponseEntity<MemberDto> findById(@RequestParam String id) {
	    MemberDto member = service.findById(id);

	    if (member != null) {
	        return ResponseEntity.ok(member);
	    } else {
	        return ResponseEntity.status(404)
	        		.build(); // 찾을 수 없음
	    }
	}
}
