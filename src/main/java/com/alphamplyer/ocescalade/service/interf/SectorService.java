package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Sector;

import java.util.List;

public interface SectorService {

    Sector getSector(Integer id);

    List<Sector> getSiteSectors(Integer site_id);
}
