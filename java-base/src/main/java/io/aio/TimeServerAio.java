package io.aio;

/**
 * Created by Admin on 2017/1/12.
 */
public class TimeServerAio {

    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeServerHandler(port)).start();
    }

}
