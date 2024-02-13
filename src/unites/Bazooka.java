package unites;

import armes.Canon;
import ressources.Affichage;
import ressources.Chemins;

public class Bazooka extends TypeMarche {
	
	public Bazooka(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = false;
        arme = new Canon(possedeArmeMultiple);
        prix = 3500;
        ptsDeplacement = 2;
        identifiant = "Bazooka";
        descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
        descriptionPart2 = "Efficacite++ : TypeChenilles & TypeNavale";
        descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
    }
	
	@Override
	public void attaquer(Unite defenseuse) {
		if (!(defenseuse instanceof Bombardier)) {
			super.attaquer(defenseuse);
		}
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_BAZOOKA));
		Affichage.affichePV(x, y, pv, false);
	}
	
	

}
