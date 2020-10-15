package aar;

import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
    	
    	//Se pide la información necesaria al usuario
    	Scanner teclado = new Scanner(System.in);
    	 String[] archivos = {"FastAndFurius","Juego de Tronos", "Mr.Robot"};
    	 String[] ubicaciones = {"Europa, Barcelona", "Europa, Amsterdam","America, LosAngeles"};
    	 int opcionArchivo, opcionUbicacion;
    	 String archivo, ubicacion;
    	 System.out.println("Elige que archivo quieres descargar:\n");
    	 for (int i=0;i<3;i++)
    		 System.out.println((i+1)+".-"+archivos[i]+"\n");
    	 opcionArchivo = Integer.parseInt(teclado.nextLine());
    	 for (int j=0;j<3;j++)
    		 System.out.println((j+1)+".-"+ubicaciones[j]+"\n");
    	 opcionUbicacion = Integer.parseInt(teclado.nextLine()); 
    	 archivo = archivos[opcionArchivo-1];
    	 ubicacion = ubicaciones[opcionUbicacion-1];
    	 System.out.println("Has escogido la ubicacion: "+ubicacion+"\nHas escogido el archivo: "+archivo);
    	 teclado.close();
    	 
    	 
    	 
    	//Iicialización y conexión con el HUB  
        ClienteUDP objetoCliente= new ClienteUDP("127.0.0.1",4444);
        objetoCliente.run(ubicacion);
        
        //Procesar la informacion del hub
        
        
        
        
        //COnectarse al edge server optimo preguntando por el archivo
        
        
        
        
        //Si no esta disponible en el edge server, peticion al origin server.
        
    }
}
