import java.awt.event.KeyEvent;

public class UtilisationAtout extends Controleur{

    public UtilisationAtout(CModele modele) {
        super(modele);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //assecher
        if (e.getKeyCode() == KeyEvent.VK_O){
            Joueur j = tourjoueur();
            //if (j.getAtout() == "Sac de sable"){
                if(bool) {
                    System.out.println("atout selectionne");
                    bool = false;
                    fdc(j, bool);
                    modele.select.setCoord(j.getX(), j.getY());
                    modele.getZone(j.getX(), j.getY()).addJoueur(modele.select);
                    modele.select.setLabel("asc_libre");
                }else{
                    if(modele.getZone(modele.select.getX(), modele.select.getY()).status() == 1){
                    System.out.println("atout utilise");

                    modele.getZone(modele.select.getX(), modele.select.getY()).assecher();
                    modele.getZone(modele.select.getX(), modele.select.getY()).removeJoueur(modele.select);
                    bool = true;
                    fdc(j, bool);
                    }else{
                        bool = true;
                        modele.getZone(modele.select.getX(), modele.select.getY()).removeJoueur(modele.select);
                        System.out.println("atout non utilisable");
                    }
                }
                j.setAtout(" ");
            //}else{
                //System.out.println("pas d'atout Sac de sable");
            //}
        }

        //deplacement libre vers zone non submergee
        if (e.getKeyCode() == KeyEvent.VK_P){
            Joueur j = tourjoueur();
            //if (j.getAtout() == "Helicoptere"){
            if(bool) {
                System.out.println("atout selectionne");
                bool = false;
                fdc(j, bool);
                modele.select.setCoord(j.getX(), j.getY());
                modele.getZone(j.getX(), j.getY()).addJoueur(modele.select);
                modele.select.setLabel("dpl_libre");
            }else{
                //System.out.println("atout utilise");

                modele.deplaceJoueur(j, modele.select.getX()- j.getX(), modele.select.getY() - j.getY());
                modele.getZone(modele.select.getX(), modele.select.getY()).removeJoueur(modele.select);
                bool = true;
                fdc(j, bool);
            }
            j.setAtout(" ");
            //}else{
              //  System.out.println("Pas d'atout Helicoptere");
            //}

        }

    }
}
