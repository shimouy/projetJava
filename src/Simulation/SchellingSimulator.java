package Simulation;
import java.awt.Color;
import Automates.Schelling;
import gui.*;


public class SchellingSimulator implements Simulable {
    private Color colors[];
    public Schelling sch;
    public GUISimulator ig;
    public int Cellules[][];

    private final int BORDER = 10;
    private final int DIM = 12;
    private final int SIZE = DIM - 2;

	public SchellingSimulator(GUISimulator ig, Schelling sch, Color colors[]) {
		this.ig=ig;
		this.sch=sch;
		this.colors = colors;
	}
	public Rectangle viewCell(int x, int y, Color col) {
        return new Rectangle(BORDER + x * DIM, BORDER + y * DIM, col, col, SIZE);
    }

	public void affiche() {
        Cellules = sch.getCellules();
        for (int i = 0; i < Cellules.length; i++) {
            for (int j = 0; j < Cellules[i].length; j++) {
                    ig.addGraphicalElement(viewCell(i, j, getCellColor(i, j)));
                }
            }
        }
	public Color getCellColor(int x, int y) {
		return colors[Cellules[x][y]];
	}
@Override
    public void next () {
        sch.generate();
        ig.reset();
        affiche();
    }

    @Override
    public void restart () {
        sch.reInit();
        ig.reset();
        affiche();
    }
}
