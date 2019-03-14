package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.dao.interf.TopoDAO;
import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.service.interf.CommentService;
import com.alphamplyer.ocescalade.service.interf.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
@EnableWebMvc
public class HomeController {

    private TopoService topoService;
    private CommentService commentService;

    @Autowired
    @Qualifier(value = "topoService")
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @Autowired
    @Qualifier(value = "commentService")
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("listTopo", this.topoService.listNumberTopo(false, null, 3, 0));
        model.addAttribute("listComment", this.commentService.getNumberComment(3, 0));
        return "index";
    }

    @RequestMapping(value="/index")
    public String indexPage(Model model) {
        model.addAttribute("listTopo", this.topoService.listNumberTopo(false, null, 3, 0));
        model.addAttribute("listComment", this.commentService.getNumberComment(3, 0));
        return "index";
    }

}
