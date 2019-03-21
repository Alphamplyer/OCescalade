package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopoMapper implements RowMapper<Topo> {

    @Override
    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topo topo = new Topo(rs.getInt("id"));
        topo.setAuthor_id(rs.getInt("author_id"));

        topo.setTopo_title(rs.getString("topo_title"));
        topo.setTopo_description(rs.getString("topo_description"));
        topo.setTopo_content(rs.getString("topo_content"));

        topo.setCreation_date(rs.getTimestamp("creation_date"));
        topo.setTopo_like(rs.getInt("topo_like"));
        topo.setTopo_vues(rs.getInt("topo_vues"));
        topo.setFindedTopo(rs.getInt("full_count"));
        return topo;
    }
}
