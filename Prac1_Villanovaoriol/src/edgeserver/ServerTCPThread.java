/**
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat 
 */
package edgeserver;

import java.net.*;
import java.io.*;

public class ServerTCPThread extends Thread {
	private Socket socket = null;
	private String iporigin = "";
	private int puertoorigin = 0;
	public static int FF =0;
	public static int JT =0;
	public static int MR =0;

	public ServerTCPThread(Socket socket, String iporigin, int puertoorigin) {
		this.socket = socket;
		this.iporigin = iporigin;
		this.puertoorigin = puertoorigin;
	}

	/**
	 * Metodo run que invocado con el start() crea un servidor concurrente para dar
	 * varias eticiones.
	 */
	@Override
	public void run() {
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		

		int ini;
		byte[] byteArray;
		String filename = "";
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("Create streams failed.");
			System.exit(1);
		}
		
		if (FF==1) {
			ClienteTCPedge objetoClienteTCP = new ClienteTCPedge(iporigin, puertoorigin, "FastAndFurius");
			objetoClienteTCP.run();	
		}
		if (JT==1) {
			ClienteTCPedge objetoClienteTCP = new ClienteTCPedge(iporigin, puertoorigin, "Juego de Tronos");
			objetoClienteTCP.run();
		}
		if (MR==1) {
			ClienteTCPedge objetoClienteTCP = new ClienteTCPedge(iporigin, puertoorigin, "Mr.Robot");
			objetoClienteTCP.run();
		}

		ProtocoloComunicacionEdge protocolo = new ProtocoloComunicacionEdge();

		String inputLine, outputLine;
		outputLine = protocolo.processInput(null);
		out.println(outputLine);

		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Recibo de cliente: " + inputLine);
				outputLine = protocolo.processInput(inputLine);
				out.println(outputLine);
				if (outputLine.equals("SI")) {
					if (inputLine.equals("FastAndFurius")) {
						filename = "EdgeServer/Fastandfurius.txt";
						File localFile = new File(filename);
						inputLine = in.readLine();
						out.println(localFile.length());
						FileInputStream fis = null;
						fis = new FileInputStream(filename);
						bis = new BufferedInputStream(fis);
						bos = new BufferedOutputStream(socket.getOutputStream());
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
						filename = "EdgeServer/Juego de tronos.txt";
						File localFile = new File(filename);
						inputLine = in.readLine();
						out.println(localFile.length());
						FileInputStream fis = null;
						fis = new FileInputStream(filename);
						bis = new BufferedInputStream(fis);
						bos = new BufferedOutputStream(socket.getOutputStream());
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
						filename = "EdgeServer/Mr.Robot.txt";
						File localFile = new File(filename);
						inputLine = in.readLine();
						out.println(localFile.length());
						FileInputStream fis = null;
						fis = new FileInputStream(filename);
						bis = new BufferedInputStream(fis);
						bos = new BufferedOutputStream(socket.getOutputStream());
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
				if (outputLine.equals("NO")) {
					if (inputLine.equals("FastAndFurius"))
						FF ++;
					if (inputLine.equals("Juego de Tronos"))
						JT++;	
					if (inputLine.equals("Mr.Robot"));
						MR++;
					
					/*
					ClienteTCPedge objetoClienteTCP = new ClienteTCPedge(iporigin, puertoorigin, inputLine);
					objetoClienteTCP.run();*/

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
			socket.close();
		} catch (IOException e) {
			System.err.println("Close failed.");
			System.exit(1);
		}
	}
}
