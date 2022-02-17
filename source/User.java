package ru.corruptzero;

public class User extends Thread {
    UDPSender sender;
    UDPListener listener;

    public final String login;
    public User(String login) throws InterruptedException {
        sender = new UDPSender();
        listener = new UDPListener();
        this.login = login;
        start();
    }
    public User() throws InterruptedException {
        sender = new UDPSender();
        listener = new UDPListener();
        this.login="Anonymous";
        this.join();
        chat();
    }
    public void chat() throws InterruptedException {
        while (true){
            sender.send();
            System.out.printf("%s отправляет сообщение.\n", login);
            listener.listen();
        }
        //listener.listen();
    }

    @Override
    public void run(){
        try {
            chat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
