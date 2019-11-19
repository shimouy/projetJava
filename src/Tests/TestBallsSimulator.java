package Tests;
import  Balls.Balls;
import Simulation.BallsSimulator;
import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class TestBallsSimulator {
	private final static int width = 500;
	private final static int height = 500;
	public static void main(String[] args) {

		Balls balls=new Balls();
		balls.addBall(new Point(30,20));
		balls.addBall(new Point(100,100));
		balls.addBall(new Point(200,280));
		balls.addBall(new Point(250,200));
		balls.addBall(new Point(180,300));

		GUISimulator gui = new GUISimulator (width ,height ,Color.BLACK) ;
		gui.setSimulable (new BallsSimulator(balls,gui));
		// TODO Auto-generated method stub

	}

}
