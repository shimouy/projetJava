package Cellule;

import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;

import java.awt.*;

public class CelluleImig extends Cellule {
    private int Netat;

    public CelluleImig(int state, int n, int m,int init,int Netat){
        super(state,n,m,init);
        this.Netat=Netat;
    }

    @Override
    public int getState() {
        return super.state;
    }

    @Override
    public int nb_voisins_vivant() {
        int tmp = 0;
        for (int i = 0; i < 8; i++) {
            if (voisins[i].state == super.mod((super.state)+1,Netat)) {
                tmp++;
            }
        }
        return tmp;
    }

    @Override
    public  void set_state() {
        super.state = super.mod((super.state) + 1, Netat);
    }



}
