package com.example.gardenflow;

import java.util.HashMap;

public class User {

    private String fullName;
    private String photo;
    private String email;
    private HashMap<String,Object> timestampJoined;

    public User() {
    }


    public User(String mFullName, String mPhoneNo, String mEmail, HashMap<String, Object> timestampJoined) {
        this.fullName = mFullName;
        this.photo = mPhoneNo;
        this.email = mEmail;
        this.timestampJoined = timestampJoined;
    }


    public String getFullName() {
        return fullName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }

    public HashMap<String, Object> getTimestampJoined() {
        return timestampJoined;
    }
}