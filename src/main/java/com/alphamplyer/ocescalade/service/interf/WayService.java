package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Way;

import java.util.List;

public interface WayService {

    Way getWay(Integer id);

    List<Way> getSectorWay(Integer sector_id);
}
