package armes;

public class MitrailleuseLourde extends Arme {

	public MitrailleuseLourde(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 1;
		porteeMax = 1;
		dmg2Infanterie = 1.0;
	    dmg2Bazooka = 0.8;
	    dmg2Tank = 0.3;
	    dmg2DCA = 0.3;
	    dmg2Helicoptere = 1.1;
	    dmg2Bombardier = 0.7;
	    dmg2Convoi = 0.5;
	    dmg2Artillerie = 0.5;
	  //valeurs attribuees par Yann
	    dmg2Barge = 0.3;
	    dmg2Corvette = 0.3;
	    dmg2Croiseur = 0.3;
	    dmg2PorteAvion = 0.25;
	    dmg2Cuirasser = 0.3;
	    dmg2SousMarin = 0.2;
	}
}
