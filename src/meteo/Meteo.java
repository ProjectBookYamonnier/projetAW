package meteo;

import java.util.Random;

import armes.Arme;
import unites.TypeChenilles;
import unites.TypeMarche;

public abstract class Meteo {

	private static final int assocNeige = 1;
	private static final int assocVentV = 2;
	public static Meteo meteoActuel;
	public static Meteo meteoSUivante;
	
	public Meteo() {
		
	}
	
	public static String meteoAleatoire(boolean act, int numero_de_manche) {
		if(numero_de_manche == 1){
			return "BeauTemps";
		}else {
			int random = random(1,5);
			if(act) {
				if(random == assocNeige) {
					return "Neige";
				}else if (random == assocVentV) {
					return "VentViolent";
				}else {
					return "BeauTemps";
				}
			}
			else {return "BeauTemps";}
		}
	}
	
	/**
	* G�n�re un nombre aleatoire entre un minimum et un maximum specifies.
	* 
	* @param min le minimum (inclus) pour le nombre aleatoire genere
	* @param max le maximum (exclus) pour le nombre aleatoire genere
	* @return un nombre aleatoire entre min et max-1
	*/
	private static int random(int min, int max) {
		Random rand = new Random();
		int random_number = rand.nextInt(max) + min;
		return random_number;
	}

	/**
	 * Permet de changer la valeur de l'attribut Multiplicateur dans le package Arme
	 * 
	 * @param mult le multiplicateur de degat associe a la meteo
	 */
	protected static void operation(double mult) {
		Arme.setMultiplicateur(mult);
	}
	
	/**
	 * Permet de changer la valeur de l'attribut Coeff dans le package TypeAerien
	 * 
	 * @param coeff un coefficient a multiplier au ptsDeplacement
	 */
	protected static void modifDeplacement(double coeff) {
//		Helicoptere.setCoeff(coeff);
//		Bombardier.setCoeff(coeff);
	}
	
	protected static void modifDiffDapresMeteo(int DiffForetChe, int DiffPlaineChe, int DiffForetMar, int DiffMontagneMar) {
		TypeChenilles.DifForetApresMeteo = DiffForetChe;
		TypeChenilles.DifPlaineApresMeteo = DiffPlaineChe;
		TypeMarche.DifForetApresMeteo = DiffForetMar;
		TypeMarche.DifMontagneApresMeteo = DiffMontagneMar;
	}
}