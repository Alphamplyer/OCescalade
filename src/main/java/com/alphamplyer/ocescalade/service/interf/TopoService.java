package com.alphamplyer.ocescalade.service.interf;

import com.alphamplyer.ocescalade.model.Topo;

import java.util.List;

public interface TopoService {

    Topo getTopo(Integer id);

    List<Topo> listTopo();

    List<Topo> listNumberTopo(Boolean bookableParameterIsImportant, Boolean bookable, Integer number, Integer offset);

    List<Topo> listSimpleTopo();

    List<Topo> listNumberSimpleTopo(Integer number, Integer offset);

    Integer countTopo(boolean bookable);

    List<Topo> listBookableTopo();

    List<Topo> listNumberBookableTopo(Integer number, Integer offset);

    List<Topo> listAuthorTopo(Integer author_id);

    List<Topo> listSearchedTopo(String[] args, Boolean bookable, Integer limit, Integer offset);

    List<Topo> listSimpleSearchedTopo(String[] args, Integer limit, Integer offset);

    List<Topo> listBookableSearchedTopo(String[] args, Integer limit, Integer offset);
}
