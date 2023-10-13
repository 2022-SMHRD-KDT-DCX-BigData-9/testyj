package com.smhrd.bigdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bigdata.entity.BootMember;
import com.smhrd.bigdata.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository repo;
	
	public BootMember login(BootMember member) {
		//select * from bootmember where id=? and pw=?
		return repo.findByIdAndPw(member.getId(), member.getPw());
	}
}





