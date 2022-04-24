
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controleur implements KeyListener{
    /**
     * On garde un pointeur vers le modèle, car le contrôleur doit
     * provoquer un appel de méthode du modèle.
     * Remarque : comme cette classe est interne, cette inscription
     * explicite du modèle est inutile. On pourrait se contenter de
     * faire directement référence au modèle enregistré pour la classe
     * englobante [VueCommandes].
     */
    CModele modele;
    public static int cpt = 0;
    public static int idj = 1;
    public int partiegagnee = 0;
    public int artefrecup = 0;
    public static boolean bool = true;
    public Controleur(CModele modele) { this.modele = modele; }
    /**
     * Action effectuée à réception d'un événement : appeler la
     * méthode [avance] du modèle.
     */

    public Joueur tourjoueur(){
        if (cpt == 3) {

            //System.out.println("changement de joueur");
            cpt = 0;
            if (idj < modele.getLjoueurs().size()-1){
                idj = idj +1;
            }else{
                idj = 0;

            }
        }
        Joueur j = modele.getLjoueurs().get(idj);
        return j;
    }

    public void fdc(Joueur j, boolean b){
        if(b){
        cpt += 1;
        CVue.action.setText("Nombre d'actions restantes : " + (3-cpt));

        if (cpt == 3){
            CVue.action.setText("Nombre d'actions restantes : " + (3));

            modele.findetour(j);
        }}
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}