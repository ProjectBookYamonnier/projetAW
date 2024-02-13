package unites;

import java.util.ArrayList;

import ressources.Affichage;
import ressources.Chemins;

public class Barge extends TypeNavale{

	public Barge(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		transporter = new ArrayList<>();
		capaciteMax = 2;
		capaciteActuelle = 0;
		prix = 4000;
		DifPlage = 1; //La barge peut aller sur la plage
		ptsDeplacement = 6;
		identifiant = "Barge";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = " Efficacite++ : Transport";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " Peut transporter 2 unite de TypeMarche";
		descriptionPart5 = " Pour rentrer il faut que l'unite de transport soit indisponible";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_BARGE));
		Affichage.affichePV(x, y, pv, false);
	}
	
}
