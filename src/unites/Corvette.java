package unites;

import armes.Canon;
import ressources.Affichage;
import ressources.Chemins;

public class Corvette extends TypeNavale {

	public Corvette(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		transport = true;
		possedeArmeMultiple = false;
		arme = new Canon(possedeArmeMultiple);
		prix = 6500;
		ptsDeplacement = 7;
		identifiant = "Corvette";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeChenilles & TypeMarche";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Elle peut transporter 1 unite de TypeMarche";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_CORVETTE));
		Affichage.affichePV(x, y, pv, false);
	}

}
