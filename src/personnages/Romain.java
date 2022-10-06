package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;
	
	public Romain(String nom, int force) {
		assert force>=0; 
		this.nom = nom;
		this.force = force;
		
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert force>=0;
		int forceinit = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		assert forceinit<force;
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 2: {
			System.out.println("le soldat "+nom+" est déjà bien protégé");
			break;
		}
		case 1:{
			if (equipements[0] == equipement) {
				System.out.println("le soldat "+nom+" a déjà un "+equipement);
			}
			else {
				equipe(equipement);
			}
			break;
		}
		default:
			equipe(equipement);
			break;
		}
	}
	private void equipe(Equipement equipement) {
		equipements[0] = equipement;
		nbEquipements++;
		System.out.println("le soldat "+nom+" s'equipe avec un "+equipement);

	}
	
	public static void main(String[] args) {
		Romain romain = new Romain("romain",6);
		romain.parler("Je suis ROMAIN");
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
	}
}
