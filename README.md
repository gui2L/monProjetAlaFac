RAPPORT (LDD2 IM2 : Guillaume Surleau et Mohamed Hamdouni)

Projet Ile Interdite

LES PARTIES DU SUJET TRAITEES

- 10.1
  L'île est representé par des cases carrés.

Pour chaque case, en fonction de leur état (normal, inondé, submergé),
l'image dessinée représentant la case est modifiée.

Une touche du clavier (barre ESPACE) est associée à l'action de fin de tour
qui inonde 3 zones alétoires de l'île  choisies parmi les zones non encore submergées.

- 10.2
  Les personnages sont représentés par des images differentes pour distinguer les joueurs.
  Ils sont placés aléatoirement suivant leur coordonnées sur une zone de l'île.
  L'utilisateur peut déplacer chacun des personnages (tour à tour) à l'aide des touches directionnel du clavier.
  Chaque personnage a 3 actions maximums avant l'action de fin de tour.
  3 actions parmi : se deplacer, assecher une zone (et recuperer un artefact )

- 10.3
  Comme pour les personnages, les artefacts sont implémentés et affichés sur l'île
  et peuvent être récuperer par un personnage si celui-ci possède la clé du l'élément en question.
  Un portail est ajouté sur l'île ayant le rôle d'échappatoire pour les personnages.
  Une fois les quatres artefacts récuperés et les personnages se trouvant tous au portail, la partie est gagnée.

-10.4
Les actions speciales sont implémentées sous le nom d'atout associé au personnage, fonctionnant comme pour les autres actions
à l'aide de boutons.
Malheureusement, nous avons manqués de temps pour traiter les autres parties intéressantes du projet.

- au niveau de l'interface
  une liste des commandes est donnée à l'utilisateur afin qu'il puisse comprendre quelle touche effectue quelle action.
  un inventaire est également affiché pour chaque joueur de la partie, prenant en compte les artefacts récuperés, clés possédés, etc...

ARCHITECTURE DU CODE

Tout en respectant une architecture Modele-Vue-Controleur:
- Dans CModele(.java), tous les objets sont initialisés ainsi que le code concret des actions effectuées qui sont associées à des touches
  du clavier
- Les actions des joueurs sont séparées dans des classes différentes, toutes héritant du Controleur(.java) où l'on retrouve
  des methodes qu'on va utiliser pour determiner le tour du joueur et le nombre d'actions faites par le joueur.
- L'interface graphique du programme est défini par CVue(.java) à l'aide d'un JFrame auquel on ajoute la grille à afficher
  et les commandes pour qu'elles fonctionnent et mettent à jour les éléments de la fenêtre.



