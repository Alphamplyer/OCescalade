package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Topo;

import java.util.List;

public interface TopoService {

    Topo getTopo(Integer id);

    List<Topo> listTopo();

    List<Topo> listNumberTopo(Boolean bookableParameterIsImportant, Boolean bookable, Integer number, Integer offset);

    List<Topo> listSimpleTopo();

    List<Topo> listNumberSimpleTopo(Integer number, Integer offset);

    Integer countSimpleTopo();

    List<Topo> listBookableTopo();

    List<Topo> listNumberBookableTopo(Integer number, Integer offset);

    List<Topo> listAuthorTopo(Integer author_id);

    List<Topo> listSearchedTopo(String[] args);

    List<Topo> listSimpleSearchedTopo(String[] args);

    List<Topo> listBookableSearchedTopo(String[] args);
}
