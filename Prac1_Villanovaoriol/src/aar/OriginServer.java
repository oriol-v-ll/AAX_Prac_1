package aar;

public class OriginServer {
    public static void main(String[] args) {
        ServerTCPInteractivo objetoServer= new ServerTCPInteractivo(5555);
        objetoServer.run();
    }  
}
