package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
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

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("le soldat "+nom+" est déjà bien protégé");
			break;
		}
		case 1:{
			if (equipements[0] == equipement || equipements[1] == equipement) {
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
		if (nbEquipement != 2) {
		if (equipements[0]==null)
			equipements[0] = equipement;
		else
			equipements[1] = equipement;
		nbEquipement++;
		System.out.println("le soldat "+nom+" s'equipe avec un "+equipement);
		}
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		assert force > 0;
		int oldForce = force;
			forceCoup = calculResistanceEquipement(forceCoup);
			force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
				texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} if ((equipements[i] != null && equipements[i].equals(Equipement.CASQUE))) {
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
			}
		parler(texte);
		if (resistanceEquipement>0)
			forceCoup -= resistanceEquipement;
		
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte]=equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
			return equipementEjecte;
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
