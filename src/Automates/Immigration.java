package Automates;
import java.util.ArrayList;

public class Immigration extends Automates {
    private int nextCells[][];

    public Immigration(int n, int m, int states) {
        this(n, m, states, 0);
    }

    public Immigration(int n, int m, int states, int initStates) {
        super(n,m,states,0);
        nextCells = new int[n][m];
    }

    protected void endCellGen(int x, int y, int nbNeighbors) {
        final int state = Cellules[x][y];
        final int next = (state + 1) % states;
        // S'il y a 3 voisins ou plus dans l'état suivant, on y passe aussi
        if (nbNeighbors >= 3)
            nextCells[x][y] = next;
            // Sinon on ne change rien
        else
            nextCells[x][y] = state;
    }

    public int numberOfNeighborsAlive(int x, int y, int n, int m, int state) {
        int nb = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // Eviter la cellule courantepmp
                if (i != 0 || j != 0) {
                    if (Cellules[mod(x + i, n)][mod(y + j, m)] == mod(state + 1, states))
                        nb++;
                }
            }
        }
        return nb;
    }

    @Override
    public void setGeneration() {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                final int state = Cellules[x][y];
                endCellGen(x, y, numberOfNeighborsAlive(x, y, n, m, state));
            }
        }
    }

    @Override
    public void finalGeneration(){
        int[][] tmp=Cellules;
        Cellules=nextCells;
        nextCells=tmp;
    }

    public  void reInit(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Cellules[i][j] = initStates;
            }
        }
        for (Cell c : Start) {
            Cellules[c.getX()][c.getY()] = c.getState();
        }
    }

    public String toString() {
		String str = new String("Immigration("+n+", "+m+")\n");

		for (Cell c : Start) {
			str += c + "\n";
		}
		return str;
	}

}
