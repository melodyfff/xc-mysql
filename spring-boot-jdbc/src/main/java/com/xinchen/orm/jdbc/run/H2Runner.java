package com.xinchen.orm.jdbc.run;

import com.xinchen.orm.jdbc.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xinchen
 * @version 1.0
 * @date 15/01/2020 15:23
 */
@Profile("test")
@Component
public class H2Runner implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(jdbcTemplate.queryForObject("select * from app_user where id = ?", new UserMapper(), new Object[]{1}));
    }

    private static final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(Long.parseLong(resultSet.getString("id")));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }
}
