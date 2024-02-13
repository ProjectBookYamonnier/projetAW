package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import librairies.AssociationTouches;
import librairies.StdDraw;
import plateau.Case;
import plateau.Plateau;
import ressources.Affichage;
import ressources.Chemins;
import ressources.Config;
import ressources.ParseurCartes;
import terrain.Eau;
import terrain.Montagne;
import terrain.Plage;
import terrain.Propriete;
import terrain.QG;
import terrain.Terrain;
import terrain.Usine;
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
import unites.TypeAerien;
import unites.TypeChenilles;
import unites.TypeMarche;
import unites.TypeNavale;
import unites.Unite;

public class Jeu {
	
	/**
	 * Classe interne Coord de la classe Jeu.
	 * Cette classe permet de stocker les coordonnees (x, y) d'une case sur le plateau de jeu.
	 * @param x : Coordonnee x de la case
	 * @param y : Coordonnee y de la case (Config.longueurCarteYCases-1 par defaut)
	*/
	private static class Coord {
		public int x;
		public int y;
		
		/**
		 * Constructeur de la classe Coord.
		 * Initialise les attributs x et y de la classe Coord
		 * @param x : Coordonnee x de la case
		 * @param y : Coordonnee y de la case
		*/
		public Coord(int x, int y) {
			this.x = x;
			this.y = Config.longueurCarteYCases-y-1;
		}
	}
	
	/*
	 * Attributs
	 */
	
	
	public static Joueur joueur_actif; // pointe vers j1 ou j2
	public static Plateau PLATEAU_DE_JEU;
	private int posX;
	private int posY;
	private int numero_de_manche;
	private Joueur j1;
	private Joueur j2;
	private boolean deplacement_active;
	private List<Coord> repertoire_fleche;
	private Unite unite_deplacee;
//	public String meteoActuel;
//	public String meteoSuivant;
	
	
	
	/**
	 * Constructeur de la classe Jeu qui permet de creer une nouvelle partie a partir d'un fichier contenant la carte.
	 * @param fileName Le nom du fichier contenant la carte.
	 * @throws Exception Si une erreur se produit lors de la lecture du fichier.
	*/
	public Jeu(String fileName) throws Exception {
		//appel au parseur, qui renvoie un tableau de String 
		String[][] carteString = ParseurCartes.parseCarte(fileName);
		for (int i = 0; i<carteString.length; i++) {
			for (int j=0; j < carteString[0].length; j++) {
				System.out.print(carteString[i][j]);
				if (j != carteString[0].length) {
						System.out.print(" | ");
				}
				else {
					System.out.println();
				}
			}
			System.out.println();
		}
		
		Config.setDimension(carteString[0].length, carteString.length);
		// initialise la configuration avec la longueur de la carte
		
		/*
		 * init attributs
		 */
		
		PLATEAU_DE_JEU = new Plateau(carteString);
		posX = 0;
		posY = 0;
		numero_de_manche = 1;
//		meteoActuel = Meteo.meteoAleatoire(true, numero_de_manche);//Au joueur de choisir si il veulent mettre un temps aleatoire dans leur jeu
		deplacement_active = false;
		repertoire_fleche = new LinkedList<>();
		unite_deplacee = null;
		j1 = new Joueur(1);
		j2 = new Joueur(2);
		joueur_actif = j1; // rouge commence
		
		joueur_actif.remplieLists();
		joueur_actif.calculeCredits();
		
	}

	/**
	 * Methode isOver de la classe Jeu.
	 * Cette methode verifie si la partie est terminee en verifiant si un joueur a remporte la victoire.
	 * 
	 * La methode parcours le plateau de jeu et ajoute les QG, usines et unites appartenant a l'adversaire dans des listes.
	 * Elle verifie ensuite si la taille de ces listes est egale a 0, et si c'est le cas, affiche un message de victoire pour l'equipe du joueur actif.
	 * Elle verifie egalement si les deux QG appartiennent a la même equipe, et si c'est le cas, affiche egalement un message de victoire pour l'equipe du joueur actif.
	 * Enfin, elle retourne false si la partie n'est pas terminee.
	*/
	public boolean isOver() {
		List<Terrain> list_QGs = new LinkedList<>();
		List<Terrain> list_usines = new LinkedList<>();
		List<Unite> list_unites = new LinkedList<>();
		Joueur joueur_adverse = null;
		if (joueur_actif == j1) joueur_adverse = j2;
		else joueur_adverse = j1;
		for (List<Case> list : PLATEAU_DE_JEU.plateau) {
			for (Case c : list) {
				if (c.getTerrain() instanceof QG) {
					list_QGs.add(c.getTerrain());
				}
				if (c.getTerrain() instanceof Usine && ((Usine)c.getTerrain()).getStatut() == joueur_adverse.getEquipe()) {
					list_usines.add(c.getTerrain());
				}
				if (c.getUnite() != null && c.getUnite().getEquipe() == joueur_adverse.getEquipe()) {
					list_unites.add(c.getUnite());
				}
			}
		}
		int equipe_int = joueur_actif.getEquipe();
		String equipe_str = "";
		switch (equipe_int) {
			case (1) : equipe_str = "Rouge"; break;
			case (2) : equipe_str = "Bleu";
		}
		if (list_usines.size() == 0 && list_unites.size() == 0) {
			String [] options = {"L'adversaire n'a plus d'unite dispo", "L'aversaire ne peut plus produire d'unites", "(presser entrer pour terminer)"};
			Affichage.popup("L'equipe "+equipe_str+" a gagne !", options, false, 0);
			return true;
		}
		QG qg1 = (QG)list_QGs.get(0);
		QG qg2 = (QG)list_QGs.get(1);
		if (qg1.getStatut() == qg2.getStatut()) {
			String [] options = {"QG adversaire capture", "(presser entrer pour terminer)"};
			Affichage.popup("L'equipe "+equipe_str+" a gagne !", options, false, 0);
			return true;
		}
		return false;
	}

