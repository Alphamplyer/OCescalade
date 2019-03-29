package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.AbstractDAO;
import com.alphamplyer.ocescalade.dao.interf.CommentDAO;
import com.alphamplyer.ocescalade.dao.mapper.CommentMapper;
import com.alphamplyer.ocescalade.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CommentDAOImpl extends AbstractDAO implements CommentDAO {

    private static final Logger logger = LoggerFactory.getLogger(CommentDAOImpl.class);

    @Autowired
    public CommentDAOImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }


    @Override
    public List<Comment> getAllComment() {
        return getNumberComment(0, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Comment> getNumberComment(Integer number, Integer offset) {
        StringBuilder sql = new StringBuilder("SELECT c.id, c.topo_id, c.user_id, c.comment_content, c.creation_date, c.reply, c.parent_id, c.edited,")
            .append(" t.topo_title,")
            .append(" u.id, u.nickname, u.inscription_date, u.permission_level FROM comment c")
            .append(" INNER JOIN topo t ON c.topo_id = t.id")
            .append(" INNER JOIN users u ON c.user_id = u.id")
            .append(" ORDER BY c.creation_date DESC");
        StringBuilder log = new StringBuilder(" Comment(s) loaded successfully !");

        if (number > 0) {
            sql.append(" LIMIT :limitation");
            log.append(" with the parameters = {\n    Limitation = ").append(number);

            if (offset > 0) {
                sql.append(" OFFSET :offset");
                log.append("\n    Offset = ").append(offset);
            }

            log.append("\n}");
        }

        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource params = new MapSqlParameterSource();
        RowMapper<Comment> rowMapper = new CommentMapper();
        List<Comment> comments;

        if (number > 0) {
            params.addValue("limitation", number);

            if (offset > 0) {
                params.addValue("offset", offset);
            }
        }

        comments = jdbcTemplate.query(sql.toString(), params, rowMapper);

        log.insert(0, comments.size());

        logger.info(log.toString());

        return comments;
    }
}
