package habitations;
import java.util.Iterator;

import personnages.*;

public class Village {
	private String nom;
	private Chef chef;
	private int nbHabitants = 0;
	private Gaulois[] habitants;

	public Village(String nom,int nbHabitantsMax) {
		this.nom = nom;
		this.habitants = new Gaulois[nbHabitantsMax];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbHabitants >= habitants.length)
			return;
		habitants[nbHabitants] = gaulois;
		nbHabitants ++;
	}
	
	public Gaulois trouverVillageois(int n) {
		return habitants[n];
	}
	public void afficherVillageois() {
		System.out.println("Chef = " + chef.getNom());
		for (int i = 0; i < nbHabitants; i++) {
			System.out.println(habitants[i]);
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("village des irreductibles",30);
//		Gaulois gaulois = village.trouverVillageois(30)
//		ne trouve pas car dépassement du max
		Chef abra = new Chef("abraraccourcix",6,1,village);
		village.setChef(abra);
		Gaulois aste = new Gaulois("Asterix", 8);
		village.ajouterHabitant(aste);
//		Gaulois gaulois = village.trouverVillageois(1)
//		erreur car il n'y a qu'un villageois au niveau 0
		Gaulois obelisque = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelisque);
		village.afficherVillageois();
	}
}
