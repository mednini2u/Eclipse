package Client;

import java.io.IOException;
import java.lang.Thread;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Serveur.Chat;

public class PollThread extends Thread{
	
	ArrayList<String> message;
	//String clients;
	
	Chat serveur;
	int msgCount =0;

	public PollThread(Chat serveur) throws IOException{
		// TODO Auto-generated constructor stub
		this.serveur = serveur;
		message = serveur.recupMessage(0);
		//clients = serveur.getNom();
		
		
	}
	
	public void run(){
	
		
		
		while(true) {
			ArrayList<String> msg = new ArrayList<String>();	
			
			
			try {
				
			
			
			msg = serveur.recupMessage(message.size());
			
			
			for(int i = 0; i<msg.size(); i++) {
				
				message.add(msg.get(i));
				
				msgCount++;
				//System.out.println("(" + msgCount + " messages envoyés.)");
				System.out.println(msg.get(i));
				
			}
			
			} catch (RemoteException e) {
			
			e.printStackTrace();
			System.out.println(e);
			}
				
				
					
					
		} 
			
	}
	
	
	
	
}
