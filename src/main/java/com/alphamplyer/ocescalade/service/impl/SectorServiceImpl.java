package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.SectorDAO;
import com.alphamplyer.ocescalade.model.Sector;
import com.alphamplyer.ocescalade.service.interf.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectorServiceImpl implements SectorService {

    @Autowired
    private SectorDAO sectorDAO;

    public void setSectorDAO(SectorDAO sectorDAO) {
        this.sectorDAO = sectorDAO;
    }

    @Override
    @Transactional
    public Sector getSector(Integer id) {
        return this.sectorDAO.getSector(id);
    }

    @Override
    @Transactional
    public List<Sector> getSiteSectors(Integer site_id) {
        return this.sectorDAO.getSiteSectors(site_id);
    }
}
