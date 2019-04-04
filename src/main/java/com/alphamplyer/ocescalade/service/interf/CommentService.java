package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Comment;
import com.alphamplyer.ocescalade.model.User;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComment();

    List<Comment> getTopoComments(Integer topo_id);

    List<Comment> getCommentReply(Integer comment_id);

    List<Comment> getNumberComment(Integer number, Integer offset);

    void insertComment(User user, String content, Integer id);
}
