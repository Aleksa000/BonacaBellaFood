package com.example.bonacabellafood;

public class Credentials {
    private String Username;
    private String Password;


    Credentials(String username, String password){
        this.Username = username;
        this.Password = password;

    }

    public Credentials(String regUsername, String regPassword, String regEmail, String regTelefon, String regPosta) {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
