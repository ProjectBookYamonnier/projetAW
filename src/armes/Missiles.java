package armes;

public class Missiles extends Arme {

	public Missiles(boolean armeMultiple) {
		super(armeMultiple);
		porteeMin = 1;
		porteeMax = 1;
		if(!armeMultiple)System.err.println("ERREUR : Le missile ne peut pas etre associe a un autre");
		else{
			dmg2Infanterie = 0.5;
			dmg2Bazooka = 0.5;
		    dmg2Tank = 0.7;
		    dmg2DCA = 0.4;
		    dmg2Helicoptere = 0.7;
		    dmg2Bombardier = 0.7;
		    dmg2Convoi = 0.7;
		    dmg2Artillerie = 0.7;
		  //valeurs attribuees par Yann
		    dmg2Barge = 0.7;
		    dmg2Corvette = 0.7;
		    dmg2Croiseur = 0.7;
		    dmg2PorteAvion = 0.8;
		    dmg2Cuirasser = 0.7;
		    dmg2SousMarin = 0;
		}
	}
}
