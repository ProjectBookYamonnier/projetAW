package unites;

import armes.Bombes;
import ressources.Affichage;
import ressources.Chemins;

public class Bombardier extends TypeAerien {

	public Bombardier(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = false;
        arme = new Bombes(possedeArmeMultiple);
        prix = 20000;
        ptsDeplacement = 7;
        identifiant = "Bombardier";
        descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
        descriptionPart2 = "Efficacite++ : Tous Type sauf TypeAerien";
        descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
    }
	
	@Override
	public void attaquer(Unite defenseuse) {
		if (!(defenseuse instanceof Bombardier || defenseuse instanceof Helicoptere)) {
			super.attaquer(defenseuse);
		}
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_BOMBARDIER));
		Affichage.affichePV(x, y, pv, false);
	}
	
	

}
