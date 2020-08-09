package com.example.optic.apiinterface.responce_get_set;

public class pend_get_set {
    int id;
    String name,mob,l,r,u,ll,lr,lu,fprice,gprice,tprice,apay,baki,date;

    public pend_get_set(int id, String name, String mob, String l, String r, String u, String ll, String lr, String lu, String fprice, String gprice, String tprice, String apay, String baki, String date) {
        this.id = id;
        this.name = name;
        this.mob = mob;
        this.l = l;
        this.r = r;
        this.u = u;
        this.ll = ll;
        this.lr = lr;
        this.lu = lu;
        this.fprice = fprice;
        this.gprice = gprice;
        this.tprice = tprice;
        this.apay = apay;
        this.baki = baki;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }

    public String getLr() {
        return lr;
    }

    public void setLr(String lr) {
        this.lr = lr;
    }

    public String getLu() {
        return lu;
    }

    public void setLu(String lu) {
        this.lu = lu;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

    public String getGprice() {
        return gprice;
    }

    public void setGprice(String gprice) {
        this.gprice = gprice;
    }

    public String getTprice() {
        return tprice;
    }

    public void setTprice(String tprice) {
        this.tprice = tprice;
    }

    public String getApay() {
        return apay;
    }

    public void setApay(String apay) {
        this.apay = apay;
    }

    public String getBaki() {
        return baki;
    }

    public void setBaki(String baki) {
        this.baki = baki;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
