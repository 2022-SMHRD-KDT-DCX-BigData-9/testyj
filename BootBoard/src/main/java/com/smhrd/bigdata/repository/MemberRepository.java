package com.smhrd.bigdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.bigdata.entity.BootMember;

@Repository
public interface MemberRepository extends JpaRepository<BootMember,Long>{
	
	public BootMember findByIdAndPw(String id,String pw);
	
}
