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

        Way way = jdbcTemplate.queryForObject(querySQL, params, rowMapper);

        return way;
    }

    @Override
    public List<Way> getSectorWay(Integer sector_id) {
        String querySQL = "SELECT * FROM way WHERE sector_id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", sector_id);
        RowMapper<Way> rowMapper = new WayMapper();

        List<Way> ways = jdbcTemplate.query(querySQL, params, rowMapper);

        return ways;
    }

    @Override
    public void insert(Integer sector_id, String name, String description, Double height, String quotation) {
        String sql = "INSERT INTO way (sector_id, height, quotation, way_name, way_description) VALUES (:sector_id, :height, :quotation, :way_name, :way_description)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sector_id", sector_id);
        params.addValue("height", height);
        params.addValue("quotation", quotation);
        params.addValue("way_name", name);
        params.addValue("way_description", description);

        jdbcTemplate.update(sql, params);
    }
}