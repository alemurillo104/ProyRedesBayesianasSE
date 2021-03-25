
package controllers;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.RedBayesiana;
import views.JPRedBayesiana;

public class FileController {
    
    
    public String saveRedArchivo(RedBayesiana RB,boolean archivoExiste, String nombreArchivo ){
        Gson g = new Gson();
        
        String datos = g.toJson(RB);
        //String datos = g.toJson(RB.vertices);
        
        String filename = "";
        String resp = "";
        
        if (archivoExiste) {
            filename = nombreArchivo;
        }else{
            
            UUID uniqid = UUID.randomUUID();
            filename = "red"+uniqid+".json";            
            //uniqid.toString();
        }
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(datos);

            writer.close();
            
            //JOptionPane.showConfirmDialog(rootPane, "Gráfica de la Red Bayesiana guardada en el directorio del proyecto! :)");
            
            if (!archivoExiste) {
                archivoExiste = true;
                nombreArchivo = filename;
            }
            resp = "Gráfica de la Red Bayesiana guardada en el directorio del proyecto! :)";
            
        } catch (IOException ex) {
            Logger.getLogger(JPRedBayesiana.class.getName()).log(Level.SEVERE, null, ex);
            
            //JOptionPane.showConfirmDialog(rootPane, "Ups! Algo salió mal con el guardado del gráfico de la red :(");
            resp = "Ups! Algo salió mal con el guardado del gráfico de la red :(";
        }
        return resp;
    }
    
    public void readRedArchivo(){
        
    }
}
