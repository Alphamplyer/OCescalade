package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.TopoDAO;
import com.alphamplyer.ocescalade.dao.mapper.TopoMapper;
import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class TopoDAOImpl extends AbstractDAO implements TopoDAO {

    private static final Logger logger = LoggerFactory.getLogger(TopoDAOImpl.class);

    @Override
    public Topo getTopo(Integer id) {
        String querySQL = "SELECT *, count(*) OVER() AS full_count  FROM topo WHERE id = :id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        RowMapper<Topo> rowMapper = new TopoMapper();

        Topo topo = jdbcTemplate.queryForObject(querySQL, params, rowMapper);

        return topo;
    }

    @Override
    public List<Topo> listTopo() {
        return listNumberTopo(false, null, 0, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Topo> listNumberTopo(Boolean bookableParameterIsImportant, Boolean bookable, Integer number, Integer offset){
        StringBuilder sql = new StringBuilder("SELECT *, count(*) OVER() AS full_count  FROM Topo");
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
    public Integer countTopo(boolean bookable) {
        String querySQL = "SELECT COUNT(*) FROM topo WHERE is_bookable = '" + bookable + "'";

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
    public List<Topo> listSearchedTopo(String[] args, Boolean bookable, Integer limit, Integer offset) {
        StringBuilder querySQL = new StringBuilder("SELECT *, count(*) OVER() AS full_count FROM topo");

        if (bookable != null) {
            querySQL.append(" WHERE is_bookable = '").append(bookable).append("'");
        }
        else {
            querySQL.append(" WHERE");
        }

        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                if (bookable != null) {
                    querySQL.append(" AND");
                }
            } else {
                querySQL.append(" OR");
            }
            querySQL.append(" (strpos(lower(topo_title), '").append(args[i]).append("') > 0 OR strpos(lower(topo_description), '").append(args[i]).append("') > 0)");
        }

        if (limit > 0) {
            querySQL.append(" LIMIT :limitation");

            if (offset > 0) {
                querySQL.append(" OFFSET :offset");
            }
        }

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource params = new MapSqlParameterSource();
        RowMapper<Topo> rowMapper = new TopoMapper();

        if (limit > 0) {
            params.addValue("limitation", limit);

            if (offset > 0) {
                params.addValue("offset", offset);
            }
        }

        List<Topo> topos = jdbcTemplate.query(querySQL.toString(), params, rowMapper);

        return topos;
    }

    @Override
    public List<Topo> listSimpleSearchedTopo(String[] args, Integer limit, Integer offset) {
        return listSearchedTopo(args, false, limit, offset);
    }

    @Override
    public List<Topo> listBookableSearchedTopo(String[] args, Integer limit, Integer offset) {
        return listSearchedTopo(args, true, limit, offset);
    }

    @Override
    public int insertTopo(User user, String title, String description, String content, Boolean bookable) {
        String sql = "INSERT INTO topo (author_id, topo_title, topo_description, topo_content, creation_date, is_bookable) VALUES (:author_id, :topo_title, :topo_description, :topo_content, 'NOW', :is_bookable);";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("author_id", user.getId());
        params.addValue("topo_title", title);
        params.addValue("topo_description", description);
        params.addValue("topo_content", content);
        params.addValue("is_bookable", bookable);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, params, keyHolder);

        return (int)keyHolder.getKeys().get("id");
    }

    @Override
    public void reserve(User user, Integer topo_id, boolean is_bookable, Timestamp begin_date, Timestamp end_date) {
        String sql = "UPDATE topo SET is_bookable = :is_bookable, begin_date = :begin_date, end_date = :end_date, organizer_id = :organizer_id WHERE id = :topo_id";

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("is_bookable", true);
        params.addValue("begin_date", begin_date);
        params.addValue("end_date", end_date);
        params.addValue("organizer_id", user.getId());
        params.addValue("topo_id", topo_id);

        jdbcTemplate.update(sql, params);
    }
}
