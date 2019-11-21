package Automates;
import java.util.ArrayList;

public class Conway extends Automates{

    public static final int DEAD = 0;
    public static final int DYING = 1;
    public static final int ALIVE = 2;
    public static final int BIRTH = 3;

    public Conway(int n, int m) {
        super(n,m,4,DEAD);
        //reInit();
    }

    public void add(int x, int y){
        Cellules[x][y]=ALIVE;
        Start.add(new Cell(x,y,ALIVE));
    }

    public int numberOfNeighbors(int x, int y, int n,int m){
        int nb=0;
        for (int i = -1 ; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // Eviter la cellule courante
                if (i != 0 || j != 0) {
                    if (Cellules[mod(x + i, n)][mod(y + j, m)] == ALIVE)
                        nb++;
                }
            }
        }
        return nb;
    }

    public void setGeneration(){
        final int tmp[][] = new int [n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (Cellules[i][j] == DEAD && numberOfNeighbors(i,j,n,m) == 3)
                    tmp[i][j] = BIRTH;
                    // Si une cellule vivante ne possède ni 2 ni 3 voisines vivantes, elle meurt
                else if (Cellules[i][j] == ALIVE && numberOfNeighbors(i,j,n,m) != 2 && numberOfNeighbors(i,j,n,m) != 3)
                    tmp[i][j] = DYING;
            }
        }
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (tmp[i][j]==BIRTH &&Cellules[i][j]==DEAD){
                    Cellules[i][j]=BIRTH;
                }
                if (tmp[i][j]==DYING && Cellules[i][j]==ALIVE){
                    Cellules[i][j]=DYING;
                }
            }
        }
    }

    public void finalGeneration(){
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                switch (Cellules[x][y]) {
                    // Toute cellule née devient vivante
                    case BIRTH:
                        Cellules[x][y] = ALIVE;
                        break;
                    // Toute mourante devient morte
                    case DYING:
                        Cellules[x][y] = DEAD;
                }
            }
        }
    }

    public  void reInit(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Cellules[i][j] = DEAD;
            }
        }
        for (Cell c : Start) {
            Cellules[c.getX()][c.getY()] = ALIVE;
        }
    }

    public String toString() {
        String str = new String("Conway("+n+", "+m+")\n");
        for (Cell c : Start) {
            str += c + "\n";
        }
        return str;
    }

    public void generate() {
        setGeneration();
        finalGeneration();
    }

}