package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.UserDAO;
import com.alphamplyer.ocescalade.dao.mapper.UserMapper;
import com.alphamplyer.ocescalade.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public User getUserByNickname(String name) {
        String sql = "SELECT * FROM users WHERE nickname = '" + name + "'";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        RowMapper<User> rowMapper = new UserMapper();


        return jdbcTemplate.queryForObject(sql, rowMapper);
    }

    @Override
    public void registerUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, nickname, password, salt, birthdate, inscription_date, mail)"
            + " VALUES (:first_name, :last_name, :nickname, :password, :salt, :birthdate, 'NOW', :mail)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("first_name", user.getFirst_name());
        params.addValue("last_name", user.getLast_name());
        params.addValue("nickname", user.getNickname());
        params.addValue("password", user.getPassword());
        params.addValue("salt", user.getSalt());
        params.addValue("birthdate", user.getBirthday());
        params.addValue("mail", user.getMail());

        jdbcTemplate.update(sql, params);
    }
}
