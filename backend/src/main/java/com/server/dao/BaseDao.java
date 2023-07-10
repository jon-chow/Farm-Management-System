package com.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
    @Autowired
    private SqlSession sqlSessionTemplate;
    protected SqlSession getSqlSession() {
        return sqlSessionTemplate;
    }
}
