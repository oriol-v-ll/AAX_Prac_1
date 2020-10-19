package aar;

public class OriginServer {
	//Se tiene que crear un servidor TCP
    public static void main(String[] args) {
        ServerTCPInteractivo objetoServer= new ServerTCPInteractivo(9999);
        objetoServer.run();
    }   
	
}
