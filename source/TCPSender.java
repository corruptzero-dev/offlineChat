package ru.corruptzero;

import java.io.*;
import java.net.Socket;

public class TCPSender {
    public TCPSender(Socket socket){
        try{
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int num = dataInputStream.readInt();
            String[] myMessages= new String[5]; //TODO correct 5
            byte[] mess = myMessages[num - 1].getBytes("UTF-8");
            dataOutputStream.writeInt(mess.length);
            dataOutputStream.write(mess);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            byteArrayOutputStream.reset();
            socket.close();
        } catch (java.io.IOException e){
            e.printStackTrace();
        }

    }
}
