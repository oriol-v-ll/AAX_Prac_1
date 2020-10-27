package origin;

import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OriginServer {
    public static void main(String[] args) {
    	Scanner teclado = new Scanner(System.in);
    	int puerto;
    	System.out.println("Por cual puerto quieres iniciar el origin server?");
    	puerto = Integer.parseInt(teclado.nextLine());
    	InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	System.out.println("El servidor Origin Server esta alojado en:"+IP+":"+puerto);
        ServerTCPInteractivo objetoServer= new ServerTCPInteractivo(puerto);
        objetoServer.run();
        teclado.close();
    }   
	
}
