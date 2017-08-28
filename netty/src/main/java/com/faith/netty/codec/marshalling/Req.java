package com.faith.netty.codec.marshalling;

import java.io.Serializable;

/**
 * Created by yunyun on 2017/8/28.
 */
public class Req implements Serializable {

    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ",userNamne:" + this.userName;
    }
}
