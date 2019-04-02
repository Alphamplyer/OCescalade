package com.alphamplyer.ocescalade.service.impl;

import com.alphamplyer.ocescalade.dao.interf.ImageDAO;
import com.alphamplyer.ocescalade.model.Image;
import com.alphamplyer.ocescalade.service.interf.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageDAO imageDAO;

    public void setImageDAO(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    @Override
    public Image getSite(Integer id) {
        return this.imageDAO.getSite(id);
    }

    @Override
    public List<Image> getTopoImages(Integer topo_id) {
        return this.imageDAO.getTopoImages(topo_id);
    }

    @Override
    public List<Image> getSiteImages(Integer site_id) {
        return this.imageDAO.getSiteImages(site_id);
    }

    @Override
    public List<Image> getSectorImages(Integer sector_id) {
        return this.imageDAO.getSectorImages(sector_id);
    }

    @Override
    public List<Image> getWayImages(Integer way_id) {
        return this.imageDAO.getWayImages(way_id);
    }
}
