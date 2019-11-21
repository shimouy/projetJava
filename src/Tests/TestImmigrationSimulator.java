package Tests;
import gui.*;
import java.awt.Color;
import Automates.Immigration;
import Simulation.ImmigrationSimulator;

public class TestImmigrationSimulator {

	private static void exempleDuSujet(Immigration immigration,int x, int y){
		immigration.add(x,y,3);
		immigration.add(x,y+1,3);
		immigration.add(x,y+2,1);

		immigration.add(x+1,y+1,1);
		immigration.add(x+1,y+2,1);
		immigration.add(x+1,y+3,1);
		immigration.add(x+1,y+4,3);

		immigration.add(x+2,y,1);
		immigration.add(x+2,y+1,1);
		immigration.add(x+2,y+2,3);
		immigration.add(x+2,y+3,2);
		immigration.add(x+2,y+4,2);

		immigration.add(x+3,y,1);
		immigration.add(x+3,y+1,1);
		immigration.add(x+3,y+2,2);
		immigration.add(x+3,y+3,2);
		immigration.add(x+3,y+4,2);

		immigration.add(x+4,y+1,2);
		immigration.add(x+4,y+2,2);
		immigration.add(x+4,y+3,2);
		immigration.add(x+4,y+4,1);

	}
    public static void main(String[] args) {

	Immigration imm = new Immigration(10, 10, 4);

		exempleDuSujet(imm,0,0);
		System.out.println(imm);

		GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);

		gui.setSimulable(new ImmigrationSimulator(gui, imm));
	}
}
