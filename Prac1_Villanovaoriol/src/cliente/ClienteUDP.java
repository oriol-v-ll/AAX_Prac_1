/**
 * ClienteUDP
 * 
 *  @author Oriol Villanova LLorens -> oriol.villanova@estudiants.urv.cat
 */
package cliente;

import java.io.*;
import java.net.*;


public class ClienteUDP {
    
    private String IP = "";
    private int puerto = 0;
    /**
     * Constructor con los parámetros de construcción.
     * @param IP
     * @param puerto
     */
    public ClienteUDP(String IP, int puerto) {
        this.IP = IP;
        this.puerto = puerto;
    }
    
    /**
     * 
     * @param Ubicacion
     * @return IP del edgeserver optimo. 
     */
    public String run(String Ubicacion) {
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
        // send user ubication.
        buf = Ubicacion.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, 
                address, puerto);  
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.err.println("Error when sending");
            System.exit(1);
        }
     
        buf = new byte[256];
        packet = new DatagramPacket(buf, buf.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            System.err.println("Error when receiving");
            System.exit(1);
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Edge server optimo: " + received);
        socket.close();
        return received;
    }
  
}

