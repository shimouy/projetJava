package Simulation;
import Automates.Immigration;
import java.awt.Color;
import gui.*;

public class ImmigrationSimulator implements Simulable {
    private final int BORDER = 10;
    private final int DIM = 50;
    private final int SIZE = DIM - 2;

    public Immigration immig;
    public GUISimulator ig;
    public int Cellules[][];

	public static final Color[] COLORS = { Color.BLACK,
		Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY,
		Color.WHITE};

	public ImmigrationSimulator(GUISimulator ig, Immigration immig) {
        this.ig=ig;
        this.immig=immig;
	}

	protected Color getCellColor(int x, int y) {
		final int state = Cellules[x][y];
		Color color;
		if (state<= COLORS.length)
		    color = COLORS[state];
		else color= new Color(state,state,state);
		return color;
	}

	public Rectangle viewCell(int x, int y, Color col) {
        return new Rectangle(BORDER + x * DIM, BORDER + y * DIM, col, col, SIZE);
    }

	public void affiche() {
        Cellules = immig.getCellules();
        for (int i = 0; i < Cellules.length; i++) {
            for (int j = 0; j < Cellules[i].length; j++) {
                    ig.addGraphicalElement(viewCell(i, j, getCellColor(i, j)));
                }
            }
        }
	@Override
    public void next () {
        immig.generate();
        ig.reset();
        affiche();
    }

    @Override
    public void restart () {
        immig.reInit();
        ig.reset();
        affiche();
    }
}
