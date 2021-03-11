
package views;

import models.RedBayesiana;

public class Main {
    
    public static void main(String[] args) {

        RedBayesiana RB = new RedBayesiana();
        
        RB.addVertice("A");
        RB.addVertice("B");
        RB.addVertice("C");
        RB.addVertice("D");
        RB.addVertice("E");
        RB.addVertice("M");
        RB.addVertice("M1");
        
        RB.setVerticeCF("A", 0.3f);
        RB.setVerticeCF("B", 0.8f);
        RB.setVerticeCF("C", 0.1f);
        
        
        
        RB.setAdyacenteProb("D", "A", 0.3f);
        RB.setAdyacenteProb("D", "B", 0.7f);
        RB.setAdyacenteProb("E", "B", 0.1f);
        RB.setAdyacenteProb("E", "C", 0.9f);
        RB.setAdyacenteProb("M", "D", 0.5f);
        RB.setAdyacenteProb("M", "E", 0.5f);
        RB.setAdyacenteProb("M1", "E", 0.1f);//1 4
        RB.setAdyacenteProb("M1", "C", 0.9f);//9 6
        
        RB.Inferencia();
        
        System.out.println(RB.toString());
    }
}


//ERRORES PARA ARREGLAR

//1. Añade probabilidad a vertices que no existen ash
