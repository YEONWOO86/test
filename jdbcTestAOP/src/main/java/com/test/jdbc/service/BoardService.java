package com.test.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.jdbc.dao.BoardDao;
import com.test.jdbc.dto.BDto;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BDto> listAll() {
		System.out.println("service boardList()");
		return boardDao.listAll();
	}

	public BDto selectOne(String name) {
		System.out.println("service boardDetail()");
			return boardDao.selectOne(name);
			
	}

//	public void upHits(int test) {
//		System.out.println("service uphits()");
//		boardDao.boardUpHits(test);
//	}

	public void update(BDto bDto) {
		System.out.println("service boardUpdate()");
		boardDao.update(bDto);
	}

	public int write(BDto bDto) {
		System.out.println("service boardInsert()");		
		return boardDao.write(bDto);
	}

	public void delete(String name) {
		System.out.println("service boardDelete()");
		boardDao.delete(name);
	}
}
