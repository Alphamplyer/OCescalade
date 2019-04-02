package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.Image;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageMapper implements RowMapper<Image> {

    @Override
    public Image mapRow(ResultSet rs, int rowNum) throws SQLException {

        Image image = new Image(rs.getInt("id"));

        image.setParent_id(rs.getInt("parent_id"));
        image.setMain_topo_image(rs.getBoolean("main_topo_image"));
        image.setTopo_image(rs.getBoolean("topo_image"));
        image.setSite_image(rs.getBoolean("site_image"));
        image.setSector_image(rs.getBoolean("sector_image"));
        image.setWay_image(rs.getBoolean("way_image"));
        image.setImage_name(rs.getString("image_name"));
        image.setImage_description(rs.getString("image_description"));
        image.setImage_url(rs.getString("image_url"));

        return image;
    }
}
