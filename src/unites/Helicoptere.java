package unites;

import java.util.ArrayList;

import armes.Missiles;
import armes.MitrailleuseLourde;
import ressources.Affichage;
import ressources.Chemins;

public class Helicoptere extends TypeAerien {
    
	TypeMarche Transporter;
	
    public Helicoptere(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = true;
        transporter = new ArrayList<>();
		capaciteMax = 1;
		capaciteActuelle = 0;
		arme = new Missiles(possedeArmeMultiple);
		arme2 = new MitrailleuseLourde(possedeArmeMultiple);
		prix = 12000;
		ptsDeplacement = 6;
		identifiant = "Helicoptere";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeChenilles & TypeMarche";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Peut transporter une unite de typeMarche";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_HELICOPTERE));
		Affichage.affichePV(x, y, pv, false);
	}
    
    

}
