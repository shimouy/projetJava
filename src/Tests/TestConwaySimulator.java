package Tests;
import gui.*;
import java.awt.Color;
import Automates.Conway;
import Simulation.ConwaySimulator;

public class TestConwaySimulator {

    public static void main(String[] args) {
        Conway [][] tab=new Conway[5][5];
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                tab [i][j]=new Conway(0, i, j,0);
            }
        }

        tab[1][1].init_state(1);
        tab[1][2].init_state(1);
        tab[2][1].init_state(1);
        tab[2][3].init_state(1);
        tab[4][4].init_state(1);

        for (int w=0;w<5;w++){
            for (int k=0;k<5;k++){
                tab[w][k].ajouter_voisins((tab));
            }
        }
        GUISimulator gui = new GUISimulator (500 ,500 ,Color.BLACK ) ;
        gui.setSimulable (new ConwaySimulator (tab,gui));
        // TODO Auto-generated method stub

    }

}
