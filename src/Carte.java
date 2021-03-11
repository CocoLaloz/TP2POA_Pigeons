import java.util.ArrayList;

public class Carte {

	int plateau [][];


	public Carte(int ligne, int colonne) {
		super();
		this.plateau = new int[ligne][colonne];
	}

	// Méthodes

	/*
	 * initialiserCarte : création d'un table rempli de 0
	 */
	public void initialiserCarte() {
		for (int i = 0 ; i < this.plateau.length ; i ++) {
			for (int j = 0 ; j < this.plateau[0].length ; j ++) {
				plateau[i][j] = 0;
			}
		}
	}

	/*
	 * affichageCarte : affiche le tableau dans la console
	 */
	public void affichageCarte() {
		for (int i = 0 ; i < this.plateau.length ; i ++) {
			for (int j = 0 ; j < this.plateau[0].length ; j ++) {
				System.out.print("|" + plateau[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}

	public void actualisationPositionPigeon(ArrayList<Pigeon> mesPigeons) {
		
		if(testNourritureMangée(mesPigeons)==false) {
			destructionPosition();
			for (int i =0; i < mesPigeons.size(); i++) {
				this.plateau[mesPigeons.get(i).positionLigne][mesPigeons.get(i).positionColonne]=1;
			}
		}
		else {
			for (int i =0; i < mesPigeons.size(); i++) {
				mesPigeons.get(i).setState(EtatsPigeon.endormi);
				mesPigeons.get(i).setPositionFood(-1, -1); //Position absence nourriture
				//Nourriture moins fraiche mais présente
			}
		}
	}

	public boolean testNourritureMangée(ArrayList<Pigeon> mesPigeons) {
		for (int i =0; i < mesPigeons.size(); i++) {
			if(this.plateau[mesPigeons.get(i).positionLigne][mesPigeons.get(i).positionColonne]==2) {
				System.out.println("nourriture mangée");
				this.plateau[mesPigeons.get(i).positionLigne][mesPigeons.get(i).positionColonne]=0;
				return true;
			}
		}
		return false;
	}

	public void destructionPosition() {
		for (int i = 0 ; i < this.plateau.length ; i ++) {
			for (int j = 0 ; j < this.plateau[0].length ; j ++) {
				if(plateau[i][j]!= 2) {
					plateau[i][j] = 0;}
			}
		}
	}
	public void initialisationPigeon (ArrayList<Pigeon>  mesPigeons) {
		for (int i =0; i < mesPigeons.size(); i++) {
			this.plateau[mesPigeons.get(i).positionLigne][mesPigeons.get(i).positionColonne]=1;
		}
	}

}