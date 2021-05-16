package ru.geekbrains.java_two.lesson6_net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class VeryVerySimpleClient {
    private static final String HOST = "localhost";
    private static final int PORT = 12256;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)){
            System.out.println("Connected!");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String msg = SCANNER.nextLine();
                out.writeUTF(msg);
                Thread.sleep(200);
                msg = in.readUTF();
                System.out.println("Received: " + msg);
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
