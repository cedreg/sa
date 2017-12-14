package server;

import java.net.*;
import java.io.*;

public class ClientWorker implements Runnable{

	private Socket client;
	
	public ClientWorker(Socket w) {
		this.client = w;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		String line;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			
			while(true) {
				line = in.readLine();
				out.println(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot read or write on client Socket");
		}
	}
	
	protected void finalize(){
		try {
			client.close();
		} catch (IOException e) {
			System.out.println("cannot close socket");
			System.exit(-1);
		}
	}

}
