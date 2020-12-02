package Serveur;


import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serveur extends UnicastRemoteObject implements Chat{
	private static final long serialVersionUID = 1L;
	Scanner sc = new Scanner(System.in);
	
	
	String nom;
	
	public Serveur() throws RemoteException {
		super();
		
	}

	
	public String messageBienvenue() throws RemoteException{
		return "Bienvenue!";
	}
	
	
	public void envoiMessage(String client, String msg) throws RemoteException {

		message.add(client + " : " + msg);

		
	}
	/*
	public String getNom() {
		return nom;
		
	}
	*/
	public synchronized ArrayList<String> getClient(String nom) throws RemoteException{
		String rep = nom + " : Un nouvel utilisateur vient d'arriver dans le chat !";
		Clients.add(nom);
		System.out.println(rep);
		return Clients;
	
		
	}
	
	
	
	public synchronized ArrayList<String> recupMessage(int pos) throws RemoteException {
		ArrayList<String> msg = new ArrayList<String>();
		
			for(int i = pos; i< message.size() ; i++) {

				msg.add(message.get(i));
			}
		
		return msg;
		
	}


	
	

	 public static void main(String args[]) throws Exception {
		 
	 	 try { 
	            LocateRegistry.createRegistry(1099); 
	        } catch (RemoteException e) {
	        }
	        Serveur chatServeur = new Serveur();
	        Naming.rebind("//localhost/ChatRMI", chatServeur);
	        System.out.println("Serveur prêt!");     
	
	    
		 
	 }


	


	
	
	

}