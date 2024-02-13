package unites;

import ressources.Affichage;
import ressources.Chemins;

public class Convoi extends TypeChenilles {
	
	public Convoi(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		transport = true;
        prix = 5000;
        ptsDeplacement = 6;
        identifiant = "Convoi";
        descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
        descriptionPart2 = "Efficacite++ : Transport";
        descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " Peut transporter une unite de TypeMarche";
		descriptionPart5 = " Pour rentrer il faut que l'unite de transport soit indisponible";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_GENIE));
		Affichage.affichePV(x, y, pv, false);
	}

}
