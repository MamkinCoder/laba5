//package com.lev.accprog.ui.core;

import java.io.*;
import java.net.Socket;

public class HttpClient {

    private final int serverPort = 6666;
    private Socket socket = null;
    private String mWord = "Hello";
    private final String module = "HttpClient";
    private BufferedReader in = null;


    private PrintWriter out = null;

    public HttpClient() {
        try {
            System.out.println("Init: " + module);
            socket = new Socket("Localhost", serverPort); // create socket.
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Server response: ");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }
}