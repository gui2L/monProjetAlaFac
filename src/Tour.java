import java.awt.event.*;

public class Tour implements KeyListener/*, ActionListener*/{
    CModele modele;
    public static int cpt = 0;
    public static int idj = 0;
    public static int partiegagnee = 0;

    // constructeur
    Tour(CModele modele){

        this.modele = modele;
    }

    @Override
    public void keyTyped(KeyEvent e) {


        //Invoked when a key has been typed.
        //This event occurs when a key press is followed by a key release.

    }

    //@Override
    public void keyPressed(KeyEvent e) {


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

        //actions de deplacement du joueur
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            modele.deplaceJoueur(j, 0, -1);
            fdc(j);
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            modele.deplaceJoueur(j,-1, 0);
            fdc(j);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            modele.deplaceJoueur(j,1, 0);
            fdc(j);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            modele.deplaceJoueur(j,0, 1);
            fdc(j);

        //actions de assecher une zone
        }else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            modele.getZone(j.getX(), j.getY()).assecher();
            fdc(j);
        }else if (e.getKeyCode() == KeyEvent.VK_Z) {

            modele.getZone(j.getX(), j.getY()-1).assecher();
            fdc(j);
        }else if (e.getKeyCode() == KeyEvent.VK_D) {

            modele.getZone(j.getX()+1, j.getY()).assecher();
            fdc(j);
        } else if (e.getKeyCode() == KeyEvent.VK_Q) {

            modele.getZone(j.getX()-1, j.getY()).assecher();
            fdc(j);
        }else if (e.getKeyCode() == KeyEvent.VK_S) {

            modele.getZone(j.getX(), j.getY()+1).assecher();
            fdc(j);

        //action de fin de tour du joueur
        }else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            cpt = 3;
            modele.findetour(j);

        //action de recuperer artefact de la zone
        }else if (e.getKeyCode() == KeyEvent.VK_R){
            modele.recupArtfct(j);
            partiegagnee += 1;
            if (partiegagnee == 4){
                System.out.println("partie gagnée");
            }
            fdc(j);

        }


    }

    public void fdc(Joueur j ){
        cpt += 1;
        if (cpt == 3){
            modele.findetour(j);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        //Invoked when a key has been released.

    }


    /*public void actionPerformed(ActionEvent e) {
        cpt = 3;
        modele.findetour();
    }
*/
}
