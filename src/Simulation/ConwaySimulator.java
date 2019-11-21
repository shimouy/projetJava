package Simulation;
        import Automates.Conway;
        import gui.*;
        import java.awt.Color;
        import java.util.Random;

public class ConwaySimulator implements Simulable {

    private final int BORDER = 10;
    private final int DIM = 30;
    private final int SIZE = DIM - 2;

    public Conway conway;
    public GUISimulator ig;
    public int Cellules[][];

    public ConwaySimulator(Conway conway, GUISimulator ig) {
        this.conway = conway;
        this.ig = ig;

    }

    public Rectangle viewCell(int x, int y, Color col) {
        return new Rectangle(BORDER + x * DIM, BORDER + y * DIM, col, col, SIZE);
    }

    public Color getCellColor(int x, int y) {
        Color color = Color.BLACK;
        switch (Cellules[x][y]) {
            case Conway.ALIVE:
                color = Color.decode("#880044");
                break;

            case Conway.DEAD:
            default:
                color = Color.decode("#ffe5d9");
                break;
        }
        return color;
    }

    public void affiche() {
        Cellules = conway.getCellules();
        for (int i = 0; i < Cellules.length; i++) {
            for (int j = 0; j < Cellules[i].length; j++) {
                    ig.addGraphicalElement(viewCell(i, j, getCellColor(i, j)));
                }
            }
        }

    @Override
    public void next () {
        conway.generate();
        ig.reset();
        affiche();
    }

    @Override
    public void restart () {
        conway.reInit();
        ig.reset();
        affiche();
    }

}