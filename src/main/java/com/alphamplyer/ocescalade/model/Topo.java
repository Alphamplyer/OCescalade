package com.alphamplyer.ocescalade.model;

import java.sql.Timestamp;

public class Topo {

    // ================== Attributes =================== //

    private Integer id;
    private Integer author_id;

    private String topo_title;
    private String topo_description;
    private String topo_content;

    private Timestamp creation_date;
    private Integer topo_like;
    private Integer topo_vues;

    private Boolean is_bookable;
    private Timestamp begin_date;
    private Timestamp end_date;
    private Integer organizer_id;

    private Integer findedTopo;

    // ================= Constructors ================== //

    public Topo() {}

    public Topo(Integer id) {
        this.id = id;
    }

    public Topo(Integer id, Integer author_id,
                String topo_title, String topo_description, String topo_content,
                Timestamp creation_date, Integer topo_like, Integer topo_vues,
                Boolean is_bookable, Timestamp begin_date, Timestamp end_date, Integer organizer_id) {
        this.id = id;
        this.author_id = author_id;

        this.topo_title = topo_title;
        this.topo_description = topo_description;
        this.topo_content = topo_content;

        this.creation_date = creation_date;
        this.topo_like = topo_like;
        this.topo_vues = topo_vues;

        this.is_bookable = is_bookable;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.organizer_id = organizer_id;
    }

    // ================ Getters/Setters ================ //

    // GET ////////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public String getTopo_title() {
        return topo_title;
    }

    public String getTopo_description() {
        return topo_description;
    }

    public String getTopo_content() {
        return topo_content;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public Integer getTopo_like() {
        return topo_like;
    }

    public Integer getTopo_vues() {
        return topo_vues;
    }

    public Boolean getIs_bookable() {
        return is_bookable;
    }

    public Timestamp getBegin_date() {
        return begin_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public Integer getOrganizer_id() {
        return organizer_id;
    }

    public Integer getFindedTopo() {
        return findedTopo;
    }

    // SET ////////////////////////////////////////////////


    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public void setTopo_title(String topo_title) {
        this.topo_title = topo_title;
    }

    public void setTopo_description(String topo_description) {
        this.topo_description = topo_description;
    }

    public void setTopo_content(String topo_content) {
        this.topo_content = topo_content;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public void setTopo_like(Integer topo_like) {
        this.topo_like = topo_like;
    }

    public void setTopo_vues(Integer topo_vues) {
        this.topo_vues = topo_vues;
    }

    public void setIs_bookable(Boolean is_bookable) {
        this.is_bookable = is_bookable;
    }

    public void setBegin_date(Timestamp begin_date) {
        this.begin_date = begin_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public void setOrganizer_id(Integer organizer_id) {
        this.organizer_id = organizer_id;
    }

    public void setFindedTopo(Integer findedTopo) {
        this.findedTopo = findedTopo;
    }

    // ==================== Methods ==================== //

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";

        vStB.append(" {")
            .append(vSEP).append("  ID = ").append(id)
            .append(vSEP).append("  Author ID = \"").append(author_id).append('"')
            .append(vSEP).append("  Title = \"").append(topo_title).append('"')
            .append(vSEP).append("  Topo topo_description = \"").append(topo_description).append('"')
            .append(vSEP).append("  Topo Content = \"").append(topo_content).append('"')
            .append(vSEP).append("  Creation Date = \"").append(creation_date).append('"')
            .append(vSEP).append("  Number of Like = \"").append(topo_like).append('"')
            .append(vSEP).append("  Number of Dislike = \"").append(topo_vues).append('"')
            .append(vSEP).append("  Topo is booking ? = \"").append(is_bookable).append('"')
            .append(vSEP).append("  {")
            .append(vSEP).append("    Begin Date = \"").append(begin_date).append('"')
            .append(vSEP).append("    End Date = \"").append(end_date).append('"')
            .append(vSEP).append("    Organizer ID = ").append(organizer_id).append('"')
            .append(vSEP).append("  }")
            .append(vSEP).append("}");
        return vStB.toString();
    }
}
