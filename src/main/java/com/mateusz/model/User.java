package com.mateusz.model;

public class User {
    private String userFirstName;
    private String userLastName;
    private String userLogin;
    private String userPassword;
    private String userScore;

    public User() {
    }

    public User(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public User(String userFirstName, String userLogin, String userScore) {
        this.userFirstName = userFirstName;
        this.userLogin = userLogin;
        this.userScore = userScore;
    }

    public User(String userScore) {
        this.userScore = userScore;
    }

    public User(String userFirstName, String userLastName, String userLogin, String userPassword) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserScore() { return userScore; }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserScore(String userScore) { this.userScore = userScore; }
}
