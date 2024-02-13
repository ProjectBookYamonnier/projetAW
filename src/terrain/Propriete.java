package terrain;

/**
 * Classe abstraite représentant une propriété.
 * 
 * Une propriété est un terrain qui peut être possédé par une équipe, et qui a un certain nombre de points de vie.
*/
public abstract class Propriete extends Terrain {
    
	/** Statut de la propriété (0=neutre, 1=rouge, 2=bleu) */
    protected int statut;
    public int getStatut() {return statut;}
    public void setStatut(int statut) {this.statut = statut;}
        
    /** Points de vie de la propriété */
    protected double pv;
    public double getPv() {return pv;}
    public void setPv(double pv) {this.pv = pv;}
    
    /**
     * Constructeur de la classe Propriété*
     * @param x Coordonnée x de la propriété
     * @param y Coordonnée y de la propriété
     * @param statut Statut de la propriété (0=neutre, 1=rouge, 2=bleu)
    */
    public Propriete(int x, int y, int statut) {
        super(x,y);
        this.statut = statut;
        identifiant = "Propriete";
        pv = 20;
    }
    
}
