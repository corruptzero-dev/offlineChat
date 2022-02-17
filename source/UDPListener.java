package ru.corruptzero;

import java.net.*;

public class UDPListener {
    public void listen() {
        int port = 11111;
        InetAddress mcastaddr;
        NetworkInterface netIf;
        try(java.net.MulticastSocket socket = new java.net.MulticastSocket(port)) {
            mcastaddr = InetAddress.getByName("235.0.0.0");
            InetSocketAddress group = new InetSocketAddress(mcastaddr, port);
            netIf = NetworkInterface.getByName("bge0");
            socket.joinGroup(group, netIf);
            byte[] buffer = new byte[1000];
            DatagramPacket receivedMessage = new DatagramPacket(buffer, buffer.length);
            socket.receive(receivedMessage); //данные записались в буффер
            System.out.println(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
