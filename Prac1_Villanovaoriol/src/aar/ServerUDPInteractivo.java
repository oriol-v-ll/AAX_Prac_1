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
        String ubicacion = "";
        String edgeServer = "";
        String[] ubicaciones = {"Europa, Madrid", "Europa, Berlin","America, Chicago"};
        String[] edgeservers = {"1.1.1.1:1111","2.2.2.2:2222","3.3.3.3:3333"};
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
                String received = new String(packet.getData(), 0, packet.getLength());
                //select the optimus ubication of the edge server
                if (received.equals("Europa, Barcelona")) {
                	ubicacion = ubicaciones[0];
                	edgeServer = edgeservers[0];
                }
                if (received.equals("Europa, Amsterdam")) {
                	ubicacion = ubicaciones[1];
                	edgeServer = edgeservers[1];
                }
                if (received.equals("America, LosAngeles")) {
                	ubicacion = ubicaciones[2];
                	edgeServer = edgeservers[2];
                }
                	
            } catch (IOException e) {
                System.err.println("Error when receiving");
                System.exit(1);
            }
            
            String informacion = edgeServer;
            
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
