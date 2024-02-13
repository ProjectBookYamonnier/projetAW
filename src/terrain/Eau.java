package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class Eau extends Terrain {

    public Eau(int x, int y) {
        super(x,y);
        identifiant = "Eau";
    }
    
    @Override
    public void afficheTerrain() {
    	Affichage.dessineImageDansCase(x, y, Chemins.getCheminTerrain(Chemins.FICHIER_EAU));
    }
    
}