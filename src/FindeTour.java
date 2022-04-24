import javax.swing.*;
import java.awt.event.*;

public class FindeTour extends Controleur implements ActionListener {

    // attributs
    CModele modele;
    // constructeur
    FindeTour(CModele modele){
        super(modele);
        
        this.modele = modele;
        

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Joueur j = tourjoueur();

        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            if (modele.getZone(j.getX(), j.getY()).def() == "portail"){
                partiegagnee = partiegagnee + modele.getZone(j.getX(), j.getY()).getJoueurs().size();
            }
            if (partiegagnee == 8){
                System.out.println("Partie gagnee");
                JFrame gg = new JFrame();
                gg.setSize(1200, 800);
                Icon icon = new ImageIcon("images_projet/victory.png");
                JLabel win = new JLabel(icon);
                gg.add(win);
                gg.setTitle("Félicitations");
                gg.pack();
                gg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gg.setVisible(true);
            }
            System.out.println("tour du Joueur " + idj);
            cpt = 3;
            modele.findetour(j);



        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Joueur j = tourjoueur();
        modele.findetour(j);
    }



}
