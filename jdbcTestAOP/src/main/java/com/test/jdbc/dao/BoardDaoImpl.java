package com.test.jdbc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.jdbc.dto.BDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
    private SqlSessionTemplate sqlSession;
	
    
	
    public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	@Override
	public List<BDto> listAll() { //목록보기
		return sqlSession.selectList("com.test.jdbc.mapper.SelectMapper.listAll");
	}


	@Override
	public int write(BDto bDto) { //글추가
		return sqlSession.insert("com.test.jdbc.mapper.SelectMapper.write",bDto);
	}


	@Override
	public int delete(String name) {//글 삭제
		// TODO Auto-generated method stub
		return sqlSession.delete("com.test.jdbc.mapper.SelectMapper.delete",name);
	}


	@Override
	public int update(BDto bDto) { //글수정
		// TODO Auto-generated method stub
		return sqlSession.update("com.test.jdbc.mapper.SelectMapper.update",bDto);
	}


	@Override
	public int boardCount() { // 조회수 (아직 미구현)
		System.out.println("���� ī��� �̱���");
		return 0;
	}


	@Override
	public BDto selectOne(String bName) { //상세보기
		System.out.println("9");
		return sqlSession.selectOne("com.test.jdbc.mapper.SelectMapper.listOne",bName);
	}

	
}
