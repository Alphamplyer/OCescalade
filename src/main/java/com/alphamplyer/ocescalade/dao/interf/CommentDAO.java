package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Comment;

import java.util.List;

public interface CommentDAO {

    public List<Comment> getAllComment();

    public List<Comment> getNumberComment(Integer number, Integer offset);
}
