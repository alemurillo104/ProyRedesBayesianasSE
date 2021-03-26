
package views;

import models.RedBayesiana;

public class MainGame {
    
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
        RB.setAdyacenteProb("M1", "E", 0.1f);
        RB.setAdyacenteProb("M1", "C", 0.9f);

        RB.Inferencia();

        System.out.println(RB.toString());
    }
}


//ERRORES PARA ARREGLAR


//TO DO - LO QUE FALTA POR HACER

// 5. Permitir editar los vertices y las aristas de los graficos 

// 10. borrar las aristas
// 11. Visual grafico, indicar que se puede añadir o editar con los mismos campos

// 13. Valores entre 0 - 1 para el CF
// 14. Añadir vertice -> cancelar ERROR

// 15. Si en darValores HN le da un valor no entre 0 -1 se reinicia todo



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
//12. Borrar comentarios  y funciones innecesarias
// 16. el CF 0 no se printea idk why