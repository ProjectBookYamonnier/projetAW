package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class Plaine extends Terrain{

    public Plaine(int x, int y) {
        super(x, y);
        identifiant = "Plaine";
    }
    
    public void afficheTerrain() {
    	Affichage.dessineImageDansCase(x, y, Chemins.getCheminTerrain(Chemins.FICHIER_PLAINE));
    }

}