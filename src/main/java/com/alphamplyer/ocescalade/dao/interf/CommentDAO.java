package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Comment;

import java.util.List;

public interface CommentDAO {

    public List<Comment> getAllComment();

    List<Comment> getTopoComments(Integer topo_id);

    List<Comment> getCommentReply(Integer comment_id);

    public List<Comment> getNumberComment(Integer number, Integer offset);
}
