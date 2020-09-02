package com.mynet.yatota.Model;


import com.google.gson.annotations.SerializedName;

public class MyProductData {
    @SerializedName("id")
    public int id;

    @SerializedName("prname")
    public String prname;

    @SerializedName("primage")
    public int primage;

    @SerializedName("prprice")
    public String prprice;

    public MyProductData(int id, String prname, int primage, String prprice) {
        this.id = id;
        this.prname = prname;
        this.primage = primage;
        this.prprice = prprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public int getPrimage() {
        return primage;
    }

    public void setPrimage(int primage) {
        this.primage = primage;
    }

    public String getPrprice() {
        return prprice;
    }

    public void setPrprice(String prprice) {
        this.prprice = prprice;
    }
}
