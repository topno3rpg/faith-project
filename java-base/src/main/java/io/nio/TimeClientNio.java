package io.nio;

/**
 * Created by Admin on 2017/1/12.
 */
public class TimeClientNio {

    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", 8080), "nio-TimeClient-001").start();
//        new Thread(new TimeClientHandle("127.0.0.1", 8080), "nio-TimeClient-002").start();
    }
}
