package com.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;


public class BaseDao {
    @Resource
    private SqlSession sqlSessionTemplate;
    /*    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
      super.setSqlSessionFactory(sqlSessionFactory);
    }*/

    /*    @Resource
        public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
            super.setSqlSessionTemplate(sqlSessionTemplate);
        }*/
    protected SqlSession getSqlSession() {
        return sqlSessionTemplate;
    }
}
