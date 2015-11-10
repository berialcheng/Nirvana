package org.nirvana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Blocked IO Server
 * 
 */
public class BIOServer {

	ServerSocket server = null;

	public void initServer(int port) throws IOException {
		server = new ServerSocket(port, 1);
	}

	public void listen() {
		try {
			String str = null;
			while (true) {
				try {
					Socket socket = server.accept();

					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

					while ((str = reader.readLine()) != null) {
						// Print out the client side content
						System.out.println(socket.getRemoteSocketAddress() + "|" + socket.getPort() + "|" + str);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} finally {
			try {
				if (server != null) {
					server.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BIOServer server = new BIOServer();
		server.initServer(8085);
		server.listen();
	}

}
