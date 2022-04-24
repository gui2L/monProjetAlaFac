import java.awt.event.KeyEvent;


public class Assecher extends Controleur{

    public Assecher(CModele modele) {
        super(modele);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Joueur j = tourjoueur();
        boolean b = (modele.getZone(j.getX(), j.getY()).status() != 0);
        //actions de assecher une zone
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (b){
            modele.getZone(j.getX(), j.getY()).assecher();
            fdc(j, bool);}
        } else if (e.getKeyCode() == KeyEvent.VK_Z) {
            modele.getZone(j.getX(), j.getY() - 1).assecher();
            fdc(j, bool);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            modele.getZone(j.getX() + 1, j.getY()).assecher();
            fdc(j, bool);
        } else if (e.getKeyCode() == KeyEvent.VK_Q) {
            modele.getZone(j.getX() - 1, j.getY()).assecher();
            fdc(j, bool);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            modele.getZone(j.getX(), j.getY() + 1).assecher();
            fdc(j, bool);
        }
    }
}
