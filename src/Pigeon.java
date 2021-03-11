import java.util.Random;

public class Pigeon implements Runnable{

	int positionLigne, positionColonne;
	Random rand = new Random();
	EtatsPigeon etat;
	int positionLigneNourriture, positionColonneNourriture;
	public Pigeon(int nombreLigne, int nombreColonne) {
		super();
		this.positionColonneNourriture=-1; //Absence de nourriture
		this.positionLigneNourriture=-1;
		setState(EtatsPigeon.endormi);
		boolean successLigne = false;
		boolean successColonne = false;
		while (successLigne==false){
			int ligneCandidat = rand.nextInt(nombreLigne);
			if(ligneCandidat<nombreLigne+1 && ligneCandidat>=0) {
				this.positionLigne = ligneCandidat;
				successLigne=true;
			}
		}
		while(successColonne==false) {
			int colonneCandidat = rand.nextInt(nombreColonne);

			if(colonneCandidat<nombreColonne+1 && colonneCandidat>=0) {
				this.positionColonne = colonneCandidat ;
				successColonne=true;
			}
		}
	}

	public void setState(EtatsPigeon state){
		this.etat=state;
	}

	public void setPositionFood(int ligneNourriture, int colonneNourriture) {
		this.positionLigneNourriture=ligneNourriture;
		this.positionColonneNourriture=colonneNourriture;
	}

	public void deplacement() {
		if(this.positionColonne<this.positionColonneNourriture) {
			positionColonne++;
		}
		else if (this.positionColonne>this.positionColonneNourriture) {
			positionColonne--;
		}
		if(this.positionLigne<this.positionLigneNourriture && positionColonne==positionColonneNourriture) {
			positionLigne++;
		}
		else if(this.positionLigne>this.positionLigneNourriture && positionColonne==positionColonneNourriture) {
			positionLigne--;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(this.etat==EtatsPigeon.actif) {
				deplacement();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(this.etat==EtatsPigeon.endormi) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}



