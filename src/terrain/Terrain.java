package terrain;

/**
 * Classe abstraite repr�sentant un terrain.
 * 
 * Un terrain est caract�ris� par ses coordonn�es x et y, ainsi qu'un identifiant.
*/
public abstract class Terrain {
	
	/** Coordonn�e x du terrain */
    protected int x;
    public int getX() {return x;}
    public void setX(int x) {this.x = x;}

    /** Coordonn�e y du terrain */
    protected int y;
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}

    /** Identifiant du terrain */
    protected String identifiant;
	public String getIdentifiant() {return identifiant;}

	/**
	 * Constructeur de la classe Terrain
	 * @param x Coordonn�e x du terrain
	 * @param y Coordonn�e y du terrain
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
