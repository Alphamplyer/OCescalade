package com.alphamplyer.ocescalade.dao.mapper;

import com.alphamplyer.ocescalade.model.Comment;
import com.alphamplyer.ocescalade.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment(rs.getInt("id"));
        comment.setTopo_id(rs.getInt("topo_id"));
        comment.setTopo_title(rs.getString("topo_title"));

        User user = new User(rs.getInt("user_id"));

        user.setNickname(rs.getString("nickname"));
        user.setInscription_date(rs.getDate("inscription_date"));
        user.setPermission_level(rs.getInt("permission_level"));

        comment.setUser(user);

        comment.setComment_content(rs.getString("comment_content"));
        comment.setCreation_date(rs.getTimestamp("creation_date"));
        comment.setReply(rs.getBoolean("reply"));
        comment.setParent_id(rs.getInt("parent_id"));
        comment.setEdited(rs.getBoolean("edited"));

        return comment;
    }
}