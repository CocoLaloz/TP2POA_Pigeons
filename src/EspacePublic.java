import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EspacePublic extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton[][] mesPaves = new JButton[5][10];  
	private ImageIcon PIGEON = new ImageIcon(getClass().getResource("images/pigeon.png")); 
	private ImageIcon NOURRITURE = new ImageIcon(getClass().getResource("images/nourriture.png"));

	public EspacePublic() {
		setTitle("Place Publique"); 
		setSize(1200, 600);   
		setLayout(new GridLayout(5,10)); 
		Container c = getContentPane();    

		for(int i =0;i<5;i++) {
			for(int j = 0;j<10;j++) {
				mesPaves[i][j]= new JButton();
				c.add(mesPaves[i][j]);
			}
		}
		this.repaint();
	      
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true);
	}
	
	/*
	 * sert à placer les pigeons sur l'espace public
	 */
	public void placementPigeons(int i, int j, String etatsDuPigeon) {
		mesPaves[i][j].setIcon(retourneImage(etatsDuPigeon));
		try {
			mesPaves[i][j].setIcon(retourneImage(etatsDuPigeon));
		}catch(Exception ex) {
		}
		this.repaint();			
	}
	
	/*
	 * sert à placer la nourriture en cliquant
	 */
	
	public void placementNourriture() {
		
	}
	
	/*
	 * renvoie l'image du pigeon ou de la nourriture
	 */
	
	public ImageIcon retourneImage(String pigeonOuNourriture) {
		ImageIcon img = new ImageIcon();
		if(pigeonOuNourriture.matches("1")) {
			img = PIGEON;
		}
		else {
			img = NOURRITURE;
		}
		return img;
	}






}
