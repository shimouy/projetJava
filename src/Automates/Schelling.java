package Automates;
import java.util.LinkedList;

public class Schelling extends Automates{
    private int K;
    private boolean init ;
    private int nextCells[][];

    private LinkedList<Cell> vacantHouses;

    public Schelling(int n, int m, int states, int K) {
		this(n, m, states, K, 0);
		init = true;
	}
	public Schelling(int n, int m, int states, int K, int initSates) {
		super(n, m, states, initSates);
		this.K = K;
        nextCells = new int[n][m];
		vacantHouses = new LinkedList<Cell>();
	}
    private void initVacantHouses() {
		vacantHouses.clear();
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				if(Cellules[x][y] == initStates)
					vacantHouses.add(new Cell(x, y, initStates));
			}
		}
	}

	protected void preGeneration() {

		// Initialise les maisons vacantes la première fois
		if (init) {
			initVacantHouses();
			init = false;
		}

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				nextCells[x][y] = Cellules[x][y];
			}
		}
	}

	protected boolean skipCellGen(int cell) {
		boolean skip = false;
		// Si une maison est vacante, elle ne va pas déménager
		if (cell == initStates)
			skip = true;
		return skip;
	}


	protected boolean isNeighborMatch(int cell, int neighbor) {
		boolean success = false;

		// Si un voisin est différent, on le compte
		if (neighbor != cell && neighbor != initStates) {
			success = true;
		}
		return success;
	}

	protected void endCellGen(int x, int y, int nbNeighbors) {
		// Si plus de K voisins différents, on déménage
		if(nbNeighbors > K) {
			// La maison courante devient vacante
			nextCells[x][y] = initStates;
			vacantHouses.add(new Cell(x, y, initStates));
			// Choix d'une nouvelle maison vacante
			Cell cell = vacantHouses.remove();
			nextCells[ cell.getX() ][ cell.getY() ] = Cellules[x][y];
		}
	}

	protected int getNeighbor(int cell, int n, int max) {
		int pos = cell + n;
		if (pos == 0)
			pos = max - 1;
		else
			pos = (pos - 1) % max;
		return pos;
	}

	public int numberOfNeighbor(int x, int y, int n, int m, int K) {
        int nb = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // Eviter la cellule courantepmp
                if (i != 0 || j != 0) {
                    if (Cellules[mod(x + i, n)][mod(y + j, m)] > K)
                        nb++;
                }
            }
        }
        return nb;
    }
    @Override
	public void setGeneration() {
		preGeneration();
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				final int cell = Cellules[x][y];
				// S'il faut générer la cellule courante
				if (!skipCellGen(cell)) {
					endCellGen(x, y, numberOfNeighbor(x,y,n,m,K));
				}
			}
		}
	}

	@Override
	public void finalGeneration() {
		int tmp[][] = Cellules;
		Cellules = nextCells;
		nextCells = tmp;
	}
	@Override
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
		String str = new String("Schelling("+n+", "+m+")\n");

		for (Cell c : Start) {
			str += c + "\n";
		}

		return str;
	}
}
