package com.alphamplyer.ocescalade.model;


public class Image
{
    // ATTRIBUTES /////////////////////////////////

    private Integer id;

    private Integer parent_id;

    private Boolean main_topo_image;

    private Boolean topo_image;

    private Boolean site_image;

    private Boolean sector_image;

    private Boolean way_image;

    private String image_url;

    private String image_name;

    private String image_description;

    // CONSTRUCTORS ///////////////////////////////

    public Image () { }

    public Image (Integer id) {
        this.id = id;
    }

    public Image (Integer id, Integer parent_id, Boolean main_topo_image, Boolean topo_image, Boolean site_image, Boolean sector_image, Boolean way_image, String image_url, String image_name, String image_description) {
        this.id = id;
        this.parent_id = parent_id;
        this.main_topo_image = main_topo_image;
        this.topo_image = topo_image;
        this.site_image = site_image;
        this.sector_image = sector_image;
        this.way_image = way_image;
        this.image_url = image_url;
        this.image_name = image_name;
        this.image_description = image_description;
    }

    // GETTERS / SETTERS //////////////////////////
    // GET ////////////////////////////////////////

    public Integer getId () {
        return this.id;
    }

    public Integer getParent_id () {
        return this.parent_id;
    }

    public Boolean getMain_topo_image () {
        return this.main_topo_image;
    }

    public Boolean getTopo_image () {
        return this.topo_image;
    }

    public Boolean getSite_image () {
        return this.site_image;
    }

    public Boolean getSector_image() {
        return sector_image;
    }

    public Boolean getWay_image () {
        return this.way_image;
    }

    public String getImage_url () {
        return this.image_url;
    }

    public String getImage_name () {
        return this.image_name;
    }

    public String getImage_description () {
        return this.image_description;
    }

    // SET ////////////////////////////////////////

    public void setId (Integer id) {
        this.id = id;
    }

    public void setParent_id (Integer parent_id) {
        this.parent_id = parent_id;
    }

    public void setMain_topo_image (Boolean main_topo_image) {
        this.main_topo_image = main_topo_image;
    }

    public void setTopo_image (Boolean topo_image) {
        this.topo_image = topo_image;
    }

    public void setSite_image (Boolean site_image) {
        this.site_image = site_image;
    }

    public void setSector_image(Boolean sector_image) {
        this.sector_image = sector_image;
    }

    public void setWay_image (Boolean way_image) {
        this.way_image = way_image;
    }

    public void setImage_url (String image_url) {
        this.image_url = image_url;
    }

    public void setImage_name (String image_name) {
        this.image_name = image_name;
    }

    public void setImage_description (String image_description) {
        this.image_description = image_description;
    }

    // METHODS ////////////////////////////////////

    @Override    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";

        vStB.append("{")
            .append(vSEP).append("Id\"").append(id).append('"')
            .append(vSEP).append("Parent_id\"").append(parent_id).append('"')
            .append(vSEP).append("Main_topo_image\"").append(main_topo_image).append('"')
            .append(vSEP).append("Topo_image\"").append(topo_image).append('"')
            .append(vSEP).append("Site_image\"").append(site_image).append('"')
            .append(vSEP).append("Way_image\"").append(way_image).append('"')
            .append(vSEP).append("Image_url\"").append(image_url).append('"')
            .append(vSEP).append("Image_name\"").append(image_name).append('"')
            .append(vSEP).append("Image_description\"").append(image_description).append('"')
            .append(vSEP).append("}");

        return vStB.toString();
    }
}