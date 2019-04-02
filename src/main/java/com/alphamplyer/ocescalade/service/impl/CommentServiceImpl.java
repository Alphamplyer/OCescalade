package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.CommentDAO;
import com.alphamplyer.ocescalade.model.Comment;
import com.alphamplyer.ocescalade.service.interf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    @Transactional
    public List<Comment> getAllComment() {
        return this.commentDAO.getAllComment();
    }

    @Override
    @Transactional
    public List<Comment> getTopoComments(Integer topo_id) {
        List<Comment> comments = this.commentDAO.getTopoComments(topo_id);

        for (Comment comment: comments) {
            comment.setReply_comments(this.commentDAO.getCommentReply(comment.getId()));
        }

        return comments;
    }

    @Override
    @Transactional
    public List<Comment> getCommentReply(Integer comment_id) {
        return this.commentDAO.getCommentReply(comment_id);
    }

    @Override
    @Transactional
    public List<Comment> getNumberComment(Integer number, Integer offset) {
        return this.commentDAO.getNumberComment(number, offset);
    }
}
