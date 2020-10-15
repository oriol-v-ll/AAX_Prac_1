package aar;

import java.net.*;
import java.io.*;

public class ServerTCPConcurrente {
    
    private int puerto = 0;
    
    public ServerTCPConcurrente(int puerto) {
        this.puerto = puerto; 
    }
    
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(puerto);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }

        while (true) {       
            try { 
                new ServerTCPThread(serverSocket.accept()).start();
            } catch (IOException e) {
                System.err.println("Accept failed");
            }
        }       
    }
}
