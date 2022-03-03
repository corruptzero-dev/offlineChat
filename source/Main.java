package ru.corruptzero;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User firstUser = new User("Marcus");
        User secondUser = new User();
        firstUser.join();
        secondUser.join();
    }
}
