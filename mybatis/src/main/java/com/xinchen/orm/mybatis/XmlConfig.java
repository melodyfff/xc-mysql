package com.xinchen.orm.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2020/7/27 23:11
 */
public class XmlConfig {
    SqlSessionFactory loadSqlSessionFactory() throws IOException {
        // load properties
        Properties properties = Resources.getResourceAsProperties("jdbc.properties");

        // load mybatis-config
        String resource = "mybatis-config.xml";
        InputStream config = Resources.getResourceAsStream(resource);

        // init SqlSessionFactory
        // notice: build(inputStream,environment,properties) ,can choose dif environment
        return new SqlSessionFactoryBuilder().build(config,properties);
    }
}
