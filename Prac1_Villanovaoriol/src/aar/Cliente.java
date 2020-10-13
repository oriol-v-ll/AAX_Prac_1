package aar;

public class Cliente {
    public static void main(String[] args) {
    	
    	//Iicialización y conexión con el HUB  
        ClienteUDP objetoCliente= new ClienteUDP("127.0.0.1",4444);
        objetoCliente.run();
        
        
    }
}
