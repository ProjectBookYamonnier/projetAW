package unites;

import java.util.List;

import armes.Arme;
import main.Jeu;
import plateau.Case;
import terrain.QG;
import terrain.Usine;
import terrain.Ville;

/**
 * Classe abstraite representant une unite.
 * Une unite est caracterisee par ses points de vie, ses coordonnees x et y, son appartenance a une equipe (1=rouge, 2=bleu),
 * sa disponibilite, sa capacite a se deplacer sur differents types de terrains, son identifiant, son arme, son eventuelle
 * seconde arme, son prix et ses points de deplacement.
*/
public abstract class Unite {
	
	// commun a tout le monde
	
	/** Points de vie de l'unite */
	protected double pv;
	public double getPv() {return pv;}
	public void setPv(double pv) {this.pv = pv;}
	
	/** Coordonnee x de l'unite */
	protected int x;
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	
	/** Coordonnee y de l'unite */
	protected int y;
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	
	/** Appartenance de l'unite a une equipe : 1=rouge, 2=bleu */
	protected int equipe; // determiner l'appartenance a son equipe : 1=rouge, 2=bleu
	public int getEquipe() {return equipe;}

	/** Disponibilite de l'unite */
	protected boolean dispo;
	public boolean getDispo() {return dispo;}
	public void setDispo(boolean dispo) {this.dispo = dispo;}
	
	// commun au classes Type(...)
	// deplacement possible en fonction du terrain

	protected int DifForet;
	public int getDifForet() {return DifForet;}
    
	protected int DifPlaine;
	public int getDifPlaine() {return DifPlaine;}
    
	protected int DifMontagne;
	public int getDifMontagne() {return DifMontagne;}
    
	protected int DifEau;
	public int getDifEau() {return DifEau;}
    
	protected int DifPlage;
	public int getDifPlage() {return DifPlage;}
	
	protected int DifPropriete;
	public int getDifPropriete() {return DifPropriete;}
	
	// commun aux classes instanciables
	
	/** Identifiant de l'unite*/
	protected String identifiant;
	public String getIdentifiant() {return identifiant;}
	
	/** Identifinat du type */
	protected String id_type; 
	public String getId_type() {return id_type;}
	
	/** Description 1 courte de l'unite */
	protected String descriptionPart1;
	public String getDescriptionPart1() {return descriptionPart1;}
	
	/** Description 2 courte de l'unite */
	protected String descriptionPart2;
	public String getDescriptionPart2() {return descriptionPart2;}
	
	/** Description 3 courte de l'unite */
	protected String descriptionPart3;
	public String getDescriptionPart3() {return descriptionPart3;}
	
	/** Description 4 courte de l'unite */
	protected String descriptionPart4;
	public String getDescriptionPart4() {return descriptionPart4;}
	
	/** Description 5 courte de l'unite */
	protected String descriptionPart5;
	public String getDescriptionPart5() {return descriptionPart5;}
	
	

	/** Arme principale de l'unite */
	protected Arme arme;
	public Arme getArme() {return arme;}
	
	/** Arme secondaire de l'unite si il en a une */
	protected Arme arme2;
	public Arme getArme2() {return arme2;}
	
	/** Prix de l'unite dans l'Usine */
	protected int prix;
	public int getPrix() {return prix;}
    
	/** Points de deplacement de l'unite*/
	protected int ptsDeplacement;
	public int getPtsDeplacement() {return ptsDeplacement;}
	public void setPtsDeplacement(int ptsDeplacement) {this.ptsDeplacement = ptsDeplacement;}
	
	/** Boolean true si il possede plusieurs armes sinon false */
	protected boolean possedeArmeMultiple;
	public boolean isPossedeArmeMultiple() {return possedeArmeMultiple;}
	public void setPossedeArmeMultiple(boolean possedeArmeMultiple) {this.possedeArmeMultiple = possedeArmeMultiple;}
    
	/** Boolean true si il peut transporter */
	protected boolean transport;
	public boolean isTransport() {return transport;}
	public void setTransport(boolean transport) {this.transport = transport;}
	
	/** int le nombre d'unite pouvant etre transporter */
	protected int capaciteMax;
	public int getCapaciteMax() {return capaciteMax;}
	public void setCapaciteMax(int capaciteMax) {this.capaciteMax = capaciteMax;}
	
	/** int le nombre d'unite pouvant etre transporter */
	protected int capaciteActuelle;
	public int getCapaciteActuelle() {return capaciteActuelle;}
	public void setCapaciteActuelle(int capaciteActuelle) {this.capaciteActuelle = capaciteActuelle;}
	
	/** list le nombre d'unite pouvant etre transporter */
	protected List<Unite> transporter;
	public List<Unite> getTransporter() {return transporter;}
	public void setTransporter(List<Unite> transporter) {this.transporter = transporter;}
	
	
	/**
	 * @param x abscisse de la case o� l'unite sera creee
	 * @param y ordonnee de la case o� l'unite sera creee
	 * @param equipe equipe a laquelle appartient l'unite (1=rouge, 2=bleu)
	 * @param dispo indique si l'unite est disponible pour �tre deplacee (true) ou non (false)
	*/
	public Unite(int x, int y, int equipe, boolean dispo) {
		pv = 10;
		this.x = x;
		this.y = y;
		this.equipe = equipe;
		this.dispo = dispo;
	}
	
