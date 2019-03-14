package com.alphamplyer.ocescalade.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Comment")
public class Comment {

    // ================== Attributes =================== //

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "topo_id")
    private Integer topo_id;
    @JoinColumn(name = "topo_title")
    private String topo_title;

    @Column(name = "author_id")
    private Integer author_id;

    private User author;

    @Column(name = "comment_content")
    private String comment_content;
    @Column(name = "creation_date")
    private Timestamp creation_date;

    @Column(name = "reply")
    private Boolean reply;
    @Column(name = "parent_id")
    private Integer parent_id;

    private List<Comment> reply_comment;

    @Column(name = "edited")
    private Boolean edited;

    // ================= Constructors ================== //

    public Comment() {}

    public Comment(Integer id) {
        this.id = id;
    }

    public Comment(Integer id, Integer topo_id, Integer author_id, String comment_content, Timestamp creation_date, Boolean reply, Integer parent_id, Boolean edited) {
        this.id = id;
        this.topo_id = topo_id;
        this.author_id = author_id;
        this.comment_content = comment_content;
        this.creation_date = creation_date;
        this.reply = reply;
        this.parent_id = parent_id;
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

    public Integer getAuthor_id() {
        return author_id;
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

    public List<Comment> getReply_comment() {
        return reply_comment;
    }

    public Boolean getEdited() {
        return edited;
    }

    public String getTopo_title() {
        return topo_title;
    }

    public User getAuthor() {
        return author;
    }

    // SET ////////////////////////////////////////////////

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopo_id(Integer topo_id) {
        this.topo_id = topo_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
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

    public void setReply_comment(List<Comment> reply_comment) {
        this.reply_comment = reply_comment;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public void setTopo_title(String topo_title) {
        this.topo_title = topo_title;
    }

    public void setAuthor(User author) {
        this.author = author;
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
            .append(vSEP).append("  Author ID = \"").append(author_id).append('"')
            .append(vSEP).append("  Topo Name = \"").append(topo_title).append('"')
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
