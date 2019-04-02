package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Site;

import java.util.List;

public interface SiteDAO {

    Site getSite(Integer id);

    List<Site> getTopoSites(Integer topo_id);
}
