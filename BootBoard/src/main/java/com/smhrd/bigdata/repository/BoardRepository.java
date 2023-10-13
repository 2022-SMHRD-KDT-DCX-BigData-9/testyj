package com.smhrd.bigdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.bigdata.entity.BootBoard;

public interface BoardRepository extends JpaRepository<BootBoard, Long>{
	
	public BootBoard findByIdx(long idx);
	
}