	// methodes
	
	/**
	 * Affiche l'unite ainsi que ses points de vie si necessaire
	*/
	public abstract void afficheUnite() ;
	
	/**
	 * Cette fonction permet le deplacement d'une unite
	 * @param dirX la position X pointee par la fl�che
	 * @param dirY la position Y pointee par la fl�che
	 */
	public void deplacement(int dirX, int dirY){
		Unite unite = Jeu.PLATEAU_DE_JEU.plateau.get(this.y).get(this.x).getUnite();
		if(unite != null) { //Verification que uni est bien une unite
			Case cVise = Jeu.PLATEAU_DE_JEU.plateau.get(dirX).get(dirY);
			if(cVise.getUnite() == null && // Verification qu'il n'y a pas d'unite sur la case
			   (cVise.getTerrain() instanceof QG == false) && // Verification qu'il n'y a pas de QG sur la case
			   (cVise.getTerrain() instanceof Ville == false) && // Verification qu'il n'y a pas de Ville sur la case
			   (cVise.getTerrain() instanceof Usine == false)) { // Verification qu'il n'y a pas d'Usine sur la case
					unite.setX(dirX);
					unite.setY(dirY);
			}
		}
	}
	
	/**
	 * L'unite attaquante attaque la defenseuse et la defenseuse riposte si elle est toujours vivante
	 * @param attaquante la premi�re Unite qui attaque
	 * @param defenseuse l'Unite qui est attaque et qui va riposter
	 */
	public static void attaquerRiposter(Unite attaquante, Unite defenseuse) {
		attaquante.attaquer(defenseuse);
		if(defenseuse.getPv() > 0) {
			defenseuse.attaquer(attaquante);
		}
	}
	
	protected void attaquer(Unite defenseuse) {
		String type_unite_def = ""+defenseuse.getIdentifiant();
		switch (type_unite_def) {
			case ("Bazooka") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Bazooka(), this.arme2.getDmg2Bazooka()));
					break;
				}else {
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Bazooka()); break;
				}
			case ("Bombardier") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Bombardier(), this.arme2.getDmg2Bombardier()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Bombardier()); break;
				}
			case ("DCA") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2DCA(), this.arme2.getDmg2DCA()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2DCA()); break;
				}
			case ("Helicoptere") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Helicoptere(), this.arme2.getDmg2Helicoptere()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Helicoptere()); break;
				}
			case ("Infanterie") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Infanterie(), this.arme2.getDmg2Infanterie()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Infanterie()); break;
				}
			case ("Tank") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Tank(), this.arme2.getDmg2Tank()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Tank()); break;
				}
			case ("Artillerie") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Artillerie(), this.arme2.getDmg2Artillerie()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Artillerie()); break;
				}
			case ("Barge") : 
					if(possedeArmeMultiple) {
						defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Barge(), this.arme2.getDmg2Barge()));
						break;
					}else{
						defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Barge()); break;
					}
			case ("Convoi") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Convoi(), this.arme2.getDmg2Convoi()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Convoi()); break;
				}
			case ("Corvette") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Corvette(), this.arme2.getDmg2Corvette()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Corvette()); break;
				}
			case ("Croiseur") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Croiseur(), this.arme2.getDmg2Croiseur()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Croiseur()); break;
				}
			case ("Cuirasser") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2Cuirasser(), this.arme2.getDmg2Cuirasser()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2Cuirasser()); break;
				}
			case ("Porte-Avion") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2PorteAvion(), this.arme2.getDmg2PorteAvion()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2PorteAvion()); break;
				}
			case ("Sous-Marin") : 
				if(possedeArmeMultiple) {
					defenseuse.pv -= Math.ceil(this.pv * Math.max(this.arme.getDmg2SousMarin(), this.arme2.getDmg2SousMarin()));
					break;
				}else{
					defenseuse.pv -= Math.ceil(this.pv * this.arme.getDmg2SousMarin()); break;
				}
			default : new Exception("unite_inconnue");
		}
		// si la defenseuse est morte :
				if (defenseuse.getPv() <= 0) {
					// On enleve l'unite de la case :
					Jeu.PLATEAU_DE_JEU.plateau.get(defenseuse.y).get(defenseuse.x).setUnite(null); 
					// on desactive le mode capture (si une capture etait en cours) et on remet les pv de la propriete a 20 :
					if (defenseuse instanceof TypeMarche && ((TypeMarche)defenseuse).getIs_capturing()) {
						TypeMarche unite_marche = (TypeMarche)defenseuse;
						unite_marche.setIs_capturing(false);
						unite_marche.getProp_capture().setPv(20);
						unite_marche.setProp_capture(null);
					}
				}
	}
	
}
