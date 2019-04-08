package com.alphamplyer.ocescalade.dao.interf;

import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface TopoDAO {

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

    int insertTopo(User user, String title, String description, String content, Boolean bookable);

    void reserve(User user, Integer topo_id, boolean is_bookable, Timestamp begin_date, Timestamp end_date);
}
