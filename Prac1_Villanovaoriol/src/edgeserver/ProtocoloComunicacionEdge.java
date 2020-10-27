
package edgeserver;
import java.io.*;


public class ProtocoloComunicacionEdge {
	
	public static String ficheros[]; 
    public ProtocoloComunicacionEdge() {}
    
    public String processInput(String theInput) {
        String theOutput = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        //Abrimos el fichero que pide el usuario.
       
        
       
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
        /*
        try {
           archivo = new File ("FicherosEdge/Fast and furius.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           String linea;
           while((linea=br.readLine())!=null)
              System.out.println(linea);
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }*/
        return theOutput;
    }
     
}
