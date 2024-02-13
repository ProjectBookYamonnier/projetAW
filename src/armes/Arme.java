package armes;

/**
 * La classe Arme représente une arme. Elle contient des propriétés telles que la portée minimale et maximale, 
 * ainsi que les dégâts infligés à différents types de cibles (infanterie, chars, hélicoptères, etc.). 
 * Les dégâts infligés sont affectés par un multiplicateur météo, qui est actuellement fixé à 1 (désactivant les effets de la météo).
 * 
 * La classe possède également une propriété booléenne armeMultiple qui indique si l'arme peut attaquer plusieurs cibles à la fois.
 * 
 * La classe dispose de plusieurs méthodes getter et setter pour accéder aux propriétés de l'arme et les modifier. 
 * La méthode setMultiplicateur peut être utilisée pour définir le multiplicateur météorologique, qui affectera tous les calculs de dommages.
*/
public abstract class Arme {
	
	/** Ce multiplicateur change en fonction de la meteo (Actuellement: meteo disfonctionnelle)*/
	protected static double mult =1;
	public static void setMultiplicateur(double multi) {mult = multi;}
	
	protected final boolean armeMultiple;

	protected int porteeMin;
	public int getPorteeMin() {return porteeMin;}
	public void setPorteeMin(int porteeMin) {this.porteeMin = porteeMin;}
	
	protected int porteeMax;
	public int getPorteeMax() {return porteeMax;}
	public void setPorteeMax(int porteeMax) {this.porteeMax = porteeMax;}
	
	protected double dmg2Infanterie;
	public double getDmg2Infanterie() {return dmg2Infanterie * mult;}

	protected double dmg2Bazooka;
	public double getDmg2Bazooka() {return dmg2Bazooka * mult;}
	
	protected double dmg2Tank;
	public double getDmg2Tank() {return dmg2Tank * mult;}
	
	protected double dmg2DCA;
	public double getDmg2DCA() {return dmg2DCA * mult;}
	
	protected double dmg2Helicoptere;
	public double getDmg2Helicoptere() {return dmg2Helicoptere * mult;}
	
	protected double dmg2Bombardier;
	public double getDmg2Bombardier() {return dmg2Bombardier * mult;}
	
	protected double dmg2Convoi;
	public double getDmg2Convoi() {return dmg2Convoi * mult;}

	protected double dmg2Artillerie;
	public double getDmg2Artillerie() {return dmg2Artillerie * mult;}
	
	protected double dmg2Barge;
	public double getDmg2Barge() {return dmg2Barge * mult;}

	protected double dmg2Corvette;
	public double getDmg2Corvette() {return dmg2Corvette * mult;}
	
	protected double dmg2Croiseur;
	public double getDmg2Croiseur() {return dmg2Croiseur * mult;}
	
	protected double dmg2PorteAvion;
	public double getDmg2PorteAvion() {return dmg2PorteAvion * mult;}
	
	protected double dmg2Cuirasser;
	public double getDmg2Cuirasser() {return dmg2Cuirasser * mult;}
	
	protected double dmg2SousMarin;
	public double getDmg2SousMarin() {return dmg2SousMarin * mult;}
	
	
	public Arme(boolean armeMultiple) {
		this.armeMultiple = armeMultiple;
	}

}
