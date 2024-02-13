package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class Montagne extends Terrain {

    public Montagne(int x, int y) {
        super(x, y);
        identifiant = "Montagne";
    }
    
    @Override
    public void afficheTerrain() {
    	Affichage.dessineImageDansCase(x, y, Chemins.getCheminTerrain(Chemins.FICHIER_MONTAGNE));
    }

}