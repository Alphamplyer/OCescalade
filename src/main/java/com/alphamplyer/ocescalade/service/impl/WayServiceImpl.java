package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.WayDAO;
import com.alphamplyer.ocescalade.model.Way;
import com.alphamplyer.ocescalade.service.interf.WayService;
import com.alphamplyer.ocescalade.utils.verification.InsertSecure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WayServiceImpl implements WayService {

    @Autowired
    private WayDAO wayDAO;

    public void setWayDAO(WayDAO wayDAO) {
        this.wayDAO = wayDAO;
    }

    @Override
    @Transactional
    public Way getWay(Integer id) {
        return this.wayDAO.getWay(id);
    }

    @Override
    @Transactional
    public List<Way> getSectorWay(Integer sector_id) {
        return this.wayDAO.getSectorWay(sector_id);
    }

    @Override
    @Transactional
    public void insert(Integer sector_id, String name, String description, Double height, String quotation) {
        name = InsertSecure.check(name);
        description = InsertSecure.check(description);
        quotation = InsertSecure.check(quotation);

        this.wayDAO.insert(sector_id, name, description, height, quotation);
    }
}
