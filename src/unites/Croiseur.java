package unites;

import armes.Canon;
import armes.MitrailleuseLourde;
import ressources.Affichage;
import ressources.Chemins;

public class Croiseur extends TypeNavale{

	public Croiseur(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		possedeArmeMultiple = true;
		arme = new Canon(possedeArmeMultiple);
		arme2 = new MitrailleuseLourde(possedeArmeMultiple);
		prix = 4500;
		ptsDeplacement = 6;
		identifiant = "Croiseur";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeChenilles & TypeMarche";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_CROISEUR));
		Affichage.affichePV(x, y, pv, false);
	}
}
