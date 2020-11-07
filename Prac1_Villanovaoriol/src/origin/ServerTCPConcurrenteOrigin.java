/**
 * Server TCP concurrente Origin
 * 
 */
package origin;

import java.net.*;
import java.io.*;

public class ServerTCPConcurrenteOrigin {
    
    private int puerto = 0;
    
    public ServerTCPConcurrenteOrigin(int puerto) {
        this.puerto = puerto; 
    }
    /**
     * Crea una instancia del servidor Origin y dependiendo de las peticiones 
     * 
     */
    @SuppressWarnings("resource")
	public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(puerto);
        } catch (IOException e) {
            System.err.println("Could not listen on port:" + puerto);
            System.exit(1);
        }

        while (true) {       
            try { 
                new ServerTCPThreadOrigin(serverSocket.accept()).start();
            } catch (IOException e) {
                System.err.println("Accept failed");
            }
        }       
    }
}