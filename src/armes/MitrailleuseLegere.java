package armes;

public class MitrailleuseLegere extends Arme {

	public MitrailleuseLegere(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 1;
		porteeMax = 1;
		dmg2Infanterie = 0.6;
	    dmg2Bazooka = 0.55;
	    dmg2Tank = 0.15;
	    dmg2DCA = 0.1;
	    dmg2Helicoptere = 0.3;
	    dmg2Bombardier = 0.0;
	    dmg2Convoi = 0.4;
	    dmg2Artillerie = 0.4;
	  //valeurs attribuees par Yann
	    dmg2Barge = 0.15;
	    dmg2Corvette = 0.15;
	    dmg2Croiseur = 0.15;
	    dmg2PorteAvion = 0.15;
	    dmg2Cuirasser = 0.15;
	    dmg2SousMarin = 0;
	}
}
