package unites;

import armes.MitrailleuseLourde;
import ressources.Affichage;
import ressources.Chemins;

public class DCA extends TypeChenilles {
    
    public DCA(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = false;
		arme = new MitrailleuseLourde(possedeArmeMultiple);
		prix = 6000;
		ptsDeplacement = 6;
		identifiant = "DCA";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeMarche & TypeAerien";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
    }

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_ANTIAIR));
		Affichage.affichePV(x, y, pv, false);
	}

}
