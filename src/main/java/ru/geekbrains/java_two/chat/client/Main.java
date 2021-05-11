package ru.geekbrains.java_two.chat.client;

import ru.geekbrains.java_two.chat.server.ChatServer;

public class Main {
    public static void main(String[] args) {
        new ServerThread().start();
        App.main(args);
    }

}

class ServerThread extends Thread {

    @Override
    public void run(){
        new ChatServer().start();
    }

}