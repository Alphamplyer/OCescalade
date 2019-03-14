package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getAllComment();

    public List<Comment> getNumberComment(Integer number, Integer offset);
}
