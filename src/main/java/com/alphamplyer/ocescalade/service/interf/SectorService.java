package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Sector;
import com.alphamplyer.ocescalade.model.User;

import java.util.List;

public interface SectorService {

    Sector getSector(Integer id);

    List<Sector> getSiteSectors(Integer site_id);

    void insertSector(User user, Integer site_id, String name, String description, String orientation);
}
