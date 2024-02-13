package terrain;

/**
 * Classe abstraite repr�sentant une propri�t�.
 * 
 * Une propri�t� est un terrain qui peut �tre poss�d� par une �quipe, et qui a un certain nombre de points de vie.
*/
public abstract class Propriete extends Terrain {
    
	/** Statut de la propri�t� (0=neutre, 1=rouge, 2=bleu) */
    protected int statut;
    public int getStatut() {return statut;}
    public void setStatut(int statut) {this.statut = statut;}
        
    /** Points de vie de la propri�t� */
    protected double pv;
    public double getPv() {return pv;}
    public void setPv(double pv) {this.pv = pv;}
    
    /**
     * Constructeur de la classe Propri�t�*
     * @param x Coordonn�e x de la propri�t�
     * @param y Coordonn�e y de la propri�t�
     * @param statut Statut de la propri�t� (0=neutre, 1=rouge, 2=bleu)
    */
    public Propriete(int x, int y, int statut) {
        super(x,y);
        this.statut = statut;
        identifiant = "Propriete";
        pv = 20;
    }
    
}
