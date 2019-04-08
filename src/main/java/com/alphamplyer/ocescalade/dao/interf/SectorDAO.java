package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Sector;
import com.alphamplyer.ocescalade.model.User;

import java.util.List;

public interface SectorDAO {

    Sector getSector(Integer id);

    List<Sector> getSiteSectors(Integer site_id);

    void insertSector(User user, Integer site_id, String name, String description, String orientation);
}
