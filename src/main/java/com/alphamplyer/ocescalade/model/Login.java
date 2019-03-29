package com.alphamplyer.ocescalade.model;

public class Login {

    private String password;
    private String username;


    public Login (String nickname, String password) {
        this.username = nickname;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
