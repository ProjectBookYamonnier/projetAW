Bonjour, voici le README du projet Advance Wars de :
Yann MONNIER et Kawrantin ARZEL--GUIZIOU


Description du jeu :
* Lorsque le jeu est lancé, un plateau se crée à partir d’une matrice de Strings. Le curseur se déplace avec les touches directionnelles, les unités et usines peuvent être sélectionnées si le curseur se trouve dessus, une liste d’actions sera alors personnalisées en fonction de l’entourage (pour l’unité) ou des crédits du joueur (pour l’usine). Certaines unités ne peuvent pas se déplacer n’importe où (ex : les tanks ne peuvent pas aller sur les montagnes ou l’eau). Nous n’avons pas eu le temps d’ajouter le coût particulier des terrains (ex : le tank doit traverser plus difficilement une forêt qu’une plaine).
* Lors du passage d’une manche à l’autre, les crédits non utilisés sont conservés (ce n’était pas spécifié dans le sujet)
* Le statut du jeu affiche les informations suivantes : le numéro de manche (s’incrémente à chaque changement de joueur), le nom de l’équipe, le nombre de crédits du joueur). ATTENTION : sur la petite carte certaines informations ne seront pas entièrement visibles (dans le statut et les popups).
* Le jeu se termine lorsque 2 QGs sont de la même équipe OU si un joueur n’a plus d’unité et ne peut plus en produire. Un popup de message de victoire s’affiche, le joueur doit presser ‘entrée’ pour quitter, et la fenêtre se ferme.
* Certains bonus ont été réalisés, s’ils proviennent du sujet un numéro leur est attribué correspondant à celui du sujet (exemple : “Le BONUS 6.3 : armes multiples”), s’il proviennent de nous, rien n'est spécifié (exemple : “Le BONUS Curseur d’attaque”).




Nous avons créé dans le package Armes:
* Arme
   * Bombes (Création)
   * Canon (Création)
   * Missiles (Création)
   * MitrailleuseLegere (Création)
   * MitrailleuseLourde (Création)
   * Mortier (Création) (BONUS)
   * Torpille (Création) (BONUS)
   * MissilesSol_Air (Création) (BONUS)


Commentaire : 
Le BONUS 6.3 : armes multiples a été réalisé 
* Les  valeurs d’efficacité ont été modifiées pour faire en sorte que cela corresponde à la Figure 9 du sujet de projet
Le BONUS 6.4 : attaques à distance a été réalisé 
* Le mortier a été implémenté
* L’artillerie a été implémentée avec son mortier
* Le missilesSol_Air a été implémenté
* Le lance-Missiles Sol-Air a été implémentée
* L’arme Torpille a été ajoutée




Nous n’avons rien modifiées dans le package librairies




Nous avons créé dans le package main:
* Jeu (Modification)
* Joueur (Création)
* Main (Modification)


Commentaire : 
Le BONUS Curseur d’attaque a été réalisé 
* Quand le joueur veut attaquer, il sélectionne l’action “Attaquer” et un curseur d’attaque s’affiche sur les unités attaquables (Pour positionner sur la prochaine unité qu’on peut attaquer Appuyez sur la touche droite de votre clavier)
Le BONUS 6.1 : Touche pour lister les unités encore utilisables a été réalisé
* Le joueur appuie sur la touche ‘u’, et le curseur se place sur une nouvelle unité disponible et lui appartenant à chaque fois qu’il appuie à nouveau sur ‘u’. Pour sélectionner l’unité, ou se déplacer ailleurs sur le plateau, il devra faire un “missclick” (exemple : appuyer 2 fois sur touche ‘entrée’ pour commencer à dessiner la flèche). Si aucune unité n’est dispo, un popup s’affiche à l’écran.
Le BONUS Donner une description de l’unité présent dans le curseur a été réalisé
* Le joueur appuie sur la touche ‘d’, et si le curseur est placé sur unité de votre équipe alors une description détaillé : Son nom, son type, les types dont l’efficacité est plus importantes, nombre de point de déplacement, sa portée, si il peut transporter des unités si oui, combien et de quel type
Le BONUS Afficher les informations d’une Propriete : 
* Le joueur appuie sur la touche ‘p’ après avoir placé son curseur sur une propriété, son type et son nombre de pv s’affichent dans un popup. (Utile lorsqu’une unité se trouve sur une propriété, rendant difficile la lecture des PVs affichés en bas à gauche de la case).
Le BONUS 6.7 : Fin de tour de tour automatique a été réalisé
* une méthode “plusDactionsPossibles” qui verifie à chaque fin de la methode “update” s’il reste des actions à faire pour le joueur courant. S’il n’y en a plus, un popup s’affiche pour le lui signaler et il confirme avec Entrée avant de passer la main au joueur suivant.
Le BONUS : La fenêtre se ferme lorsque le jeu est fini



