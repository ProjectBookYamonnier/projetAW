package plateau;

import java.util.ArrayList;
import java.util.List;

import terrain.Eau;
import terrain.Foret;
import terrain.Montagne;
import terrain.Plage;
import terrain.Plaine;
import terrain.QG;
import terrain.Terrain;
import terrain.Usine;
import terrain.Ville;
import unites.Artillerie;
import unites.Barge;
import unites.Bazooka;
import unites.Bombardier;
import unites.Convoi;
import unites.Corvette;
import unites.Croiseur;
import unites.Cuirasser;
import unites.DCA;
import unites.Helicoptere;
import unites.Infanterie;
import unites.LanceMissilesSolAir;
import unites.PorteAvion;
import unites.SousMarin;
import unites.Tank;
import unites.Unite;

public class Repertoire {
	
	public static List<List<Terrain>> repertoireTerrain;
	public static List<List<Unite>> repertoireUnite;
	
	
	public Repertoire(String [][] plateau) {
		repertoireTerrain = initRepTer(plateau);
		repertoireUnite = initRepUni(plateau);
	}
	
	/**
	 * Initialise la representation des terrains du jeu a partir d'un tableau de tableau de chaines de caracteres.
	 * 
	 * @param plateau le tableau de tableau de chaines de caracteres representant le plateau de jeu.
	 * @return La representation des terrains de jeu sous forme de liste de listes de terrains.
	 * @throws Exception Si un terrain est inconnu.
	 */
	public List<List<Terrain>> initRepTer(String [][] plateau){
        List<List<Terrain>> rep = new ArrayList<>();
        for(int i = 0; i < plateau.length; i++) {
            rep.add(new ArrayList<>());
            for(int j = 0; j < plateau[i].length; j++) {
                String [] tab1 = plateau[i][j].split(";");
                switch(tab1[0]) {
                    case ("Plaine") : 
                        rep.get(i).add(new Plaine(j,i)); 
                    break;
                    case ("Eau") : 
                        rep.get(i).add(new Eau(j,i));
                    break;
                    case ("Montagne") : 
                        rep.get(i).add(new Montagne(j,i));
                    break;
                    case ("Foret") : 
                        rep.get(i).add(new Foret(j,i));
                    break;
                    case ("Plage") : 
                    	rep.get(i).add(new Plage(j,i));
                }
                String [] tab2 = plateau[i][j].split(":");
                switch(tab2[0]) {
                    case("QG")    :
                        rep.get(i).add(new QG(j, i, Integer.valueOf(tab2[1])));
                    break;
                    case("Ville") : 
                        rep.get(i).add(new Ville(j, i, Integer.valueOf(tab2[1])));
                    break;
                    case("Usine") : 
                        rep.get(i).add(new Usine(j,i, Integer.valueOf(tab2[1])));
                    break;
                    default : 
                    	new Exception("terrain_inconnu");
                }
            }
        }
        return rep;
    }
	
	/**
	 * Initialise la representation des Unites du jeu a partir d'un tableau de tableau de chaines de caracteres.
	 * 
	 * @param plateau un tableau de tableau de chaines de caracteres representant le plateau de jeu.
	 * @return La representation des unites du jeu sous forme de liste de listes d'Unite.
	 */
	public List<List<Unite>> initRepUni(String [][] plateau) {
		List<List<Unite>> rep = new ArrayList<>();
		for(int i = 0; i < plateau.length; i++) {
			rep.add(new ArrayList<>());
			for(int j = 0; j < plateau[i].length; j++) {
				String [] tab1 = plateau[i][j].split(";");
				String [] tab2;
				if(tab1.length > 1) {
					tab2 = tab1[1].split(":");
					switch(tab2[0]) {
						case ("Tank") : 
							rep.get(i).add(new Tank(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Infanterie") : 
							rep.get(i).add(new Infanterie(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Helico") :
							rep.get(i).add(new Helicoptere(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("DCA") :
							rep.get(i).add(new DCA(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Bombardier") : 
							rep.get(i).add(new Bombardier(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Bazooka") :
							rep.get(i).add(new Bazooka(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Convoit") : 
							rep.get(i).add(new Convoi(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Barge") : 
							rep.get(i).add(new Barge(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Corvette") : 
							rep.get(i).add(new Corvette(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Croiseur") : 
							rep.get(i).add(new Croiseur(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Porte-Avion") : 
							rep.get(i).add(new PorteAvion(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Cuirasser") : 
							rep.get(i).add(new Cuirasser(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Sous-Marin") : 
							rep.get(i).add(new SousMarin(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Artillerie") : 
							rep.get(i).add(new Artillerie(j, i, Integer.valueOf(tab2[1]), true));
						break;
						case ("Lance-missile") : 
							rep.get(i).add(new LanceMissilesSolAir(j, i, Integer.valueOf(tab2[1]), true));
						break;
						default : 
							rep.get(i).add(null);
					}
				}
				else  {
					rep.get(i).add(null);
				}
			}
		}
		return rep;
	}
	

}
