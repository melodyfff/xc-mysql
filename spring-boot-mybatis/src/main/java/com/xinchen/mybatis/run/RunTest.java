package com.xinchen.mybatis.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author xinchen
 * @version 1.0
 * @date 15/01/2020 16:26
 */
@Component
public class RunTest implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (final Connection connection = dataSource.getConnection()){
            try (final PreparedStatement preparedStatement = connection.prepareStatement("select * from app_user where id = ? or id =?")){
                preparedStatement.setInt(1,1);
                preparedStatement.setInt(2,2);
                final ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
//                        System.out.println(resultSet.getObject(i));
                        // ignore
                    }
                }
            }
        }
    }
}
