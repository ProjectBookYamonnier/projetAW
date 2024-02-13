package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class Foret extends Terrain{

    public Foret(int x, int y) {
        super(x, y);
        identifiant = "Foret";
    }
    
    @Override
    public void afficheTerrain() {
    	Affichage.dessineImageDansCase(x, y, Chemins.getCheminTerrain(Chemins.FICHIER_FORET));
    }

}