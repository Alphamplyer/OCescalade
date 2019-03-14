package com.alphamplyer.ocescalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "User")
public class User {

    // ==================== Attributes ==================== //
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "user_password")
    private String password;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "inscription_date")
    private Date inscriptionDate;
    @Column(name = "mail")
    private String mail;
    /**
     * User permission Level; 0 = default rigth; 1 = no right; 2 = administrator; 3 = superAdministrator
     */
    @Column(name = "permission_level")
    private Integer permissionLevel;

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
     * @param firstName -
     * @param secondName -
     * @param nickname -
     * @param password -
     * @param mail -
     * @param permissionLevel -
     */
    public User(Integer id, String firstName, String secondName, String nickname, String password, Date inscriptionDate, String mail, Integer permissionLevel) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.nickname = nickname;
        this.password = password;
        this.inscriptionDate = inscriptionDate;
        this.mail = mail;
        this.permissionLevel = permissionLevel;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set User first name
     * @param firstName New User first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get User second name
     * @return User second name
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * Set User second name
     * @param secondName New User second name
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
    public Date getInscriptionDate() {
        return inscriptionDate;
    }

    /**
     * Set User inscription date
     * @param inscriptionDate New User inscription date
     */
    public void setInscriptionDate(Date inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
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
    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * Set User permission level
     * @param permissionLevel New User permission level
     */
    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }


    // ==================== Methods ==================== //
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = "\n";
        vStB.append(" {\n")
            .append("         User ID =").append(id)
            .append(vSEP).append("      first name = \"").append(firstName).append('"')
            .append(vSEP).append("     second name = \"").append(secondName).append('"')
            .append(vSEP).append("        nickname = \"").append(nickname).append('"')
            .append(vSEP).append("        password = \"").append(password).append('"')
            .append(vSEP).append("        Birthday = \"").append(birthday).append('"')
            .append(vSEP).append("Inscription Date = \"").append(inscriptionDate).append('"')
            .append(vSEP).append("   mail (e-mail) = \"").append(mail).append('"')
            .append(vSEP).append("permission level = \"").append(permissionLevel).append('"')
            .append("\n}");
        return vStB.toString();
    }
}
