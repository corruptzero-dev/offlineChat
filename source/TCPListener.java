package ru.corruptzero;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPListener {
    public TCPListener(){
        try(ServerSocket serverSocket = new ServerSocket(11112)){
            Socket socket = serverSocket.accept();
            new TCPSender(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
