package com.example.labsheet10;

public class User {

    private int userID;
    private String userName;
    private String password;
    private String type;

    public User(int userID, String userName, String password, String type) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
