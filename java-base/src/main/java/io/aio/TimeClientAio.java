package io.aio;

/**
 * Created by Admin on 2017/1/12.
 */
public class TimeClientAio {

    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", 8080)).start();
    }
}
