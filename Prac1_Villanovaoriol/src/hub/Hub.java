package hub;

import java.net.InetAddress;
import java.util.Scanner;
import java.net.UnknownHostException;

public class Hub {
	
	   public static void main(String[] args) {
	    	Scanner teclado = new Scanner(System.in);
	    	int puerto;
	    	System.out.println("Por cual puerto quieres iniciar el HUB?");
	    	puerto = Integer.parseInt(teclado.nextLine());
	    	InetAddress IP = null;
			try {
				IP = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
	    	System.out.println("El HUB esta alojado en:"+IP+":"+puerto);
	        ServerUDPInteractivo objetoServer= new ServerUDPInteractivo(4444);
	        objetoServer.run();
	        teclado.close();
	    }
}
