package com.smhrd.bigdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.bigdata.entity.BootBoard;
import com.smhrd.bigdata.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository repo;
	
	public List<BootBoard> boardList() {
		List<BootBoard> list = repo.findAll();
		return list;
	}
	
	public void write(BootBoard b) {
		//save~ : insert
		repo.save(b);
	}
	
	public BootBoard content(int idx) {
		BootBoard b = repo.findByIdx(idx);
		
		return b;
	}
}






