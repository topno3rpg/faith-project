package io.bio;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Admin on 2017/1/10.
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                //use default
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("the time server is starting at port:" + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (server != null) {
                System.out.println("the time server close");
                server.close();
                server = null;
            }
        }

    }
}
