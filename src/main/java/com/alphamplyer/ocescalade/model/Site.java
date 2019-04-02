package com.alphamplyer.ocescalade.model;

import java.util.List;

public class Site {

    private Integer id;
    private Integer topo_id;
    private String site_name;
    private String site_description;
    private Double site_elevation;
    private String rock_type;
    private List<Sector> sectors;

    // CONSTRUCTOR /////////////////////////////////////

    public Site() {}

    public Site (Integer id) {
        this.id = id;
    }

    public Site (Integer id, Integer topo_id, String site_name, String site_description, Double site_elevation, String rock_type) {
        this.id = id;
        this.topo_id = topo_id;
        this.site_name = site_name;
        this.site_description = site_description;
        this.site_elevation = site_elevation;
        this.rock_type = rock_type;
    }


    // GETTERS / SETTERS ///////////////////////////////

    // GET /////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public Integer getTopo_id() {
        return topo_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public String getSite_description() {
        return site_description;
    }

    public Double getSite_elevation() {
        return site_elevation;
    }

    public String getRock_type() {
        return rock_type;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    // SET /////////////////////////////////////////////

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopo_id(Integer topo_id) {
        this.topo_id = topo_id;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public void setSite_description(String site_description) {
        this.site_description = site_description;
    }

    public void setSite_elevation(Double site_elevation) {
        this.site_elevation = site_elevation;
    }

    public void setRock_type(String rock_type) {
        this.rock_type = rock_type;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    // METHODS /////////////////////////////////////////

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";

        vStB.append(" {")
            .append(vSEP).append("  ID = ").append(id)
            .append(vSEP).append("  Topo ID = \"").append(topo_id).append('"')
            .append(vSEP).append("  Site name = \"").append(site_name).append('"')
            .append(vSEP).append("  Site description = \"").append(site_description).append('"')
            .append(vSEP).append("  Site elevation = \"").append(site_elevation).append('"')
            .append(vSEP).append("  Rock type = \"").append(rock_type).append('"')
            .append(vSEP).append("}");
        return vStB.toString();
    }
}
