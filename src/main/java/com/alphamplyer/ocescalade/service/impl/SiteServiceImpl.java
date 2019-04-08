package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.SectorDAO;
import com.alphamplyer.ocescalade.dao.interf.SiteDAO;
import com.alphamplyer.ocescalade.model.Site;
import com.alphamplyer.ocescalade.model.User;
import com.alphamplyer.ocescalade.service.interf.SiteService;
import com.alphamplyer.ocescalade.utils.verification.InsertSecure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteDAO siteDAO;

    @Autowired
    private SectorDAO sectorDAO;

    public void setSiteDAO(SiteDAO siteDAO) { this.siteDAO = siteDAO; }

    public void setSectorDAO(SectorDAO sectorDAO) {
        this.sectorDAO = sectorDAO;
    }

    @Override
    @Transactional
    public Site getSite(Integer id) {
        return this.siteDAO.getSite(id);
    }

    @Override
    @Transactional
    public List<Site> getTopoSites(Integer topo_id) {
        List<Site> sites = this.siteDAO.getTopoSites(topo_id);

        for (Site site : sites) {
            site.setSectors(this.sectorDAO.getSiteSectors(site.getId()));
        }

        return sites;
    }

    @Override
    @Transactional
    public void insertSite(User user, Integer id, String name, String description, Double elevation, String rock_type) {

        name = InsertSecure.check(name);
        description = InsertSecure.check(description);

        this.siteDAO.insertSite(user, id, name, description, elevation, rock_type);
    }
}
