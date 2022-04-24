import java.awt.event.KeyEvent;


public class Deplacement extends Controleur{

    public Deplacement(CModele modele) {
        super(modele);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Joueur j = tourjoueur();
        if(!bool) {
            j = modele.select;
        }
        //actions de deplacement du joueur
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(modele.getZone(j.getX(), j.getY()-1).status() != 2){
            modele.deplaceJoueur(j, 0, -1);
            fdc(j, bool);}
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(modele.getZone(j.getX()-1, j.getY()).status() != 2){
            modele.deplaceJoueur(j,-1, 0);
            fdc(j, bool);}
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(modele.getZone(j.getX()+1, j.getY()).status() != 2){
            modele.deplaceJoueur(j,1, 0);
            fdc(j, bool);}
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(modele.getZone(j.getX(), j.getY()+1).status() != 2){
            modele.deplaceJoueur(j,0, 1);
            fdc(j, bool);}
        }
    }

}
