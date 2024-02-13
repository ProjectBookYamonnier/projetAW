package unites;

import java.util.ArrayList;

import armes.MitrailleuseLourde;
import ressources.Affichage;
import ressources.Chemins;

public class PorteAvion extends TypeNavale {

	public PorteAvion(int x, int y, int equipe, boolean dispo) {
		super(x, y, equipe, dispo);
		possedeArmeMultiple = false;
		transporter = new ArrayList<>();
		capaciteMax = 2;
		capaciteActuelle = 0;
		arme = new MitrailleuseLourde(possedeArmeMultiple);
		prix = 9000;
		ptsDeplacement = 4;
		identifiant = "Porte-Avion";
		descriptionPart1 = " Son nom est "+ identifiant+ " et son type est " + id_type;
		descriptionPart2 = " Efficacite++ : TypeAerien & TypeMarche";
		descriptionPart3 = " Peut se deplacer de "+ptsDeplacement+" cases";
		descriptionPart4 = " la portee de son arme est de 1";
		descriptionPart5 = " Peut transporter 2 TypeAerien";
	}

	@Override
	public void afficheUnite() {
		if(pv > 0)Affichage.dessineImageDansCase(x, y, Chemins.getCheminUnite(equipe, dispo, Chemins.FICHIER_PORTEAVION));
		Affichage.affichePV(x, y, pv, false);
		
	}

	//Actions possible sur PorteAvion : Deplacer, Creer, Transporter
	
}
