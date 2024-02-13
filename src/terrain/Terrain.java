package terrain;

/**
 * Classe abstraite représentant un terrain.
 * 
 * Un terrain est caractérisé par ses coordonnées x et y, ainsi qu'un identifiant.
*/
public abstract class Terrain {
	
	/** Coordonnée x du terrain */
    protected int x;
    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    /** Coordonnée y du terrain */
    protected int y;
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

    /** Identifiant du terrain */
    protected String identifiant;
	public String getIdentifiant() {return identifiant;}

	/**
	 * Constructeur de la classe Terrain
	 * @param x Coordonnée x du terrain
	 * @param y Coordonnée y du terrain
	*/
    public Terrain(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Affiche le terrain
    */
    public abstract void afficheTerrain() ;

}
