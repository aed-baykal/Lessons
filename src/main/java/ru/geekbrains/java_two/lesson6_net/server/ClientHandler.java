package ru.geekbrains.java_two.lesson6_net.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    static int clientCounter = 0;
    private int clientNumber;
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private ChatServer chatServer;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.clientNumber = ++clientCounter;
            System.out.println("Client Handler created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    String msg = new DataInputStream(inputStream).readUTF();
                    System.out.printf("Client #%d: %s\n", this.clientNumber, msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
