import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.io.File;
import java.io.IOException;

class VueGrille extends JPanel implements Observer {
    /**
     * On maintient une référence vers le modèle.
     */
    private CModele modele;
    /**
     * Définition d'une taille (en pixels) pour l'affichage des cellules.
     */
    private final static int TAILLE = 80;

    /**
     * Constructeur.
     */
    public VueGrille(CModele modele) {
        this.modele = modele;
        /** On enregistre la vue [this] en tant qu'observateur de [modele]. */
        modele.addObserver(this);
        /**
         * Définition et application d'une taille fixe pour cette zone de
         * l'interface, calculée en fonction du nombre de cellules et de la
         * taille d'affichage.
         */
        Dimension dim = new Dimension(TAILLE * CModele.LARGEUR, TAILLE * CModele.HAUTEUR);
        //Dimension dim = new Dimension(800, 600);
        this.setPreferredSize(dim);
    }

    /**
     * L'interface [Observer] demande de fournir une méthode [update], qui
     * sera appelée lorsque la vue sera notifiée d'un changement dans le
     * modèle. Ici on se content de réafficher toute la grille avec la méthode
     * prédéfinie [repaint].
     */
    public void update() {
        repaint();
    }

    /**
     * Les éléments graphiques comme [JPanel] possèdent une méthode
     * [paintComponent] qui définit l'action à accomplir pour afficher cet
     * élément. On la redéfinit ici pour lui confier l'affichage des cellules.
     * <p>
     * La classe [Graphics] regroupe les éléments de style sur le dessin,
     * comme la couleur actuelle.
     */
    public void paintComponent(Graphics g) {
        super.repaint();
        /** Pour chaque cellule... */
        for (int i = 1; i <= CModele.LARGEUR; i++) {
            for (int j = 1; j <= CModele.HAUTEUR; j++) {
                /**
                 * ... Appeler une fonction d'affichage auxiliaire.
                 * On lui fournit les informations de dessin [g] et les
                 * coordonnées du coin en haut à gauche.
                 */
                paint(g, modele.getZone(i, j), (i - 1) * TAILLE, (j - 1) * TAILLE);
            }
        }
    }

    /**
     * Fonction auxiliaire de dessin d'une cellule.
     * Ici, la classe [Cellule] ne peut être désignée que par l'intermédiaire
     * de la classe [CModele] à laquelle elle est interne, d'où le type
     * [CModele.Cellule].
     * Ceci serait impossible si [Cellule] était déclarée privée dans [CModele].
     */


    private void paint(Graphics g, Zone c, int x, int y) {
        Color couleur;

        if (c.status() == 1) {
            /*g.setColor(Color.orange);
            g.fillRect(x, y, TAILLE, TAILLE);
            g.setColor(Color.red);
            g.drawRect(x, y, TAILLE, TAILLE);*/
            try {
                Image terre = ImageIO.read(new File("images_projet","water4.png"));
                g.drawImage(terre, x, y, TAILLE, TAILLE, this);
            }catch (IOException e){
                System.out.println("erreur image lecture");
            }
        }
        if (c.status() == 2) {
            //g.setColor(Color.red);
            //g.fillRect(x, y, TAILLE, TAILLE);
            try {
                Image eau = ImageIO.read(new File("images_projet","water.png"));
                g.drawImage(eau, x, y, TAILLE, TAILLE, this);
            }catch (IOException e){
                System.out.println("erreur image lecture");
            }
            if(c.getJoueurs().size() != 0){
                //Icon icon2 = new ImageIcon("images_projet/diluc.png");
                //CVue.kazuha.setIcon(icon1);
                
                if (Controleur.idj==0){
                    Icon icon1 = new ImageIcon("images_projet/kazuha1.png");
                    CVue.kazuha.setIcon(icon1);
                } else if (Controleur.idj==1){
                    Icon icon1 = new ImageIcon("images_projet/mona1.png");
                    CVue.mona.setIcon(icon1);
                } else if (Controleur.idj==2){
                    Icon icon1 = new ImageIcon("images_projet/yaemiko1.png");
                    CVue.yaemiko.setIcon(icon1);
                } else if (Controleur.idj==3){
                    Icon icon1 = new ImageIcon("images_projet/diluc1.png");
                    CVue.diluc.setIcon(icon1);
                } 
                JFrame gameover = new JFrame();
                gameover.setSize(1200, 800);
                Icon icon = new ImageIcon("images_projet/defeat.png");
                JLabel end = new JLabel(icon);
                gameover.add(end);
                gameover.setTitle("Game Over - Joueur Inondé");
                gameover.pack();
                gameover.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameover.setVisible(true);
            }
        }

        if (c.status() == 0) {
            //couleur = new Color(0,150, 0);
            //g.setColor(couleur);
            /*g.setColor(Color.DARK_GRAY);
            g.fillRect(x, y, TAILLE, TAILLE);
            g.setColor(Color.red);
            g.drawRect(x, y, TAILLE, TAILLE);*/
            try {
                Image sol = ImageIO.read(new File("images_projet","1.png"));
                g.drawImage(sol, x, y, TAILLE, TAILLE, this);
            }catch (IOException e){
                System.out.println("erreur image lecture");
            }
        }

        if (c.def() == "portail") {
            //g.setColor(Color.WHITE);
            //g.fillRect(x, y, TAILLE, TAILLE);
            try {
                Image portail = ImageIO.read(new File("images_projet", "portail.png"));
                g.drawImage(portail, x+5, y+5, TAILLE-10, TAILLE-10, this);
            }catch (IOException e){
            }
            if(c.status() == 1){
            //g.setColor(Color.orange);
            //g.drawRect(x, y, TAILLE, TAILLE);
            }else if(c.status() == 2){
                //g.setColor(Color.red);
                //g.drawRect(x, y, TAILLE, TAILLE);
                //System.out.println("partie perdue : portail coule");
                JFrame gameover = new JFrame();
                gameover.setSize(1200, 800);
                Icon icon = new ImageIcon("images_projet/defeat.png");
                JLabel end = new JLabel(icon);
                gameover.add(end);
                gameover.setTitle("Game Over - Portail Inondé");
                gameover.pack();
                gameover.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameover.setVisible(true);
            }

        }



        //JOUEURS
        if ((c.getJoueurs()).size() != 0) {
            for(int i =0; i <c.getJoueurs().size(); i++){
                if(c.getJoueurs().get(i).getLabel() == "dpl_libre"){
                    g.setColor(Color.white);
                    g.drawRect(x+5, y+5, TAILLE-10,TAILLE-10);
                }else if(c.getJoueurs().get(i).getLabel() == "asc_libre"){
                    g.setColor(Color.yellow);
                    g.drawRect(x+5, y+5, TAILLE-10,TAILLE-10);
                }else{
                    g.drawImage(c.getJoueurs().get(i).getIm(), x+5, y+5, TAILLE-10,TAILLE-10,this);
                }
            }
        }

        //ARTEFACTS
        if ((c.getArtefacts()).size() != 0) {
            String s = c.getArtefacts().get(0).getElement();
            if(s == "air"){
                g.setColor(Color.blue);
            }else if(s == "terre"){
                couleur = new Color(88, 41, 0);
                g.setColor(couleur);
            }else if(s == "eau"){
                couleur = new Color(106, 51, 255);
                g.setColor(couleur);
            }else if(s == "feu"){
                g.setColor(Color.yellow);
            }

            g.drawImage(c.getArtefacts().get(0).getIm(), x+5, y+5, TAILLE-10,TAILLE-10,this);
        }


    }
}