import java.util.ArrayList;

public class Zone {
    private CModele modele;
    private int etat;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Artefact> artefacts;
    private final int x, y;

    public Zone(CModele modele, int x, int y) {
        this.modele = modele;
        this.etat = 0;
        this.x = x; this.y = y;
        this.artefacts = new ArrayList<Artefact>();
        this.joueurs = new ArrayList<Joueur>();
    }

    public int status(){
        return this.etat;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Artefact> getArtefacts() {
        return artefacts;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public void addJoueur(Joueur j){
        this.joueurs.add(j);
    }

    public void removeJoueur(Joueur j){
        this.joueurs.remove(j);
    }

    public void addArtefact(Artefact a){
        this.artefacts.add(a);
    }

    public void removeArtefact(Artefact a){
        this.artefacts.remove(a);
    }

    public void inonde(){
        if (etat == 0){
            etat = 1;
        }else if (etat == 1){
            etat = 2;
        }
}}
