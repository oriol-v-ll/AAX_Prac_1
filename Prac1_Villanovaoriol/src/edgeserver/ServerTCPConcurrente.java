/**
 * Server TCP concurrente
 * 
 */
package edgeserver;

import java.net.*;
import java.io.*;

public class ServerTCPConcurrente {
    
    private int puerto = 0;
    
    public ServerTCPConcurrente(int puerto) {
        this.puerto = puerto; 
    }
    
    @SuppressWarnings("resource")
	public void run(String iporigin, int puertoorigin) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(puerto);
        } catch (IOException e) {
            System.err.println("Could not listen on port:" + puerto);
            System.exit(1);
        }

        while (true) {       
            try { 
                new ServerTCPThread(serverSocket.accept(),iporigin,puertoorigin).start();
            } catch (IOException e) {
                System.err.println("Accept failed");
            }
        }       
    }
}
