import javax.swing.*;

class VueCommandes extends JPanel{
    /**
     * Pour que le bouton puisse transmettre ses ordres, on garde une
     * référence au modèle.
     */
    private CModele modele;
    public Controleur dpl;
    public Controleur asc;
    public Controleur fdt;

    /** Constructeur. */
    public VueCommandes(CModele modele) {
        this.modele = modele;
        /**
         * On crée un nouveau bouton, de classe [JButton], en précisant le
         * texte qui doit l'étiqueter.
         * Puis on ajoute ce bouton au panneau [this].
         */



        //JButton assecherZone = new JButton("Assecher");
        //JButton recupererArtefact = new JButton("recuperer");

        //JButton End = new JButton("Fin de Tour");
        //JButton dplHaut = new JButton("^");

       // this.add(assecherZone);
        //this.add(recupererArtefact);
        //this.add(End);
        //this.add(dplHaut);
        /**
         * Le bouton, lorsqu'il est cliqué par l'utilisateur, produit un
         * événement, de classe [ActionEvent].
         *
         * On a ici une variante du schéma observateur/observé : un objet
         * implémentant une interface [ActionListener] va s'inscrire pour
         * "écouter" les événements produits par le bouton, et recevoir
         * automatiquements des notifications.
         * D'autres variantes d'auditeurs pour des événements particuliers :
         * [MouseListener], [KeyboardListener], [WindowListener].
         *
         * Cet observateur va enrichir notre schéma Modèle-Vue d'une couche
         * intermédiaire Contrôleur, dont l'objectif est de récupérer les
         * événements produits par la vue et de les traduire en instructions
         * pour le modèle.
         * Cette strate intermédiaire est potentiellement riche, et peut
         * notamment traduire les mêmes événements de différentes façons en
         * fonction d'un état de l'application.
         * Ici nous avons un seul bouton réalisant une seule action, notre
         * contrôleur sera donc particulièrement simple. Cela nécessite
         * néanmoins la création d'une classe dédiée.
         */
        Controleur fdt = new FindeTour(modele);

        Controleur dpl = new Deplacement(modele);
        Controleur asc = new Assecher(modele);
        Controleur rec = new Recuperation(modele);
        Controleur ato = new Recuperation(modele);

        /** Enregistrement du contrôleur comme auditeur du bouton. */


        this.addKeyListener(fdt);

        //this.addKeyListener(fdt);
        //VueCommandes.nombouton.setText("Actions Restantes : ")


        this.addKeyListener(ato);
        this.addKeyListener(dpl);
        this.addKeyListener(asc);
        this.addKeyListener(rec);
        this.setFocusable(true);
        /**
         * Variante : une lambda-expression qui évite de créer une classe
         * spécifique pour un contrôleur simplissime.

         JButton boutonAvance = new JButton(">");
         this.add(boutonAvance);
         boutonAvance.addActionListener(e -> { if (e.equals(End)) {modele.findetour();}  });

         */

    }
}