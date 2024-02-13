package unites;

import armes.Canon;
import armes.MitrailleuseLegere;
import ressources.Affichage;
import ressources.Chemins;

public class Tank extends TypeChenilles {
    
    public Tank(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        possedeArmeMultiple = true;
		arme = new Canon(possedeArmeMultiple);
		arme2 = new MitrailleuseLegere(possedeArmeMultiple);
		prix = 7000;
		ptsDeplacement = 6;
		identifiant = "Tank";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeChenilles & TypeMarche";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de est arme est de 1 et de "+arme.getPorteeMin()+ " a "+ arme.getPorteeMax();
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
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_TANK));
		Affichage.affichePV(x, y, pv, false);
	}
}
