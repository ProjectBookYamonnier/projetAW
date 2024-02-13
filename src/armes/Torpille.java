package armes;

public class Torpille extends Arme {

	public Torpille(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 1;
		porteeMax = 1;
		if(armeMultiple)System.err.println("ERREUR : La torpille ne peut pas etre associee a une autre arme");
		else{
			dmg2Infanterie = 0.0;
			dmg2Bazooka = 0.0;
		    dmg2Tank = 0.0;
		    dmg2DCA = 0.0;
		    dmg2Helicoptere = 0.0;
		    dmg2Bombardier = 0.0;
		    dmg2Convoi = 0.0;
		    dmg2Artillerie = 0.0;
		    //valeurs attribuees par Yann
		    dmg2Barge = 1.0;
		    dmg2Corvette = 1.0;
		    dmg2Croiseur = 0.55;
		    dmg2PorteAvion = 1.0;
		    dmg2Cuirasser = 1.0;
		    dmg2SousMarin = 0.55;
		}
	}
}
