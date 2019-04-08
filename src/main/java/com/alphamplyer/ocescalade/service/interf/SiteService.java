package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Site;
import com.alphamplyer.ocescalade.model.User;

import java.util.List;

public interface SiteService {

    Site getSite(Integer id);

    List<Site> getTopoSites(Integer topo_id);

    void insertSite(User user, Integer id, String name, String description, Double elevation, String rock_type);
}
