package com.xinchen.mybatis.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 *
 * 没有在spring boot配置文件中进行配置的普通初始化方式
 *
 * @author xinchen
 * @version 1.0
 * @date 16/01/2020 11:18
 */
@Profile("normal")
@Configuration
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        final PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(patternResolver.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        // 也可直接用注解@MapperScan
//        final MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.xinchen.mybatis.core.dao");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        return mapperScannerConfigurer;
//    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        // ExecutorType默认为SIMPLE : 这个类型不做特殊的事情，它只为每个语句创建一个PreparedStatement
        // BATCH : 这个类型批量更新，且必要地区别开其中的select 语句，确保动作易于理解。(在事物未提交前,无法获取到自增id)
        // REUSE : 这种类型将重复使用PreparedStatements
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.SIMPLE);
    }

}
