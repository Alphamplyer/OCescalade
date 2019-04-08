package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Way;

import java.util.List;

public interface WayService {

    Way getWay(Integer id);

    List<Way> getSectorWay(Integer sector_id);

    void insert(Integer sector_id, String name, String description, Double height, String quotation);
}
