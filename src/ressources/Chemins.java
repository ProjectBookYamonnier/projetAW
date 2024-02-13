package ressources;

import java.io.File;

/**
Classe qui gere les chemins d'acces des fichiers. 
 */
public class Chemins {
    /** chemin vers la racine, a modifier si les fichiers ne sont pas trouves */
    protected static final String CHEMIN_RACINE = ""; 
    
    /** Nom de la carte 1 donnee en exemple */
    public static final String NOM_CARTE_1 = "map1.awdcmap";
    /** chemin vers l'image du curseur des fenetres popup */
    protected static final String CHEMIN_CURSEUR_POPUP = CHEMIN_RACINE + "pictures" + File.separator + "cursor_popup.png";
    /** chemin vers l'image du curseur d'attaques */
    public static final String CHEMIN_CIBLE_ATTAQUE = CHEMIN_RACINE + "pictures" + File.separator + "CibleAttaque.png";
    /** Dossier qui contient les cartes  */
    protected static final String DOSSIER_CARTES = CHEMIN_RACINE +  "maps";
    /** Dossier contenant les images */
    protected static final String DOSSIER_IMAGES = CHEMIN_RACINE + "pictures";
    /** fichier de l'image du curseur de la fenetre popup */
    protected static final String  POPUP_CURSEUR = DOSSIER_IMAGES + File.separator + "cursor_popup.png";
    /** Dossier contenant les sprites des batiments */
    protected static final String DOSSIER_BATIMENTS = DOSSIER_IMAGES + File.separator + "buildings";
    /** Dossier contenant les sprites des terrains */
    protected static final String DOSSIER_TERRAINS = DOSSIER_IMAGES + File.separator + "terrains";
    /** Dossier contenant les sprites des unites */
    protected static final String DOSSIER_UNITES = DOSSIER_IMAGES +  File.separator + "troops";
    /** Dossier contenant les sprites des fleche de deplacement */
    protected static final String DOSSIER_FLECHES = DOSSIER_IMAGES +  File.separator + "arrows";
    /** Dossier contenant les sprites des vies */
    protected static final String DOSSIER_VIE = DOSSIER_IMAGES +  File.separator + "vie";
    /**	Pour un bout de fleche dont une extremite est a gauche de la case*/
    public static final String DIRECTION_GAUCHE = "left";
    /**	Pour un bout de fleche dont une extremite est a droite de la case*/
    public static final String DIRECTION_DROITE = "right";
    /**	Pour un bout de fleche dont une extremite est en bas de la case*/
    public static final String DIRECTION_BAS = "down";
    /**	Pour un bout de fleche dont une extremite est en haut de la case*/
    public static final String DIRECTION_HAUT = "up";
    /**	Pour un bout de fleche qui commence dans cette case*/
    public static final String DIRECTION_DEBUT = "begin";
    /**	Pour un bout de fleche qui termine dans cette case*/
    public static final String DIRECTION_FIN = "end";

    /** Nom du fichier de l'image de l'unite anti-air. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_ANTIAIR = "antiair.png";
    /** Nom du fichier de l'image de l'unite artillerie. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_ARTILLERIE = "artillery.png";
    /** Nom du fichier de l'image de l'unite bazooka. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_BAZOOKA = "bazooka.png";
    /** Nom du fichier de l'image de l'unite bombardier. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_BOMBARDIER = "bomber.png";
    /** Nom du fichier de l'image de l'unite helicoptere. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_HELICOPTERE = "helicopter.png";
    /** Nom du fichier de l'image de l'unite infanterie. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_INFANTERIE = "infantry.png";
    /** Nom du fichier de l'image de l'unite genie. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_GENIE = "rig.png";
    /** Nom du fichier de l'image de l'unite tank. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_TANK = "tank.png";
    /** Nom du fichier de l'image de l'unite croiseur. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_CROISEUR = "croiseur.png";
    /** Nom du fichier de l'image de l'unite barge. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_BARGE = "barge.png";
    /** Nom du fichier de l'image de l'unite corvette. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_CORVETTE = "corvette.png";
    /** Nom du fichier de l'image de l'unite porte-avion. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_PORTEAVION = "porte-avion.png";
    /** Nom du fichier de l'image de l'unite cuirasser. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_CUIRASSER = "cuirasser.png";
    /** Nom du fichier de l'image de l'unite sous-marin. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_SOUSMARIN = "sous-marin.png";
    /** Nom du fichier de l'image de l'unite Lance-Missiles Sol-Air. Ce fichier existe dans plusieurs repertoires correspondants a  la couleur de l'unite et si elle est disponible ou non*/
    public static final String FICHIER_SOLAIR = "lance-missile.png";
    
        
    /** Nom du ficher contenant l'image du terrain plaine*/
    public static final String FICHIER_PLAINE = "plain.png";
    /** Nom du ficher contenant l'image du terrain montagne*/
    public static final String FICHIER_MONTAGNE = "mountain.png";  
    /** Nom du ficher contenant l'image du terrain eau*/
    public static final String FICHIER_EAU = "water.png";
    /** Nom du ficher contenant l'image du terrain foret*/
    public static final String FICHIER_PLAGE = "plage.png";
    /** Nom du ficher contenant l'image du terrain plage*/
    public static final String FICHIER_FORET = "forest.png";
    /** Nom du ficher contenant l'image du terrain ville. Ce fichier existe dans trois repertoires: rouge, bleu, neutre  */
    public static final String FICHIER_VILLE = "city.png";
    /** Nom du ficher contenant l'image du terrain usine. Ce fichier existe dans trois repertoires: rouge, bleu, neutre  */
    public static final String FICHIER_USINE = "factory.png";
    /** Nom du ficher contenant l'image du terrain QG. Ce fichier existe dans deux repertoires: rouge et bleu */
    public static final String FICHIER_QG = "hq.png";
    
