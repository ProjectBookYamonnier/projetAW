package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class QG extends Propriete {

     public QG(int x, int y, int statut) {
         super(x,y,statut);
         identifiant = "QG";
     }
    
	@Override
	public void afficheTerrain() {
		Affichage.dessineImageDansCase(x, y, Chemins.getCheminPropriete(Chemins.FICHIER_QG, statut));
		Affichage.affichePV(x, y, pv, true);
	}

}