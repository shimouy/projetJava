package Agent;

import processing.core.PVector;
import processing.*;
import java.io.Serializable;
import java.lang.Math.*;
import java.lang.Object;
import java.util.ArrayList;

public class Voiture {
        PVector location;
        PVector velocity;
        PVector acceleration;
        final int maxspeed = 4;
        final float maxforce =(float) 0.1;
        int index;
        ArrayList<Voiture> start;
        ArrayList<Voiture> Current;
        private int nbVoitures;


        public int setnbVoiture(int nbVoiture){
            return  this.nbVoitures=nbVoiture;
        }


        public int getNbVoitures(){
            return nbVoitures;
        }
        public Voiture(int x, int y, int vx, int vy, int ax, int ay, int i ){
            acceleration = new PVector(ax, ay);
            velocity = new PVector(vx, vy);
            location = new PVector(x, y);
            index=i;
            start = new ArrayList<Voiture>();
            Current = new ArrayList<Voiture>();
        }

        public void add(int x,int y,int vx,int vy,int ax,int ay,int i){
            start.add(new Voiture(x,y,vx,vy,ax,ay,i));
            Current.add(new Voiture(x,y,ax,ay,vx,vy,i));

        }

        public PVector getLocation() {
            return location;
        }
        public PVector getVelocity() {
            return velocity;
        }
        public PVector getAcceleration() {
            return acceleration;
        }

        public  PVector rule1(Voiture[] voitures , int nb) {
            PVector pcj = new PVector(0, 0);
            for (int i = 0; i < nb; i++) {
                if(i!=index)
                pcj.add(voitures[i].location);
            }
            return pcj;
        }

        public float vectorDistanse (PVector location1,PVector location2){
            float x = Math.abs(location1.x-location2.x);
            float y= Math.abs(location1.y-location2.y);
            float z= Math.abs(location1.z-location2.z);

            float vector = (x*x)+(y*y)+(z*z);
            return (float) Math.sqrt(vector);
        }

         public  PVector rule2(Voiture[] voitures , int nb) {
            PVector c = new PVector(0, 0);
             for (int i = 0; i < nb; i++) {
                 if (i != index) {
                     if (vectorDistanse(location, voitures[i].location) < 100) {
                         c.sub(PVector.sub(location,voitures[i].location));
                     }
                 }
             }
             return c;
         }

        public void applyForce(PVector force) {
            acceleration.add(force);
        }

        public void seek(PVector target) {
            PVector desired = PVector.sub(target,location);
            desired.normalize();
            desired.mult(maxspeed);
            PVector steer = PVector.sub(desired,velocity);
            steer.limit(maxforce);
            applyForce(steer);
        }

        public void SetGeneration(Voiture[] next, Voiture[] Current){
            for (int i=0;i<nbVoitures;i++){
                next[i].acceleration.add(rule1(Current,nbVoitures),rule2(Current,nbVoitures));
                next[i].velocity.add(Current[i].velocity,next[i].acceleration);
                next[i].location.add(Current[i].location,next[i].velocity);
            }
        }


        public void finalGeneration(Voiture[] next,Voiture[] Current){
            for (int i=0;i<nbVoitures;i++){
                Current[i].location.sub(next[i].location);
                Current[i].location.div(100);
                Current[i].velocity=next[i].velocity;
                Current[i].acceleration=next[i].acceleration;
            }
        }

        public void reInit(){
            for (Voiture v: start){
                Current.add(v);
            }
        }

}
