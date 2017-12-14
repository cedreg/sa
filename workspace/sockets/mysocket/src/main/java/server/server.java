package server;

import java.net.*;
import server.ClientWorker;
import java.io.*;

public class server {
	
	public static void main(String argv[]) throws IOException{
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9001);
			
			while(true) {
				ClientWorker cw = new ClientWorker(ss.accept());
				Thread t = new Thread(cw);
				t.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		ss.close();
	}
}
