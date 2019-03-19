package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.TopoDAO;
import com.alphamplyer.ocescalade.dao.mapper.TopoMapper;
import com.alphamplyer.ocescalade.model.Topo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TopoDAOImpl extends AbstractDAO implements TopoDAO {

    private static final Logger logger = LoggerFactory.getLogger(TopoDAOImpl.class);

    @Autowired
    public TopoDAOImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Topo getTopo(Integer id) {
        String querySQL = "SELECT * FROM topo WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        Topo topo = jdbcTemplate.queryForObject(querySQL, params, Topo.class);

        return topo;
    }

    @Override
    public List<Topo> listTopo() {
        return listNumberTopo(false, null, 0, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Topo> listNumberTopo(Boolean bookableParameterIsImportant, Boolean bookable, Integer number, Integer offset){
        StringBuilder sql = new StringBuilder("SELECT * FROM Topo");
        StringBuilder log = new StringBuilder(" Topo(s) successfully loaded !");


        if (bookableParameterIsImportant || number > 0) {
            log.append(" with the parameters = {");
        }

        if (bookableParameterIsImportant) {
            sql.append(" WHERE is_bookable = :bookable");
            log.append("\n    Bookable = ").append(bookable);

            if (number <= 0) {
                log.append("\n}");
            }
        }

        sql.append(" ORDER BY creation_date DESC");

        if (number > 0) {
            sql.append(" LIMIT :limitation");
            log.append("\n    Limitation = ").append(number);

            if (offset > 0) {
                sql.append(" OFFSET :offset");
                log.append("\n    Offset = ").append(offset).append("\n}");
            }
            else {
                log.append("\n}");
            }
        }

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource params = new MapSqlParameterSource();
        RowMapper<Topo> rowMapper = new TopoMapper();
        List<Topo> topos;

        if (bookable != null) {
            params.addValue("bookable", bookable);
        }

        if (number > 0) {
            params.addValue("limitation", number);

            if (offset > 0) {
                params.addValue("offset", offset);
            }
        }

        topos = jdbcTemplate.query(sql.toString(), params, rowMapper);

        log.insert(0, topos.size());

        logger.info(log.toString());

        return topos;
    }

    @Override
    public List<Topo> listSimpleTopo() {
        return listNumberSimpleTopo(0, 0);
    }

    @Override
    public List<Topo> listNumberSimpleTopo(Integer number, Integer offset) {
        return listNumberTopo(true, false, number, offset);
    }

    @Override
    public Integer countSimpleTopo() {
        String querySQL = "SELECT COUNT(*) FROM topo WHERE is_bookable = 'FALSE'";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        Integer numberOftopo = jdbcTemplate.queryForObject(querySQL, Integer.class);

        return numberOftopo;
    }

    @Override
    public List<Topo> listBookableTopo() {
        return listNumberTopo(true, false, 0, 0);
    }

    @Override
    public List<Topo> listNumberBookableTopo(Integer number, Integer offset) {
        return listNumberTopo(true, true, number, offset);
    }

    @Override
    public List<Topo> listAuthorTopo(Integer author_id) {
        return null;
    }

    @Override
    public List<Topo> listSearchedTopo(String[] args) {
        return null;
    }

    @Override
    public List<Topo> listSimpleSearchedTopo(String[] args) {
        return null;
    }

    @Override
    public List<Topo> listBookableSearchedTopo(String[] args) {
        return null;
    }
}
