package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.Site;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteMapper implements RowMapper<Site> {

    @Override
    public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
        Site site = new Site(rs.getInt("id"));
        site.setTopo_id(rs.getInt("topo_id"));

        site.setSite_name(rs.getString("site_name"));
        site.setSite_description(rs.getString("site_description"));

        site.setSite_elevation(rs.getDouble("site_elevation"));
        site.setRock_type(rs.getString("rock_type"));

        return site;
    }
}
