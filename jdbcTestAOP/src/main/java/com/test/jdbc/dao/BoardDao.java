package com.test.jdbc.dao;

import java.util.List;

import com.test.jdbc.dto.BDto;

public interface BoardDao {
	
	public int write(BDto bDto);
	public int delete(String name);
	public int update(BDto bDto);
	public BDto selectOne(String bName);
	public List<BDto> listAll();
	
	int boardCount() ;
}
