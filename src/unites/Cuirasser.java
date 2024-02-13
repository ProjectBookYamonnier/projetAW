package unites;

import armes.Mortier;
import ressources.Affichage;
import ressources.Chemins;

public class Cuirasser extends TypeNavale {

	public Cuirasser(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		possedeArmeMultiple = false;
		arme = new Mortier(possedeArmeMultiple); 
		arme.setPorteeMin(3);
		arme.setPorteeMax(5);
		prix = 8000;
		ptsDeplacement = 4;
		identifiant = "Cuirasser";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = "Efficacite++ : TypeChenilles & TypeNavale";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " La portee de son arme est de " + arme.getPorteeMin()+" a "+ arme.getPorteeMax();
		descriptionPart5 = " Ne peut pas transporter d'unites";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_CUIRASSER));
		Affichage.affichePV(x, y, pv, false);
	}

	//Actions possible sur PorteAvion : Deplacer, Attaquer
}
