package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadBataille extends Thread{
int id;
BufferedReader in1;
PrintWriter out1;
BufferedReader in2;
PrintWriter out2;
Jeu gr1;
Jeu gr2;
String p1;
String p2;
/*static PrintWriter[] outs=new PrintWriter[100]; 
static int nbid=0;*/

public ThreadBataille(int id,Socket client1,Socket client2) {
	
	try {
		this.id=id;
		
		in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
		out1 = new PrintWriter(client1.getOutputStream(), true);
		
		in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
		out2 = new PrintWriter(client2.getOutputStream(), true);
		
		
		
		
	}
	
	catch (Exception e) {}
}

public String addBateauJ1() {
	try {
		gr1 = new Jeu();
		int i =0;
		int a1;
		int b1;
		int c1;
		int d1;
		while(i!=5) {
			
			out1.println("Il vous reste " + (5-i) + " bateaux à placer!" );
			out1.println("Entrer les coordonées d'un bateau (0-9):");
			
				out1.println("Ligne 1:");
				a1  = Integer.parseInt(in1.readLine());
			
				
				while (a1 >= 9) {
					out1.println("Ligne 1:");
					a1  = Integer.parseInt(in1.readLine());
				}
				
				out1.println("Ligne 2:");
				b1 = Integer.parseInt(in1.readLine());
				
				while (b1 >=9) {
					out1.println("Ligne 2:");
					b1 = Integer.parseInt(in1.readLine());
				}
				
				out1.println("Colonne 3:");
				c1 = Integer.parseInt(in1.readLine());
				while(c1 >=9) {
					out1.println("Colonne 3:");
					c1 = Integer.parseInt(in1.readLine());
				}
				
				out1.println("Colonne 4:");
				d1 = Integer.parseInt(in1.readLine());
				while(d1 >=9) {
					out1.println("Colonne 4:");
					d1 = Integer.parseInt(in1.readLine());
				}
			
			
			if(gr1.creerBateau(a1, b1, c1, d1) == true) {
				
				out1.println("Bateau créé!");
				i++;
			}
			else {
				if(gr1.testPos(a1-1, c1-1) == true || gr1.testPos(b1-1, d1-1) == true) {
					out1.println("Il y a déjà un bateau ici!");
				}
				else {
					out1.println("Coordonnées incorrectes : Un bateau fait maximum 5 cases !\n"
							+ "Vous devez inscrire la ligne1, ligne2, colonne1, colonne2\n"
							+ "Exemple (1,1,2,3) pour un bateau sur la ligne 1 de la colonne 2 à 3"
							+ "\n------------------------------------------------------------");
				}
			
			}
			
		}
		
		
		String grid1 = gr1.Afficher();
		return grid1;
		
	} 
	catch (Exception e) {
		// TODO: handle exception
	}
	return null;
}



public String addBateauJ2() {
	try {
		gr2 = new Jeu();
		String grid2;
		int i =0;
		while(i!=5) {
			out2.println("Il vous reste " + (5-i) + " bateaux à placer!" );
			out2.println("Entrer les coordonées d'un bateau (0-9):\n");
			
			out2.println("Ligne 1:");
			int a2 = Integer.parseInt(in2.readLine());
			while (a2 >= 9) {
				out1.println("Ligne 1:");
				a2 = Integer.parseInt(in1.readLine());
			}
			
			out2.println("Ligne 2:");
			int b2 = Integer.parseInt(in2.readLine());
			while (b2 >=9) {
				out2.println("Ligne 2:");
				b2 = Integer.parseInt(in2.readLine());
			}
			
			out2.println("Colonne 3:");
			int c2 = Integer.parseInt(in2.readLine());
			while(c2>=9) {
				out2.println("Colonne 3:");
				c2 = Integer.parseInt(in2.readLine());
			}
			
			out2.println("Colonne 4:");
			int d2 = Integer.parseInt(in2.readLine());
			while (d2>=9 || d2==0) {
				out2.println("Colonne 4:");
				d2 = Integer.parseInt(in2.readLine());
			}
			
			
			if(gr2.creerBateau(a2, b2, c2, d2) == true) {
				
				out2.println("Bateau créé!\n");
				i++;
			}
			else {
				if(gr2.testPos(a2-1, c2-1) == true || gr2.testPos(b2-1, d2-1)) {
					out2.println("Il y a déjà un bateau ici!");
				}
				else {
					out2.println("Coordonnées incorrectes : Un bateau fait maximum 5 cases !\n"
							+ "Vous devez inscrire la ligne1, ligne2, colonne1, colonne2\n"
							+ "Exemple (1,1,2,3) pour un bateau sur la ligne 1 de la case 2 à 3");
				}
			}
		}
		
		
		grid2 = gr2.Afficher();
		return grid2;
	} 
	catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	
	
}

	public boolean attackJ1() {
		try {
			out2.println(p1 +" vous attaque!");
			out1.println("Veuillez entrez des coordonnées pour attaquez " + p2 + " :");
			out1.println("X :"); int x = Integer.parseInt(in1.readLine());
			out1.println("Y :"); int y = Integer.parseInt(in1.readLine());
			if (gr2.attack(x, y)==true) {
				out1.println("Touché");
				return true;
			}
			else {
				out1.println("Non touché");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean attackJ2() {
		try {
			out1.println(p2 + " vous attaque!");
			out2.println("Veuillez entrez des coordonnées pour attaquez "+ p1 +" :");
			out2.println("X :"); int x = Integer.parseInt(in2.readLine());
			out2.println("Y :"); int y = Integer.parseInt(in2.readLine());
			if (gr1.attack(x, y)==true) {
				out2.println("Touché");
				return true;
			}
			else {
				out2.println("Non touché");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
	
	public boolean finDePartie() {
		int fin1 = gr1.fin();
		int touch1 = 0;
		
		int fin2= gr2.fin();
		int touch2 = 0;
				
		while (fin1 != touch1 && fin2 != touch2) {
			if (attackJ1()==true) {
				out1.println("Vous avez touché " + (touch2+1) + " fois " + p2);
				out2.println(p1 + " vous a touché " + (touch2+1) + " fois");
				touch2++;	
			}
			else {

				out2.println(p1 +" vous a raté");
			}
			
			
			if (attackJ2()==true) {
				out2.println("Vous avez touché " + (touch1+1) + " fois " +p1);
				out1.println(p2 + " vous a touché " + (touch1+1) + " fois");
				touch1++;	
			}
			else {
				out1.println(p2 + " vous a raté");
			}
		
			System.out.println(fin1 + " " + touch1);
			System.out.println(fin2 + " " + touch2);
		
		} 
		
		
		if(fin1==touch1) {
			return true;
		}
		else {
			return false;
		}
		
			

		
		
		
	}
	
	
	
	

	public void run() {
		try {
			
			
			out1.println("            --- Bienvenue dans cette bataille navale ! ---" 
					+ "                                                  "
					+ "                                                   "
					+ "   _  _                        <|\r\n"
					+ "    \\/              __'__     __'__      __'__\r\n"
					+ "                   /    /    /    /     /    /\r\n"
					+ "                  /\\____\\    \\____\\     \\____\\               _  _\r\n"
					+ "                 / ___!___   ___!___    ___!___               \\/\r\n"
					+ "               // (      (  (      (   (      (\r\n"
					+ "             / /   \\______\\  \\______\\   \\______\\\r\n"
					+ "           /  /   ____!_____ ___!______ ____!_____\r\n"
					+ "         /   /   /         //         //         /\r\n"
					+ "      /    /   |         ||         ||         |\r\n"
					+ "     /_____/     \\         \\\\         \\\\         \\\r\n"
					+ "           \\      \\_________\\\\_________\\\\_________\\\r\n"
					+ "            \\         |          |         |\r\n"
					+ "             \\________!__________!_________!________/\r\n"
					+ "              \\|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_/|\r\n"
					+ "               \\    _______________                /\r\n"
					+ "^^^^!^!^^^^!!^^^\\_\"/_)/_)_/_)__)/_)/)/)_)_\"_'_\"_//)/)/)/)^^^%!^^^^^^%^\r\n"
					+ "^!!^^^^^^^!^^^!!^^^^^^^^^^!^^^%%^^^^^^^^^^%^^^!!!!!!^^^^^^^^^^^^^^^^^^!\r\n"
					+ "-------------------------------------------------------------------------"
					+ "\n");
			
			out2.println("            --- Bienvenue dans cette bataille navale ! ---"
					+ "                                                  "
					+ "                                                   "
					+ "   _  _                        <|\r\n"
					+ "    \\/              __'__     __'__      __'__\r\n"
					+ "                   /    /    /    /     /    /\r\n"
					+ "                  /\\____\\    \\____\\     \\____\\               _  _\r\n"
					+ "                 / ___!___   ___!___    ___!___               \\/\r\n"
					+ "               // (      (  (      (   (      (\r\n"
					+ "             / /   \\______\\  \\______\\   \\______\\\r\n"
					+ "           /  /   ____!_____ ___!______ ____!_____\r\n"
					+ "         /   /   /         //         //         /\r\n"
					+ "      /    /   |         ||         ||         |\r\n"
					+ "     /_____/     \\         \\\\         \\\\         \\\r\n"
					+ "           \\      \\_________\\\\_________\\\\_________\\\r\n"
					+ "            \\         |          |         |\r\n"
					+ "             \\________!__________!_________!________/\r\n"
					+ "              \\|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_/|\r\n"
					+ "               \\    _______________                /\r\n"
					+ "^^^^!^!^^^^!!^^^\\_\"/_)/_)_/_)__)/_)/)/)_)_\"_'_\"_//)/)/)/)^^^%!^^^^^^%^\r\n"
					+ "^!!^^^^^^^!^^^!!^^^^^^^^^^!^^^%%^^^^^^^^^^%^^^!!!!!!^^^^^^^^^^^^^^^^^^!\r\n"
					+ "-------------------------------------------------------------------------"
					+ "\n");
			out1.println("--> Joueur 1, saississez votre nom : <--");
			out2.println("--> Le joueur 1 est entrain de saisir son nom. <--");
			p1 = in1.readLine();
			out1.println("--> Le joueur 2 est entrain de saisir son nom. <--");
			out2.println("--> Joueur 2, saississez votre nom : <--");
			p2 = in2.readLine();
			
			

			out1.println("--> " + p1 + " doit placer ses bateaux ! <--");
			out2.println("--> " + p1 + " doit placer ses bateaux ! <--");
			out1.println(addBateauJ1());
			
			out1.println("--> " + p2 + " doit placer ses bateaux ! <--");
			out2.println("--> " + p2 + " doit placer ses bateaux ! <--");
			out2.println(addBateauJ2());
			
			if(finDePartie()==true) {
				out1.println("\n--- "+ p2 + " gagne ! ---");
				out2.println("\n--- " + p2 +" gagne ! ---");
			
			}
			else {
				
				out1.println("\n--- " + p1 +" gagne ! ---");
				out2.println("\n--- "+ p1 +" gagne ! ---");
			}
				
				
				

			
			
	}
	catch (Exception e) {}
}
}