package com.alphamplyer.ocescalade.model;

import java.sql.Timestamp;
import java.util.List;

public class Comment {

    // ================== Attributes =================== //

    private Integer id;

    private Integer topo_id;
    private String topo_title;

    private User user;

    private String comment_content;
    private Timestamp creation_date;

    private Boolean reply;
    private Integer parent_id;
    private List<Comment> reply_comments;

    private Boolean edited;

    // ================= Constructors ================== //

    public Comment() {}

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, Integer topo_id, String topo_title, User user, String comment_content, Timestamp creation_date, Boolean reply, Integer parent_id, List<Comment> reply_comments, Boolean edited) {
        this.id = id;
        this.topo_id = topo_id;
        this.topo_title = topo_title;
        this.user = user;
        this.comment_content = comment_content;
        this.creation_date = creation_date;
        this.reply = reply;
        this.parent_id = parent_id;
        this.reply_comments = reply_comments;
        this.edited = edited;
    }

    // ================ Getters/Setters ================ //

    // GET ////////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public Integer getTopo_id() {
        return topo_id;
    }

    public String getTopo_title() {
        return topo_title;
    }

    public User getUser() {
        return user;
    }

    public String getComment_content() {
        return comment_content;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public Boolean getReply() {
        return reply;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public List<Comment> getReply_comments() {
        return reply_comments;
    }

    public Boolean getEdited() {
        return edited;
    }

    // SET ////////////////////////////////////////////////

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopo_id(Integer topo_id) {
        this.topo_id = topo_id;
    }

    public void setTopo_title(String topo_title) {
        this.topo_title = topo_title;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public void setReply(Boolean reply) {
        this.reply = reply;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public void setReply_comments(List<Comment> reply_comments) {
        this.reply_comments = reply_comments;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    // ==================== Methods ==================== //

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";
        vStB.append(" {\n")
            .append(vSEP).append("  ID = ").append(id)
            .append(vSEP).append("  Topo ID").append(topo_id)
            .append(vSEP).append("  Topo Name = \"").append(topo_title).append('"')
            .append(vSEP).append("  Author ID = \"").append(user.getId()).append('"')
            .append(vSEP).append("  Content = \"").append(comment_content).append('"')
            .append(vSEP).append("  Creation Date = \"").append(creation_date).append('"')
            .append(vSEP).append("  Is a reply = \"").append(reply).append('"')
            .append(vSEP).append("  {")
            .append(vSEP).append("    Parent ID = \"").append(parent_id).append('"')
            .append(vSEP).append("  }")
            .append(vSEP).append("isEdited ? = \"").append(edited).append('"')
            .append("\n}");
        return vStB.toString();
    }
}
