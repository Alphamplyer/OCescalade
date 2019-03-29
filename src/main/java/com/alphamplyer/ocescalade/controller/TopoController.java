package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.service.interf.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class TopoController {

    private TopoService topoService;

    @Autowired
    @Qualifier(value = "topoService")
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @RequestMapping("/topo/{id}")
    public String topoPage(Model model, @PathVariable(name = "id") int id) {

        Topo topo = this.topoService.getTopo(id);

        model.addAttribute("topo", topo);

        return "topo";
    }
}
