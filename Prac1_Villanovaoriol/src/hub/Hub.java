/**
 * HUB 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 */
package hub;

import java.net.InetAddress;
import java.util.Scanner;
import java.net.UnknownHostException;
/**
 * En esta clase se implementa el main para que el hub proporciona a cada cliente la IP de su edgeserver Optimo. 
 * Si la ubicación no esta en el rango del edge server se envia la IP del Origin. 
 * 
 * @author oriol
 *
 */
public class Hub {
	
	   public static void main(String[] args) {
	    	Scanner teclado = new Scanner(System.in);
	    	int puerto;
	    	System.out.println("Por cual puerto quieres iniciar el HUB?"+"\n");
	    	puerto = Integer.parseInt(teclado.nextLine());
	    	InetAddress IP = null;
			try {
				IP = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
	    	System.out.println("¿Cúal es la IP del origin server? 0000:0.0.0.0"+"\n");
	    	String iporigin = teclado.nextLine();

	    	System.out.println("IP Origin Server:"+iporigin+"\n");
	    	System.out.println("El HUB esta alojado en:"+IP+":"+puerto);
	        ServerUDPInteractivo objetoServer= new ServerUDPInteractivo(4444);
	        objetoServer.run(iporigin);
	        teclado.close();
	    }
}