	/**
	 * Methode afficheStatutJeu de la classe Jeu.
	 * Cette methode affiche le statut actuel de la partie dans la zone de texte dediee de l'interface graphique.
	 * Elle affiche le numero de manche, l'equipe actuellement active et le nombre de credits possedes par cette equipe.
	 * Elle utilise la methode afficheTexteDescriptif de la classe Affichage pour afficher ces informations.
	*/
	public void afficheStatutJeu() {
		switch(joueur_actif.getEquipe()) {
			case (1) :
				Affichage.afficheTexteDescriptif("Manche n°"+numero_de_manche+" | Equipe Rouge | Credits : " + j1.getCredits());
				break;
			case (2) :
				Affichage.afficheTexteDescriptif("Manche n°"+numero_de_manche+" | Equipe Bleue | Credits : " + j2.getCredits());
				break;
			default :
				new Exception("joueurActif incoherent");
		}
	}
	
	/**
	 * Methode initialDisplay de la classe Jeu.
	 * Cette methode initialise l'affichage graphique en activant le double buffering avec StdDraw.enableDoubleBuffering()
	 * et en appelant la methode display() pour dessiner l'interface graphique initiale.
	 * Le double buffering permet de rendre l'affichage plus fluide en mettant tous les dessins en memoire tampon et en ne les affichant qu'au prochain appel de StdDraw.show().
	*/
	public void initialDisplay() {
		StdDraw.enableDoubleBuffering(); // rend l'affichage plus fluide: tout draw est mis en buffer et ne s'affiche qu'au prochain StdDraw.show();
		display();
	}

	/**
	 * Methode display de la classe Jeu.
	 * Cette methode gère l'affichage graphique de l'interface de jeu en appelant differentes methodes d'affichage.
	 * Elle utilise StdDraw.clear() pour effacer l'affichage precedent, puis appelle la methode afficheStatutJeu() pour afficher le statut actuel de la partie.
	 * Elle parcours ensuite le plateau de jeu et appelle les methodes afficheTerrain() et afficheUnite() des cases pour afficher les terrains et les unites.
	 * Si le deplacement d'unites est actif, elle appelle la methode drawGameArrow() pour afficher les flèches de deplacement.
	 * Elle appelle ensuite la methode Affichage.dessineGrille() pour dessiner une grille autour des cases, puis drawGameCursor() pour dessiner le curseur de selection de case.
	 * Enfin, elle utilise StdDraw.show() pour afficher les modifications sur l'ecran.
	*/
	public void display() {
		StdDraw.clear();
		afficheStatutJeu();
		for (List<Case> list : PLATEAU_DE_JEU.plateau) {
			for (Case c : list) {
				c.getTerrain().afficheTerrain();
				if (c.getUnite() != null) {
					c.getUnite().afficheUnite();
				}
			}
		}
		if (deplacement_active)
			drawGameArrow();
		Affichage.dessineGrille(); // affiche une grille, mais n'affiche rien dans les cases
		drawGameCursor(posX, posY);
		StdDraw.show(); // montre a l'ecran les changement demandes
	}

	/**
	 * Dessine le curseur de jeu a l'emplacement specifie (x, y).
	 * @param x La coordonnee x où dessiner le curseur.
	 * @param y La coordonnee y où dessiner le curseur.
	*/

	public void drawGameCursor(int x, int y) {
		Affichage.dessineCurseur(x, y);
	}
	
