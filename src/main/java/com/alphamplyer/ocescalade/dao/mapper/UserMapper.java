package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User(rs.getInt("id"));
        user.setFirst_name(rs.getString("first_name"));
        user.setLast_name(rs.getString("last_name"));
        user.setNickname(rs.getString("nickname"));
        user.setPassword(rs.getString("password"));
        user.setBirthday(rs.getDate("birthdate"));
        user.setInscription_date(rs.getDate("inscription_date"));
        user.setMail(rs.getString("mail"));
        user.setPermission_level(rs.getInt("permission_level"));
        user.setSalt(rs.getString("salt"));

        return user;
    }
}
