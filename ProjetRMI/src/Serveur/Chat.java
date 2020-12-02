package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;



public interface Chat extends Remote{

	public String messageBienvenue() throws RemoteException;
	
	public ArrayList<String> message  = new ArrayList<String>();
	
	public void envoiMessage(String client, String msg) throws RemoteException;
	
	public ArrayList<String> recupMessage(int pos) throws RemoteException;
	
	public ArrayList<String> getClient(String nom) throws RemoteException;
	
	public ArrayList<String> Clients = new ArrayList<String>() ;

	
	
	


}