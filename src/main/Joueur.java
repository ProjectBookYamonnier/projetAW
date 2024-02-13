package main;

import java.util.LinkedList;
import java.util.List;

import plateau.Case;
import terrain.Propriete;
import unites.Unite;

public class Joueur {
	
	/** Credit du joueur */
	private int credits;
	public int getCredits() {return credits;}
	public void setCredits(int credits) {this.credits = credits;}
	
	/** Equipe d'apartenance du joueur */
	private int equipe;
	public int getEquipe() {return equipe;}
	
	/** Liste les unites possedees et disponibles */
	private List<Unite> unites_possedees_dispo;
	public List<Unite> getUnites_possedees_dispo() {return unites_possedees_dispo;}

	/** Liste les propriete possedees */
	private List<Propriete> proprietes_possedees; 
	public List<Propriete> getProprietes_possedees() {return proprietes_possedees;}
	
	/**
	 * Constructeur de la classe Joueur.
	 * Initialise les attributs de la classe Joueur.
	 * @param equipe : numero d'equipe du joueur (1 = rouge, 2 = bleu)
	*/
	public Joueur(int equipe) {
        this.equipe = equipe;
        credits = 0;
        unites_possedees_dispo = new LinkedList<>(); 
        proprietes_possedees = new LinkedList<>();
    }
	
	public void remplieLists() {
        proprietes_possedees.clear();
        unites_possedees_dispo.clear();
        for (List<Case> list : Jeu.PLATEAU_DE_JEU.plateau) {
            for (Case c : list) {
                if (c.getUnite() != null && c.getUnite().getEquipe() == equipe && c.getUnite().getDispo()) {
                    unites_possedees_dispo.add(c.getUnite());
                }
                if (c.getTerrain() instanceof Propriete && ((Propriete)c.getTerrain()).getStatut() == equipe) {
                    proprietes_possedees.add((Propriete)c.getTerrain());
                }
            }
        }
    }
	
	public void calculeCredits() {
		credits += proprietes_possedees.size()*1000;
	}
	
	

}