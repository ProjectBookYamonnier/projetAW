package armes;

public class MissilesSol_Air extends Arme {

	public MissilesSol_Air(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 3;
		porteeMax = 6;
		if(armeMultiple)System.err.println("ERREUR : Le Missile Air-Sol ne peut pas etre associe a une autre arme");
		else{
			dmg2Infanterie = 0.0;
			dmg2Bazooka = 0.0;
		    dmg2Tank = 0.0;
		    dmg2DCA = 0.0;
		    dmg2Helicoptere = 1.2;
		    dmg2Bombardier = 1.2;
		    dmg2Convoi = 0.0;
		    dmg2Artillerie = 0.0;
		    //valeurs attribuees par Yann
		    dmg2Barge = 0.0;
		    dmg2Corvette = 0.0;
		    dmg2Croiseur = 0.0;
		    dmg2PorteAvion = 0.0;
		    dmg2Cuirasser = 0.0;
		    dmg2SousMarin = 0.0;
		}
	}

}
