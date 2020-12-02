package Client;

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
	Chat Serveur;
	Scanner sc;
	int msgCount = 0;

	
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (Chat)Naming.lookup("//localhost/ChatRMI");
		sc = new Scanner(System.in);
		try {
			new PollThread(Serveur).start();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println(e);
		}
	
	}
	
	
	
	public static void main(String args[]) throws Exception {
        Client chatClient = new Client();       
        System.out.println(chatClient.Serveur.messageBienvenue());
        
        System.out.println("Veuillez entrer votre nom : ");
        String client = chatClient.sc.nextLine();
        
        
        
        
        System.out.println("Conversation ('exit' pour se déconnecter):");
        System.out.println("Nouvel utilisateur s'est connecté!");
        chatClient.Serveur.getClient(client);
        while(true) {
        	
        
        	String message = null;
        	
        	
          	message = chatClient.sc.nextLine();
          	
          	if(!message.equals("exit")) {
          		
             	chatClient.Serveur.envoiMessage(client,message);
          	}
          	else {
          		System.out.println("Vous avez quitté le chat.");
          		System.out.println(client + " s'est déconnecté");
          		break;
          	}
          	
        }
    	System.out.println("Fermeture de la conversation."); 
        
       
        
	}
        
        

     
       	
    }



	
