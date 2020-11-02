/**
 * PROTOCOLO DE COMUNICACION EDGE SERVER 
 * 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat
 * 
 */
package edgeserver;


/**
 * Clase que dependiendo de que contesta el cliente, el edgeserver contesta la respues óptima.
 * 
 * @author oriol
 *
 */
public class ProtocoloComunicacionEdge {
	
	public static String ficheros[]; 
    public ProtocoloComunicacionEdge() {}
    
    public String processInput(String theInput) {
        String theOutput = null;
       
        if (theInput != null) {
        	if (theInput.equals("FastAndFurius")) {
        		theOutput = "NO";
        	}else if (theInput.equals("Juego de Tronos")) {
        		theOutput = "SI";
        	}else if (theInput.equals("Mr.Robot")) {
        		theOutput = "SI";
        	}else if (theInput.equals("iporiginserver")) {
        		theOutput = "9.9.9.9";
        	}else if(theInput.equals("puertooriginserver")) {
        		theOutput = "9999";
        	}
        	else {
        		theOutput = "NO";
        	}

        	if (theInput.equals("Gracias")) {
        		theOutput = "Bye.";
        	}
        	
        }else {
        	System.out.println("El fichero no existe...");
        	theOutput = "Que quieres descargar?";
        	
        }

        return theOutput;
    }
     
}
