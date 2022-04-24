import javax.swing.*;
import java.awt.*;

class CVue extends Observable{
    /**
     * JFrame est une classe fournie pas Swing. Elle représente la fenêtre
     * de l'application graphique.
     */
    public JFrame frame;
    /**
     * VueGrille et VueCommandes sont deux classes définies plus loin, pour
     * nos deux parties de l'interface graphique.
     */
    private VueGrille grille;
    private VueCommandes commandes;
    
    public static JLabel eau;
    public static JLabel feu;
    public static JLabel air;
    public static JLabel terre; 
    public static JLabel kazuha;
    public static JLabel mona;
    public static JLabel yaemiko;
    public static JLabel diluc;
    public static JLabel tour;
    public static JLabel action;
    public static JLabel cle1img;
    public static JLabel cle2img;
    public static JLabel cle3img;
    public static JLabel cle4img;



    /** Construction d'une vue attachée à un modèle. */
    public CVue(CModele modele) {
        /** Définition de la fenêtre principale. */
        frame = new JFrame();
        frame.setTitle("Projet Ile Interdite");
        //File path = new File("images_projet");
        /**
         * On précise un mode pour disposer les différents éléments à
         * l'intérieur de la fenêtre. Quelques possibilités sont :
         *  - BorderLayout (défaut pour la classe JFrame) : chaque élément est
         *    disposé au centre ou le long d'un bord.
         *  - FlowLayout (défaut pour un JPanel) : les éléments sont disposés
         *    l'un à la suite de l'autre, dans l'ordre de leur ajout, les lignes
         *    se formant de gauche à droite et de haut en bas. Un élément peut
         *    passer à la ligne lorsque l'on redimensionne la fenêtre.
         *  - GridLayout : les éléments sont disposés l'un à la suite de
         *    l'autre sur une grille avec un nombre de lignes et un nombre de
         *    colonnes définis par le programmeur, dont toutes les cases ont la
         *    même dimension. Cette dimension est calculée en fonction du
         *    nombre de cases à placer et de la dimension du contenant.
         */
        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 800);

        /** Définition des deux vues et ajout à la fenêtre. */
        grille = new VueGrille(modele);
        frame.add(grille, BorderLayout.CENTER);
        commandes = new VueCommandes(modele);
        frame.add(commandes, BorderLayout.SOUTH);

        /**
         * Remarque : on peut passer à la méthode [add] des paramètres
         * supplémentaires indiquant où placer l'élément. Par exemple, si on
         * avait conservé la disposition par défaut [BorderLayout], on aurait
         * pu écrire le code suivant pour placer la grille à gauche et les
         * commandes à droite.
         *     frame.add(grille, BorderLayout.WEST);
         *     frame.add(commandes, BorderLayout.EAST);
         */

        /**
         * Fin de la plomberie :
         *  - Ajustement de la taille de la fenêtre en fonction du contenu.
         *  - Indiquer qu'on quitte l'application si la fenêtre est fermée.
         *  - Préciser que la fenêtre doit bien apparaître à l'écran.
         */
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Controleur dpl = new Deplacement(modele);
        JPanel panel1 = new JPanel();
        panel1.setBounds(800,0,400,30); 
        panel1.setBackground(Color.lightGray);
        tour = new JLabel("Tour du Joueur : " + Controleur.idj,JLabel.CENTER);
        action = new JLabel("Nombre d'actions restantes : " +  (3-dpl.cpt),JLabel.CENTER);
        panel1.add(tour);
        panel1.add(action);
        JPanel titreArt = new JPanel();
        titreArt.setBounds(800,30,400,30); 
        JLabel art = new JLabel("Artéfacts : ");
        titreArt.add(art);
        
        JPanel Artifact = new JPanel();
        Artifact.setBounds(800,60,400,100); 
        
        Icon icon1 = new ImageIcon("images_projet/eau1.png");
        eau = new JLabel(icon1);
        Icon icon2 = new ImageIcon("images_projet/feu1.png");
        feu = new JLabel(icon2);

        Icon icon3 = new ImageIcon("images_projet/terre1.png");
        terre = new JLabel(icon3);

        Icon icon4 = new ImageIcon("images_projet/air1.png");
        air = new JLabel(icon4);
        Artifact.add(eau);
        Artifact.add(feu);
        Artifact.add(terre);
        Artifact.add(air);

        JPanel perso1_2 = new JPanel();
        perso1_2.setBounds(800,160,400,150); 
        perso1_2.setBackground(Color.lightGray);
        
        Icon perso1 = new ImageIcon("images_projet/kazuha0.png");
        kazuha = new JLabel(perso1);
        Icon perso2 = new ImageIcon("images_projet/mona.png");
        mona = new JLabel(perso2);

        air = new JLabel(icon4);
        perso1_2.add(kazuha);
        perso1_2.add(mona);
        JPanel perso3_4 = new JPanel();
        perso3_4.setBounds(800,400,400,150); 
        perso3_4.setBackground(Color.lightGray);
         
        Icon perso3 = new ImageIcon("images_projet/yaemiko.png");
        yaemiko = new JLabel(perso3);
        Icon perso4 = new ImageIcon("images_projet/diluc.png");
        diluc = new JLabel(perso4);
        perso3_4.add(yaemiko);
        perso3_4.add(diluc);


        Icon cleicon = new ImageIcon("images_projet/cle.png");
        JPanel cle1 = new JPanel();
        cle1.setBounds(800,310,200,80); 
        cle1img= new JLabel(cleicon);
        cle1.add(cle1img);
        JPanel cle2 = new JPanel();
        cle2.setBounds(1000,310,200,80); 
        cle2img= new JLabel(cleicon);
        cle2.add(cle2img);
        JPanel cle3 = new JPanel();
        cle3.setBounds(800,550,200,80); 
        cle3img= new JLabel(cleicon);
        cle3.add(cle3img);
        JPanel cle4 = new JPanel();
        cle4.setBounds(1000,550,200,80); 
        cle4img= new JLabel(cleicon);
        cle4.add(cle4img);

        Icon commandes = new ImageIcon("images_projet/cmd.png");
        JPanel cmd = new JPanel();
        cmd.setBounds(800,650,360,120);
        JLabel cmdl= new JLabel(commandes);
        cmd.add(cmdl);


        Icon regles = new ImageIcon("images_projet/rules.png");
        JPanel rules = new JPanel();
        rules.setBounds(0,850,1201,120);
        JLabel regle= new JLabel(regles);
        rules.add(regle);

        frame.add(cmd);
        frame.add(rules);
        frame.add(panel1);
        frame.add(titreArt);
        frame.add(Artifact);
        frame.add(perso1_2);
        frame.add(cle1);
        frame.add(cle2);
        frame.add(perso3_4);
        frame.add(cle3);
        frame.add(cle4);
        frame.setSize(1200, 1000);
        frame.setLayout(null);  
        frame.setVisible(true);


        
    }
}

