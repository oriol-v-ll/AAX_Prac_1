/**
 * Server IDP Interactivo para el Hub 
 * 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 * 
 */
package hub;

import java.io.*;
import java.net.*;

public class ServerUDPInteractivo {
    
    private int puerto = 0;
    static final int ITERACIONES_HUB = 100;
    public ServerUDPInteractivo(int puerto) {
        this.puerto = puerto; 
    }
    /**
     * Ejecuta un hilo que recibe peticiones UDP. 
     * 
     * @author Oriol Villanova Llorens
     */
    public void run(String IPOrigin) {
    	String informacion = "";
        String ubicacion = "";
        String edgeServer = "";
        String[] ubicaciones = {"Europa, Madrid", "Europa, Berlin","America, Chicago", "Otro"};
        String[] edgeservers = {"1111:127.0.0.1","2222:127.0.0.1","3333:127.0.0.1","9999:127.0.0.1"};
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(puerto);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+puerto);
            System.exit(1);
        }
        
        for(int i=0; i<ITERACIONES_HUB; i++) {
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
                if (received.equals("Otro")) {
                	ubicacion = ubicaciones[3];
                	 edgeServer = edgeservers[3];
                }
               
                	
            } catch (IOException e) {
                System.err.println("Error when receiving");
                System.exit(1);
            }
            
            
            informacion = edgeServer;
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
            System.out.println("Peticion servida numero: "+i + "  Tu ubicacion es: " +ubicacion);
        }
        socket.close();
    }
    
}
