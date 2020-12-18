package Server;

import java.net.ServerSocket;
import java.net.Socket;

import Server.ThreadBataille;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ecoute = new ServerSocket(1234);
	
			
			System.out.println("Serveur lancé!");
			int id=0;

			while(true) {
				Socket client1 = ecoute.accept();
				Socket client2 = ecoute.accept();
				new ThreadBataille(id,client1,client2).start();
				id++;
				}
			
			} 
		
		
		catch(Exception e) {e.getMessage();}{
			// traitement d'erreur
		}
	}
	
}
