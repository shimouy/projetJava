package Tests;

import gui.*;
import java.awt.Color;
import Automates.Conway;
import Simulation.ConwaySimulator;

public class TestConwaySimulator {

    private static void exempleOfProject(Conway conway, int x, int y) {
        conway.add(x,y);
        conway.add(x,y+1);
        conway.add(x+1,y);
        conway.add(x+2,y+2);
        conway.add(x+3,y+4);
    }

    private static void pentaDecathlon (Conway conway, int x, int y) {
        conway.add(x,y);
        conway.add(x-1,y-1);
        conway.add(x,y-1);
        conway.add(x+1,y-1);
        conway.add(x-2,y-2);
        conway.add(x-1,y-2);
        conway.add(x,y-2);
        conway.add(x+1,y-2);
        conway.add(x+2,y-2);
        conway.add(x-2,y-9);
        conway.add(x-1,y-9);
        conway.add(x,y-9);
        conway.add(x+1,y-9);
        conway.add(x+2,y-9);
        conway.add(x-1,y-10);
        conway.add(x,y-10);
        conway.add(x+1,y-10);
        conway.add(x,y-11);
    }

    public static void main(String[] args) {
        Conway conway = new Conway(20, 18);
        exempleOfProject(conway,3,8);
        pentaDecathlon(conway,12,14);

        GUISimulator gui = new GUISimulator (500 ,500 ,Color.BLACK ) ;
        gui.setSimulable(new ConwaySimulator(conway,gui));
    }

}
