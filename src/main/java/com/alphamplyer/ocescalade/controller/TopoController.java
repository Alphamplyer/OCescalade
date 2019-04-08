package com.alphamplyer.ocescalade.controller;

import com.alphamplyer.ocescalade.model.*;
import com.alphamplyer.ocescalade.service.interf.*;
import com.alphamplyer.ocescalade.utils.validation.DateValidation;
import com.alphamplyer.ocescalade.utils.validation.DecimalValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@Controller
@EnableWebMvc
public class TopoController {

    private static final Logger logger = LoggerFactory.getLogger(TopoController.class);

    private TopoService topoService;
    private SiteService siteService;
    private SectorService sectorService;
    private CommentService commentService;
    private UserService userService;
    private WayService wayService;

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
    @Qualifier(value = "sectorService")
    public void setSectorService(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "commentService")
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    @Qualifier(value = "wayService")
    public void setWayService(WayService wayService) {
        this.wayService = wayService;
    }

    @RequestMapping("/topo/{id}")
    public String topoPage(Model model, @PathVariable(name = "id") int id) {

        Topo topo = this.topoService.getTopo(id);
        List<Site> sites = this.siteService.getTopoSites(id);
        List<Comment> comments = this.commentService.getTopoComments(id);
        User organizer;

        if (topo.getIs_bookable() && topo.getOrganizer_id() != null && topo.getOrganizer_id() > 0) {
            organizer = this.userService.getUser(topo.getOrganizer_id());
            model.addAttribute("organizer", organizer);
        }


        model.addAttribute("topo", topo);
        model.addAttribute("sites", sites);
        model.addAttribute("comments", comments);

        return "topo";
    }

    @RequestMapping(value = "/addComment/{id}", method = RequestMethod.POST)
    public String addComment(Model model, @RequestParam(name="content") String content, @PathVariable Integer id, HttpServletRequest request, HttpSession httpSession) {

        if (httpSession.getAttribute("user_data") != null) {
            User user = (User)httpSession.getAttribute("user_data");
            this.commentService.insertComment(user, content, id);
        }

        return "redirect:" + request.getHeader("Referer") + "#com";
    }

