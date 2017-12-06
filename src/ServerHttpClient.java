//package com.lev.accprog.ui.core;

import java.net.*;
import java.io.*;

public class ServerHttpClient {
    static ServerSocket listener;

    public static void main(String[] ar) throws IOException {
        int port = 6666; // port
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(port);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            try {
                listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    out.println("Server Recived: " + input);
                }
            } catch (IOException e) {
                System.out.println("Error with thread");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Cannot close socket.");
                }
            }
        }
    }
}