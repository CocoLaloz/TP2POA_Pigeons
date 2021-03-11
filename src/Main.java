import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int ligne=5; //UserAnswer
	static int colonne=10;//UserAnswer
	static int nbPigeon=5;//UserAnswer
	static KeyEvent e;
	static Scanner sc = new Scanner(System.in);


	static HashMap<Integer, Pigeon> mesPigeonsMap= new HashMap<Integer, Pigeon>();;
	static ArrayList<Pigeon> mesPigeons = new ArrayList<Pigeon>();
	
	
	
	
	public static void main(String[] args) {
		// Génération de la carte vide

		Carte maCarte = new Carte(ligne,colonne);
		maCarte.initialiserCarte();
		maCarte.affichageCarte();
		// Initialisation des pigeons

		creationPigeon(nbPigeon);
		maCarte.initialisationPigeon(mesPigeons);
	
		while (true) {
			//if(e.getKeyCode() == KeyEvent.VK_SPACE) { //Au clic
				
			System.out.println("bouffe ?");
			int a=sc.nextInt();
				if(a==1) {
					creationNourriture(maCarte);
				}
			//}
				maCarte.actualisationPositionPigeon(mesPigeons);
				maCarte.affichageCarte();
		}
	}


	public static void creationPigeon(int nombreDePigeons) {
		for(int i =0; i<nombreDePigeons; i++) {
			Pigeon monPigeon = new Pigeon(ligne, colonne);
			mesPigeonsMap.put(i, monPigeon);
			mesPigeons.add((Pigeon) mesPigeonsMap.get(i));
			Thread monThread = new Thread(monPigeon);
			monThread.start();
		}
	}
	public static void creationNourriture(Carte maCarte) {
		int x,y;//On recup les positions du clic
		//On donne les positions en argument
		System.out.println("entrer la position de la nourriture");
		x= sc.nextInt();
		y= sc.nextInt();
		Nourriture maNourriture = new Nourriture(x,y); 
		if(maCarte.plateau[x][y] == 0) {
			maCarte.plateau[x][y]=2;
		}
		else {
			System.out.println("l'emplacement ne peut pas acceuillir de nourriture");
		}			
		for(int i =0; i<mesPigeons.size(); i++) {
			mesPigeons.get(i).setState(EtatsPigeon.actif);
			mesPigeons.get(i).setPositionFood(x, y);
		}
	}

}
