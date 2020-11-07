/**
 * Protocolo de comunicacion del origin server
 */

package origin;

import java.io.*;

public class ProtocoloComunicacion {

	public ProtocoloComunicacion() {
	}

	/**
	 * Este metodo verifica la información del usuario y devuelve una respuesta
	 * acorde con lo que espera el usuario.
	 * 
	 * @param theInput
	 * @return theOutput
	 */
	public String processInput(String theInput) {
		String theOutput = null;

		if (theInput != null) {
			File archivo = new File("Origin/" + theInput + ".txt");
			if (!archivo.exists()) {
				theOutput = "NO";
			} else {
				theOutput = "SI";
			}
		} else {
			theOutput = "Que quieres descargar?";
		}
		return theOutput;
	}
}
