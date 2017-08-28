package com.faith.netty.codec.marshalling;

import java.io.Serializable;

/**
 * Created by yunyun on 2017/8/28.
 */
public class Resp implements Serializable {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "code:" + this.code + ",msg:" + this.msg;
    }
}
