package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.SectorDAO;
import com.alphamplyer.ocescalade.dao.mapper.SectorMapper;
import com.alphamplyer.ocescalade.model.Sector;
import com.alphamplyer.ocescalade.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectorDAOImpl extends AbstractDAO implements SectorDAO {

    @Override
    public Sector getSector(Integer id) {
        String querySQL = "SELECT * FROM sector WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        RowMapper<Sector> rowMapper = new SectorMapper();

        Sector site = jdbcTemplate.queryForObject(querySQL, params, rowMapper);

        return site;
    }

    @Override
    public List<Sector> getSiteSectors(Integer site_id) {
        String querySQL = "SELECT * FROM sector WHERE site_id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", site_id);
        RowMapper<Sector> rowMapper = new SectorMapper();

        List<Sector> site = jdbcTemplate.query(querySQL, params, rowMapper);

        return site;
    }

    @Override
    public void insertSector(User user, Integer site_id, String name, String description, String orientation) {
        String sql = "INSERT INTO sector (site_id, orientation, sector_name, sector_description) " +
            " VALUES (:site_id, :orientation, :sector_name, :sector_description)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("site_id", site_id);
        params.addValue("orientation", orientation);
        params.addValue("sector_name", name);
        params.addValue("sector_description", description);

        jdbcTemplate.update(sql, params);
    }
}
