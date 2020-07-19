package com.mynet.yatota.Model;

import com.google.gson.annotations.SerializedName;

public class ManagerimodelClass {
    @SerializedName("timeserved")
    private String TimeServed;

    @SerializedName("attendant")
    private String Attendant;

    @SerializedName("customergender")
    private String CustomerGender;

    @SerializedName("customerage")
    private String CustomerAge;

    @SerializedName("servicetype")
    private String ServiceType;

    @SerializedName("amount")
    private String Amount;

    @SerializedName("mpesacode")
    private String MpesaCode;

    public ManagerimodelClass() {
    }

    public String getTimeServed() {
        return TimeServed;
    }

    public void setTimeServed(String timeServed) {
        TimeServed = timeServed;
    }

    public String getAttendant() {
        return Attendant;
    }

    public void setAttendant(String attendant) {
        Attendant = attendant;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }

    public String getCustomerAge() {
        return CustomerAge;
    }

    public void setCustomerAge(String customerAge) {
        CustomerAge = customerAge;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getMpesaCode() {
        return MpesaCode;
    }

    public void setMpesaCode(String mpesaCode) {
        MpesaCode = mpesaCode;
    }
}
