package com.test.jdbc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.jdbc.vo.SelectVo;

@Repository
public class SormDao {
	@Autowired
    private SqlSessionTemplate sqlSession;
	
    
	
    public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}



	public List<SelectVo> listAll(){
        return sqlSession.selectList("com.test.jdbc.mapper.SelectMapper.listAll");
    }
}
