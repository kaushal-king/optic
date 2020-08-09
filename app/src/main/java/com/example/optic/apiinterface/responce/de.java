package com.example.optic.apiinterface.responce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class de {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sum")
    @Expose
    private String sum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
