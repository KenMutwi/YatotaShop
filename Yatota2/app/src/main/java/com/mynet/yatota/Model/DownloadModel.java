package com.mynet.yatota.Model;

public class DownloadModel {
    private String id;
    private String comptime;
    private String timeserved;
    private String attendant;
    private String customergender;
    private String customerage;
    private String servicetype;
    private String amount;
    private String mpesacode;

    public DownloadModel(String id, String comptime, String timeserved, String attendant, String customergender, String customerage, String servicetype, String amount, String mpesacode) {
        this.id = id;
        this.comptime = comptime;
        this.timeserved = timeserved;
        this.attendant = attendant;
        this.customergender = customergender;
        this.customerage = customerage;
        this.servicetype = servicetype;
        this.amount = amount;
        this.mpesacode = mpesacode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComptime() {
        return comptime;
    }

    public void setComptime(String comptime) {
        this.comptime = comptime;
    }

    public String getTimeserved() {
        return timeserved;
    }

    public void setTimeserved(String timeserved) {
        this.timeserved = timeserved;
    }

    public String getAttendant() {
        return attendant;
    }

    public void setAttendant(String attendant) {
        this.attendant = attendant;
    }

    public String getCustomergender() {
        return customergender;
    }

    public void setCustomergender(String customergender) {
        this.customergender = customergender;
    }

    public String getCustomerage() {
        return customerage;
    }

    public void setCustomerage(String customerage) {
        this.customerage = customerage;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMpesacode() {
        return mpesacode;
    }

    public void setMpesacode(String mpesacode) {
        this.mpesacode = mpesacode;
    }
}
