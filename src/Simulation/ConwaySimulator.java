package Simulation;
        import Automates.Conway;
        import gui.*;
        import java.awt.Color;


public class ConwaySimulator implements Simulable {
    Conway[][]tab;
    GUISimulator ig;


    public ConwaySimulator( Conway [][]tab, GUISimulator ig) {
        this.tab = tab;
        this.ig = ig;

    }

    public void affiche(Conway [][]tab, GUISimulator ig) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tab[i][j].getState() == 1) {
                    ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.CYAN, 100));
                }
            }
        }
    }

    public void delete(Conway[][] tab,GUISimulator ig) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ig.addGraphicalElement(new Rectangle((tab[i][j].getN())*100, (tab[i][j].getM())*100,Color.GRAY, Color.WHITE, 100));
            }
        }
    }



// ...

    @Override
    public void next () {
        delete(tab,ig);
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                tab[i][j].set_state();
            }
        }
        affiche(tab,ig);
    }




    @Override
    public void restart () {
        delete(tab,ig);
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                tab[i][j].reInit();
            }
        }
        affiche(tab,ig);
    }
}