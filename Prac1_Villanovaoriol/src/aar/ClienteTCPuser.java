package aar;

import java.io.*;
import java.net.*;

public class ClienteTCPuser {
    
    private String IP = "";
    private int puerto = 0;
    private String archivo = "";
    
    public ClienteTCPuser(String IP, int puerto, String archivo) {
        this.IP = IP;
        this.puerto = puerto;
        this.archivo =  archivo;
    }
    
    public void run() {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
 
        try {
            socket = new Socket(IP, puerto);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: "+IP);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: "+IP);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        try {
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye."))
                    break;
		    
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getCause());
            System.exit(1);
        }  
            
        try {
            out.close();      
            in.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Close failed.");
            System.exit(1);
        }  
    }
  
}
