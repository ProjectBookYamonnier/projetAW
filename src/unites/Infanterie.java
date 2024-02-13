package unites;

import armes.MitrailleuseLegere;
import ressources.Affichage;
import ressources.Chemins;

public class Infanterie extends TypeMarche {
    
    public Infanterie(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = false;
		arme = new MitrailleuseLegere(possedeArmeMultiple);
		prix = 1500;
		ptsDeplacement = 3;
		identifiant = "Infanterie";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeMarche";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_INFANTERIE));
		Affichage.affichePV(x, y, pv, false);
	}
    
    

}
