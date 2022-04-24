import java.awt.*;
import java.util.ArrayList;

public class Joueur {
    CModele modele;
    private String key;
    public ArrayList<Artefact> artefacts;
    private int x, y;
    private static int cpt_j = 0;
    private String label;
    private String atout;
    private Image im;


    public Joueur(int x, int y, Image im){
        this.key = " ";
        this.artefacts = new ArrayList<Artefact>();
        this.atout = " ";
        this.im = im;
        this.x = x; this.y = y;
        this.label = "" + cpt_j;
        cpt_j += 1;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public String getKeys() {
        return key;
    }
    public Image getIm() {
        return im;
    }

    public String getLabel() {
        return label;
    }

    public String getAtouts() {
        return atout;
    }

    public void recupArtefact(Artefact a){
        artefacts.add(a);
    }

    public void receiveKey(String cle){
        key = cle;
        }

    public void deplace(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void setAtout(String atout) {
        this.atout = atout;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCoord(int x, int y){
        this.y = y;
        this.x = x;
    }

}

