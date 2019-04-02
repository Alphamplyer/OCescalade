package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.ImageDAO;
import com.alphamplyer.ocescalade.dao.mapper.ImageMapper;
import com.alphamplyer.ocescalade.model.Image;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDAOImpl extends AbstractDAO implements ImageDAO {

    @Override
    public Image getSite(Integer id) {
        String querySQL = "SELECT * FROM site WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        RowMapper<Image> rowMapper = new ImageMapper();

        Image image = jdbcTemplate.queryForObject(querySQL, params, rowMapper);

        return image;
    }

    @Override
    public List<Image> getTopoImages(Integer topo_id) {
        return getImages("SELECT * FROM image WHERE parent_id = :id AND topo_image = 'TRUE'", topo_id);
    }

    @Override
    public List<Image> getSiteImages(Integer site_id) {
        return getImages("SELECT * FROM image WHERE parent_id = :id AND site_image = 'TRUE'", site_id);
    }

    @Override
    public List<Image> getSectorImages(Integer sector_id) {
        return getImages("SELECT * FROM image WHERE parent_id = :id AND sector_image = 'TRUE'", sector_id);
    }

    @Override
    public List<Image> getWayImages(Integer way_id) {
        return getImages("SELECT * FROM image WHERE parent_id = :id AND way_image = 'TRUE'", way_id);
    }

    private List<Image> getImages(String querySQL, Integer parent_id) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", parent_id);
        RowMapper<Image> rowMapper = new ImageMapper();

        List<Image> images = jdbcTemplate.query(querySQL, params, rowMapper);

        return images;
    }
}
