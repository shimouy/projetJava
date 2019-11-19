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

 public BallsSimulator(Balls balls,GUISimulator gui) {
  this.balls=balls;
  this.gui=gui;
  balls.setX(gui.getPanelWidth());
  balls.setY(gui.getPanelHeight());
 }
public Color randColor(){
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
   gui.addGraphicalElement(new Oval((int) point.getX(),(int) point.getY(), Color.BLACK, randColor(), 40));
  }
 }


 @Override
 public void next () {
  this.balls.animBalls(gui.getPanelWidth(),gui.getPanelHeight());
  this.gui.reset();
  this.affiche();
 }

 @Override
 public void restart () {
  this.balls.reInit();
  this.gui.reset();
  this.affiche();
 }


 public static class ConwaySimulator implements Simulable {
     Conway[][] tab;
     GUISimulator ig;


     public ConwaySimulator( Conway [][]tab, GUISimulator ig) {
         this.tab = tab;
         this.ig = ig;

     }

     public void affiche(Conway [][]tab, GUISimulator ig) {
         for (int i = 0; i < 5; i++) {
             for (int j = 0; j < 5; j++) {
                 if (tab[i][j].getState() == 1) {
                     ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.CYAN, 100));
                 }
             }
         }
     }

     public void delete(Conway[][] tab,GUISimulator ig) {
         for (int i = 0; i < 5; i++) {
             for (int j = 0; j < 5; j++) {
             ig.addGraphicalElement(new Rectangle((tab[i][j].getN())*100, (tab[i][j].getM())*100,Color.GRAY, Color.WHITE, 100));
             }
         }
     }



 // ...

     @Override
     public void next () {
         delete(tab,ig);
         for (int i=0;i<5;i++){
             for (int j=0;j<5;j++){
                  tab[i][j].set_state();
             }
         }
         affiche(tab,ig);
     }




     @Override
     public void restart () {
         delete(tab,ig);
         for (int i=0;i<5;i++){
             for (int j=0;j<5;j++){
                 tab[i][j].reInit();
             }
         }
         affiche(tab,ig);
     }

     public static class CelluleImigSimulator extends ConwaySimulator {

         public CelluleImigSimulator(Conway[][]tab, GUISimulator ig){
             super(tab,ig);
         }

         @Override
         public void affiche(Conway [][]tab, GUISimulator ig) {
             for (int i = 0; i < 5; i++) {
                 for (int j = 0; j < 5; j++) {
                     if (tab[i][j].getState() == 0) {
                         ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.WHITE, 100));
                     }
                     if (tab[i][j].getState() == 1) {
                         ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.LIGHT_GRAY, 100));
                     }
                     if (tab[i][j].getState() == 2) {
                         ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.DARK_GRAY, 100));
                     }
                     if (tab[i][j].getState() == 3) {
                         ig.addGraphicalElement(new Rectangle(tab[i][j].getN()*100, tab[i][j].getM()*100, Color.GRAY, Color.BLACK, 100));
                     }
                 }
             }
         }

         @Override
         public void next () {
             //tab[0][0].set_state(tab);
             int [] copy = new int [25];
             for (int i = 0; i < 5; i++) {
                 for (int j = 0; j < 5; j++) {
                     copy[(5*i)+j]= tab[i][j].nb_voisins_vivant();

                 }
             }
             for (int i = 0; i < 5; i++) {
                 for (int j = 0; j < 5; j++) {
                     if (copy[(5 * i) + j] > 2) {
                         tab[i][j].set_state();
                     }
                 }
             }
             affiche(tab,ig);
         }
     }
 }
}
