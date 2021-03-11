import java.util.Random;

public class Nourriture {

	int positionLigne, positionColonne;
	Random rand = new Random();

	public Nourriture(int positionLigne, int positionColonne) {
		super();
		this.positionLigne = positionLigne;
		this.positionColonne = positionColonne;
	}

	public Nourriture() {
		this.positionLigne = rand.nextInt(5); // position du clic à terme
		this.positionColonne = rand.nextInt(10); // position du clic à terme
	}
	
	
}
