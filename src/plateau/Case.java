package plateau;

import terrain.Terrain;
import unites.Unite;

/**
 * Classe repr�sentant une case d'un plateau de jeu.
 * 
 * Une case contient un terrain et une unit�.
*/
public class Case {

	/* Le terrain de la case */
    private Terrain ter;
    /* L'unite presente sur la case */
    private Unite uni;
    
    /**
     * Constructeur de la classe Case
     * @param terrain Le terrain de la case
     * @param unite L'unite presente sur la case
    */
    public Case(Terrain terrain, Unite unite) {
        this.ter = terrain;
        this.uni = unite;
    }

    /**
     * Obtient le terrain de la case
     * @return Le terrain de la case
    */
    public Terrain getTerrain() {
        return ter;
    }

    /**
     * Obtient l'unite presente sur la case
     * @return L'unite presente sur la case
    */
    public Unite getUnite() {
        return uni;
    }

    /**
     * Definit l'unite presente sur la case
     * @param unite L'unite a definir sur la case
    */
    public void setUnite(Unite unite) {
        this.uni = unite;
    }

}