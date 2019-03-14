package com.alphamplyer.ocescalade.dao.impl;

import com.alphamplyer.ocescalade.dao.interf.TopoDAO;
import com.alphamplyer.ocescalade.model.Topo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopoDAOImpl implements TopoDAO {

    private static final Logger logger = LoggerFactory.getLogger(TopoDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Topo getTopo(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Topo topo = session.load(Topo.class, id);
        logger.info("Topo successfully loaded !", topo.toString());
        return topo;
    }

    @Override
    public List<Topo> listTopo() {
        return listNumberTopo(false, null, 0, 0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Topo> listNumberTopo(Boolean bookableParameterIsImportant, Boolean bookable, Integer number, Integer offset){
        StringBuilder sql = new StringBuilder("SELECT t FROM Topo t");

        if (bookableParameterIsImportant != null) {
            if (bookableParameterIsImportant)
                sql.append(" WHERE t.is_bookable = :bookable");
        }

        sql.append(" ORDER BY t.creation_date DESC");

        Session session = this.sessionFactory.getCurrentSession();

        List<Topo> topos;

        if (bookableParameterIsImportant) {
            if (number > 0 && offset > 0) {
                topos = session.createQuery(sql.toString()).setParameter("bookable", bookable).setMaxResults(number).setFirstResult(offset).list();
                logger.info(topos.size() + " Topo(s) successfully loaded !\nParameters = {\n    Bookable = " + bookable + "\n    Limitation = " + number + "\n    Offset = " + offset + "\n}");
            } else if (number > 0) {
                topos = session.createQuery(sql.toString()).setParameter("bookable", bookable).setMaxResults(number).list();
                logger.info(topos.size() + " Topo(s) successfully loaded !\nParameters = {\n    Bookable = " + bookable + "\n    Limitation = " + number + "\n}");
            } else {
                topos = session.createQuery(sql.toString()).setParameter("bookable", bookable).list();
                logger.info(topos.size() + " Topo(s) successfully loaded !\nParameter = {\n    Bookable = " + bookable + "\n}");
            }
        }
        else {
            if (number > 0 && offset > 0) {
                topos = session.createQuery(sql.toString()).setMaxResults(number).setFirstResult(offset).list();
                logger.info(topos.size() + " Topo(s) successfully loaded !\nParameters = {\n    Limitation = " + number + "\n    Offset = " + offset + "\n}");
            } else if (number > 0) {
                topos = session.createQuery(sql.toString()).setMaxResults(number).list();
                logger.info(topos.size() + " Topo(s) successfully loaded !\nParameter = {\n    Limitation = " + number + "\n}");
            } else {
                topos = session.createQuery(sql.toString()).list();
                logger.info(topos.size() + " Topo(s) successfully loaded !");
            }
        }

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
    public List<Topo> listBookableTopo() {
        return listNumberTopo(true, false, 0, 0);
    }

    @Override
    public List<Topo> listNumberBookableTopo(Integer number, Integer offset) {
        return listNumberTopo(true, true, number, offset);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Topo> listAuthorTopo(Integer author_id) {
        //noinspection JpaQlInspection
        String sql = "SELECT t FROM Topo t WHERE t.author_id = :author_id ORDER BY t.creation_date";

        Session session = this.sessionFactory.getCurrentSession();

        List<Topo> topos = session.createQuery(sql).setParameter("author_id", author_id).list();

        logger.info(topos.size() + " Topo(s) successfully loaded !");

        return topos;
    }

    @Override
    public List<Topo> listSearchedTopo(String[] args) {
        return null;
    }

    @Override
    public List<Topo> listSimpleSearchedTopo(String[] args) {
        return null;
    }

    @Override
    public List<Topo> listBookableSearchedTopo(String[] args) {
        return null;
    }
}
