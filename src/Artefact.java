import java.awt.*;

public class Artefact {
    private String element;
    private int x, y;
    private String label;
    private Image im;

    public Artefact(String element, int x, int y, Image im){
        this.element = element;
        this.x = x;
        this.y = y;
        this.label = "*";
        this.im = im;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getIm() {
        return im;
    }

    public String getLabel() {
        return label;
    }

    public String getElement() {
        return element;
    }
}
