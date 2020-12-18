package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import Client.ListeningThread;

public class Client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 1234);

			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			new ListeningThread(s).start();
			
			System.out.println("Connexion réussie!");
			Scanner sc = new Scanner(System.in);
			String message="";
			
			while (message!="fin") {
				message=sc.nextLine();
				out.println(message);
				
			}
			
			sc.close();
			
			
			} 
		catch(Exception e) {e.getMessage();}{
			
			// traitement d'erreur
		}
	}
}
