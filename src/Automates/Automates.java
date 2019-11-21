package Automates;
import java.util.ArrayList;

public abstract class Automates {
    protected int states;
    protected int m;
    protected int n;
    protected int initStates;
    protected int[][]Cellules;
    protected ArrayList<Cell>Start;

    public Automates(int n, int m, int states,int initStates){
        this.n = n;
        this.m = m;
        this.states = states;
        this.initStates=states;

        Cellules= new int[n][m];
        Start = new ArrayList<Cell>();
    }


    public Automates(int size, int states, int defaultState) {
		this(size, size, states, defaultState);
	}

	public void add(int x, int y, int state){
        Start.add(new Cell(x,y,state));
        Cellules[x][y]=state;
    }

    public int [][] getCellules(){
        return Cellules;
    }

    public static int mod (int a, int b) {
        int res = a % b;
        if (res<0 && b>0) {
            res += b;
        }
        return res;
    }


    public abstract void setGeneration();
    public abstract void finalGeneration();
    public abstract void reInit();

    public void generate() {
        setGeneration();
        finalGeneration();
    }

    public String toString(){
        String str = new String("Automates ("+n+", "+m+","+states+")\n");
        for (Cell c : Start) {
            str += c + "\n";
        }
        return str;

    }


    public class Cell{
        private int x;
        private int y;
        private int states;

        public Cell(int x, int y, int state){
            this.x=x;
            this.y=y;
            this.states=state;
        }

        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public int getState(){
            return states;
        }

    }
}
