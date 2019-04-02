package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getAllComment();

    List<Comment> getTopoComments(Integer topo_id);

    List<Comment> getCommentReply(Integer comment_id);

    public List<Comment> getNumberComment(Integer number, Integer offset);
}
