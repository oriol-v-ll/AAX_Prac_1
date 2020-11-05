/**
 * 
 * ServerTCPThreadOrigin
 * @author Oriol Villanova Llorens -> oriol.villanova@estudiants.urv.cat 
 */
package origin;

import java.net.*;

import java.io.*;

public class ServerTCPThreadOrigin extends Thread {
	private Socket socket = null;

	public ServerTCPThreadOrigin(Socket socket) {
		this.socket = socket;

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
					if (inputLine.equals("FastAndFurius")) {
						filename = "Origin/Fastandfurius.txt";
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
						filename = "Origin/Juego de tronos.txt";
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
						filename = "Origin/Mr.Robot.txt";
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