Nous avons créé dans le package meteo:
* Meteo (Création) (BONUS)
	* BeauTemps (Création) (BONUS)
	* Neige (Création) (BONUS)
	* VentViolent (Création) (BONUS)
	
Commentaire :
Le BONUS 6.11 : Météo a été réalisé (Cependant il n'est pas fonctionnel)
* Nous n'avons pas eu le temps de finir ce BONUS mais avons commencé la création des classes avec les attributs, méthodes et constructeur


Nous avons créé dans le package plateau:
* Case (Création)
* Plateau (Création)
* Repertoire (Création)




Nous avons modifié dans le package ressources:
* Affichage (Modification)
* Ajout d’une fonction d’affichage des vies pour les unités et les propriété
* Modification du y dans dessineImageDansCase pour un affichage + logique
* Chemins (Modification)
* Ajout de nouvelles constante de type String pour les pvs (ATTENTION : les pvs des unités s’affichent en bas à gauche et ceux des propriétés en bas à droite), les nouvelles unités et la plage
* Config (Modification)
* ajout de ‘t’ et ‘d’ dans TOUCHES_PERTINENTES_CARACTERES
* ParseurCartes (Modification)
* genereDictionnaireTerrain() : ajout de “S” pour “Plage”
* genereDictionnaireTroupes() : ajout de lettre(s) pour les nouvelles unités BONUS (voir plus bas)


Nous avons créé dans le package terrain:
* Terrain (abstract) (Création)
   * Propriete (abstract) (Création)
      * QG (Création)
      * Usine (Création)
      * Ville (Création)
   * Eau (Création)
   * Foret (Création)
   * Montagne (Création)
   * Plage (Création) (BONUS 6.9) (oui, c’est bien nous les designers)
   * Plaine (Création)


Commentaire : 
Le BONUS 6.9 : Création de la classe Plage




Nous avons créé dans le package unites :
* Unite (abstract) (Création)
   * TypeMarche (abstract) (Création)
      * Infanterie (Création)
      * Bazooka (Création)
   * TypeChenille (abstract) (Création)
      * Tank (Création)
      * DCA (Création)
      * Convoi (Création) (BONUS 6.6)
      * Artillerie (Création) (BONUS 6.4)
      * Lance-Missile (Création) (BONUS 6.4)
   * TypeAerien (abstract) (Création)
      * Bombardier (Création)
      * Helicoptere (Création)
   * TypeNavale (abstract) (Création) (BONUS 6.9)
      * Barge (Création) (BONUS 6.9)
      * Corvette (Création) (BONUS 6.9)
      * Croiseur (Création) (BONUS 6.9)
      * Cuirasser (Création) (BONUS 6.9)
      * PorteAvion (Création) (BONUS 6.9)
      * SousMarin (Création) (BONUS 6.9)


Commentaire : 
Le BONUS 6.6 : Transport d’unités à pied à été réalisé
Le BONUS 6.9 : Unités navales a été réalisé
* Unités navales basiques (Fonctionnel)
* Unités navales avancées (Fonctionnel et non-complète)
   * Le sous-marin ne peux pas plonger et faire surface
   * Le porte-avion ne peux pas créée d’unités aériennes




Nous avons rajouté dans le dossier maps :
* Carte de Test Nouveauté.awdcmap (Création)
C’est une carte qui possède des plages ainsi que des usines proches de l’eau pour pouvoir faire des unités Navales
* Exposition des Unités.awdcmap (Création)
C’est une carte qui expose toutes les unités existantes




Nous avons rajouté dans le répertoire pictures:
* Ajout d’une image plage.png dans le dossier terrains (BONUS 6.9)
* Ajout d’un curseur d’attaque CurseurAttaque.png dans le dossier pictures (BONUS)
* Ajouts des images des unités (BONUS 6.n) dans chacune des catégories blue (available | unavailable) et red (available | unavailable)
   * artillery.png
   * barge.png
   * corvette.png
      * Dû au manque de ressources pour l’image de la corvette sur le site Spriters Ressource, nous avons décidé d’utiliser un pixel art de bateau de pirate modifié pour avoir les couleurs associées au joueur du jeu (bleu ou rouge)
   * croiseur.png
   * cuirasser.png
   * porte-avion.png
   * sous-marin.png
   * lance-missile.png
* Création d’un dossier vie composée de 19 images composées des vies des propriétés ou vie des unités :
* 1.png
à
* 20.png