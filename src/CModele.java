import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
public class CModele extends Observable{
    public static final int HAUTEUR = 10, LARGEUR = 10;
    public static final int x = LARGEUR/2, y = HAUTEUR/2;
    private Zone[][] zones;
    public static final int dimH = 7, dimL = 7;
    private ArrayList<String> Atouts;

    File path = new File("images_projet");

    private Image P1;
    private Image P2;
    private  Image P3;
    private Image P4;

    private Image A1;
    private Image A2;
    private Image A3;
    private Image A4;




    private Joueur j1;
    private Joueur j2;
    private Joueur j3;
    private Joueur j4;
    public  Joueur select;

    private ArrayList<Joueur> ljoueurs;

    private Artefact air;
    private Artefact eau;
    private Artefact terre;
    private Artefact feu;
    private ArrayList<Artefact> lartefacts;

    private String k_air = "air";
    private String k_eau = "eau";
    private String k_terre = "terre";
    private String k_feu = "feu";
    private ArrayList<String> lkeys;

    public CModele(){
        /**
         * Pour éviter les problèmes aux bords, on ajoute une ligne et une
         * colonne de chaque côté, dont les cellules n'évolueront pas.
         */
        try{
        P1 = ImageIO.read(new File(path, "diluc.png"));
        P2 = ImageIO.read(new File(path, "kazuha.png"));
        P3 = ImageIO.read(new File(path, "mona.png"));
        P4 = ImageIO.read(new File(path, "yaemiko.png"));

        A1 = ImageIO.read(new File(path, "eau.png"));
            A2 = ImageIO.read(new File(path, "terre.png"));
            A3 = ImageIO.read(new File(path, "air.png"));
            A4 = ImageIO.read(new File(path, "feu.png"));
        }catch (IOException e){
            System.out.println("erreur image lecture");
        }

        select = new Joueur(0, 0, P1);

        Atouts = new ArrayList<String>();
        Atouts.add("Sac de sable");
        Atouts.add("Helicoptere");

        ljoueurs = new ArrayList<Joueur>();
        lartefacts = new ArrayList<Artefact>();

        lkeys = new ArrayList<String>();
        lkeys.add(k_air);lkeys.add(k_eau);lkeys.add(k_terre);lkeys.add(k_feu);

        zones = new Zone[LARGEUR + 2][HAUTEUR + 2];
        for (int i = 0; i < LARGEUR + 2; i++) {
            for (int j = 0; j < HAUTEUR + 2; j++) {
                zones[i][j] = new Zone(this, i, j, "zone");
            }
        }

        initIle();
        initHeliport();

        j1 = initJoueur(P1);
        j2 = initJoueur(P2);
        j3 = initJoueur(P3);
        j4 = initJoueur(P4);

        eau = initArtefact("eau", A1);
        terre = initArtefact("terre", A2);
        air = initArtefact("air", A3);
        feu = initArtefact("feu", A4);




    }

    public Zone getZone(int x, int y) {
        return zones[x][y];
    }
    public ArrayList<Joueur> getLjoueurs() {
        return ljoueurs;
    }

