package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.WayDAO;
import com.alphamplyer.ocescalade.dao.mapper.WayMapper;
import com.alphamplyer.ocescalade.model.Way;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WayDAOImpl extends AbstractDAO implements WayDAO {

    @Override
    public Way getWay(Integer id) {
        String querySQL = "SELECT * FROM way WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        RowMapper<Way> rowMapper = new WayMapper();

        Way site = jdbcTemplate.queryForObject(querySQL, params, rowMapper);

        return site;
    }

    @Override
    public List<Way> getSectorWay(Integer sector_id) {
        String querySQL = "SELECT * FROM way WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", sector_id);
        RowMapper<Way> rowMapper = new WayMapper();

        List<Way> site = jdbcTemplate.query(querySQL, params, rowMapper);

        return site;
    }
}