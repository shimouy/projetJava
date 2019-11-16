package Cellule;
import gui.*;
import java.awt.Color;

public class CelluleImigSimulator extends CelluleSimulator {

    public CelluleImigSimulator(Cellule [][]tab, GUISimulator ig){
        super(tab,ig);
    }

    @Override
    public void affiche(Cellule [][]tab, GUISimulator ig) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tab[i][j].getState() == 0) {
                    ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.WHITE, 100));
                }
                if (tab[i][j].getState() == 1) {
                    ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.LIGHT_GRAY, 100));
                }
                if (tab[i][j].getState() == 2) {
                    ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.DARK_GRAY, 100));
                }
                if (tab[i][j].getState() == 3) {
                    ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.BLACK, 100));
                }
            }
        }
    }

    @Override
    public void next () {

        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                tab[i][j].set_state();
            }
        }
        affiche(tab,ig);
    }
}
