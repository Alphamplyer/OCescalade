package com.alphamplyer.ocescalade.model;

public class Way {

    private Integer id;
    private Integer sector_id;
    private double height;
    private String quotation;
    private String way_name;
    private String way_description;


    // CONSTRUCTORS //////////////////////////////////

    public Way() {}

    public Way(Integer id) {
        this.id = id;
    }

    public Way(Integer id, Integer sector_id, double height, String quotation, String way_name, String way_description) {
        this.id = id;
        this.sector_id = sector_id;
        this.height = height;
        this.quotation = quotation;
        this.way_name = way_name;
        this.way_description = way_description;
    }


    // GETTERS / SETTERS /////////////////////////////
    // GET ///////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public Integer getSector_id() {
        return sector_id;
    }

    public double getHeight() {
        return height;
    }

    public String getQuotation() {
        return quotation;
    }

    public String getWay_name() {
        return way_name;
    }

    public String getWay_description() {
        return way_description;
    }

    // SET ///////////////////////////////////////////

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSector_id(Integer sector_id) {
        this.sector_id = sector_id;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public void setWay_name(String way_name) {
        this.way_name = way_name;
    }

    public void setWay_description(String way_description) {
        this.way_description = way_description;
    }


    // METHODS ///////////////////////////////////////

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";

        vStB.append("{")
            .append(vSEP).append("  ID = ").append(id)
            .append(vSEP).append("  Sector ID = \"").append(sector_id).append('"')
            .append(vSEP).append("  Way name = \"").append(way_name).append('"')
            .append(vSEP).append("  Way description = \"").append(way_description).append('"')
            .append(vSEP).append("  Height = \"").append(height).append('"')
            .append(vSEP).append("  Quotation = \"").append(quotation).append('"')
            .append(vSEP).append("}");

        return vStB.toString();
    }
}
