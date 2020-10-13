package aar;

import java.io.*;
import java.net.*;


public class ClienteUDP {
    
    private String IP = "";
    private int puerto = 0;
    
    public ClienteUDP(String IP, int puerto) {
        this.IP = IP;
        this.puerto = puerto;
    }
    
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+puerto);
            System.exit(1);
        }
        
        // send request
        byte[] buf = new byte[256];
        InetAddress address = null;
        try {
            address = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.err.println("Unknown Host Exception");
            System.exit(1);
        }
        DatagramPacket packet = new DatagramPacket(buf, buf.length, 
                address, puerto);  
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.err.println("Error when sending");
            System.exit(1);
        }
        
        // get response
        packet = new DatagramPacket(buf, buf.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            System.err.println("Error when receiving");
            System.exit(1);
        }

        // display response
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Fecha actual: " + received);
        
        socket.close();
    }
  
}

