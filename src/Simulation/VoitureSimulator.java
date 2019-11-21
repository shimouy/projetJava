package Simulation;
import Agent.Voiture;
import java.awt.Color;

import gui.*;

public class VoitureSimulator implements Simulable{

    public Voiture voiture;
    public GUISimulator ig;
    public Voiture[] current;
    public Voiture[] next;

    public VoitureSimulator(GUISimulator ig, Voiture voiture){
        this.ig=ig;
        this.voiture=voiture;
    }

    public void affiche(Voiture [] current , int nb) {
        for (int i = 0; i < nb; i++) {
            ig.addGraphicalElement(new Oval((int) current[i].getLocation().x, (int) current[i].getLocation().y, Color.WHITE, Color.BLACK, 10));
        }
    }

    @Override
    public void next(){
        voiture.SetGeneration(next,current);
        voiture.finalGeneration(next,current);
        ig.reset();
        affiche(current,voiture.getNbVoitures());
    }

    @Override
    public void restart(){
        voiture.reInit();
        ig.reset();
        affiche(current,voiture.getNbVoitures());
    }
}
