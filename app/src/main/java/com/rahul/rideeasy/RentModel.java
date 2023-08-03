package com.rahul.rideeasy;

public class RentModel {
    String name,rate,phone,surl;
    RentModel(){

    }
    public RentModel(String name, String rate, String phone, String surl) {
        this.name = name;
        this.rate = rate;
        this.phone = phone;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