    @RequestMapping("/newtopo")
    public String newTopo(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user_data") != null) {
            return "newtopo";
        }
        return "redirect:/error";
    }

    @RequestMapping(value = "/addTopo", method = RequestMethod.POST)
    public String addComment(Model model, @RequestParam(name="title") String title, @RequestParam(name="description") String description, @RequestParam(name="content") String content,
                             @RequestParam(name="bookable", required = false) Boolean bookable, HttpSession httpSession) {

        if (httpSession.getAttribute("user_data") != null) {
            User user = (User)httpSession.getAttribute("user_data");
            if (bookable == null)
                bookable = false;
            int key = this.topoService.insertTopo(user, title, description, content, bookable);
            return "redirect:/topo/" + key;
        }
        else {
            return "redirect:/error";
        }
    }

    @RequestMapping("/newsite/{id}")
    public String newsite(Model model, @PathVariable Integer id, HttpSession httpSession) {

        Topo topo = this.topoService.getTopo(id);

        if (httpSession.getAttribute("user_data") != null) {

            User user = (User)httpSession.getAttribute("user_data");

            if (topo.getAuthor_id().equals(user.getId()))
            {
                model.addAttribute("topo_id", topo.getId());
                model.addAttribute("rock_types", new String[] {"Calcaire", "Gabbro", "Gneiss", "Granit", "Grès siliceux", "Grès calcaire (Bious)", "Quartzite", "Serpentine" });

                return "newsite";
            }

            return "redirect:/error";
        }

        return "redirect:/error";
    }

    @RequestMapping(value = "/addSite/{id}", method = RequestMethod.POST)
    public String addSite(Model model, @PathVariable Integer id, @RequestParam String name, @RequestParam String description,
                          @RequestParam String elevation, @RequestParam String rock_type,
                          HttpSession httpSession, HttpServletRequest request) {

        Topo topo = this.topoService.getTopo(id);
        boolean corect_elevation = new DecimalValidation().valid(elevation);

        if (httpSession.getAttribute("user_data") != null) {

            User user = (User) httpSession.getAttribute("user_data");

            if (topo.getAuthor_id().equals(user.getId())) {
                if (corect_elevation) {

                    this.siteService.insertSite(user, id, name, description, Double.parseDouble(elevation), rock_type);
                    return "redirect:/topo/" + id;
                }

                return "redirect:" + request.getHeader("Referer");
            }

            return "redirect:/error";
        }

        return "redirect:/error";
    }


    @RequestMapping("/newsector/{topo_id}/{site_id}")
    public String newsector(Model model, @PathVariable Integer topo_id, @PathVariable Integer site_id, HttpSession httpSession) {

        Topo topo = this.topoService.getTopo(topo_id);
        Site site = this.siteService.getSite(site_id);

        if (httpSession.getAttribute("user_data") != null) {

            User user = (User)httpSession.getAttribute("user_data");

            if (topo.getAuthor_id().equals(user.getId()) && topo.getId().equals(site.getTopo_id()))
            {
                model.addAttribute("topo_id", topo.getId());
                model.addAttribute("site_id", site_id);
                model.addAttribute("orientations", new String[] {"E", "N", "NE", "NW", "S", "SE", "SW", "W" });

                return "newsector";
            }

            return "redirect:/error";
        }

        return "redirect:/error";
    }

    @RequestMapping(value = "/addSector/{topo_id}/{site_id}", method = RequestMethod.POST)
    public String addSector(Model model, @PathVariable Integer topo_id, @PathVariable Integer site_id, @RequestParam String name,
                          @RequestParam String description, @RequestParam String orientation,
                          HttpSession httpSession) {

        Topo topo = this.topoService.getTopo(topo_id);
        Site site = this.siteService.getSite(site_id);

        if (httpSession.getAttribute("user_data") != null) {

            User user = (User) httpSession.getAttribute("user_data");

            if (topo.getAuthor_id().equals(user.getId()) && topo.getId().equals(site.getTopo_id())) {

                this.sectorService.insertSector(user, site_id, name, description, orientation);

                return "redirect:/topo/" + topo_id;
            }

            return "redirect:/error";
        }

        return "redirect:/error";
    }

    @RequestMapping("/reservation/{id}")
    public String reservation(Model model, @PathVariable Integer id, HttpSession httpSession, @RequestParam(required = false) Boolean er) {

        Topo topo = this.topoService.getTopo(id);

        if (httpSession.getAttribute("user_data") != null) {

            if (topo.getIs_bookable()) {

                if (er != null)
                    model.addAttribute("er", er);

                model.addAttribute("topo_id", id);
                return "reservation";
            }

            return "redirect:/error";
        }

        return "redirect:/error";
    }

    @RequestMapping(value = "/reserve/{id}", method = RequestMethod.POST)
    public String reserve(Model model, @PathVariable Integer id, @RequestParam String begin_date, @RequestParam String end_date, HttpSession httpSession, RedirectAttributes redirectAttributes) {

        Topo topo = this.topoService.getTopo(id);

        if (httpSession.getAttribute("user_data") != null) {

            if (topo.getIs_bookable()) {

                User user = (User) httpSession.getAttribute("user_data");

                boolean v_begin_date = new DateValidation().valid(begin_date);
                boolean v_end_date = new DateValidation().valid(end_date);

                Timestamp bd, ed;

                if (v_begin_date && v_end_date) {
                    bd = new Timestamp(DateValidation.convertStringToTimestamp(begin_date).getTime());
                    ed = new Timestamp(DateValidation.convertStringToTimestamp(begin_date).getTime());
                }
                else {
                    logger.debug("User entered a bad Date format !");

                    redirectAttributes.addAttribute("er", true);

                    return "redirect:/reservation/" + id;
                }
                this.topoService.reserve(user, id, true, bd, ed);

                return "redirect:/topo/" + id;
            }

            return "redirect:/error";
        }

        return "redirect:/error";
    }

    @RequestMapping("/topo/{topo_id}/{site_id}/{sector_id}")
    public String sectorpage(Model model, @PathVariable Integer topo_id, @PathVariable Integer site_id, @PathVariable Integer sector_id, HttpSession httpSession) {

        Site site = this.siteService.getSite(site_id);
        Sector sector = this.sectorService.getSector(sector_id);

        if (sector.getSite_id().equals(site_id) && site.getTopo_id().equals(topo_id)) {

            Topo topo = this.topoService.getTopo(topo_id);
            List<Way> ways = this.wayService.getSectorWay(sector_id);

            model.addAttribute("author_id", topo.getAuthor_id());
            model.addAttribute("topo_id", topo_id);
            model.addAttribute("site_id", site_id);
            model.addAttribute("sector", sector);
            model.addAttribute("ways", ways);

            return "sector";
        }

        return "redirect:/error";
    }

    @RequestMapping("/newway/{topo_id}/{site_id}/{sector_id}")
    public String newway(Model model, @PathVariable Integer topo_id, @PathVariable Integer site_id, @PathVariable Integer sector_id, HttpSession httpSession) {

        if (httpSession.getAttribute("user_data") != null) {

            User user = (User) httpSession.getAttribute("user_data");

            Topo topo = this.topoService.getTopo(topo_id);
            Site site = this.siteService.getSite(site_id);
            Sector sector = this.sectorService.getSector(sector_id);

            if (sector.getSite_id().equals(site_id) && site.getTopo_id().equals(topo_id) && topo.getAuthor_id().equals(user.getId()))
            {
                String[] quotations = {"3A", "3B", "3C", "4A", "4B", "4C", "5A", "5B", "5C", "6A", "6B", "6C", "7A", "7B", "7C", "8A", "8B", "8C", "9A", "9B", "9C"};
                model.addAttribute("quotations", quotations);

                return "/newway";
            }
        }

        return "redirect:/error";
    }

    @RequestMapping(value = "/addway/{topo_id}/{site_id}/{sector_id}", method = RequestMethod.POST)
    public String addway(Model model, @PathVariable Integer topo_id, @PathVariable Integer site_id, @PathVariable Integer sector_id, HttpSession httpSession,
                         @RequestParam String name, @RequestParam String description, @RequestParam String height, @RequestParam String quotation) {

        if (httpSession.getAttribute("user_data") != null) {

            User user = (User) httpSession.getAttribute("user_data");

            Topo topo = this.topoService.getTopo(topo_id);
            Site site = this.siteService.getSite(site_id);
            Sector sector = this.sectorService.getSector(sector_id);

            if (sector.getSite_id().equals(site_id) && site.getTopo_id().equals(topo_id) && topo.getAuthor_id().equals(user.getId()))
            {
                this.wayService.insert(sector_id, name, description, Double.parseDouble(height), quotation);

                return "redirect:/topo/" + topo_id + "/" + site_id + "/" + sector_id;
            }
        }

        return "redirect:/error";
    }


}
