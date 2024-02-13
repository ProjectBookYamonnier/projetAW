package armes;

public class Mortier extends Arme {

	public Mortier(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 2;
		porteeMax = 3;
		if(armeMultiple)System.err.println("ERREUR : Le mortier ne peut pas faire partie d'une arme multiple");
		else{
			dmg2Infanterie = 0.4;
			dmg2Bazooka = 0.5;
		    dmg2Tank = 0.7;
		    dmg2DCA = 0.7;
		    dmg2Helicoptere = 0.0;
		    dmg2Bombardier = 0.0;
		    dmg2Convoi = 0.7;
		    dmg2Artillerie = 0.7;
		    //valeurs attribuees par Yann  
		    dmg2Barge = 0.7;
		    dmg2Corvette = 0.7;
		    dmg2Croiseur = 0.7;
		    dmg2PorteAvion = 0.7;
		    dmg2Cuirasser = 0.7;
		    dmg2SousMarin = 0;
		}
	}
}
