package ru.corruptzero;

public class User extends Thread {
    UDPSender sender;
    UDPListener listener;
    ChatThread ct = new ChatThread();
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
        ct.join();
        ct.start();
        System.out.printf("%s подключился.\n", login);
        while (true){
            sender.send(login);
            System.out.printf("%s отправляет сообщение.%n", login);
            Thread.sleep(5000);
        }
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
