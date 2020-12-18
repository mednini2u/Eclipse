package Server;

import java.util.Scanner;

public class Jeu {
	int[][] grille;
	int count = 0;
	
	public Jeu() {
		grille = new int[10][10];
		for(int j=0;j< grille.length;j++) {
			for(int i=0;i<grille.length;i++) {
				grille[i][j] = 0;
			}
		}
		
		
	}
	
	
	
	
	
	public String Afficher() {
		String grid = "---> \nVotre grille : \n"  
						+ "\n    0 1 2 3 4 5 6 7 8 9"
						+ "\n    -------------------\n";
		
		for(int j=0;j< grille.length;j++) {
			grid += j + " | ";
			for(int i=0;i<grille.length;i++) {
				
	
				grid += grille[i][j] + " ";
			}
			grid += "\n";
		}
		
		return grid;
		
	}
	
	
	public boolean testPos(int lin, int col) {
		if (grille[lin][col] == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	public boolean creerBateau(int lin1, int lin2, int col1, int col2) {
		int valLin = Math.abs(lin1-lin2);
		int valCol = Math.abs(col1-col2);
		boolean batcr= false;

		if(lin1<=9 && lin2<=9 && col1<=9 && col2<=9) {
			
		
		if (lin1 == lin2 && col1 != col2 && valCol<5) {
			if(col1<col2) {
				for(int i =col1;i<col2+1;i++) {
					if(testPos(i-1,lin1-1)==false) {
						grille[i-1][lin1-1] = 1;
						batcr = true;
					}
					else {
						System.out.println("Il y a déjà un bateau ici : Ligne " + lin1);
						batcr = false;
						
					}
				}
			}
			else {
				for(int i = col2;i<col1+1;i++) {
					if(testPos(i-1,lin1-1)==false) {
						grille[i-1][lin1-1] = 1;
						batcr = true;
					}
					else {
						System.out.println("Il y a déjà un bateau ici : Ligne " + lin1);
						batcr = false;
					}
					
				}
			}
		}
		
	
		
		else if (lin1 != lin2 && col1 == col2 && valLin<5) {
			if(lin1<lin2) {
				for(int i =lin1;i<lin2+1;i++) {
					if(testPos(col1-1,i-1)==false) {
						grille[col1-1][i-1] = 1;
						batcr = true;
					}
					else {
						System.out.println("Il y a déjà un bateau ici : Colonne " + col1);
						batcr = false;
					}
				}
			}
			else {
				for(int i =lin2;i<lin1+1;i++) {
					if(testPos(col1-1,i-1)==false) {
						grille[col1-1][i-1] = 1;
						batcr = true;
					}
					else {
						System.out.println("Il y a déjà un bateau ici : Colonne " + col1);
						batcr = false;
					}
					
				}
			}
		}
		
		
		
		else if(lin1 == lin2 && col1 == col2) {
			 	if(testPos(lin1-1,col1-1)==false) {
					grille[lin1-1][col1-1] = 1;
					batcr = true;
				}
				else {
					System.out.println("Il y a déjà un bateau ici : Colonne " + col1);
					batcr = false;
				}
		}
		
		else {
			batcr = false;
		}
			return batcr;
		}
		
		
		else {
			batcr = false;
			return batcr;
		}
	}
		
	
	
	
	public boolean attack(int l, int c) {
		
		if(grille[c][l] == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int fin() {
			for(int i = 0; i<grille.length; i++){
				for(int j = 0; j<grille[i].length; j++){
					if(testPos(i,j)==true){
						count++;
					}
				}
			}

		return count;
	}
		
	
	
	
	
/*
	public static void main(String[] args) {
		Jeu cr = new Jeu();
		Jeu cr1 = new Jeu();
		
		 Scanner in = new Scanner(System.in);
		cr.creerBateau(2,2,2,5);
		System.out.println(cr.Afficher());
		int touch = 0;
		
		
		int fin = cr.fin();
		
		
	
		do {
			System.out.println("Attaquez:");
			System.out.println("X :");int x = in.nextInt();
			System.out.println("Y :");int y = in.nextInt();
			if (cr.attack(x, y)==true) {
				System.out.println(fin);
				System.out.println("Touché " + (touch+1) + " fois");
				touch++;
				
			}
			else {
				System.out.println("Non touché");
			}
		
		
		} while (fin!=touch);
		
		System.out.println("Partie finie");
		}
		
*/	

	
	
	
	
}
