package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Topo;

import java.util.List;

public interface TopoDAO {

    Topo getTopo(Integer id);

    List<Topo> getAllTopo();
}
