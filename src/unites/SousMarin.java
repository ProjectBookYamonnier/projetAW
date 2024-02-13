package unites;

import armes.Torpille;
import ressources.Affichage;
import ressources.Chemins;

public class SousMarin extends TypeNavale {

	public SousMarin(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		possedeArmeMultiple = false;
		arme = new Torpille(possedeArmeMultiple);
		prix = 10000;
		ptsDeplacement = 6;
		identifiant = "Sous-Marin";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeNavale";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de 1";
		descriptionPart5 = " Ne peut pas transporter d'unites";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_SOUSMARIN));
		Affichage.affichePV(x, y, pv, false);
	}

	//Actions possible sur PorteAvion : Deplacer, Plonger, Faire Surface, Transporter, Attaquer
	//Si il est a la surface toutes les unite le voit et donc peuvent l'attaquer
	//Sinon il y a que le croiseur et le sous-marin qui peuvent l'atteindre sauf si l'unite est adjacentes 
	
}