    /** Nom du ficher contenant l'image de vie 1*/
    public static final String FICHIER_UN = "1.png";
    /** Nom du ficher contenant l'image de vie 1 � gauche */
    public static final String FICHIER_UNG = "1g.png";
    /** Nom du ficher contenant l'image de vie 2*/
    public static final String FICHIER_DEUX = "2.png";
    /** Nom du ficher contenant l'image de vie 2 � gauche */
    public static final String FICHIER_DEUXG = "2g.png";
    /** Nom du ficher contenant l'image de vie 3*/
    public static final String FICHIER_TROIS = "3.png";
    /** Nom du ficher contenant l'image de vie 3 � gauche */
    public static final String FICHIER_TROISG = "3g.png";
    /** Nom du ficher contenant l'image de vie 4*/
    public static final String FICHIER_QUATRE = "4.png";
    /** Nom du ficher contenant l'image de vie 1 � gauche */
    public static final String FICHIER_QUATREG = "4g.png";
    /** Nom du ficher contenant l'image de vie 5*/
    public static final String FICHIER_CINQ = "5.png";
    /** Nom du ficher contenant l'image de vie 1 � gauche */
    public static final String FICHIER_CINQG = "5g.png";
    /** Nom du ficher contenant l'image de vie 6*/
    public static final String FICHIER_SIX = "6.png";
    /** Nom du ficher contenant l'image de vie 1 � gauche */
    public static final String FICHIER_SIXG = "6g.png";
    /** Nom du ficher contenant l'image de vie 7*/
    public static final String FICHIER_SEPT = "7.png";
    /** Nom du ficher contenant l'image de vie 7 � gauche */
    public static final String FICHIER_SEPTG = "7g.png";
    /** Nom du ficher contenant l'image de vie 8*/
    public static final String FICHIER_HUIT = "8.png";
    /** Nom du ficher contenant l'image de vie 1 � gauche */
    public static final String FICHIER_HUITG = "8g.png";
    /** Nom du ficher contenant l'image de vie 9*/
    public static final String FICHIER_NEUF = "9.png";
    /** Nom du ficher contenant l'image de vie 1 � gauche */
    public static final String FICHIER_NEUFG = "9g.png";
    /** Nom du ficher contenant l'image de vie 10*/
    public static final String FICHIER_DIX = "10.png";
    /** Nom du ficher contenant l'image de vie 11*/
    public static final String FICHIER_ONZE = "11.png";
    /** Nom du ficher contenant l'image de vie 12*/
    public static final String FICHIER_DOUZE = "12.png";
    /** Nom du ficher contenant l'image de vie 13*/
    public static final String FICHIER_TREIZE = "13.png";
    /** Nom du ficher contenant l'image de vie 14*/
    public static final String FICHIER_QUATORZE = "14.png";
    /** Nom du ficher contenant l'image de vie 15*/
    public static final String FICHIER_QUINZE = "15.png";
    /** Nom du ficher contenant l'image de vie 16*/
    public static final String FICHIER_SEIZE = "16.png";
    /** Nom du ficher contenant l'image de vie 17*/
    public static final String FICHIER_DIXSEPT = "17.png";
    /** Nom du ficher contenant l'image de vie 18*/
    public static final String FICHIER_DIXHUIT = "18.png";
    /** Nom du ficher contenant l'image de vie 19*/
    public static final String FICHIER_DIXNEUF = "19.png";
    /** Nom du ficher contenant l'image de vie 20*/
    public static final String FICHIER_VINGT = "20.png";
    
