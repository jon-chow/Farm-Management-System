package com.server.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;


public class BaseDao extends SqlSessionDaoSupport {
    /*    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
      super.setSqlSessionFactory(sqlSessionFactory);
    }*/

    @Resource
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
