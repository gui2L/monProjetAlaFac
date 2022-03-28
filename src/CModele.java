import java.util.ArrayList;
import java.util.Random;

public class CModele extends Observable{
    public static final int HAUTEUR=40, LARGEUR=60;
    private Zone[][] zones;
    public static final int x=2, y=2;

    public CModele() {
        /**
         * Pour éviter les problèmes aux bords, on ajoute une ligne et une
         * colonne de chaque côté, dont les cellules n'évolueront pas.
         */
        zones = new Zone[LARGEUR+2][HAUTEUR+2];
        for(int i=0; i<LARGEUR+2; i++) {
            for (int j = 0; j < HAUTEUR+2; j++) {
                zones[i][j] = new Zone(this, i, j);
            }
        }
        //initJoueur();
        initArtefacts();
    }

    public Zone getZone(int x, int y) {
        return zones[x][y];
    }

    public void avance() {
        for(int i = 0; i < 3; i++){
            int a = genererInt(0, LARGEUR);
            int b = genererInt(0, HAUTEUR);
            zones[a][b].inonde();
        }
        /**
         * Pour finir, le modèle ayant changé, on signale aux observateurs
         * qu'ils doivent se mettre à jour.
         */
        notifyObservers();
    }

    /**public void initJoueur(){
        Joueur un = new Joueur(x, y);
        Joueur deux = new Joueur(x, y);

    }*/

    /**public void initHeliport(){
        zones[x][y].addJoueur(un);
    }*/

    public int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }

    public void initArtefacts(){
        Artefact air = new Artefact("air", genererInt(0, LARGEUR), genererInt(0, HAUTEUR));
        Artefact eau = new Artefact("eau", genererInt(0, LARGEUR), genererInt(0, HAUTEUR));
        Artefact terre = new Artefact("terre", genererInt(0, LARGEUR), genererInt(0, HAUTEUR));
        Artefact feu = new Artefact("feu", genererInt(0, LARGEUR), genererInt(0, HAUTEUR));
        zones[air.getX()][air.getY()].addArtefact(air);
        zones[eau.getX()][eau.getY()].addArtefact(eau);
        zones[terre.getX()][terre.getY()].addArtefact(terre);
        zones[feu.getX()][feu.getY()].addArtefact(feu);

    }

    /**
    public void DeplaceràDroite(Joueur j){ }
    public void DeplaceràGauche(Joueur j){ }
    public void DeplacerenHaut(Joueur j){ }
    public void DeplacerenBas(Joueur j){ }
     */
}
