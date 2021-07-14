package com.cos.security1.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.security1.member.Member;

public class PrincipalDetails implements UserDetails{
	@Autowired
	private Member member; 
	
	public PrincipalDetails(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {return member.getRole();}
		});
		return collect;//해당 멤버의 권한을 리턴 Authentication 객체여야 들어갈 수 있다.
	}

	@Override
	public String getPassword() {return member.getPassword();}

	@Override
	public String getUsername() {return member.getUsername();}

	@Override
	public boolean isAccountNonExpired() {return true;}

	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {return true;}
	
	
}
