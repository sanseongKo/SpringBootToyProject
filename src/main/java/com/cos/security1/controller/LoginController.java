package com.cos.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.security1.auth.PrincipalDetails;
import com.cos.security1.member.Member;
import com.cos.security1.memberRepository.MemberRepository;

@Controller
public class LoginController {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/login")
	public String login(Authentication authentication
			, @AuthenticationPrincipal PrincipalDetails memberDetails) {
		PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
		return "login";
	}
	@GetMapping({"/", ""})
	public String main() {
		return "mainPage";
	}
	@GetMapping("loginPage")
	public String loginPage() {
		return "loginPage";
	}
	@PostMapping("/join")
	public String join(Member member) {
		member.setRole("ROLE_USER");
		String rawPassword = member.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		member.setPassword(encPassword);
		
		memberRepository.save(member);
		return "redirect:/loginPage";
	}
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
}
