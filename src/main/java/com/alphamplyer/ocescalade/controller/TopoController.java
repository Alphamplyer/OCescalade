package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.Comment;
import com.alphamplyer.ocescalade.model.Site;
import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.service.interf.CommentService;
import com.alphamplyer.ocescalade.service.interf.SiteService;
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
public class TopoController {

    private TopoService topoService;
    private SiteService siteService;
    private CommentService commentService;

    @Autowired
    @Qualifier(value = "topoService")
    public void setTopoService(TopoService topoService) {
        this.topoService = topoService;
    }

    @Autowired
    @Qualifier(value = "siteService")
    public void setSiteService(SiteService siteService) {
        this.siteService = siteService;
    }

    @Autowired
    @Qualifier(value = "commentService")
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/topo/{id}")
    public String topoPage(Model model, @PathVariable(name = "id") int id) {

        Topo topo = this.topoService.getTopo(id);
        List<Site> sites = this.siteService.getTopoSites(id);
        List<Comment> comments = this.commentService.getTopoComments(id);

        model.addAttribute("topo", topo);
        model.addAttribute("sites", sites);
        model.addAttribute("comments", comments);

        return "topo";
    }
}
