/**
 * CLIENTE 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 * 
 */
package cliente;

import java.util.Scanner;

/**
 * Clase cliente, incia una ubicacion de un cliente a escoger y le da a elegir
 * el archivo que quiere descargar.
 * 
 * @author oriol
 *
 */
public class Cliente {
	public static void main(String[] args) {

		System.out.println("-********CLIENTE********-\\n");
		Scanner teclado = new Scanner(System.in);
		String[] archivos = { "FastAndFurius", "Juego de Tronos", "Mr.Robot" }; // FastAndFurius
		String[] ubicaciones = { "Europa, Barcelona", "Europa, Amsterdam", "America, LosAngeles", "Otro" };
		int opcionArchivo, opcionUbicacion;
		String archivo, ubicacion;
		System.out.println("Elige que archivo quieres descargar:\n");
		for (int i = 0; i < archivos.length; i++)
			System.out.println((i + 1) + ".-" + archivos[i] + "\n");
		opcionArchivo = Integer.parseInt(teclado.nextLine());
		System.out.println("Elige en que ubicacion estas:\n");
		for (int j = 0; j < ubicaciones.length; j++)
			System.out.println((j + 1) + ".-" + ubicaciones[j] + "\n");
		opcionUbicacion = Integer.parseInt(teclado.nextLine());
		archivo = archivos[opcionArchivo - 1];
		ubicacion = ubicaciones[opcionUbicacion - 1];
		System.out.println("Has escogido la ubicacion: " + ubicacion + "\nHas escogido el archivo: " + archivo);
		String edgeserver = "";
		ClienteUDP objetoCliente = new ClienteUDP("127.0.0.1", 4444);
		edgeserver = objetoCliente.run(ubicacion);
		String ipedgeserver = edgeserver.substring(5, edgeserver.length());
		String puertoedgeerver = edgeserver.substring(0, 4);
		int puerto = Integer.parseInt(puertoedgeerver);
		@SuppressWarnings("unused")
		String conexionOrigin = null;
		ClienteTCPuser objetoClienteTCP = new ClienteTCPuser(ipedgeserver, puerto, archivo);
		conexionOrigin = objetoClienteTCP.run();
		teclado.close();

	}

}
