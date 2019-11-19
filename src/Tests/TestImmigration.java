package Tests;
import Automates.Immigration;

public class TestImmigration  {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Immigration[][] tab = new Immigration[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tab[i][j] = new Immigration(0, i, j, 0,4);
            }
        }


        tab[0][0].init_state(3);
        tab[0][1].init_state(3);
        tab[0][2].init_state(1);

        tab[1][1].init_state(1);
        tab[1][2].init_state(1);
        tab[1][3].init_state(1);
        tab[1][4].init_state(3);

        tab[2][0].init_state(1);
        tab[2][1].init_state(1);
        tab[2][2].init_state(3);
        tab[2][3].init_state(2);
        tab[2][4].init_state(2);

        tab[3][0].init_state(1);
        tab[3][1].init_state(1);
        tab[3][2].init_state(2);
        tab[3][3].init_state(2);
        tab[3][4].init_state(2);

        tab[4][1].init_state(2);
        tab[4][2].init_state(2);
        tab[4][3].init_state(2);
        tab[4][4].init_state(1);


        for (int w = 0; w < 5; w++) {
            for (int k = 0; k < 5; k++) {
                tab[w][k].ajouter_voisins((tab));
            }
        }
        System.out.println("On affiche les voisins à l'état initial");
        for (int z=0;z<5;z++){
            for(int q=0;q<5;q++){
            System.out.println("nb-voisins ["+z+"]["+q+"] = " +tab[z][q].nb_voisins_vivant());

            }
        }
        System.out.println(("On affiche les voisins dans Step 1"));

        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                tab[i][j].set_state();
            }
        }


        for (int z=0;z<5;z++){
            for(int q=0;q<5;q++){
                System.out.println("nb-voisins ["+z+"]["+q+"] = " +tab[z][q].nb_voisins_vivant());
            }
        }




    }
}
