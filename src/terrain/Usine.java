package terrain;

import main.Jeu;
import plateau.Case;
import ressources.Affichage;
import ressources.Chemins;
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

public class Usine extends Propriete {

    public Usine(int x,int y, int statut) {
        super(x,y,statut);
        identifiant = "Usine";
    }

	@Override
	public void afficheTerrain() {
		Affichage.dessineImageDansCase(x, y, Chemins.getCheminPropriete(Chemins.FICHIER_USINE, statut));
		Affichage.affichePV(x, y, pv, true);
	}

	/**
	 * 
	 * @param nom_classe est l'identifiant associe a l'unite que l'on souhaite
	 * @param credit est les credit actuel du JoueurActif
	 * @param avecOuPasEau est une case <true> si il y a pas d'eau autour de l'usine sinon <false>
	 * @return les credits soustraits du joueurActif
	 */
	public void creerUnite(String text, int credit, Case avecOuPasEau) {
		String [] nom_classe = text.split(" ");
        Unite nouvelle = null;
        int coutUnite = 0;
        int newX = x;
        int newY = y;
        boolean presenceEau = avecOuPasEau.getTerrain() instanceof Eau;
        if(presenceEau) {
        	switch(nom_classe[0]) {
        		case("Artillerie") : nouvelle = new Artillerie(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Bazooka") : nouvelle = new Bazooka(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Bombardier") : nouvelle = new Bombardier(newX,newY,statut,false);coutUnite = nouvelle.getPrix(); break;
	            case("DCA") : nouvelle = new DCA(newX,newY,statut,false); coutUnite = nouvelle.getPrix(); break;
	            case("Helicoptere") : nouvelle = new Helicoptere(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Infanterie") : nouvelle = new Infanterie(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Tank") : nouvelle = new Tank(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Convoi") : nouvelle = new Convoi(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Lance-Missile") : nouvelle = new LanceMissilesSolAir(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Barge") : 
	            	newX = avecOuPasEau.getTerrain().getX();
            		newY = avecOuPasEau.getTerrain().getY();
	            	nouvelle = new Barge(newX,newY,statut,false); 
	            	coutUnite = nouvelle.getPrix();
	            	break;
	            case("Corvette") : 
	            	newX = avecOuPasEau.getTerrain().getX();
	            	newY = avecOuPasEau.getTerrain().getY();
	            	nouvelle = new Corvette(newX,newY,statut,false);
	            	coutUnite = nouvelle.getPrix();
	            	break;
	            case("Croiseur") : 
	            	newX = avecOuPasEau.getTerrain().getX();
            		y = avecOuPasEau.getTerrain().getY();
	            	nouvelle = new Croiseur(newX,newY,statut,false);
	            	coutUnite = nouvelle.getPrix();
	            	break;
	            case("Cuirasser") : 
	            	newX = avecOuPasEau.getTerrain().getX();
	            	newY = avecOuPasEau.getTerrain().getY();
	            	nouvelle = new Cuirasser(newX,newY,statut,false);
	            	coutUnite = nouvelle.getPrix();
	            	break;
	            case("Porte-Avion") : 
	            	newX = avecOuPasEau.getTerrain().getX();
	            	newY = avecOuPasEau.getTerrain().getY();
	            	nouvelle = new PorteAvion(newX,newY,statut,false);
	            	coutUnite = nouvelle.getPrix();
	            	break;
	            case("Sous-Marin") : 
	            	newX = avecOuPasEau.getTerrain().getX();
            		newY = avecOuPasEau.getTerrain().getY();
	            	nouvelle = new SousMarin(newX,newY,statut,false);
	            	coutUnite = nouvelle.getPrix();
	            	break;
	            default : new Exception("unite_inconnue");
        	}
        }else {
        	switch(nom_classe[0]) {
	    		case("Artillerie") : nouvelle = new Artillerie(newX,newY,statut,false);coutUnite = nouvelle.getPrix(); break;
	            case("Bazooka") : nouvelle = new Bazooka(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Bombardier") : nouvelle = new Bombardier(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("DCA") : nouvelle = new DCA(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Helicoptere") : nouvelle = new Helicoptere(newX,newY,statut,false);coutUnite = nouvelle.getPrix(); break;
	            case("Infanterie") : nouvelle = new Infanterie(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Tank") : nouvelle = new Tank(newX,newY,statut,false);coutUnite = nouvelle.getPrix(); break;
	            case("Convoi") : nouvelle = new Convoi(newX,newY,statut,false); coutUnite = nouvelle.getPrix();break;
	            case("Lance-Missile") : nouvelle = new LanceMissilesSolAir(newX,newY,statut,false);coutUnite = nouvelle.getPrix(); break;
	            default : new Exception("unite_inconnue");
        	}
        }
        Jeu.PLATEAU_DE_JEU.plateau.get(newY).get(newX).setUnite(nouvelle);
        Jeu.joueur_actif.setCredits(credit-coutUnite);
        
    }
}
