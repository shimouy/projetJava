package Tests;
import gui.*;
import java.awt.Color;
import Balls.*;
public class TestBallsSimulator {

	public static void main(String[] args) {
		Balls b=new Balls();
		GUISimulator gui = new GUISimulator (500 ,500 ,Color.BLACK ) ;
		gui.setSimulable (new BallsSimulator (b,gui) ) ; ;
		// TODO Auto-generated method stub

	}

}
