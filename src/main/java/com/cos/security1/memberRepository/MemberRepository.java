package com.cos.security1.memberRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.security1.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	public Member findByUsername(String username);
}
