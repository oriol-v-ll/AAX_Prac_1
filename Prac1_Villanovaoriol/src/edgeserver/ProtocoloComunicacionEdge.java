/**
 * PROTOCOLO DE COMUNICACION EDGE SERVER 
 * 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 * 
 */
package edgeserver;

import java.io.*;

/**
 * Clase que dependiendo de que contesta el cliente, el edgeserver contesta la
 * respues óptima.
 * 
 * @author oriol
 *
 */
public class ProtocoloComunicacionEdge {

	public static String ficheros[];

	public ProtocoloComunicacionEdge() {
	}
	/**
	 * Classe para procesar la información que proviene del cliente y darle una respuesta adiente.
	 * @param theInput
	 * @return theOutput: Respuesta que dará el servidor. 
	 */
	public String processInput(String theInput) {
		String theOutput = null;

		if (theInput != null) {
			File archivo = new File("EdgeServer/" + theInput + ".txt");
			if (!archivo.exists()) {
				System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
				theOutput = "NO";
			} else {
				theOutput = "SI";
			}
			if (theInput.equals("iporiginserver"))
				theOutput = "127.0.0.1";
			if (theInput.equals("puertooriginserver"))
				theOutput = "9999";

		} else {
			System.out.println("El fichero no existe...");
			theOutput = "Que quieres descargar?";

		}

		return theOutput;
	}

}
