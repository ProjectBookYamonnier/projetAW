package armes;

public class Canon extends Arme {

	public Canon(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 1;
		porteeMax = 1;
		if(armeMultiple) {
			dmg2Infanterie = 0;
		    dmg2Bazooka = 0;
		    dmg2Tank = 0.55;
		    dmg2DCA = 0.6;
		    dmg2Helicoptere = 0;
		    dmg2Bombardier = 0;
		    dmg2Convoi = 0.7;
		    dmg2Artillerie = 0.7;
		  //valeurs attribuees par Yann
		    dmg2Barge = 0.55;
		    dmg2Corvette = 0.45;
		    dmg2Croiseur = 0.5;
		    dmg2PorteAvion = 0.3;
		    dmg2Cuirasser = 0.45;
		    dmg2SousMarin = 0;
		}else {
			dmg2Infanterie = 0.45;
		    dmg2Bazooka = 0.45;
		    dmg2Tank = 0.55;
		    dmg2DCA = 0.6;
		    dmg2Helicoptere = 0.3;
		    dmg2Bombardier = 0;
		    dmg2Convoi = 0.7;
		    dmg2Artillerie = 0.7;
		  //valeurs attribuees par Yann
		    dmg2Barge = 0.55;
		    dmg2Corvette = 0.45;
		    dmg2Croiseur = 0.5;
		    dmg2PorteAvion = 0.3;
		    dmg2Cuirasser = 0.45;
		    dmg2SousMarin = 0;
		}
	}
}
