/**
 * EDGE SERVER
 * 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 * 
 */
package edgeserver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Main del edgeserver que hace la conexión con el cliente y con el Origin si le hace falta el archivo.
 * @author oriol
 *
 */
public class EdgeServer {
	    public static void main(String[] args) {
	    	//Preguntar que servidor y en que localizacion queremos iniciarlo:
	    	Scanner teclado = new Scanner(System.in);
	    	int opcionUbicacion, puerto;
	    	String ubicacion;
	    	String[] ubicaciones = {"Europa, Madrid", "Europa, Berlin","America, Chicago"};
	    	int[] puertos = {1111,2222,3333};
	    	System.out.println("En que ubicacion esta el servidor?");
	    	for (int i=0;i<3;i++)
	    		System.out.println((i+1)+".-"+ubicaciones[i]+"\n");
	    	opcionUbicacion = Integer.parseInt(teclado.nextLine()); 
	    	puerto = puertos[opcionUbicacion-1];
	    	ubicacion = ubicaciones[opcionUbicacion-1];
	    	System.out.println("¿Cúal es la IP del origin server?");
	    	String iporigin = teclado.nextLine();
	    	System.out.println("¿Cúal es el puerto del origin server?");
	    	int puertoorigin = Integer.parseInt(teclado.nextLine()); 
	    	InetAddress IP = null;
			try {
				IP = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			System.out.println("El EdgeServer esta alojado en:"+IP+":"+puerto+"Y localizado en:"+ubicacion);
	        ServerTCPConcurrente objetoServer= new ServerTCPConcurrente(puerto);
	        objetoServer.run(iporigin,puertoorigin);
	        teclado.close();
	        

	    }
}
