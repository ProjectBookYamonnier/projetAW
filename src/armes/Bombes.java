package armes;

public class Bombes extends Arme {

	public Bombes(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 1;
		porteeMax = 1;
		dmg2Infanterie = 1.0;
	    dmg2Bazooka = 1.0;
	    dmg2Tank = 1.0;
	    dmg2DCA = 0.7;
	    dmg2Helicoptere = 0.0;
	    dmg2Bombardier = 0.0;
	    dmg2Convoi = 1.0;
	    dmg2Artillerie = 1.0;
	    //valeurs attribuees par Yann
	    dmg2Barge = 1.0;
	    dmg2Corvette = 1.0;
	    dmg2Croiseur = 1.0;
	    dmg2PorteAvion = 0.9;
	    dmg2Cuirasser = 1.0;
	    dmg2SousMarin = 0;
	}

}
