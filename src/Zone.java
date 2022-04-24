import java.util.ArrayList;

public class Zone {
    private CModele modele;
    private int etat;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Artefact> artefacts;
    private final int x, y;
    private String definition;

    public Zone(CModele modele, int x, int y, String def) {
        this.modele = modele;
        this.etat = 2;
        this.x = x; this.y = y;
        this.artefacts = new ArrayList<Artefact>();
        this.joueurs = new ArrayList<Joueur>();
        this.definition = def;
    }

    public int status(){
        return this.etat;
    }
    public String def(){return this.definition;}

    public void setStatus(int etat) {
        this.etat = etat;
    }
    public void setDefinition(String def){this.definition = def;}

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

    public void assecher() {
        if (this.etat == 1) {
            this.etat -= 1;
        } else {
            System.out.println("Zone submergée ou asséchée");
        }
    }

    public void inonde() {
        if (this.status() == 1 || this.status() == 0) {
            this.etat += 1;
        }else if (this.status() == 10){

        }
    }
}
