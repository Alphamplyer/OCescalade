package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Image;

import java.util.List;

public interface ImageService {

    Image getSite(Integer id);

    List<Image> getTopoImages(Integer topo_id);

    List<Image> getSiteImages(Integer site_id);

    List<Image> getSectorImages(Integer sector_id);

    List<Image> getWayImages(Integer way_id);
}
