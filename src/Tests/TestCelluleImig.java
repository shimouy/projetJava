package Tests;
import Cellule.*;

public class TestCelluleImig  {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Cellule[][] tab = new Cellule[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tab[i][j] = new CelluleImig(0, i, j, 0,4);
            }
        }


        tab[0][0].init_state(3);
        tab[0][1].init_state(3);
        tab[2][0].init_state(1);

        tab[1][1].init_state(1);
        tab[2][1].init_state(1);
        tab[3][1].init_state(1);
        tab[1][4].init_state(3);

        tab[0][2].init_state(1);
        tab[1][2].init_state(1);
        tab[2][2].init_state(3);
        tab[3][2].init_state(2);
        tab[4][2].init_state(2);

        tab[3][0].init_state(1);
        tab[1][3].init_state(1);
        tab[2][3].init_state(2);
        tab[3][3].init_state(2);
        tab[4][3].init_state(2);

        tab[4][1].init_state(2);
        tab[2][4].init_state(2);
        tab[3][4].init_state(2);
        tab[4][4].init_state(1);


        for (int w = 0; w < 5; w++) {
            for (int k = 0; k < 5; k++) {
                tab[w][k].ajouter_voisins((tab));
            }
        }
        for (int z=0;z<5;z++){
            println("nb-voisins [")
        }

    }
}
