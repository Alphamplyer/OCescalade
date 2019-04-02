package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Site;

import java.util.List;

public interface SiteService {

    Site getSite(Integer id);

    List<Site> getTopoSites(Integer topo_id);
}
