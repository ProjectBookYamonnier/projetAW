package unites;

import armes.Mortier;
import ressources.Affichage;
import ressources.Chemins;

public class Artillerie extends TypeChenilles {

	public Artillerie(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = false;
		arme = new Mortier(possedeArmeMultiple);
		prix = 6000;
		ptsDeplacement = 5;
		identifiant = "Artillerie";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeChenilles & TypeNavale";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_ARTILLERIE));
		Affichage.affichePV(x, y, pv, false);
	}
	
}
