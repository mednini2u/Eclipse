/*package CB;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


import Serveur.Chat;

public class Client {
	private static final long serialVersionUID = 1L;
	Client Serveur;
	static Scanner sc;
	int msgCount = 0;

	
	
	public Client(String nom) throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (Client) Naming.lookup("//localhost/ChatRMICB");
		sc = new Scanner(System.in);
	
	}
	
	
	
	public static void main(String args[]) throws Exception {
  
        System.out.println("Veuillez entrer votre nom : ");
        String nom = sc.nextLine();
        
        ClientCallB chatClient = new Client(nom);
        
     
       
        
	}
        
        

     
       	
    }


*/
	
