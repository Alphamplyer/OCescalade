package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.Topo;
import com.alphamplyer.ocescalade.service.interf.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String topoPage(Model model) {
        List<Topo> topos = simpleTopoRequest(false, 1);
        topoTreatment(model, 1, false, false, topos);

        return "topos";
    }

    @RequestMapping("/topos/{id}")
    public String topoPageWithGivenPage (@PathVariable int id, Model model) {
        List<Topo> topos = simpleTopoRequest(false, id);
        topoTreatment(model, id, false, false, topos);

        return "topos";
    }

    @RequestMapping("/bookable_topos")
    public String bookableTopoPage(Model model) {
        List<Topo> topos = simpleTopoRequest(true, 1);
        topoTreatment(model, 1, false, true, topos);

        return "topos";
    }

    @RequestMapping("/bookable_topos/{id}")
    public String bookableTopoPageWithGivenPage (@PathVariable int id, Model model) {
        List<Topo> topos = simpleTopoRequest(true, id);
        topoTreatment(model, id, false, true, topos);

        return "topos";
    }

    @RequestMapping(value = "/topos_search", method = RequestMethod.GET)
    public String topoSearch(@RequestParam("topo_search") String topo_search, Model model) {
        if (topo_search.length() <= 0) {
            return "redirect:topos";
        }

        System.out.println("OKKKKKKKKKKKKKK");

        List<Topo> topos = this.topoService.listSimpleSearchedTopo(topo_search, 10, 0);
        topoTreatment(model, 1, false, false, topos);

        model.addAttribute("search", topo_search.replaceAll("\\s+", "+"));

        return "topos";
    }

    @RequestMapping(value = "/topos_search/{id}", method = RequestMethod.GET)
    public String topoSearch(@RequestParam("topo_search") String topo_search, @PathVariable int id, Model model) {
        if (topo_search.length() <= 0) {
            return "redirect:topos";
        }

        List<Topo> topos = this.topoService.listSimpleSearchedTopo(topo_search, MAX_TOPO_BY_PAGE, (id - 1) * MAX_TOPO_BY_PAGE);
        topoTreatment(model, id, false, false, topos);

        model.addAttribute("search", topo_search.replaceAll("\\s+", "+"));

        return "topos";
    }

    @RequestMapping(value = "/bookable_topos_search", method = RequestMethod.GET)
    public String bookableTopoSearch(@RequestParam("topo_search") String topo_search, Model model) {
        if (topo_search.length() <= 0) {
            return "redirect:bookable_topos";
        }

        List<Topo> topos = this.topoService.listBookableSearchedTopo(topo_search, 10, 0);
        topoTreatment(model, 1, false, true, topos);

        model.addAttribute("search", topo_search.replaceAll("\\s+", "+"));

        return "topos";
    }

    @RequestMapping(value = "/bookable_topos_search/{id}", method = RequestMethod.GET)
    public String bookableTopoSearch(@RequestParam("topo_search") String topo_search, @PathVariable int id, Model model) {
        if (topo_search.length() <= 0) {
            return "redirect:bookable_topos";
        }

        List<Topo> topos = this.topoService.listBookableSearchedTopo(topo_search, MAX_TOPO_BY_PAGE, (id - 1) * MAX_TOPO_BY_PAGE);
        topoTreatment(model, id, false, true, topos);

        model.addAttribute("search", topo_search.replaceAll("\\s+", "+"));

        return "topos";
    }

    @RequestMapping(value = "/global_search", method = RequestMethod.GET)
    public String globalSearch(@RequestParam("topo_search") String topo_search, Model model) {

        List<Topo> topos = this.topoService.listSearchedTopo(topo_search, null, 10, 0);
        topoTreatment(model, 1, true, null, topos);

        model.addAttribute("search", topo_search.replaceAll("\\s+", "+"));

        return "topos";
    }

    @RequestMapping(value = "/global_search/{id}", method = RequestMethod.GET)
    public String globalSearch(@RequestParam("topo_search") String topo_search, @PathVariable int id, Model model) {

        List<Topo> topos = this.topoService.listSearchedTopo(topo_search, null, MAX_TOPO_BY_PAGE, (id - 1) * MAX_TOPO_BY_PAGE);
        topoTreatment(model, id, true, null, topos);

        model.addAttribute("search", topo_search.replaceAll("\\s+", "+"));

        return "topos";
    }

    private void topoTreatment(Model model, int id, boolean global_search_page, Boolean bookable, List<Topo> topos) {

        int number_topo_founded;
        boolean exit_next_page = false;
        boolean exit_prev_page = false;
        int max_page;

        if (id <= 0)
            id = 1;

        number_topo_founded = numberTopo(topos);

        max_page = maxPage(number_topo_founded);

        if (id < max_page)
            exit_next_page = true;

        if (id != 1)
            exit_prev_page = true;

        setupAttribute(model, id, max_page, exit_prev_page, exit_next_page, global_search_page, bookable, topos, number_topo_founded);
    }

    private List<Topo> simpleTopoRequest(Boolean bookable, int id) { return this.topoService.listNumberTopo(true, bookable, MAX_TOPO_BY_PAGE, (id - 1) * MAX_TOPO_BY_PAGE); }

    private int numberTopo(List<Topo> topos) {
        if (topos.size() > 0)
            return topos.get(0).getFindedTopo();
        else
            return 0;
    }

    private int maxPage (int topoNumber) {
        return (int)Math.ceil(topoNumber / (float)MAX_TOPO_BY_PAGE);
    }

    private void setupAttribute(Model model, int page_id, int max_page, boolean exit_prev_page, boolean exit_next_page, boolean global_search_page, Boolean bookable, List<Topo> topos, int number_topo_founded) {
        model.addAttribute("actual_page", page_id);
        model.addAttribute("max_page", max_page);
        model.addAttribute("exist_prev_page", exit_prev_page);
        model.addAttribute("exist_next_page", exit_next_page);
        model.addAttribute("global_search_page", global_search_page);
        model.addAttribute("bookable", bookable);
        model.addAttribute("number_topo_founded", number_topo_founded);
        model.addAttribute("listTopo", topos);
    }
}
