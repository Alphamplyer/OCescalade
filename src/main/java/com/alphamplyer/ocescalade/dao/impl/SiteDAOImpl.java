package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.SiteDAO;
import com.alphamplyer.ocescalade.dao.mapper.SiteMapper;
import com.alphamplyer.ocescalade.model.Site;
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
}
