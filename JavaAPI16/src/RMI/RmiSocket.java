package RMI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;


public class RmiSocket extends RMISocketFactory {

	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("creating ServerSocket on port " + port);
		return new ServerSocket(port);
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("creating socket to host : " + host + " on port " + port);
		return new Socket(host,port);
	}

}

