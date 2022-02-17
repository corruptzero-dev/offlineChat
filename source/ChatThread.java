package ru.corruptzero;

public class ChatThread extends Thread{
    UDPListener listener = new UDPListener();
    @Override
    public void run(){
        while (true){
            try {
                listener.listen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
