

package origin;

import java.io.*;

public class ProtocoloComunicacion {
 
    
    public ProtocoloComunicacion() {}
    
    public String processInput(String theInput) {
        String theOutput = null;
        
        if (theInput != null) {
        	if (theInput.equals("FastAndFurius")) {
        		theOutput = "SI";
        	}else if (theInput.equals("Juego de Tronos")) {
        		theOutput = "SI";
        	}else if (theInput.equals("Mr.Robot")) {
        		theOutput = "SI";
        	}else {
        		theOutput = "NO";
        	}
        	if (theInput.equals("iporiginserver")) {
        		theOutput = "9.9.9.9:9999"; //Aquí no haría falta 
        	}
  
        	
        }else {
        	System.out.println("El fichero no existe...");
        	theOutput = "Que quieres descargar?";
        	
        }
     
        return theOutput;
    }
    

     
}
