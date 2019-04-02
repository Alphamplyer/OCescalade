package com.alphamplyer.ocescalade.model;


public class Sector
{
    // ATTRIBUTES /////////////////////////////////

    private Integer id;

    private Integer site_id;

    private String orientation;

    private String difficulty;

    private String sector_name;

    private String sector_description;

    // CONSTRUCTORS ///////////////////////////////

    public Sector () { }

    public Sector (Integer id) {
        this.id = id;
    }

    public Sector (Integer id, Integer site_id, String orientation, String difficulty, String sector_name, String sector_description) {
        this.id = id;
        this.site_id = site_id;
        this.orientation = orientation;
        this.difficulty = difficulty;
        this.sector_name = sector_name;
        this.sector_description = sector_description;
    }

    // GETTERS / SETTERS //////////////////////////
    // GET ////////////////////////////////////////

    public Integer getId () {
        return this.id;
    }

    public Integer getSite_id () {
        return this.site_id;
    }

    public String getOrientation () {
        return this.orientation;
    }

    public String getDifficulty () {
        return this.difficulty;
    }

    public String getSector_name () {
        return this.sector_name;
    }

    public String getSector_description () {
        return this.sector_description;
    }

    // SET ////////////////////////////////////////

    public void setId (Integer id) {
        this.id = id;
    }

    public void setSite_id (Integer site_id) {
        this.site_id = site_id;
    }

    public void setOrientation (String orientation) {
        this.orientation = orientation;
    }

    public void setDifficulty (String difficulty) {
        this.difficulty = difficulty;
    }

    public void setSector_name (String sector_name) {
        this.sector_name = sector_name;
    }

    public void setSector_description (String sector_description) {
        this.sector_description = sector_description;
    }

    // METHODS ////////////////////////////////////

    @Override    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";

        vStB.append("{")
            .append(vSEP).append("Id\"").append(id).append('"')
            .append(vSEP).append("Site_id\"").append(site_id).append('"')
            .append(vSEP).append("Orientation\"").append(orientation).append('"')
            .append(vSEP).append("Difficulty\"").append(difficulty).append('"')
            .append(vSEP).append("Sector_name\"").append(sector_name).append('"')
            .append(vSEP).append("Sector_description\"").append(sector_description).append('"')
            .append(vSEP).append("}");

        return vStB.toString();
    }
}