    public void findetour(Joueur j) {
        for (int i = 0; i < 3; i++) {
            int a = genererInt(y - dimH/2, (dimH + y - dimH/2)+1);
            int b = genererInt(x - dimL/2, (dimL + x - dimL/2)+1);
            zones[a][b].inonde();
        }
        keyhasard(j);
        notifyObservers();
        CVue.tour.setText("Tour du Joueur : " + (Controleur.idj+1));

        if ((Controleur.idj+1)==1){
            Icon icon1 = new ImageIcon("images_projet/kazuha0.png");
            Icon icon2 = new ImageIcon("images_projet/diluc.png");
            CVue.kazuha.setIcon(icon1);
            CVue.diluc.setIcon(icon2);
        } else if ((Controleur.idj+1)==2){
            Icon icon1 = new ImageIcon("images_projet/mona0.png");
            Icon icon2 = new ImageIcon("images_projet/kazuha.png");
            CVue.mona.setIcon(icon1);
            CVue.kazuha.setIcon(icon2);
        } else if ((Controleur.idj+1)==3){
            Icon icon1 = new ImageIcon("images_projet/yaemiko0.png");
            Icon icon2 = new ImageIcon("images_projet/mona.png");
            CVue.yaemiko.setIcon(icon1);
            CVue.mona.setIcon(icon2);
        } else if ((Controleur.idj+1)==4){
            Icon icon1 = new ImageIcon("images_projet/diluc0.png");
            Icon icon2 = new ImageIcon("images_projet/yaemiko.png");
            CVue.diluc.setIcon(icon1);
            CVue.yaemiko.setIcon(icon2);
        } 

        Controleur.cpt=3;
        CVue.action.setText("Nombre d'actions restantes : " + 3);
        /**Icon iconeau = new ImageIcon("images_projet/eau1.png"); 
        Icon iconfeu = new ImageIcon("images_projet/feu1.png"); 
        Icon iconair = new ImageIcon("images_projet/air1.png"); 
        Icon iconterre = new ImageIcon("images_projet/terre1.png"); 
        for (int i=0; i< j.artefacts.size();i++){
            System.out.println(j.artefacts.get(i).getElement());
            if(j.artefacts.get(i).getElement()=="eau"){
                iconeau = new ImageIcon("images_projet/eau2.png"); 
            } else if(j.artefacts.get(i).getElement()=="feu"){
                iconfeu = new ImageIcon("images_projet/feu2.png");
            } else if(j.artefacts.get(i).getElement()=="terre"){
                iconterre = new ImageIcon("images_projet/terre2.png");
            } else if(j.artefacts.get(i).getElement()=="air"){
                iconair = new ImageIcon("images_projet/air2.png");
            }
        }
        CVue.feu.setIcon(iconfeu);
        CVue.air.setIcon(iconair);
        CVue.eau.setIcon(iconeau);
        CVue.terre.setIcon(iconterre);**/
        //CVue spec = new CVue(this);
        
    }

    public void keyhasard(Joueur j) {
        Random nb = new Random();
        int aleatoire = nb.nextInt(10);
        if (lkeys.size() > 0) {
            if (aleatoire == 1 | aleatoire == 2 | aleatoire == 3){
                int idk = genererInt(0, lkeys.size());
                if(lkeys.size() != 0){j.receiveKey(lkeys.get(idk));

                if(lkeys.get(idk)=="eau"){
                    if (Controleur.idj==0){
                        Icon icon1 = new ImageIcon("images_projet/cleeau.png");
                        CVue.cle1img.setIcon(icon1);
                    } else if (Controleur.idj==1){
                        Icon icon1 = new ImageIcon("images_projet/cleeau.png");
                        CVue.cle2img.setIcon(icon1);
                    } else if (Controleur.idj==2){
                        Icon icon1 = new ImageIcon("images_projet/cleeau.png");
                        CVue.cle3img.setIcon(icon1);
                    } else if (Controleur.idj==3){
                        Icon icon1 = new ImageIcon("images_projet/cleeau.png");
                        CVue.cle4img.setIcon(icon1);
                    } 
                } else if(lkeys.get(idk)=="feu"){
                    if (Controleur.idj==0){
                       Icon icon1 = new ImageIcon("images_projet/clefeu.png");
                        CVue.cle1img.setIcon(icon1);
                    } else if (Controleur.idj==1){
                        Icon icon1 = new ImageIcon("images_projet/clefeu.png");
                        CVue.cle2img.setIcon(icon1);
                    } else if (Controleur.idj==2){
                        Icon icon1 = new ImageIcon("images_projet/clefeu.png");
                        CVue.cle3img.setIcon(icon1);
                    } else if (Controleur.cpt==3){
                        Icon icon1 = new ImageIcon("images_projet/clefeu.png");
                        CVue.cle4img.setIcon(icon1);
                    } 
                } else if(lkeys.get(idk)=="terre"){
                    if (Controleur.idj==0){
                       Icon icon1 = new ImageIcon("images_projet/cleterre.png");
                        CVue.cle1img.setIcon(icon1);
                    } else if (Controleur.idj==1){
                        Icon icon1 = new ImageIcon("images_projet/cleterre.png");
                        CVue.cle2img.setIcon(icon1);
                    } else if (Controleur.idj==2){
                        Icon icon1 = new ImageIcon("images_projet/cleterre.png");
                        CVue.cle3img.setIcon(icon1);
                    } else if (Controleur.idj==3){
                        Icon icon1 = new ImageIcon("images_projet/cleterre.png");
                        CVue.cle4img.setIcon(icon1);
                    } 
                } else if(lkeys.get(idk)=="air"){
                    if (Controleur.idj==0){
                       Icon icon1 = new ImageIcon("images_projet/cleair.png");
                        CVue.cle1img.setIcon(icon1);
                    } else if (Controleur.idj==1){
                        Icon icon1 = new ImageIcon("images_projet/cleair.png");
                        CVue.cle2img.setIcon(icon1);
                    } else if (Controleur.idj==2){
                        Icon icon1 = new ImageIcon("images_projet/cleair.png");
                        CVue.cle3img.setIcon(icon1);
                    } else if (Controleur.idj==3){
                        Icon icon1 = new ImageIcon("images_projet/cleair.png");
                        CVue.cle4img.setIcon(icon1);
                    } 
                }
                lkeys.remove(idk);}
                
            }else if (aleatoire == 4){
                zones[j.getX()][j.getY()].inonde();
                System.out.println("pas de chance, la zone a ete inondee");
            }else if (aleatoire == 5 | aleatoire == 6 | aleatoire == 7){
                int h = genererInt(0,1);
                j.setAtout(Atouts.get(h));
                System.out.println("Joueur" + j.getLabel() + " receive atout" + Atouts.get(h));
            }
        }
        /**
         * Pour finir, le modèle ayant changé, on signale aux observateurs
         * qu'ils doivent se mettre à jour.
         */
        notifyObservers();
    }

