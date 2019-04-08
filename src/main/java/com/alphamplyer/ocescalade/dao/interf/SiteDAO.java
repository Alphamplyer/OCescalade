package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Site;
import com.alphamplyer.ocescalade.model.User;

import java.util.List;

public interface SiteDAO {

    Site getSite(Integer id);

    List<Site> getTopoSites(Integer topo_id);

    void insertSite(User user, Integer id, String name, String description, Double elevation, String rock_type);
}
