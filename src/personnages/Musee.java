package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		if (nbTrophees<200) {
			trophees[nbTrophees] = new Trophee(gaulois,equipement);
			nbTrophees++;
		}
	}

	public String extraireInstructionsCaml() {
		String texte = "let musee = [\n" ;
		
		for (int i = 0; i < nbTrophees; i++) {
			texte+="\""+trophees[i].donnerNom()+"\",";
			texte+="\""+trophees[i].getEquipement().toString()+"\"";
			if (i==nbTrophees-1)
				texte+=";";
			texte+="\n";
		}
		
		texte += "]";
		return texte;
	}
}