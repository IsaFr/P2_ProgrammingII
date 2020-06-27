package com.example.p_two;

import java.util.Date;

public class Member {
    private String Name;
    private String Info;
    private int Photo;
    private boolean Sex;
    private Date DateBith;

    public Member(String name, String info, int photo, boolean sex, Date dateBith, String direction) {
        Name = name;
        Info = info;
        Photo = photo;
        Sex = sex;
        DateBith = dateBith;
        Direction = direction;
    }

    private String Direction;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public Date getDateBith() {
        return DateBith;
    }

    public void setDateBith(Date dateBith) {
        DateBith = dateBith;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }
}
