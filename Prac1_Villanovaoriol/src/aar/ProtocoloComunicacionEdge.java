
package aar;
import java.io.*;


public class ProtocoloComunicacionEdge {
	
	public static String ficheros[]; 
    public ProtocoloComunicacionEdge() {}
    
    public String processInput(String theInput) {
        String theOutput = null;
        
        //Abrimos el fichero que pide el usuario.
        //Si lo tenemos lo damos para descargar al usuario
        //Si no lo tenemos le pasamos al usuario la ip del origin server 
        //En el caso de no tenerlo, se establecera conexion con el origin server para descargarlo para futuros clientes
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

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
        }
        return theOutput;
    }
     
}
