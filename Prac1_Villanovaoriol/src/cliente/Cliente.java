/**
 * CLIENTE 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 * 
 */
package cliente;

import java.util.Scanner;
/**
 * Clase cliente, incia una ubicacion de un cliente a escoger y le da a elegir el archivo que quiere descargar. 
 * 
 * @author oriol
 *
 */
public class Cliente {
    public static void main(String[] args) {
    	
    	//Se pide la información necesaria al usuario
    	 Scanner teclado = new Scanner(System.in);
    	 String[] archivos = {"FastAndFurius","Juego de Tronos", "Mr.Robot"}; //FastAndFurius
    	 String[] ubicaciones = {"Europa, Barcelona", "Europa, Amsterdam","America, LosAngeles"};
    	 int opcionArchivo, opcionUbicacion;
    	 String archivo, ubicacion;
    	 //Cambio para que el cliente pueda escribir el archivo que quiere descargar.
    	 System.out.println("Elige que archivo quieres descargar:\n");
    	 for (int i=0;i<3;i++)
    		 System.out.println((i+1)+".-"+archivos[i]+"\n");
    	 opcionArchivo = Integer.parseInt(teclado.nextLine());
    	 System.out.println("Elige en que ubicacion estas:\n");
    	 for (int j=0;j<3;j++)
    		 System.out.println((j+1)+".-"+ubicaciones[j]+"\n");
    	 opcionUbicacion = Integer.parseInt(teclado.nextLine()); 
    	 archivo = archivos[opcionArchivo-1];
    	 ubicacion = ubicaciones[opcionUbicacion-1];
    	 System.out.println("Has escogido la ubicacion: "+ubicacion+"\nHas escogido el archivo: "+archivo);

    	//Iicialización y conexión con el HUB 
    	String edgeserver = "";
        ClienteUDP objetoCliente= new ClienteUDP("127.0.0.1",4444);
        edgeserver = objetoCliente.run(ubicacion);
        //Procesar la informacion del hub 
        //String ipedgeserver = edgeserver.substring(0,7); //Solo funciona para ips de un solo digito; Poible cambio
        String puertoedgeerver = edgeserver.substring(8,12);
        
        //Conectarse al edge server optimo preguntando por el archivo
        int puerto = Integer.parseInt(puertoedgeerver);
        //ClienteTCPuser objetoClienteTCP= new ClienteTCPuser(ipedgeserver,puerto,archivo);
        String conexionOrigin = null;
        ClienteTCPuser objetoClienteTCP= new ClienteTCPuser("127.0.0.1",puerto,archivo);
        conexionOrigin = objetoClienteTCP.run();
      
        
        teclado.close();
        
        
        
    }

}
