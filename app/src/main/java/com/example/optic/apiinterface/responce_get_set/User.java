package com.example.optic.apiinterface.responce_get_set;

public class User {
    int id;
    String mobno;



    public User(int id, String mobno) {
        this.id = id;

        this.mobno = mobno;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }
}
