package unites;

import armes.MissilesSol_Air;
import ressources.Affichage;
import ressources.Chemins;

public class LanceMissilesSolAir extends TypeChenilles {

	public LanceMissilesSolAir(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		possedeArmeMultiple = false;
		arme = new MissilesSol_Air(possedeArmeMultiple);
		prix = 12000;
		ptsDeplacement = 5;
		identifiant = "Lance-Missile";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeAerien";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de "+arme.getPorteeMin()+ " a "+arme.getPorteeMax();
		descriptionPart5 = " Ne peut pas transporter d'unites";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_SOLAIR));
		Affichage.affichePV(x, y, pv, false);
	}

}