    /** 
     * Donne le chemin de l'image de vie de l'entit�.
      * @param nomFichier Le nom du fichier de vie, par exemple <code>FICHIER_UN</code>
      * @return Le chemin vers l'image de la vie
      */
    public static String getCheminVie(String fichier) {
    	return DOSSIER_VIE + File.separator + fichier;
    }
    
    /**
    * Donne le chemin de l'image de l'unite.
    * @param joueur 1 pour rouge, 2 pour bleu, 0 pour neutre 
    * @param disponible <code>true</code> quand l'unite est disponible, <code>false</code> quand l'unite ne l'est pas
    * @param fichier Le nom du fichier correspondant, par exemple FICHIER_HELICOPTERE
    * @return Le chemin complet vers l'image 
    */
    public static String getCheminUnite(int joueur, boolean disponible, String fichier) {
        String a = "available";
        if (!disponible) {
            a = "unavailable";
        }
        return DOSSIER_UNITES + File.separator + getStringJoueur(joueur) + File.separator + a + File.separator + fichier;   
    }

    /** 
    * Donne le chemin de l'image du terrain (hors proprietes).
     * @param nomFichier Le nom du fichier du terrain, par exemple <code>FICHIER_FORET</code>
     * @return Le chemin vers l'image du terrain
     */
    public static String getCheminTerrain(String nomFichier) {
        return DOSSIER_TERRAINS + File.separator + nomFichier;
    }
    
    /**
     * Donne le chemin de l'image de fleche correspondant aux extremités données.
     * Attention, si la combinaison d'extremites donnee ne fonctionne pas, cette methode renverra un nom de fichier inexistant (par exemple down-down)
     * @param extremite1 Nom de l'une des extremites parmi begin, end, left, right, up or down
     * @param extremite2 Nom de l'autre des extremites parmi begin, end, left, right, up or down
     * @return Le chemin vers l'image de fleche correspondant, peut ne pas exister pour une combinaison impossible
     */
    public static String getCheminFleche(String extremite1, String extremite2) {
    	String premier;
    	String deuxieme;
    	//S'assure que premier et deuxieme soient dans l'ordre alphabetic pour donner le bon nom de fichier
    	// (si cette combinaison est possible. Par exemple la combinaison up-up est impossible.
    	if (extremite1.compareTo(extremite2)<0) {
        	premier = extremite1;
        	deuxieme = extremite2;
    	} else  {
        	premier = extremite2;
        	deuxieme = extremite1;
    	}
        return DOSSIER_FLECHES + File.separator  + premier + "_" + deuxieme + ".png";   
    }

    
    
    private static String getStringJoueur(int joueur) {
          switch (joueur) {
            case (0): return "neutral"; 
            case (1): return "red"; 
            default: return "blue";
        }
    }

    /** 
    * Donne le chemin de l'image de la propriete.
     * @param nomFichier Le nom du fichier de la propriete, par exemple <code>FICHIER_VILLE</code>
     * @param joueur Le joueur possedant la propriete: 0 pour neutre, 1 pour rouge, 2 pour bleu
     * @return Le chemin vers l'image de la propriete
     */
    public static String getCheminPropriete(String nomFichier, int joueur) {
        return DOSSIER_BATIMENTS + File.separator + getStringJoueur(joueur) + File.separator + nomFichier; 
    }
	/**
	 * Donne le chemin vers le fichier de la carte
	 * @param nomFichier Le nom du ficher de la carte, qui doit etre dans le dossier "maps"
	 * @return Le chemin vers le fichier
	 */
    public static String getCheminCarte(String nomFichier) {
        return CHEMIN_RACINE + "maps" + File.separator + nomFichier;
    }

	/**
	 * Renvoie le dossier contenant les cartes, qui est le dossier dans lequel l'outil de selection ira chercher
	 * @return Le dossier des cartes du jeu
	 */
    public static String getDossierCartes() {
        return DOSSIER_CARTES;
    }
}
