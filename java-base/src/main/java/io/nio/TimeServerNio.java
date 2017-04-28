package io.nio;

/**
 * Created by Admin on 2017/1/12.
 */
public class TimeServerNio {

    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8080);
        new Thread(timeServer, "nio-MultiplexerTimeServer-001").start();
    }
}
