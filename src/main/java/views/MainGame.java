
package views;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Adyacente;
import models.Persona;
import models.PersonaArray;
import models.RedBayesiana;
import models.RedParserController;
import models.Vertice;
import models.VerticeM;

public class MainGame {
    
    public static void main(String[] args) {
        
        String filename = "red.json";
        //String filename = "ejemplo.json";
        String json = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            
            String linea = "";
            while ( (linea = br.readLine())!= null ) {                
                json+= linea;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(json);
        
        /*
        //FUNCIONAAAA
        Gson g = new Gson();
        PersonaArray p = g.fromJson(json, PersonaArray.class);
        System.out.println(p);
        
        for (Persona p1 : p.getVertices()) {
            System.out.println(p1);
        }
        */
        
        
        
        Gson g = new Gson();
        RedParserController p = g.fromJson(json, RedParserController.class);
        System.out.println(p);
        
        //RedBayesiana RB = new RedBayesiana();
        
        
        for (Vertice vertice : p.getVertices()) {
            
            //Vertice v = new Vertice(vertice.getTag());
            
            
            System.out.println(vertice.getTag());
            System.out.println(vertice.getCF());
            System.out.println(vertice.getPosX());
            System.out.println(vertice.getPosY());
            
            LinkedList<Adyacente> ad = vertice.getAdyacentes();
            for (int i = 0; i < ad.size(); i++) {
                System.out.println("verticeU = "+ad.get(i).getVerticeU());
                System.out.println("probabilidad = " + ad.get(i).getProbabilidad());
            }
            //Adyacente[] ad = vertice.getAdys();
            /*
            for (int i = 0; i < ad.length; i++) {
                System.out.println("verticeU = "+ad[i].getVerticeU());
                System.out.println("probabilidad = " + ad[i].getProbabilidad());
            }*/
        }
        System.out.println("holisssssssssssss");
        System.out.println("length = " + p.getVertices().size());
        RedBayesiana RB = new RedBayesiana();
        RB.setAdyacentes(p.getVertices());
        System.out.println(RB.toString());
        System.out.println("holisssssssssssss2");
        
        
        System.out.println("------------------------------------");
        UUID uniqid = UUID.randomUUID();
        //UUID uniqid = UUID.randomUUID();
        System.out.println(uniqid);
        
        System.out.println("uniq = "+ uniqid.toString());
//        Gson g = new Gson();
//        Persona p = g.fromJson(json, Persona.class);
//        System.out.println(p);
//        p.setEdad(12);
//        System.out.println(p);

/*
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
            
            Gson g = new Gson();
            
            System.out.println(g.toJson(RB.vertices.get(5).getAdyacentes()));
            */
    }
}


            /*
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
            
            System.out.println(RB.toString());*/

//ERRORES PARA ARREGLAR


//TO DO - LO QUE FALTA POR HACER

// 5. Permitir editar los vertices y las aristas de los graficos 

// 10. borrar las aristas
// 11. Visual grafico, indicar que se puede añadir o editar con los mismos campos

//IN PROGRESS
// 1. Graficar





//DONE 
//1. Añade vertices duplicados
//2. Añade probabilidad a vertices que no existen ash /// no se cual era el ejemplo :c

// 2. Almacenar la info de la red en un archivo
// 3. Leer del archivo los datos para graficar la red
// 4. Graficar la red
// 6. Actualizar los graficos de la red guardada, es decir, actualizar los datos del mismo archivo
//    y luego guardarlo en el mismo.
// 7. Poner todos los CFs en -1
// 8. Borrar los CFs graficamente cuando volvemos a hacer la inferencia para que no se sobreponga

// 9. Editar las probabilidades de las aristas