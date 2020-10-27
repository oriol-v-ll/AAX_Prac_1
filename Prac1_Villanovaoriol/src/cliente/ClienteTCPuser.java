package cliente;

import java.io.*;
import java.net.*;

public class ClienteTCPuser {

	private String IP = "";
	private int puerto = 0;
	private String archivo = "";

	public ClienteTCPuser(String IP, int puerto, String archivo) {
		this.IP = IP;
		this.puerto = puerto;
		this.archivo = archivo;
	}

	public String run() {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			socket = new Socket(IP, puerto);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + IP);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: " + IP);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser = null;

		try {
			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals("Bye."))
					break;

				if (fromServer.equals("Que quieres descargar?")) {
					fromUser = archivo;
					if (fromUser != null) {
						System.out.println("Client: " + fromUser);
						out.println(fromUser);
					}
				}
				if (fromServer.equals("SI")) {
					System.out.println("DESCARGANDO. ");
					System.out.println("DESCARGANDO.. ");
					System.out.println("DESCARGANDO... ");
					fromUser = "Gracias";
					out.println(fromUser);
					break;

				} else if (fromServer.equals("NO")) {
					System.out.println("El archivo que buscas no esta disponible :( ....estamos trabajando en ello...");
					fromUser = "iporiginserver";
					out.println(fromUser);
					if ((fromServer = in.readLine()) != null) {
						System.out.println("Server: " + fromServer);
						String ipOriginServer = fromServer;
						fromUser = "puertooriginserver";
						out.println(fromUser);
						if ((fromServer = in.readLine()) != null) {
							System.out.println("Server: " + fromServer);
							int puertoOriginerver = Integer.parseInt(fromServer);
							ipOriginServer = "127.0.0.1"; //BORRAR LINEA CUANDO SE HAGA EN ORDENADORES SEPARADOS
							ClienteTCPUserToOrigin objetoCliente = new ClienteTCPUserToOrigin(ipOriginServer,
									puertoOriginerver, archivo);
							objetoCliente.run();
							fromUser = "Gracias";
							out.println(fromUser);

						}
					}
				}

			}

		} catch (IOException e) {
			System.err.println(e.getCause());
			System.exit(1);
		}

		try {
			out.close();
			in.close();
			stdIn.close();
			socket.close();
		} catch (IOException e) {
			System.err.println("Close failed.");
			System.exit(1);
		}
		String si = "Si";
		return si;
	}

}
