package histoire;

import personnages.Gaulois;
import personnages.Musee;
import personnages.Druide;
import personnages.Equipement;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix = new Gaulois("Obelix",10);
		Druide panoramix = new Druide("Panoramix",5,10);
		Romain minus = new Romain("Minus",1);
		Musee louvrix = new Musee();
		panoramix.parler("Je vais aller preparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Belenos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour a  tous");
		minus.parler("UN GAU... UN GAUGAU...");
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.faireUneDonnation(louvrix);
		System.out.println(louvrix.extraireInstructionsCaml());
	}

}