package ru.geekbrains.java_two.lesson6_net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSingleConsoleServer {
    private static final int PORT = 12256;
    private static Socket socket;
    private static DataOutputStream out;
    private static DataInputStream in;
    private Thread serverConsoleTread;

    public static void main(String[] args) {
        new SimpleSingleConsoleServer().runServer();
    }

    private void runServer() {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started!");
            waitingForConnectionAndInitResources(serverSocket);
            startConcoleTread();
            while (true) {
                String msg = in.readUTF();
                if (msg.equals("/end")) {
                    shutDownServer();
                }
                System.out.println("Received: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutDownServer();
                System.out.println("Finished!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutDownServer() throws IOException {
        serverConsoleTread.interrupt();
        socket.close();
        System.out.println("Server stopped");
    }

    private void startConcoleTread() {
        serverConsoleTread = new Thread(() -> {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("You can enter message for client >>>>");
            try {
                while (!Thread.currentThread().isInterrupted()){
                    if (bufferedReader.ready()) {
                        String messageFromServer = bufferedReader.readLine();
                        out.writeUTF(messageFromServer);
                        Thread.sleep(200);
                    }
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        serverConsoleTread.start();
    }

    private void waitingForConnectionAndInitResources(ServerSocket serverSocket) throws IOException {
        System.out.println("Waiting for connection...");
        socket = serverSocket.accept();
        System.out.println("Client has connected.");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

    }
}
