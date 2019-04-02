package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Sector;

import java.util.List;

public interface SectorDAO {

    Sector getSector(Integer id);

    List<Sector> getSiteSectors(Integer site_id);
}
