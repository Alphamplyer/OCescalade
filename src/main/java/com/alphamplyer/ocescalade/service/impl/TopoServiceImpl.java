package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.TopoDAO;
import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.model.User;
import com.alphamplyer.ocescalade.service.interf.TopoService;
import com.alphamplyer.ocescalade.utils.verification.InsertSecure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopoServiceImpl implements TopoService {

    @Autowired
    private TopoDAO topoDAO;

    public void setTopoDAO(TopoDAO topoDAO) {
        this.topoDAO = topoDAO;
    }

    @Override
    @Transactional
    public Topo getTopo(Integer id) {
        return this.topoDAO.getTopo(id);
    }

    @Override
    @Transactional
    public List<Topo> listTopo() {
        return this.topoDAO.listTopo();
    }

    @Override
    @Transactional
    public List<Topo> listNumberTopo(Boolean bookableParameterIsImportant, Boolean bookable, Integer number, Integer offset) {
        return this.topoDAO.listNumberTopo(bookableParameterIsImportant, bookable, number, offset);
    }

    @Override
    @Transactional
    public List<Topo> listSimpleTopo() {
        return this.topoDAO.listSimpleTopo();
    }

    @Override
    @Transactional
    public List<Topo> listNumberSimpleTopo(Integer number, Integer offset) {
        return this.topoDAO.listNumberSimpleTopo(number, offset);
    }

    @Override
    @Transactional
    public Integer countTopo(boolean bookable) {
        return this.topoDAO.countTopo(bookable);
    }

    @Override
    @Transactional
    public List<Topo> listBookableTopo() {
        return this.topoDAO.listBookableTopo();
    }

    @Override
    @Transactional
    public List<Topo> listNumberBookableTopo(Integer number, Integer offset) {
        return this.topoDAO.listNumberBookableTopo(number, offset);
    }

    @Override
    @Transactional
    public List<Topo> listAuthorTopo(Integer author_id) {
        return this.topoDAO.listAuthorTopo(author_id);
    }

    @Override
    @Transactional
    public List<Topo> listSearchedTopo(String args, Boolean bookable, Integer limit, Integer offset) {
        return this.topoDAO.listSearchedTopo(splitArgs(args), bookable, limit, offset);
    }

    @Override
    @Transactional
    public List<Topo> listSimpleSearchedTopo(String args, Integer limit, Integer offset) {
        return this.topoDAO.listSimpleSearchedTopo(splitArgs(args), limit, offset);
    }

    @Override
    @Transactional
    public List<Topo> listBookableSearchedTopo(String args, Integer limit, Integer offset) {
        return this.topoDAO.listBookableSearchedTopo(splitArgs(args), limit, offset);
    }

    @Override
    @Transactional
    public int insertTopo(User user, String title, String description, String content, Boolean bookable) {

        title = InsertSecure.check(title);
        description = InsertSecure.check(description);
        content = InsertSecure.check(content);

        return this.topoDAO.insertTopo(user, title, description, content, bookable);
    }

    private String[] splitArgs(String s) {

        s = s.toLowerCase();

        String[] args = s.split("\\s+");

        if (args.length == 0)
            args = new String[] { s };

        return args;
    }
}
