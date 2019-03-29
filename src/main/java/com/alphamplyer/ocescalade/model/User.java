package com.alphamplyer.ocescalade.model;

import java.sql.Date;

public class User {

    // ==================== Attributes ==================== //

    private Integer id;

    private String first_name;
    private String last_name;
    private String nickname;

    private String mail;
    private String password;
    private String salt;

    private Date birthday;
    private Date inscription_date;

    private Integer permission_level;


    // ==================== Constructors ==================== //
    /**
     * Constructor
     */
    public User() { }

    /**
     * Constructor
     * @param id -
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     * Constructor
     * @param id -
     * @param first_name -
     * @param last_name -
     * @param nickname -
     * @param password -
     * @param inscription_date -
     * @param mail -
     * @param permission_level -
     */
    public User(Integer id, String first_name, String last_name, String nickname, String password, String salt, Date inscription_date, String mail, Integer permission_level) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.password = password;
        this.salt = salt;
        this.inscription_date = inscription_date;
        this.mail = mail;
        this.permission_level = permission_level;
    }

    // ==================== Getters/Setters ==================== //

    /**
     * Get User ID
     * @return User ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set User ID
     * @param id New User ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get User first name
     * @return User first name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * Set User first name
     * @param first_name New User first name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * Get User second name
     * @return User second name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * Set User second name
     * @param last_name New User second name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * Get User nickname
     * @return User nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Set User nickname
     * @param nickname New User nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Get User password
     * @return Encrypt User password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set User password
     * @param password New encrypted password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Get User birthday
     * @return User birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Set User birthday
     * @param birthday New User birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Get User inscription date
     * @return User inscription date
     */
    public Date getInscription_date() {
        return inscription_date;
    }

    /**
     * Set User inscription date
     * @param inscription_date New User inscription date
     */
    public void setInscription_date(Date inscription_date) {
        this.inscription_date = inscription_date;
    }

    /**
     * Get User e-mail
     * @return User e-mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Set User e-mail
     * @param mail New User e-mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Get User permission level
     * @return User permission level
     */
    public Integer getPermission_level() {
        return permission_level;
    }

    /**
     * Set User permission level
     * @param permission_level New User permission level
     */
    public void setPermission_level(Integer permission_level) {
        this.permission_level = permission_level;
    }


    // ==================== Methods ==================== //
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";
        vStB.append(" {\n")
            .append("         User ID =").append(id)
            .append(vSEP).append("      first name = \"").append(first_name).append('"')
            .append(vSEP).append("     second name = \"").append(last_name).append('"')
            .append(vSEP).append("        nickname = \"").append(nickname).append('"')
            .append(vSEP).append("        password = \"").append(password).append('"')
            .append(vSEP).append("        Birthday = \"").append(birthday).append('"')
            .append(vSEP).append("Inscription Date = \"").append(inscription_date).append('"')
            .append(vSEP).append("   mail (e-mail) = \"").append(mail).append('"')
            .append(vSEP).append("permission level = \"").append(permission_level).append('"')
            .append("\n}");
        return vStB.toString();
    }
}
