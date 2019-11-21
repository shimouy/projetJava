package Simulation;
import Automates.Conway;
import Balls.Balls;

import java.awt.Color;
import java.awt.Point;
import java.util.Iterator;
import java.util.Random;

import gui.GUISimulator;
import gui.Oval;
import gui.Rectangle;
import gui.Simulable;


public class BallsSimulator implements Simulable {
    private Balls balls;
    private GUISimulator gui;

    public BallsSimulator(Balls balls, GUISimulator gui) {
        this.balls = balls;
        this.gui = gui;
        balls.setX(gui.getPanelWidth());
        balls.setY(gui.getPanelHeight());
    }

    public Color randColor() {
        Random rand = new Random();
        float hue = rand.nextFloat();
        float saturation = (rand.nextInt(2000) + 100) / 1600f;
        float luminance = 0.97f;
        return Color.getHSBColor(hue, saturation, luminance);
    }

    public void affiche() {
        Iterator<Point> it = balls.iterator();
        while (it.hasNext()) {
            Point point = it.next();
            gui.addGraphicalElement(new Oval((int) point.getX(), (int) point.getY(), Color.BLACK, randColor(), 40));
        }
    }


    @Override
    public void next() {
        this.balls.animBalls(gui.getPanelWidth(), gui.getPanelHeight());
        this.gui.reset();
        this.affiche();
    }

    @Override
    public void restart() {
        this.balls.reInit();
        this.gui.reset();
        this.affiche();
    }

}
