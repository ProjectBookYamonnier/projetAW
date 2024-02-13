package plateau;

import java.util.ArrayList;
import java.util.List;

import main.Jeu;
import ressources.Config;
import terrain.Eau;
import terrain.Terrain;
import unites.Barge;
import unites.Convoi;
import unites.Corvette;
import unites.Helicoptere;
import unites.PorteAvion;
import unites.Unite;

/**
 * La classe Plateau representant le tableau du jeu.
 */
public class Plateau {

    public List<List<Case>> plateau;
    public static List<List<Terrain>> repertoireTerrain;
    public static List<List<Unite>> repertoireUnite;
    
    public Plateau(String [][] carteString) {
    	/*
    	 * initialisationRep permet d'initialiser les 2 repertoires repertoireTerrain et repertoireUnite
    	 */
        Repertoire initialisationRep = new Repertoire(carteString);
        repertoireTerrain = Repertoire.repertoireTerrain;
        repertoireUnite = Repertoire.repertoireUnite;
        plateau = fusion();
    }
    
    /**
     * Fusionne les listes de terrains et d'unites pour creer une liste de listes de cases.
     * @return La liste de listes de cases creee a partir des listes de terrains et d'unites.
    */
    private static List<List<Case>> fusion() {
    	List<List<Case>> plat = new ArrayList<>();
    	for (int i = 0; i < repertoireTerrain.size(); i++) {
    		plat.add(new ArrayList<>());
			for (int j = 0; j < repertoireTerrain.get(i).size(); j++) {
				Terrain terrain = repertoireTerrain.get(i).get(j);
				Unite unite = repertoireUnite.get(i).get(j);
				plat.get(i).add(new Case(terrain, unite));
			}
		}
    	return plat;
    }
    
    /**
     * V�rifie la presence d'eau autour d'une case donnee et retourne la premiere case d'eau vide trouvee.
     * @param x La coordonnee x de l'usine.
     * @param y La coordonnee y de l'usine.
     * @return La premiere case d'eau vide trouv�e autour de la case donn�e, ou la case donnee si aucune case d'eau vide n'est trouvee.
    */
    public static Case presenceEau(int x, int y) {
    	List<List<Case>> plat = Jeu.PLATEAU_DE_JEU.plateau;
    	if(x < Config.longueurCarteXCases-1) {
    		Case Agauche = plat.get(y).get(x+1);
    		if(Agauche.getTerrain() instanceof Eau) {
    			if(Agauche.getUnite() == null) return Agauche;
    		}
    	}
        if(x > 0) {
        	Case Adroite = plat.get(y).get(x-1);//GOOD
    		if(Adroite.getTerrain() instanceof Eau) {
    			if(Adroite.getUnite() == null) return Adroite;
    		}
        }
        if(y > 0) {
        	Case Ahaut = plat.get(y-1).get(x);//GOOD
    		if(Ahaut.getTerrain() instanceof Eau) {
    			System.out.println("haut");
    			if(Ahaut.getUnite() == null) return Ahaut;
    		}
        }
        if(y < Config.longueurCarteYCases-1) {
        	Case Abas = plat.get(y+1).get(x);
    		if(Abas.getTerrain() instanceof Eau) {
    			if(Abas.getUnite() == null) return Abas;
    		}
        }
        return plat.get(y).get(x);
    }
    
    /**
     * La méthode verifUniteAProximite est utilisée pour vérifier s'il existe une unité à proximité des coordonnées données (x, y).
     * La méthode vérifie les quatre tuiles adjacentes (haut, bas, gauche, droite) et renvoie l'objet Case de la première unité trouvée 
     * qui est une instance des classes suivantes : Barge, Convoi, Corvette, Helicoptere, PorteAvion. 
     * 
     * Si aucune unité des classes ci-dessus n'est trouvée, la méthode renvoie l'objet Case du premier terrain non aquatique trouvé à proximité.
     * 
     * @param x La coordonnée x de l'emplacement à vérifier.
     * @param y La coordonnée y de l'emplacement à vérifier.
     * @param act Un drapeau booléen indiquant s'il faut retourner un cas vide ou non.
     * @param pourAvion Un drapeau booléen indiquant s'il faut vérifier la présence d'eau ou non.
     * @return L'objet Case de la première unité trouvée, ou le premier objet Case de terrain non aquatique trouvé à proximité, 
     * ou null si aucune unité ou aucun Case de terrain non aquatique n'est trouvé.
     */
    public static Case verifUniteAProximite(int x, int y, boolean act, boolean pourAvion) {
    	y = Config.longueurCarteYCases-y-1;
    	if(Jeu.coordValides(x+1, y)) {
    		Case c = Jeu.PLATEAU_DE_JEU.plateau.get(y).get(x+1);
    		if(c.getUnite() != null) {
    			if(c.getUnite() instanceof Barge || 
    					c.getUnite() instanceof Convoi ||
    					c.getUnite() instanceof Corvette || 
    					c.getUnite() instanceof Helicoptere ||
    					c.getUnite() instanceof PorteAvion) {
    				return c;
    			}
    		}
    		else { //permet de retourner si la case est vide
    			if(act) {
    				if(!pourAvion) {
    					if(!(c.getTerrain() instanceof Eau)) {
    						return c;
    					}
    				}
    				else {
    					return c;
    				}
    			}
    		}
    	}
    	if(Jeu.coordValides(x-1, y)) {
    		Case c = Jeu.PLATEAU_DE_JEU.plateau.get(y).get(x-1);
    		if(c.getUnite() != null) {
    			if(c.getUnite() instanceof Barge || 
    					c.getUnite() instanceof Convoi ||
    					c.getUnite() instanceof Corvette || 
    					c.getUnite() instanceof Helicoptere ||
    					c.getUnite() instanceof PorteAvion) {
    				return c;
    			}
    		}
    		else {
    			if(act) {
    				if(!pourAvion) {
    					if(!(c.getTerrain() instanceof Eau)) {
    						return c;
    					}
    				}
    				else {
    					return c;
    				}
    			}
    		}
    	}
    	if(Jeu.coordValides(x, y+1)) {
    		Case c = Jeu.PLATEAU_DE_JEU.plateau.get(y+1).get(x);
    		if(c.getUnite() != null) {
    			if(c.getUnite() instanceof Barge || 
    					c.getUnite() instanceof Convoi ||
    					c.getUnite() instanceof Corvette || 
    					c.getUnite() instanceof Helicoptere ||
    					c.getUnite() instanceof PorteAvion) {
    				return c;
    			}
    		}
    		else {
    			if(act) {
    				if(!pourAvion) {
    					if(!(c.getTerrain() instanceof Eau)) {
    						return c;
    					}
    				}
    				else {
    					return c;
    				}
    			}
    		}
    	}
    	if(Jeu.coordValides(x, y-1)) {
    		Case c = Jeu.PLATEAU_DE_JEU.plateau.get(y-1).get(x);
    		if(c.getUnite() != null) {
    			if(c.getUnite() instanceof Barge || 
    					c.getUnite() instanceof Convoi ||
    					c.getUnite() instanceof Corvette || 
    					c.getUnite() instanceof Helicoptere ||
    					c.getUnite() instanceof PorteAvion) {
    				return c;
    			}
    		}else {
    			if(act) {
    				if(!pourAvion) {
    					if(!(c.getTerrain() instanceof Eau)) {
    						return c;
    					}
    				}
    				else {
    					return c;
    				}
    			}
    		}
    	}
    	return null;
    }
    
    
}