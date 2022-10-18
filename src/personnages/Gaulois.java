package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees = 0;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
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
		return "Le gaulois " + nom + " : ";
		}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) *effetPotion); 
		for (int i = 0; trophee != null && i < trophee.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
			+ ", effetPotion=" + effetPotion + "]";
	}
	public void boirePotion(int forcePotion) {
		System.out.println("Merci Druide, je sens que ma force est "+ forcePotion +" fois décuplée. ");
		this.effetPotion = forcePotion;
	}
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees>0)
			parler("Je donne tous mes trophées au musée \n");
		for (int i = 1; i < nbTrophees; i++,nbTrophees--) {
			System.out.println("- "+trophees[i-1].toString()+"\n");
			musee.donnerTrophee(this, trophees[i-1]);
			trophees[i-1] = null;
			
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("asterix",118218);
		System.out.println(asterix.getNom());
		asterix.parler("asterix est là c'est la bagarre !");
		Romain romain = new Romain("romain",-1);
		asterix.frapper(romain);
		asterix.toString();
	}
}