	/**
	 * Met a jour le jeu en reagissant aux entrees de l'utilisateur. Cette methode boucle jusqu'a ce qu'une entree soit detectee, puis reagit en consequence.
	 * Si l'utilisateur appuie sur la touche HAUT, le curseur de jeu est deplace vers le haut. Si l'utilisateur appuie sur la touche BAS, le curseur de jeu est deplace vers le bas.
	 * Si l'utilisateur appuie sur la touche GAUCHE, le curseur de jeu est deplace vers la gauche. Si l'utilisateur appuie sur la touche DROITE, le curseur de jeu est deplace vers la droite.
	*/
	public void update() {
		AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree(); //cette fonction boucle jusqu'a la prochaine entree de l'utilisateur
		joueur_actif.remplieLists();
		if (toucheSuivante.isHaut()) {
			System.out.println("Touche HAUT");
			// deplacer le curseur vers le haut
			if (coordValides(posX,posY+1)) posY++;
			deplacerFleche();
		}
		else if (toucheSuivante.isBas()){
			System.out.println("Touche BAS");
			// deplacer le curseur vers le bas
			if (coordValides(posX,posY-1)) posY--;
			deplacerFleche();
		}
		else if (toucheSuivante.isGauche()) { 
			System.out.println("Touche GAUCHE");
			// deplacer le curseur vers la gauche
			if (coordValides(posX-1,posY)) posX--;
			deplacerFleche();
		}
		else if (toucheSuivante.isDroite()) { 
			System.out.println("Touche DROITE");
			// deplacer le curseur vers la droite
			if (coordValides(posX+1,posY)) posX++;
			deplacerFleche();
		}
		else if (toucheSuivante.isEntree()) { 
			System.out.println("Touche ENTREE");
			// pour parcourir la List<List<Case>> "plateau", on le fait en partant d'en haut � gauche :
			int y = Config.longueurCarteYCases - posY - 1;
			
			Case actuelle = PLATEAU_DE_JEU.plateau.get(y).get(posX); 
			Unite unite = actuelle.getUnite();
			Terrain terrain = actuelle.getTerrain();
			
			// confirmer le deplacement d'une unite et gestion de l'action a effectuer :
			if (deplacement_active) { 
				// si il n'y a personne (deplacement classique) ou si unite_deplacee est deja la (deplacement zero) : 
				if (unite == null || unite == unite_deplacee) {
					// si l'unite realisait une capture, on l'annule :
					if (unite_deplacee instanceof TypeMarche && ((TypeMarche)unite_deplacee).getIs_capturing() && unite != unite_deplacee) {
						TypeMarche unite_marche = (TypeMarche)unite_deplacee;
						unite_marche.setIs_capturing(false);
						unite_marche.getProp_capture().setPv(20);
						unite_marche.setProp_capture(null);
					}
					// confirmation du deplacement :
					PLATEAU_DE_JEU.plateau.get(unite_deplacee.getY()).get(unite_deplacee.getX()).setUnite(null);
					actuelle.setUnite(unite_deplacee);
					unite_deplacee.setX(posX);
					unite_deplacee.setY(y);
					deplacement_active = false;
					repertoire_fleche.clear();
					display();
					// ajout dans une List des differentes actions que peut realiser unite_deplacee :
					List<String> list_actions = new ArrayList<>();
					list_actions.add("Attendre");
					List<Unite> list_unites_attaquables = null;
					if(!(unite_deplacee instanceof Barge || unite_deplacee instanceof Convoi)) {
						list_unites_attaquables = unitesDansPortee(unite_deplacee.getArme().getPorteeMin(), unite_deplacee.getArme().getPorteeMax());//ennemiAProximite();
						if (list_unites_attaquables.size() != 0) {
							list_actions.add("Attaquer");
						}
					}
					if (unite_deplacee instanceof TypeMarche && 
							terrain instanceof Propriete && 
							((Propriete)terrain).getStatut() != joueur_actif.getEquipe()) {
                        list_actions.add("Capturer");
                    }
					Case c_transport = Plateau.verifUniteAProximite(posX, posY, false, false);
					Unite unite_de_transport = null;
					if(c_transport != null) unite_de_transport = c_transport.getUnite();
					if(unite_de_transport != null) {
						if((unite_de_transport.getCapaciteActuelle() < unite_de_transport.getCapaciteMax()) && ((unite_deplacee instanceof TypeMarche && (unite_de_transport instanceof Barge ||
	    			unite_de_transport instanceof Convoi || unite_de_transport instanceof Corvette ||
	    			unite_de_transport instanceof Helicoptere)) || unite_deplacee instanceof TypeAerien && 
								unite_de_transport instanceof PorteAvion)) {
							list_actions.add("Rentrer");
							
							
						}
					}
					Case libre = null;
					if(unite_deplacee != null) {
						if(unite_deplacee instanceof Barge ||
				    			unite_deplacee instanceof Convoi || unite_deplacee instanceof Corvette ||
				    			unite_deplacee instanceof Helicoptere || unite_deplacee instanceof PorteAvion) {
							if(unite_deplacee.getCapaciteActuelle() > 0) {
								if(unite_deplacee instanceof PorteAvion) {
									libre = Plateau.verifUniteAProximite(posX, posY, true, true);
								}else {
									libre = Plateau.verifUniteAProximite(posX, posY, true, false);
								}
								if (libre != null) {
									list_actions.add("Sortir");
								}
							}
						}
					}
					
					String [] tab_actions = fromListToTab(list_actions);
					int choix = Affichage.popup("Quelle action souhaitez-vous realiser ?", tab_actions, false, 0);
					// choix de l'action a realiser :
					switch (tab_actions[choix]) {
						case ("Attendre") : break;
						case ("Attaquer") : selectionneEtAttaque(list_unites_attaquables); break;
						case ("Capturer") : ((TypeMarche)unite_deplacee).capturer((Propriete)terrain);break;
						case ("Rentrer") : 
							System.out.println(unite_deplacee +" "+ unite_de_transport);
							rentrer(unite_de_transport.getTransporter(),unite_deplacee, unite_de_transport);break;
						case ("Sortir") :
							if(unite_deplacee instanceof PorteAvion) {
								sortir(unite_deplacee.getTransporter(), Plateau.verifUniteAProximite(posX, posY, true, true), unite_deplacee);
							}else {
								sortir(unite_deplacee.getTransporter(),Plateau.verifUniteAProximite(posX, posY, true, false), unite_deplacee);}
					}
					// manip de fin :
					unite_deplacee.setDispo(false);
					unite_deplacee = null;
				}
			}
			
			// commencer a deplacer une unite :
			else if (unite != null && unite.getDispo() && unite.getEquipe() == joueur_actif.getEquipe()) {
				repertoire_fleche.add(new Coord(posX,posY));
				drawGameArrow();
				deplacement_active = true;
				unite_deplacee = unite;
			}
			
			// acheter une unite :
			else if (terrain instanceof Usine && joueur_actif.getCredits() >= 1500) {
				Usine usine = (Usine)terrain;
				if (usine.getStatut() == joueur_actif.getEquipe()) {
					Unite [] listeUtiliser;
					Case avecEauOuPas = Plateau.presenceEau(usine.getX(), usine.getY());
					boolean presenceEau = PLATEAU_DE_JEU.plateau.get(usine.getY()).get(usine.getX()) != avecEauOuPas;
					// on met des valeurs improbables pour init les Unites car on a juste besoin de recuperer l'info du prix :
					// on ajoute dans une liste les unites achetables :
					if(presenceEau) {
						Unite [] all_options_eau = {new Bazooka(-1,-1,0,false),
								new Bombardier(-1,-1,0,false),
								new DCA(-1,-1,0,false),
								new Helicoptere(-1,-1,0,false),
								new Infanterie(-1,-1,0,false),
								new Tank(-1,-1,0,false),
								new Artillerie(-1,-1,0,false),
								new LanceMissilesSolAir(-1,-1,0,false),
								new Barge(-1,-1,0,false),
								new Convoi(-1,-1,0,false),
								new Corvette(-1,-1,0,false),
								new Croiseur(-1,-1,0,false),
								new PorteAvion(-1,-1,0,false),
								new SousMarin(-1,-1,0,false),
								new Cuirasser(-1,-1,0,false)};
						listeUtiliser = all_options_eau;
					}else {
						Unite [] all_options = {new Bazooka(-1,-1,0,false),
								new Bombardier(-1,-1,0,false),
								new DCA(-1,-1,0,false),
								new Helicoptere(-1,-1,0,false),
								new Infanterie(-1,-1,0,false),
								new Tank(-1,-1,0,false),
								new Artillerie(-1,-1,0,false),
								new LanceMissilesSolAir(-1,-1,0,false)};
						listeUtiliser = all_options;
					}
					List<String> options_list = new LinkedList<>();
					for (Unite u : listeUtiliser) {
						if (joueur_actif.getCredits() >= u.getPrix()) {
							options_list.add(u.getIdentifiant()+" ("+u.getDescriptionPart2()+") ");
						}
					}
					// on convertit la liste en tableau :
					// (on se permet toutes ses etapes comme le nombre d'unites n'est pas gigantesque)
					String [] options_tab = fromListToTab(options_list);
					int choix = Affichage.popup("Que voulez-vous acheter ?", options_tab, true, 0);
					if(choix != -1) {
						if(joueur_actif.getCredits() >= 1500){
							usine.creerUnite(options_tab[choix],joueur_actif.getCredits(),avecEauOuPas);
						}
					}
				}
			}
		}
		else if (toucheSuivante.isEchap()) { 
			// annuler le deplacement d'une unite :
			if (deplacement_active) {
				repertoire_fleche.clear();
				deplacement_active = false;
				unite_deplacee = null;
			}
		}
		//  ATTENTION ! si vous voulez detecter d'autres touches que 't',
		//  vous devez les ajouter au tableau Config.TOUCHES_PERTINENTES_CARACTERES
		else if (toucheSuivante.isCaractere('t')) {
			String[] options = {"Oui", "Non"};
			String nom_joueur = "";
			switch (joueur_actif.getEquipe()) {
				case (1) : nom_joueur = "l'equipe Rouge"; break;
				case (2) : nom_joueur = "l'equipe Bleue"; break;
			}
			if (Affichage.popup("Finir le tour de "+nom_joueur+" ?", options, true, 1) == 0) {
				System.out.println("FIN DE TOUR");
				actionsFinDeTour();
			}
		}
		else if (toucheSuivante.isCaractere('d')) {
			System.out.println("Touche d");
			int y = Config.longueurCarteYCases-posY-1;
			Unite desc = PLATEAU_DE_JEU.plateau.get(y).get(posX).getUnite();
			if (desc != null) {
				if(desc.getEquipe() == joueur_actif.getEquipe()) {
					String [] information = {desc.getDescriptionPart1()," "+desc.getDescriptionPart2(),desc.getDescriptionPart3(),desc.getDescriptionPart4(),desc.getDescriptionPart5()};
					Affichage.popup("Voici les informations souhaitees :", information, true, 0);
				}else {
					String [] AucInformation = {"OK"};
					Affichage.popup("Vous n'êtes pas autorise a voir les proprietes de cette unite", AucInformation, true, 0);
				}
			}
		}
		else if (toucheSuivante.isCaractere('p')) { 
            int y = Config.longueurCarteYCases-posY-1;
            Terrain desc = PLATEAU_DE_JEU.plateau.get(y).get(posX).getTerrain();
            if (desc != null && desc instanceof Propriete) {
                String [] information = {"Son nom est " + desc.getIdentifiant(),"PV = "+((Propriete)desc).getPv()};
                Affichage.popup("Voici les informations souhaitee :", information, true, 0);
            }
        }
		else if (toucheSuivante.isCaractere('u') && !deplacement_active) {
            if (!joueur_actif.getUnites_possedees_dispo().isEmpty()) {
                for (int i=0 ; i<joueur_actif.getUnites_possedees_dispo().size() ; i++) {
                    posX = joueur_actif.getUnites_possedees_dispo().get(i).getX();
                    posY = Config.longueurCarteYCases - joueur_actif.getUnites_possedees_dispo().get(i).getY() - 1;
                    display();
                    AssociationTouches toucheSuivante2 = AssociationTouches.trouveProchaineEntree();
                    if (toucheSuivante2.isCaractere('u')) {
                        if (i==joueur_actif.getUnites_possedees_dispo().size()-1) {
                            i=-1;
                        }
                    }
                    else {
                        display();
                        break; // on sort du for car le joueur souhaite sortir de la selection d'unite avec 'u'
                    }
                }
            }
            else {
                String[] options = {"OK"};
                Affichage.popup("Plus d'unites disponibles !", options, false, 0);
            }
        }
		if (plusDactionsPossibles() ) {
            display();
            String[] options = {"Confirmer"};
            if (Affichage.popup("Fin de tour automatique !", options, false, 0) == 0) {
                System.out.println("FIN DE TOUR AUTOMATIQUE");
                actionsFinDeTour();
            }
        }
		display();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////METHODES POUR L'AFFICHAGE DE LA FLECHE//////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Dessine une flèche sur le plateau de jeu en suivant les coordonnees specifiees dans le repertoire de flèche. La flèche est dessinee en utilisant des images stockees dans des chemins specifiques.
	 * La flèche est dessinee en partant de la première coordonnee specifiee jusqu'a la dernière, en suivant les coordonnees suivantes pour dessiner les sections de flèche.
	 * Si la direction precedente est vers la gauche et la direction actuelle est vers la droite, alors la flèche sera dessinee avec une section droite.
	 * Si la direction precedente est vers le haut et la direction actuelle est vers le bas, alors la flèche sera dessinee avec une section basse.
	*/
	public void drawGameArrow() {
		String direction_precedente = null;
		for (Coord coord : repertoire_fleche) {
			int x = coord.x;
			int y = coord.y;
			int index = repertoire_fleche.indexOf(coord);
			switch (index) {
				case (0) :
					Affichage.dessineImageDansCase(x, y, Chemins.getCheminFleche(Chemins.DIRECTION_DEBUT,Chemins.DIRECTION_FIN));
					direction_precedente = Chemins.DIRECTION_DEBUT;
					break;
				default :
					if (index != repertoire_fleche.size()) {
						int old_x = repertoire_fleche.get(index-1).x;
						int old_y = repertoire_fleche.get(index-1).y;
						if (index > 1) {
							clearArrowCase(old_x,old_y); // on supprime la fin de fleche de la case precedente
						}
						if (old_x < x) {
							Affichage.dessineImageDansCase(old_x, old_y, Chemins.getCheminFleche(direction_precedente, Chemins.DIRECTION_DROITE));
							Affichage.dessineImageDansCase(x, y, Chemins.getCheminFleche(Chemins.DIRECTION_GAUCHE, Chemins.DIRECTION_FIN));
							direction_precedente = Chemins.DIRECTION_GAUCHE;
						}
						else if (old_x > x) {
							Affichage.dessineImageDansCase(old_x, old_y, Chemins.getCheminFleche(direction_precedente, Chemins.DIRECTION_GAUCHE));
							Affichage.dessineImageDansCase(x, y, Chemins.getCheminFleche(Chemins.DIRECTION_DROITE, Chemins.DIRECTION_FIN));
							direction_precedente = Chemins.DIRECTION_DROITE;
						}
						else if (old_y > y) {
							Affichage.dessineImageDansCase(old_x, old_y, Chemins.getCheminFleche(direction_precedente, Chemins.DIRECTION_HAUT));
							Affichage.dessineImageDansCase(x, y, Chemins.getCheminFleche(Chemins.DIRECTION_BAS, Chemins.DIRECTION_FIN));
							direction_precedente = Chemins.DIRECTION_BAS;
						}
						else if (old_y < y) {
							Affichage.dessineImageDansCase(old_x, old_y, Chemins.getCheminFleche(direction_precedente, Chemins.DIRECTION_BAS));
							Affichage.dessineImageDansCase(x, y, Chemins.getCheminFleche(Chemins.DIRECTION_HAUT, Chemins.DIRECTION_FIN));
							direction_precedente = Chemins.DIRECTION_HAUT;
						}
					}
			}
		}
	}
	
	/**
	 * reimprime le terrain et l'unite de la case (x,y) pour "effacer" la fin de fleche qui s'y trouve
	 * @param x un int
	 * @param y un int
	 */
	public void clearArrowCase(int x, int y) {
		Case c = PLATEAU_DE_JEU.plateau.get(y).get(x);
		c.getTerrain().afficheTerrain();
		if (c.getUnite() != null)
			c.getUnite().afficheUnite();
	}
	

	/**
	 * Deplace la fleche
	 */
	public void deplacerFleche() {
		if (deplacement_active) {
			int pts_dep = unite_deplacee.getPtsDeplacement();
			if (pts_dep >= repertoire_fleche.size() && terrainAccessible()) {
				ajouterCoord();
			}
			else {
				boolean etape_suiv = true;
				for (Coord coord : repertoire_fleche) {
					// le joueur essaye de revenir en arriere (par une boucle ou en revenant sur ses pas) :
					if (coord.x == posX && coord.y == Config.longueurCarteYCases - posY - 1) {
						ajouterCoord();
						etape_suiv = false;
						break; // on sort du for quand la coord a ete trouvee
					}
				}
				// on reste ou on est si le joueur essaye d'ajouter une coordonnee inaccessible :
				if (etape_suiv) {
					posX = repertoire_fleche.get(repertoire_fleche.size()-1).x;
					posY = Config.longueurCarteYCases - repertoire_fleche.get(repertoire_fleche.size()-1).y - 1;
				}
			}
		}
	}
	
	/**
	 * Ajoute une nouvelle coordonnee a repFleche
	 * si la coordonnee s'y trouve deja, on ne garde que la liste du debut jusqu'a avant l'occurence de cette valeur, puis on l'ajoute
	 */
	public void ajouterCoord() { 
		for (int i=0 ; i<repertoire_fleche.size() ; i++) {
			if (repertoire_fleche.get(i).x == posX && repertoire_fleche.get(i).y == Config.longueurCarteYCases - posY - 1) {
				repertoire_fleche = repertoire_fleche.subList(0, i);
			}
		}
		repertoire_fleche.add(new Coord(posX,posY));
	}
	
	/**
     * Verifie si unite_deplacee peut se rendre sur la case de coord (posX,posY)
     * @return true si oui, false sinon
     */
    public boolean terrainAccessible() {
        int x = posX;
        int y = Config.longueurCarteYCases - posY - 1;
        Terrain terrain = PLATEAU_DE_JEU.plateau.get(y).get(x).getTerrain();
        if (unite_deplacee instanceof TypeMarche) {
            if (terrain instanceof Eau) {
                return false;
            }
        }
        else if (unite_deplacee instanceof TypeChenilles) {
            if (terrain instanceof Eau || terrain instanceof Montagne) {
                return false;
            }
        }
        else if(unite_deplacee instanceof Barge) {
        	if(terrain instanceof Eau || terrain instanceof Plage) {
        		return true;
        	}else {
        		return false;
        	}
        }
        else if (unite_deplacee instanceof TypeNavale) {
        	if(!(terrain instanceof Eau)) {
        		return false;
        	}
        }
        return true;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////METHODES POUR L'ACTION "RENTRER"///////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
    /**
     * Cette methode permet de rentrer une unite dans un transport.
     * 
     * Elle verifie d'abord que la capacite actuelle du transport est inferieure ou egale a sa capacite maximale.
     * Si c'est le cas, elle ajoute l'unite a la liste d'unites, incremente la capacite actuelle du transport de 1 
     * et met a null la case du plateau de jeu sur laquelle se trouvait l'unite.
     * 
     * @param listUnite une liste d'unites deja presente dans le transport
     * @param unite une unite a rentrer
     * @param transport une unite de transport
    */
	public static void rentrer(List<Unite> listUnite, Unite unite, Unite transport) {
		int x = unite.getX();
		int y = unite.getY();
	    if (unite.getCapaciteActuelle() <= unite.getCapaciteMax()) {
	    		listUnite.add(unite);
	    		transport.setCapaciteActuelle(transport.getCapaciteActuelle()+1);
	    		Jeu.PLATEAU_DE_JEU.plateau.get(y).get(x).setUnite(null);
	    }
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////METHODES POUR L'ACTION "SORTIR"///////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Cette methode permet de sortir une unite d'un transport.
	 *
	 * Elle cree un tableau d'identifiants d'unites contenues dans le transport en utilisant la capacite actuelle du transport.
	 * Elle utilise ensuite une fenêtre de dialogue pour demander a l'utilisateur quelle unite il souhaite sortir parmi celles disponibles.
	 * Selon le choix de l'utilisateur, elle recupère l'unite correspondante dans la liste d'unites, decremente la capacite actuelle du transport de 1,
	 * met a jour les coordonnees de l'unite sortie et place cette unite sur la case libre passee en entree.
	 * 
	 * @param listUnite une liste d'unites presente dans le transport
	 * @param libre une case libre où placer l'unite sortie
	 * @param transport une unite de transport
	*/
	public static void sortir(List<Unite> listUnite, Case libre, Unite transport) {
		
		String [] id_uni = new String[transport.getCapaciteActuelle()];
		for(int i = 0; i < transport.getCapaciteActuelle(); i++) {
			Unite u = listUnite.get(i);
			if(u != null) {
				id_uni[i] = u.getIdentifiant();
			}
		}
		int choix = Affichage.popup("Quelle unite voulez-vous sortir ?", id_uni, false, 0);
		switch(choix) {
			case(0) : 
				Unite stock = listUnite.get(0);
				transport.setCapaciteActuelle(transport.getCapaciteActuelle()-1);
				stock.setX(libre.getTerrain().getX());
				stock.setY(libre.getTerrain().getY());
				libre.setUnite(stock);
				break;
			case(1) : 
				Unite stock1 = listUnite.get(1);
				transport.setCapaciteActuelle(transport.getCapaciteActuelle()-1);
				stock1.setX(libre.getTerrain().getX());
				stock1.setY(libre.getTerrain().getY());
				libre.setUnite(stock1);break;
		}
	}
    
//////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////METHODES POUR L'ACTION "ATTAQUER"///////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Renvoie une liste d'unites dans un intervalle donne de l'unite deplacee.
	 * Si l'unite deplacee est une barge ou un convoi, une liste vide est retournee.
	 * @param porteeMin la plage minimale des unites a renvoyer
	 * @param porteeMax la portee maximale des unites a renvoyer
	 * @return une liste d'unites dans l'intervalle donne qui ne sont pas dans la même equipe que le joueur actif.
	*/
	public List<Unite> unitesDansPortee(int porteeMin, int porteeMax) {
	    List<Unite> unitesDansPortee = new ArrayList<>();
	    if (unite_deplacee instanceof Barge || unite_deplacee instanceof Convoi) {
	        return unitesDansPortee;
	    }
	    // utilisation d'une HashMap pour stocker les unites et leur position
	    HashMap<Unite, Point> positions = new HashMap<>();
	    for (List<Case> ligne : PLATEAU_DE_JEU.plateau) {
	        for (Case c : ligne) {
	            if (c.getUnite() != null) {
	                positions.put(c.getUnite(), new Point(c.getTerrain().getX(), c.getTerrain().getY()));
	            }
	        }
	    }
	    // calcul de la distance entre l'unite deplacee et les autres unites
	    for (Unite u : positions.keySet()) {
	        if (u != unite_deplacee) {
	            int distance = (int) Math.sqrt(Math.pow(positions.get(u).x - positions.get(unite_deplacee).x, 2) + Math.pow(positions.get(u).y - positions.get(unite_deplacee).y, 2));
	            if (distance >= porteeMin && distance <= porteeMax && u.getEquipe() != joueur_actif.getEquipe()) {
	                unitesDansPortee.add(u);
	            }
	        }
	    }
	    return unitesDansPortee;
	}

	
	/**
	 * Le joueur navigue dans la liste entree en parametre et selectionne celle qu'il veut attaquer, puis l'attaque
	 * Il navigue en appuyant sur la touche DROITE du clavier, un 2e curseur se deplace d'unite en unite sur le plateau
	 * @param list une List d'Unites
	 */
	public void selectionneEtAttaque(List<Unite> list) {
		if(!(unite_deplacee instanceof Barge)) {
			for (int i=0 ; i<list.size() ; i++) {
				int x = list.get(i).getX();
				int y = Config.longueurCarteYCases - list.get(i).getY() -1;
				display();
				drawGameCursorAttaque(x, y);
				StdDraw.show();
				AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree(); //cette fonction boucle jusqu'a la prochaine entree de l'utilisateur
				if (toucheSuivante.isDroite()) {
					if (i == list.size()-1) {
						i = -1;
					}
				}
				else if (toucheSuivante.isEntree()) {
					Unite defenseuse = list.get(i); 
					Unite.attaquerRiposter(unite_deplacee, defenseuse);
					return;
				}
				else {
					i--;
				}
			}
		}else {
			String [] tab = new String[1];
			tab[0] = "OK";
			Affichage.popup("Cette unite ne possède pas d'arme pour attaquer", tab, true, 0);
		}
		
	}
	
	/**
	 * Dessine le curseur de jeu a l'emplacement specifie (x, y).
	 * @param x La coordonnee x où dessiner le curseur.
	 * @param y La coordonnee y où dessiner le curseur.
	*/

	public void drawGameCursorAttaque(int x, int y) {
		y = Config.longueurCarteYCases-y-1;
		Affichage.dessineImageDansCase(x, y, Chemins.CHEMIN_CIBLE_ATTAQUE);
	}
	
////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////METHODES ANNEXES//////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

	/**
     * Verifie si le joueur courant n'a plus d'action a effectuer selon ces criteres :
     *  - pas de creation d'unite possible
     *      - pas d'usines de possedees
     *      - pas d'usines de dispo
     *      - nombre de credits inf a 1500
     *  - plus d'unite pouvant executer des actions
     *      - toutes indispo
     *      - plus d'unites
     * @return true si joueur_actif n'a plus d'action a effectuer, false sinon
     */
    public boolean plusDactionsPossibles() {
        for (List<Case> list : PLATEAU_DE_JEU.plateau) {
            for (Case c : list) {
                Terrain terrain = c.getTerrain();
                if (joueur_actif.getCredits() >= 1500) {
                    // c'est une usine && elle appartient au joueur_actif
                    if (terrain instanceof Usine && ((Usine)terrain).getStatut() == joueur_actif.getEquipe()) {
                        // pas d'unite sur l'usine :
                        if (PLATEAU_DE_JEU.plateau.get(terrain.getY()).get(terrain.getX()).getUnite() == null) {
                            return false;
                        }
                    }
                }
                // une unite est presente && elle est de l'equipe du joueur_actif && elle est dispo 
                if (c.getUnite() != null && c.getUnite().getEquipe() == joueur_actif.getEquipe() && c.getUnite().getDispo()) {
                    return false;
                }
            }
        }
        return true;
    }
	
	
	public void actionsFinDeTour() {
        if (joueur_actif == j1) joueur_actif = j2;
        else joueur_actif = j1;
        joueur_actif.remplieLists(); 
        joueur_actif.calculeCredits();
        numero_de_manche++;
        tousDispo();
        posX = 0;
        posY = 0;
    }
	
	/**
	* Verifie si les coord (x;y) sont valides pour le plateau
	* @param x un int
	* @param y un int
	* @return true si valides, false sinon
	*/
	public static boolean coordValides(int x, int y) {
		return (y < Config.longueurCarteYCases &&
		y >= 0 &&
		x < Config.longueurCarteXCases &&
		x >= 0);
	}

	/**
	* Convertit une List de String en tableau de String
	* @param list une List de String
	* @return un tableau de String
	*/
	public static String[] fromListToTab(List<String> list) {
		String [] tab = new String[list.size()];
		for (int i=0 ; i<list.size() ; i++) {
			tab[i] = list.get(i);
		}
		return tab;
	}
	
	/**
	 * Rend toutes les unite du plateau disponibles
	 */
	public void tousDispo() {
		for (List<Case> list : PLATEAU_DE_JEU.plateau) {
			for (Case c : list) {
				if (c.getUnite() != null) {
					c.getUnite().setDispo(true);
				}
			}
		}
	}
}
