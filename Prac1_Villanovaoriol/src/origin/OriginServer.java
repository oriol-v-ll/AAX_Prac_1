/**
 * Origin server -> este servidor es el que tiene todo los archivos
 */
package origin;

import java.util.Scanner;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Origin server procesa la información tanto del cliente como del edgeserver y
 * les da sus peticiones
 * 
 * @author oriol
 *
 */
public class OriginServer {
	public static void main(String[] args) {
		System.out.println("-********ORIGIN SERVER********-\\n");
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
		System.out.println("El servidor Origin Server esta alojado en:" + IP + ":" + puerto);
		ServerTCPConcurrenteOrigin objetoServer = new ServerTCPConcurrenteOrigin(puerto);
		objetoServer.run();
		teclado.close();
	}

}
