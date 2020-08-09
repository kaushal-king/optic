package com.example.optic.apiinterface.responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responce {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("de")
    @Expose
    private de de;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public de getDe() {
        return de;
    }

    public void setDe(de de) {
        this.de = de;
    }

}
