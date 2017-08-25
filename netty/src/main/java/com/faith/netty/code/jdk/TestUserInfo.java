package com.faith.netty.code.jdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by yunyun on 2017/8/25.
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUserName("welcome to netty");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b=bos.toByteArray();
        System.out.println("the jdk serializable length is : "+b.length);
        bos.close();
        System.out.println("-----------------------");
        System.out.println("the byte array serializable length is : "+info.codeC().length);
    }
}
