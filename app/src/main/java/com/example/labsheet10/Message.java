package com.example.labsheet10;

public class Message {

    private int userID;
    private String subject;
    private String message;

    public Message(int userID, String subject, String message) {
        this.userID = userID;
        this.subject = subject;
        this.message = message;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

