package edgeserver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EdgeServer {
	    public static void main(String[] args) {
	    	//Preguntar que servidor y en que localizacion queremos iniciarlo:
	    	Scanner teclado = new Scanner(System.in);
	    	int opcionUbicacion, puerto, opcionPuerto;
	    	String ubicacion;
	    	String[] ubicaciones = {"Europa, Madrid", "Europa, Berlin","America, Chicago"};
	    	int[] puertos = {1111,2222,3333};
	    	System.out.println("En que ubicacion esta el servidor?");
	    	for (int i=0;i<3;i++)
	    		System.out.println((i+1)+".-"+ubicaciones[i]+"\n");
	    	opcionUbicacion = Integer.parseInt(teclado.nextLine()); 
	    	System.out.println("En que puerto quieres iniciar el servidor?");
	    	for (int j=0;j<3;j++)
	    		System.out.println((j+1)+".-"+puertos[j]+"\n");
	    	opcionPuerto = Integer.parseInt(teclado.nextLine()); 
	    	puerto = puertos[opcionPuerto-1];
	    	ubicacion = ubicaciones[opcionUbicacion-1];
	    	InetAddress IP = null;
			try {
				IP = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			System.out.println("El EdgeServer esta alojado en:"+IP+":"+puerto);
	    	
	    	//Inicializacion servidor para atender peticiones de los clientes
	        ServerTCPConcurrente objetoServer= new ServerTCPConcurrente(puerto);
	        objetoServer.run();
	        

	    }
}
