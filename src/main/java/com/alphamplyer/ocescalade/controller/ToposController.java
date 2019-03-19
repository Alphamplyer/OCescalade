package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.service.interf.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class ToposController {

    private final int MAX_TOPO_BY_PAGE = 10;

    private TopoService topoService;

    @Autowired
    @Qualifier(value = "topoService")
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @RequestMapping("/topos")
    public String toposPage(Model model) {

        Integer number_topo_founded = this.topoService.countSimpleTopo();

        boolean exit_next_page = false;

        int max_page = (int)Math.ceil(number_topo_founded / (float)MAX_TOPO_BY_PAGE);

        if (1 < max_page)
            exit_next_page = true;

        List<Topo> topos = this.topoService.listNumberTopo(false, null, 10, 0);

        model.addAttribute("actual_page", 1);
        model.addAttribute("max_page", max_page);
        model.addAttribute("exist_prev_page", false);
        model.addAttribute("exist_next_page", exit_next_page);
        model.addAttribute("number_topo_founded", number_topo_founded);
        model.addAttribute("listTopo", topos);
        return "topos";
    }

    @RequestMapping("/topos/{id}")
    public String topoPageWithGivenPage (@PathVariable int id, Model model) {

        if (id <= 0)
            id = 1;

        Integer number_topo_founded = this.topoService.countSimpleTopo();

        boolean exit_next_page = false;
        boolean exit_prev_page = false;

        int max_page = (int)Math.ceil(number_topo_founded / (float)MAX_TOPO_BY_PAGE);

        if (id < max_page)
            exit_next_page = true;

        if (id != 1)
            exit_prev_page = true;

        List<Topo> topos = this.topoService.listNumberTopo(true, false, MAX_TOPO_BY_PAGE, (id - 1) * MAX_TOPO_BY_PAGE);

        model.addAttribute("actual_page", id);
        model.addAttribute("max_page", max_page);
        model.addAttribute("exist_prev_page", exit_prev_page);
        model.addAttribute("exist_next_page", exit_next_page);
        model.addAttribute("number_topo_founded", number_topo_founded);
        model.addAttribute("listTopo", topos);
        return "topos";
    }

}
