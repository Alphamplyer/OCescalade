package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Way;

import java.util.List;

public interface WayDAO {

    Way getWay(Integer id);

    List<Way> getSectorWay(Integer sector_id);
}
