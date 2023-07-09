package com.server.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.Resource;

@Configuration
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setMapperLocations(getMapperLocations());
        // Other configurations
        return sessionFactory.getObject();
    }

    private Resource[] getMapperLocations() throws Exception {
        String mapperLocations = "classpath*:mybatis/mapper/**/*.xml";
        return new PathMatchingResourcePatternResolver().getResources(mapperLocations);
    }
}
