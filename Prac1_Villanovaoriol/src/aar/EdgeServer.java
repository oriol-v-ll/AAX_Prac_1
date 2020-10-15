package aar;

public class EdgeServer {
	    public static void main(String[] args) {
	    	//Preguntar que servidor y en que localizacion queremos iniciarlo:
	    	
	    	//Inicializacion servidor para atender peticiones de los clientes
	        ServerTCPConcurrente objetoServer= new ServerTCPConcurrente(2222);
	        objetoServer.run();
	        
	        //Inicializacion del cliente de cara el contacto con el origin server
	        ClienteTCPedge objetoCliente= new ClienteTCPedge("9.9.9.9",9999);
	        objetoCliente.run();
	    }
}
