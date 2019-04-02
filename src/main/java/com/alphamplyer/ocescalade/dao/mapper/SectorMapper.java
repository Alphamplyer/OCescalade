package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.Sector;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectorMapper implements RowMapper<Sector> {

    @Override
    public Sector mapRow(ResultSet rs, int rowNum) throws SQLException {

        Sector sector = new Sector(rs.getInt("id"));

        sector.setSite_id(rs.getInt("site_id"));
        sector.setOrientation(rs.getString("orientation"));
        sector.setDifficulty(rs.getString("difficulty"));
        sector.setSector_name(rs.getString("sector_name"));
        sector.setSector_description(rs.getString("sector_description"));

        return sector;
    }
}
