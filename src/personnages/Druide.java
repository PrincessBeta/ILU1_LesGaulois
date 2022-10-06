package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + 
				" et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion() {
		Random random = new Random();
		int effet = random.nextInt(effetPotionMax-effetPotionMin)+effetPotionMin;
		if (effet>7)
			System.out.println("j'ai préparé une super potion de force" + effet);
		else
			System.out.println("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force "+ effet);
		return effet;		
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom().equals("Obelix")) {
			System.out.println("Non, Obélix !... Tu n’auras pas de potion magique ! ");
			return;
		}
		gaulois.boirePotion(forcePotion);
		
	}
	public static void main(String[] args) {
		Druide panoramix = new Druide("panoramix", 5, 10);
		panoramix.preparerPotion();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}