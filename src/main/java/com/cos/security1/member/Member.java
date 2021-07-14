package com.cos.security1.member;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	private String username;
	private String password;
	private String email;
	private String role;
	@CreationTimestamp
	private Timestamp regdate;
	
	@Builder
	public Member(int uid, String username, String email, String password, String nickname, Timestamp regdate, String role) {
		super();
		this.uid = uid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.regdate = regdate;
		this.role = role;
	}
	
	
}
