package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.Way;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WayMapper implements RowMapper<Way> {

    @Override
    public Way mapRow(ResultSet rs, int rowNum) throws SQLException {

        Way way = new Way(rs.getInt("id"));
        way.setSector_id(rs.getInt("sector_id"));
        way.setHeight(rs.getDouble("height"));
        way.setQuotation(rs.getString("quotation"));
        way.setWay_name(rs.getString("way_name"));
        way.setWay_description(rs.getString("way_description"));

        return way;
    }
}
