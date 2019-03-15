package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.interf.CommentDAO;
import com.alphamplyer.ocescalade.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAOImpl implements CommentDAO {

    private static final Logger logger = LoggerFactory.getLogger(CommentDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Comment> getAllComment() {
        return getNumberComment(0, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Comment> getNumberComment(Integer number, Integer offset) {
        //language=hql
        String sql = "FROM Comment c INNER JOIN topo_title ORDER BY c.creation_date DESC";


        Session session = this.sessionFactory.getCurrentSession();
        List<Comment> comments;

        if (number > 0 && offset > 0) {
            comments = session.createQuery(sql).setMaxResults(number).setFirstResult(offset).list();
            logger.info(comments.size() + " Comment(s) successfully loaded !\\nParameters = {\n    Limitation = " + number + "\n    Offset = " + offset + "\n}");
        } else if (number > 0) {
            comments = session.createQuery(sql).setMaxResults(number).list();
            logger.info(comments.size() + " Comment(s) successfully loaded !\\nParameters = {\n    Limitation = " + number +"\n}");
        } else {
            comments = session.createQuery(sql).list();
            logger.info(comments.size() + " Comment(s) successfully loaded !");
        }

        return comments;
    }
}
