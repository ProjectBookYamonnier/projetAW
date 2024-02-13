package unites;

import terrain.Propriete;

/**
 * Classe abstraite representant les unites de type "Marche" dans le jeu.
 * Les unites de type "Marche" ont la capacite de capturer des proprietes.
*/
public abstract class TypeMarche extends Unite {

	/**
	 * Attribut indiquant si l'unite est en train de capturer une propriete.
	 */
	private boolean is_capturing; // mis a true lorsque le joueur utilise cette unite pour capturer
	public boolean getIs_capturing() {return is_capturing;}
	public void setIs_capturing(boolean mode_capture) {this.is_capturing = mode_capture;}
	
	/**
	 * Attribut stockant la propriete que l'unite est en train de capturer.
	 */
	private Propriete prop_capture; // on y stocke la propriete que cette unite est en train de capturer
	public Propriete getProp_capture() {return prop_capture;}
	public void setProp_capture(Propriete prop_capture) {this.prop_capture = prop_capture;}
	
	/**
	 * DifMontagneApresMeteo est une variable statique qui determine le co�t de deplacement pour les unites de type "TypeMarche" sur les terrains de type Montagne;
	*/
	public static int DifMontagneApresMeteo;
	public static void setDifPlaineApresMeteo(int difPlaineApresMeteo) {DifMontagneApresMeteo = difPlaineApresMeteo;}

	/**
	 * DifForetApresMeteo est une variable statique qui determine le co�t de deplacement pour les unites de type "TypeMarche" sur les terrains de type Foret;
	*/
	public static int DifForetApresMeteo;
	public static void setDifForetApresMeteo(int difForetApresMeteo) {DifForetApresMeteo = difForetApresMeteo;}
	
	/**
	 * Constructeur de la classe TypeMarche.
	 * Il herite de la classe m�re "Type", et initialise les attributs de la classe TypeMarche.
	 * @param x : Coordonnee x de la case
	 * @param y : Coordonnee y de la case
	 * @param equipe : Numero d'equipe de la case
	 * @param dispo : Disponibilite de la case (True = disponible, False = non disponible)
	 * @param is_capturing : booleen indiquant si la case est en train de capturer (False par defaut)
	 * @param prop_capture : propriete de capture (null par defaut)
	 * @param DifForet : Difficulte de marche dans une for�t (DifForetApresMeteo par defaut)
	 * @param DifPlaine : Difficulte de marche dans une plaine (1 par defaut)
	 * @param DifPlage : Difficulte de marche sur une plage (1 par defaut)
	 * @param DifMontagne : Difficulte de marche dans une montagne (DifMontagneApresMeteo par defaut)
	 * @param DifEau : Difficulte de marche dans l'eau (100 par defaut, terrain inacessible)
	 * @param DifPropriete : Difficulte de marche sur une propriete (1 par defaut)
	*/
	public TypeMarche(int x, int y, int equipe, boolean dispo) {
        super(x, y, equipe, dispo);
        is_capturing = false;
        prop_capture = null;
        id_type = "TypeMarche";
		DifForet = DifForetApresMeteo;
		DifPlaine = 1;
		DifPlage = 1;
		DifMontagne = DifMontagneApresMeteo;
		DifEau = 100; // terrain inacessible
		DifPropriete = 1;
	}
	
	/**
	 * Methode capturer de la classe TypeMarche.
	 * Cette methode permet de capturer une propriete ennemie.
	 * @param defenseuse : propriete a capturer
	 * @param is_capturing : booleen indiquant si la case est en train de capturer (True)
	 * @param prop_capture : propriete de capture (defenseuse)
	 * 
	 * La methode verifie si la propriete appartient a une autre equipe que celle de la case capturante. Si c'est le cas,
	 * elle calcule les dommages infliges a la propriete, et verifie si celle-ci a encore des PV.
	 * Si la propriete n'a plus de PV, la methode change son statut pour celui de l'equipe capturante et lui redonne 20 PV.
	 * Enfin, le booleen is_capturing est remis a False et prop_capture a null.
	*/
	public void capturer(Propriete defenseuse) {
		is_capturing = true;
		prop_capture = defenseuse;
		if (defenseuse.getStatut() != this.equipe) {
			double dommages = Math.ceil(defenseuse.getPv() - this.pv);
			defenseuse.setPv(dommages);
			if (defenseuse.getPv() <= 0) { 
				defenseuse.setStatut(this.equipe); // on change l'appartenance de la propriete 
				defenseuse.setPv(20); // On lui redonne 20 pvs
				is_capturing = false;
				prop_capture = null;
			}
		}
	}

}
