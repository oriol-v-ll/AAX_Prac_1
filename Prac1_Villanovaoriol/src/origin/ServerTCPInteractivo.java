/**
 * 
 * SERVER TCP INTERACTIVO ORIGIN 
 * 
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat 
 * 
 */
package origin;

import java.net.*;
import java.io.*;

public class ServerTCPInteractivo {

	private int puerto = 0;

	public ServerTCPInteractivo(int puerto) {
		this.puerto = puerto;
	}

	public void run() {
		ServerSocket serverSocket = null;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		int ini;
		byte[] byteArray;
		String filename = "";

		try {
			serverSocket = new ServerSocket(puerto);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + puerto);
			System.exit(1);
		}

		Socket clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
			clientSocket.setSoLinger(true, 10);
		} catch (IOException e) {
			System.err.println("Accept failed.");
			System.exit(1);
		}

		PrintWriter out = null;
		BufferedReader in = null;
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Create streams failed.");
			System.exit(1);
		}

		ProtocoloComunicacion protocolo = new ProtocoloComunicacion();

		String inputLine, outputLine;
		outputLine = protocolo.processInput(null);
		out.println(outputLine);

		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Recibo de cliente: " + inputLine);
				outputLine = protocolo.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.equals("SI")) {
					// Implementación de sistema de descargas.
					if (inputLine.equals("FastAndFurius")) {
						filename = "Origin/Fastandfurius.txt";
						File localFile = new File(filename);
						inputLine = in.readLine();
						out.println(localFile.length());
						FileInputStream fis = null;
						fis = new FileInputStream(filename);
						bis = new BufferedInputStream(fis);
						bos = new BufferedOutputStream(clientSocket.getOutputStream());
						byteArray = new byte[(int) localFile.length()];
						ini = bis.read(byteArray, 0, (int) localFile.length());
						bos.write(byteArray, 0, ini);
						bos.flush();
						bis.close();
						bos.close();
						out.close();
						in.close();
						break;
					}
					if (inputLine.equals("Juego de Tronos")) {
						filename = "Origin/Juego de tronos.txt";
						File localFile = new File(filename);
						inputLine = in.readLine();
						out.println(localFile.length());
						FileInputStream fis = null;
						fis = new FileInputStream(filename);
						bis = new BufferedInputStream(fis);
						bos = new BufferedOutputStream(clientSocket.getOutputStream());
						byteArray = new byte[(int) localFile.length()];
						ini = bis.read(byteArray, 0, (int) localFile.length());
						bos.write(byteArray, 0, ini);
						bos.flush();
						bis.close();
						bos.close();
						out.close();
						in.close();
						break;
					}
					if (inputLine.equals("Mr.Robot")) {
						filename = "Origin/Mr.Robot.txt";
						File localFile = new File(filename);
						inputLine = in.readLine();
						out.println(localFile.length());
						FileInputStream fis = null;
						fis = new FileInputStream(filename);
						bis = new BufferedInputStream(fis);
						bos = new BufferedOutputStream(clientSocket.getOutputStream());
						byteArray = new byte[(int) localFile.length()];
						ini = bis.read(byteArray, 0, (int) localFile.length());
						bos.write(byteArray, 0, ini);
						bos.flush();
						bis.close();
						bos.close();
						out.close();
						in.close();
						break;
					}
				}
				if (outputLine.equals("Bye."))
					break;
			}
		} catch (IOException e) {
			System.err.println("Read failed.");
			System.exit(1);
		}

		try {
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Close failed.");
			System.exit(1);
		}
	}
}
