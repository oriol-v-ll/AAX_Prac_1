/**
 * ClienteTCPuser
 * 
 * @author Oriol Villanova LLorens -> oriol.villanova@estudiants.urv.cat
 */
package cliente;

import java.io.*;
import java.net.*;

public class ClienteTCPuser {

	private String IP = "";
	private int puerto = 0;
	private String archivo = "";

	/**
	 * Constructor de la classe para incicar una conexion de cliente con la IP, el
	 * puerto y el archivo que se quiere descargar.
	 * 
	 * @param IP
	 * @param puerto
	 * @param archivo
	 */
	public ClienteTCPuser(String IP, int puerto, String archivo) {
		this.IP = IP;
		this.puerto = puerto;
		this.archivo = archivo;
	}

	/**
	 * run, crea una conexión mediante sockets con el edgeserver.
	 * 
	 * @return SI si se ha completado; No si no se ha completado
	 */
	public String run() {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		byte[] receivedData;
		int ini;
		String file;
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
					out.println("Tamaño?");
					System.out.println("Client: " + "Tamaño?");
					String L = in.readLine();
					int longitud = Integer.parseInt(L);
					System.out.println("Server: " + longitud);

					System.out.println("DESCARGANDO. ");
					System.out.println("DESCARGANDO.. ");
					System.out.println("DESCARGANDO... ");

					// fromServer = in.readLine();
					receivedData = new byte[longitud];
					bis = new BufferedInputStream(socket.getInputStream());
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					file = "Descargas/descarga.txt";
					bos = new BufferedOutputStream(new FileOutputStream(file));
					ini = bis.read(receivedData);
					bos.write(receivedData, 0, ini);

					bos.close();
					dis.close();
					bos.flush();
					out.close();
					in.close();
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
							ClienteTCPUserToOrigin objetoCliente = new ClienteTCPUserToOrigin(ipOriginServer,
									puertoOriginerver);

							objetoCliente.run(archivo);
							break;

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