    public boolean recupArtfct(Joueur j){
        Zone art = zones[j.getX()][j.getY()];
        if (art.getArtefacts().size() != 0& j.getKeys().contains(art.getArtefacts().get(0).getLabel())){
            j.recupArtefact(art.getArtefacts().get(0));
            if(art.getArtefacts().get(0).getElement()=="eau"){
                Icon icon = new ImageIcon("images_projet/eau2.png"); 
                CVue.eau.setIcon(icon);
            } else if(art.getArtefacts().get(0).getElement()=="feu"){
                Icon icon = new ImageIcon("images_projet/feu2.png");
                CVue.feu.setIcon(icon);
            } else if(art.getArtefacts().get(0).getElement()=="terre"){
                Icon icon = new ImageIcon("images_projet/terre2.png");
                CVue.terre.setIcon(icon);
            } else if(art.getArtefacts().get(0).getElement()=="air"){
                Icon icon = new ImageIcon("images_projet/air2.png");
                CVue.air.setIcon(icon);
            }  
            art.removeArtefact(art.getArtefacts().get(0));
            return true;
        }else{
            return false;
        }
    }

    public Joueur initJoueur(Image P) {
        int e = genererInt(y - dimH/2, (dimH + y - dimH/2)+1);
        int f = genererInt(x - dimL/2, (dimL + x - dimL/2)+1);

        while(zones[e][e].getJoueurs().size() != 0) {
            e = genererInt(y - dimH/2, (dimH + y - dimH/2)+1);
            f = genererInt(x - dimL/2, (dimL + x - dimL/2)+1);
        }
        Joueur j = new Joueur(e, f, P);

        zones[j.getX()][j.getY()].addJoueur(j);
        ljoueurs.add(j);
        notifyObservers();
        return j;

    }

    public Artefact initArtefact(String s, Image P){
        int e = genererInt(y - dimH/2, (dimH + y - dimH/2)+1);
        int f = genererInt(x - dimL/2, (dimL + x - dimL/2)+1);

        while(zones[e][f].getArtefacts().size() != 0) {
            e = genererInt(y - dimH/2, (dimH + y - dimH/2)+1);
            f = genererInt(x - dimL/2, (dimL + x - dimL/2)+1);
        }
        Artefact a = new Artefact(s, e, f, P);
        zones[a.getX()][a.getY()].addArtefact(a);
        lartefacts.add(a);
        notifyObservers();
        return a;
    }


     public void initHeliport(){
         int a = genererInt(y - dimH/2, (dimH + y - dimH/2)+1);
         int b = genererInt(x - dimL/2, (dimL + x - dimL/2)+1);
         zones[a][b].setDefinition("portail");
         notifyObservers();
    }


    public void initIle() {
        for(int i = y - dimH/2; i < dimH + y - dimH/2+1; i++){
            for(int j = x - dimL/2; j < dimL + x - dimL/2+1; j++) {
                zones[i][j].setStatus(0);
            }
        }
        notifyObservers();

    }


    public void deplaceJoueur(Joueur j, int x, int y) {
        if(zones[j.getX() + x][j.getY() + y].status() != 2) {
            zones[j.getX() + x][j.getY() + y].addJoueur(j);
            zones[j.getX()][j.getY()].removeJoueur(j);
            j.deplace(x, y);
        }else{
            System.out.println("Zone submergee");
        }
        notifyObservers();
    }

    public int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }




}
