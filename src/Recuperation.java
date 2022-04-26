import java.awt.event.KeyEvent;
import javax.swing.*;


public class Recuperation extends Controleur{
    public Recuperation(CModele modele) {
        super(modele);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Joueur j = tourjoueur();
        if (e.getKeyCode() == KeyEvent.VK_R) {
            if(modele.recupArtfct(j)){
                modele.recupArtfct(j);
                artefrecup += 1;
                if (artefrecup == 4) {
                    System.out.println("Tous les artefacts ont ete recuperes!!");

                }
                fdc(j, bool);
            }
        }
    }
}
