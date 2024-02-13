package terrain;

import ressources.Affichage;
import ressources.Chemins;

public class Plage extends Terrain {

	public Plage(int x, int y) {
		super(x, y);
		identifiant = "Plage";
	}

	@Override
	public void afficheTerrain() {
		Affichage.dessineImageDansCase(x, y, Chemins.getCheminTerrain(Chemins.FICHIER_PLAGE));
	}

}
