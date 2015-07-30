package com.example.retrofittest.Model;

import java.util.List;

/**
 * Created by cloud on 22/7/15.
 */
public class User {
    private String id;
    private String udid;
    private String phone;
    private Integer webrtcId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String audioNumber;
    private String videoNumber;
    private String im;
    private List<Phone> phones;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getWebrtcId() {
        return webrtcId;
    }

    public void setWebrtcId(Integer webrtcId) {
        this.webrtcId = webrtcId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAudioNumber() {
        return audioNumber;
    }

    public void setAudioNumber(String audioNumber) {
        this.audioNumber = audioNumber;
    }

    public String getVideoNumber() {
        return videoNumber;
    }

    public void setVideoNumber(String videoNumber) {
        this.videoNumber = videoNumber;
    }

    public String getIm() {
        return im;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
