package com.example.labsheet10;

public class Message {
    private int messageID;
    private int userID;
    private String subject;
    private String message;

    public Message(int messageID, int userID, String subject, String message) {
        this.messageID = messageID;
        this.userID = userID;
        this.subject = subject;
        this.message = message;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
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
