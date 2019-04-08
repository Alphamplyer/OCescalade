package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.SiteDAO;
import com.alphamplyer.ocescalade.dao.mapper.SiteMapper;
import com.alphamplyer.ocescalade.model.Site;
import com.alphamplyer.ocescalade.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SiteDAOImpl extends AbstractDAO implements SiteDAO {

    @Override
    public Site getSite(Integer id) {
        String querySQL = "SELECT * FROM site WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        RowMapper<Site> rowMapper = new SiteMapper();

        Site site = jdbcTemplate.queryForObject(querySQL, params, rowMapper);

        return site;
    }

    @Override
    public List<Site> getTopoSites(Integer topo_id) {
        String querySQL = "SELECT * FROM site WHERE topo_id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", topo_id);
        RowMapper<Site> rowMapper = new SiteMapper();

        List<Site> site = jdbcTemplate.query(querySQL, params, rowMapper);

        return site;
    }

    @Override
    public void insertSite(User user, Integer id, String name, String description, Double elevation, String rock_type) {
        String sql = "INSERT INTO site (topo_id, site_name, site_description, site_elevation, rock_type) VALUES (:topo_id, :site_name, :site_description, :site_elevation, :rock_type)";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("topo_id", id);
        params.addValue("site_name", name);
        params.addValue("site_description", description);
        params.addValue("site_elevation", elevation);
        params.addValue("rock_type", rock_type);

        jdbcTemplate.update(sql, params);
    }
}
