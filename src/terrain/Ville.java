package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class Ville extends Propriete {

    public Ville(int x, int y, int statut) {
        super(x,y,statut);
        identifiant = "Ville";
    }

	@Override
	public void afficheTerrain() {
		Affichage.dessineImageDansCase(x, y, Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, statut));
		Affichage.affichePV(x, y, pv, true);
	}
    
    

}