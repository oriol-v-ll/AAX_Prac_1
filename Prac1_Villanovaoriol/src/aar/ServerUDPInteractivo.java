package aar;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServerUDPInteractivo {
    
    private int puerto = 0;
    
    public ServerUDPInteractivo(int puerto) {
        this.puerto = puerto; 
    }
    
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(puerto);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+puerto);
            System.exit(1);
        }
        
        for(int i=0; i<5; i++) {
            byte[] buf = new byte[256];  
            
            DatagramPacket packet = new DatagramPacket(buf, buf.length);       
            try {
                socket.receive(packet);
            } catch (IOException e) {
                System.err.println("Error when receiving");
                System.exit(1);
            }
            
        
            String[] ubicacion = {"Europa, Madrid", "Europa, Berlin","America, Chicago"};
            String sdate = ubicacion[0];
            String edgeserver =  "192.168.0.1:4444";
            String informacion = sdate + edgeserver;
            
            InetAddress addressOrigen = packet.getAddress();
            int puertoOrigen = packet.getPort();
            buf = informacion.getBytes();
            
            packet = new DatagramPacket(buf, buf.length, addressOrigen, 
                    puertoOrigen);
            try {
                socket.send(packet);
            } catch (IOException e) {
                System.err.println("Error when sending");
                System.exit(1);
            }
            System.out.println("Peticion servida numero: "+i);
        }
        socket.close();
    }
    
}
