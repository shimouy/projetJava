package Balls;
import gui.*;
import java.awt.Color;

public class BallsSimulator implements Simulable {
 Balls b;
 GUISimulator ig;
 int ix;
 int iy;

 public BallsSimulator(Balls b,GUISimulator ig) {
  this.b=b;
  this.ig=ig;
  ix=1;
  iy=1;
 }

 public void affiche(Balls b,GUISimulator ig) {
  ig.addGraphicalElement(new Oval(b.getX(), b.getY(), Color.BLACK, Color.WHITE, 10));
 }

 public void delete(Balls b,GUISimulator ig) {
  ig.addGraphicalElement(new Oval(b.getX(), b.getY(), Color.BLACK, Color.BLACK, 10));
 }
 // ...

 @Override
 public void next () {
  delete(b,ig);
  b.translate(ix*10,iy* 10);
  affiche(b,ig);
  if(b.getY()==500){
   iy*=-1;
  }
  if(b.getX()==500) {
   ix*=-1;
  }
  if(b.getY()<0) iy*=-1;
  if (b.getX()<0) ix*=-1;
 }

 @Override
 public void restart () {
  if ((b.getX()!=0)||(b.getY()!=0)) delete(b,ig);
  b.reInit();
  affiche(b,ig);
 }


}
