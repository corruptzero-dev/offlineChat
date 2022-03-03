package ru.corruptzero;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPSender {
    public void send(String login){
        byte[] buffer = login.getBytes(StandardCharsets.UTF_8);
        try(java.net.DatagramSocket socket = new java.net.DatagramSocket()){
            socket.connect(InetAddress.getByName("235.0.0.0"), 11111);
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, socket.getInetAddress(), socket.getPort());
            socket.setBroadcast(true);
            socket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

