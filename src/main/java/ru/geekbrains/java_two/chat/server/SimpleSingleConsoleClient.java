package ru.geekbrains.java_two.chat.server;

import java.io.*;
import java.net.Socket;

public class SimpleSingleConsoleClient {
    private static final String HOST = "localhost";
    private static final int PORT = 12256;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Thread clientConsoleTread;

    public static void main(String[] args) {
        new SimpleSingleConsoleClient().runClient();
    }

    private void runClient() {
        try(Socket socket = new Socket(HOST, PORT)){
            System.out.println("Client started!");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            startConcoleTread();
            while (true) {
                String msg = in.readUTF();
                if (msg.equals("/end")) {
                    shutDownClient(socket);
                }
                System.out.println("Received: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutDownClient(socket);
                System.out.println("Finished!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutDownClient(Socket socket) throws IOException {
        clientConsoleTread.interrupt();
        if (socket != null) socket.close();
        System.out.println("Client  stopped");
    }

    private void startConcoleTread() {
        clientConsoleTread = new Thread(() -> {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("You can enter message for server >>>>");
            try {
                while (!Thread.currentThread().isInterrupted()){
                    if (bufferedReader.ready()) {
                        String messageFromClient = bufferedReader.readLine();
                        out.writeUTF(messageFromClient);
                        Thread.sleep(200);
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        clientConsoleTread.start();
    }

}
