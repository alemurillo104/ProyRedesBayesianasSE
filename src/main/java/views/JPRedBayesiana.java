
package views;

import com.google.gson.Gson;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import models.Adyacente;
import models.Constantes;
import models.RedBayesiana;
import models.RedParserController;
import models.Vertice;


public class JPRedBayesiana extends javax.swing.JFrame {
    
    private RedBayesiana RB;
    
    private String action;
    private String actualVertice;
    private String vOrigen, vDestino;
    private float vprobabilidad;
    
    public JPRedBayesiana() {
        initComponents();
        RB = new RedBayesiana();
        action = Constantes.INICIAL;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addVerticeButton = new javax.swing.JButton();
        addProbabilidadButton = new javax.swing.JButton();
        inferenciaButton = new javax.swing.JButton();
        verticeOrigen = new javax.swing.JTextField();
        verticeDestino = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultadosTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        limpiarLienzoButton = new javax.swing.JMenuItem();
        cargarRedButton = new javax.swing.JMenuItem();
        guardarRedButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lienzo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lienzoOnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Proyecto - Redes Bayeanas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sistemas Expertos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Vertice Origen:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Vertice Destino:");

        addVerticeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addVerticeButton.setText("Añadir Vertice");
        addVerticeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVerticeButtonActionPerformed(evt);
            }
        });

        addProbabilidadButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addProbabilidadButton.setText("Añadir Probabilidad");
        addProbabilidadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProbabilidadButtonActionPerformed(evt);
            }
        });

        inferenciaButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inferenciaButton.setText("Inferencia");
        inferenciaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inferenciaButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Resultados");

        resultadosTextArea.setColumns(20);
        resultadosTextArea.setRows(5);
        jScrollPane1.setViewportView(resultadosTextArea);

        jMenu1.setText("Menu");

        limpiarLienzoButton.setText("Limpiar Lienzo");
        limpiarLienzoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarLienzoButtonActionPerformed(evt);
            }
        });
        jMenu1.add(limpiarLienzoButton);

        cargarRedButton.setText("Cargar Red");
        cargarRedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarRedButtonActionPerformed(evt);
            }
        });
        jMenu1.add(cargarRedButton);

        guardarRedButton.setText("Guardar Red");
        guardarRedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarRedButtonActionPerformed(evt);
            }
        });
        jMenu1.add(guardarRedButton);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(104, 104, 104))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(verticeOrigen))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(verticeDestino))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(addProbabilidadButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(inferenciaButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addVerticeButton))))
                        .addContainerGap(21, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)))
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addVerticeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(verticeOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(verticeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addProbabilidadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inferenciaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addVerticeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVerticeButtonActionPerformed
        
        if ( action.equals(Constantes.INICIAL) ) {
            //cuando le doy cancelar sale un exception, hay que ponerle un trycatch o algo asi 

            String VerticeTag = JOptionPane.showInputDialog("Inserte nombre del vertice: ");
            if (VerticeTag.length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Ingrese otra vez, no registro un vertice");
            } else {
                System.out.println("oh vaya");

                String VerticeTagU = VerticeTag.toUpperCase();

                Vertice v1 = RB.getVertice(VerticeTagU);

                if (v1 == null) { //para que no añada duplicados

                    actualVertice = VerticeTagU;
                    Vertice v = new Vertice(VerticeTagU);
                    RB.addVertice(VerticeTagU);
                    action = Constantes.DIBUJAR_VERTICES;
                    JOptionPane.showMessageDialog(rootPane, "Elija el lugar dando click");
                    String verticesji = RB.toString();

                    resultadosTextArea.setText(verticesji);
                }else{
                    JOptionPane.showConfirmDialog(rootPane, "El vertice ya existe");
                }

            }
        }
    }//GEN-LAST:event_addVerticeButtonActionPerformed

    private void lienzoOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoOnMouseClicked
        
        if (action.equals(Constantes.DIBUJAR_VERTICES)) {
            Graphics G1 = lienzo.getGraphics();
            G1.drawOval(evt.getX() - 8, evt.getY(), 20, 20);
            
            Vertice v = RB.getVertice(actualVertice);
            v.setPosX(evt.getX());
            v.setPosY(evt.getY());
            
            G1.drawString(actualVertice, v.getPosX(), v.getPosY() + 15);
            //G1.drawString(G.L1.getLast(), G.PosX.getLast(), G.PosY.getLast() + 15);
            action = Constantes.INICIAL;
        }
        
    }//GEN-LAST:event_lienzoOnMouseClicked

    private void addProbabilidadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProbabilidadButtonActionPerformed
        
        if ( action.equals(Constantes.INICIAL) ) {
            

            String vorigen = verticeOrigen.getText();
            String vdestino = verticeDestino.getText();

            if (vorigen.length() == 0 || vdestino.length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Ingrese correctamente los vertices");
            }else{

                String dato = JOptionPane.showInputDialog("Ingrese la probalidad");
                if (!dato.isEmpty()) {
                    System.out.println(dato + " - lo tomeee");
                    try {
                        vprobabilidad = Float.parseFloat(dato);
                        Vertice v = RB.getVertice(vorigen.toUpperCase());
                        Vertice u = RB.getVertice(vdestino.toUpperCase());
                        if (v == null || u == null ) {
                            JOptionPane.showConfirmDialog(rootPane, "Ingrese vertices válidos");
                        }else{
                            //RB.setAdyacenteProbV(u, v, vprobabilidad); //verificar
                            RB.setAdyacenteProb(u.getTag(), v.getTag(), vprobabilidad); //verificar tambien, este me funciono primero
                            //RB.setAdyacente(u, v, vprobabilidad);
                            Graphics G1 = lienzo.getGraphics();
                            int vposX = v.getPosX();
                            int vposY = v.getPosY();
                            int uposX = u.getPosX();
                            int uposY = u.getPosY();

                            //x = x + 30;
                            G1.drawLine(vposX, vposY, uposX, uposY);
                            G1.drawString(dato, (vposX + uposX)/2, (vposY + uposY )/ 2);
                            //G1.drawLine(G.PosX.get(u) + 12, G.PosY.get(u) + 12, G.PosX.get(v), G.PosY.get(v));
                            //G1.drawString(G.Listacosto(u, v).toString(), (G.PosX.get(u) + G.PosX.get(v)) / 2, (G.PosY.get(u) + G.PosY.get(v)) / 2);
                        }    
                    } catch (Exception e) {
                        System.out.println("error we");
                    }


                }
            }
        }
    }//GEN-LAST:event_addProbabilidadButtonActionPerformed

    private void darValoresHN(){
        //dar valores a los HN
        
        for (Vertice v : RB.vertices) {
            LinkedList<Adyacente> adys = v.getAdyacentes();
            float cf;
            if (RB.isHecho(v)) {
                String dato = JOptionPane.showInputDialog("¿Cuál es el valor CF de "+ v.getTag()+"?");                
                if (dato.length() == 0) {
                    cf = 0;
                }else{
                    try {
                        cf = Float.parseFloat(dato);
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(rootPane, "Ingrese el valor de un CF válido");
                        break;
                    }
                }
                Graphics G1 = lienzo.getGraphics();
                G1.drawString(dato, v.getPosX(), v.getPosY() - 10);
                
                //TODO: Para eliminar los CF's que ya use, PROBAR
                //G1.clearRect(vkey.getPosX(), vkey.getPosY() + 15, 20, 20);
                v.setCF(cf); //creo que lo actualicé
            }
        }
    }
    
    private void inferenciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inferenciaButtonActionPerformed
       
        if ( action.equals(Constantes.INICIAL) ) {
            String res;
            if (RB.verificarRed()) {
                 //Damos valores a los HNs
                darValoresHN();

                res = RB.InferenciaStr();
            }else{
                System.out.println("Inserte bien su red");
                res = "Inserte bien su red, no se realizó la inferencia";
            }
            
            resultadosTextArea.append("\n");//hago un espacio ñe
            resultadosTextArea.append(res); //lo va a poner abajito        
        }
    }//GEN-LAST:event_inferenciaButtonActionPerformed

    private void cargarRedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarRedButtonActionPerformed
        
        
        JFileChooser fileChooser = new JFileChooser();
        //System.out.println("PATH DEL PROYECTO : " + new File(".").getAbsoluteFile());
        fileChooser.setCurrentDirectory(new File(".").getAbsoluteFile());
        int returnVal = fileChooser.showOpenDialog(this); //idk
        //int returnVal = fileChooserAddDoc.showOpenDialog(fileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
             
             cargarRedArchivo(file);
             
        }
    }//GEN-LAST:event_cargarRedButtonActionPerformed

    private void guardarRedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarRedButtonActionPerformed
        
        Gson g = new Gson();
        
        String datos = g.toJson(RB);
        //String datos = g.toJson(RB.vertices);
        
        UUID uniqid = UUID.randomUUID();
        //UUID uniqid = UUID.randomUUID();
        //uniqid.toString();
        String filename = "red"+uniqid+".json";
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(datos);

            writer.close();
            
            JOptionPane.showConfirmDialog(rootPane, "Gráfica de la Red Bayesiana guardada en el directorio del proyecto! :)");
            
        } catch (IOException ex) {
            Logger.getLogger(JPRedBayesiana.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showConfirmDialog(rootPane, "Ups! Algo salió mal con el guardado del gráfico de la red :(");
        }
        
        /*
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")){
            raf.writeChars(datos); // creo
            
        } catch (Exception e) {
        }*/
    }//GEN-LAST:event_guardarRedButtonActionPerformed

    private void limpiarLienzoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarLienzoButtonActionPerformed
        
        //creo que si limpio el lienzo deberia comenzar con una red nueva (vacia) o no?
        
        lienzo.repaint();
        RB = new RedBayesiana();
        //Limpio los inputs que estaba mostrando tambien
        verticeOrigen.setText("");
        verticeDestino.setText("");
        resultadosTextArea.setText(""); //limpio los resultados tambien
        //lienzo.removeAll(); //creo
    }//GEN-LAST:event_limpiarLienzoButtonActionPerformed

    
    public void cargarRedArchivo(File file){
        String json = "";
        try {
        
            FileReader fr = new FileReader(file);
        
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            while ( (linea = br.readLine())!= null ) {                
                json+= linea;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Gson g = new Gson();
        RedParserController p = g.fromJson(json, RedParserController.class);
        System.out.println(p);
        
        
        for (Vertice vertice : p.getVertices()) {
            
            System.out.println(vertice.getTag());
            System.out.println(vertice.getCF());
            System.out.println(vertice.getPosX());
            System.out.println(vertice.getPosY());
            
            LinkedList<Adyacente> ad = vertice.getAdyacentes();
            for (int i = 0; i < ad.size(); i++) {
                System.out.println("verticeU = "+ad.get(i).getVerticeU());
                System.out.println("probabilidad = " + ad.get(i).getProbabilidad());
            }
        }
        
        System.out.println("length = " + p.getVertices().size());
        //RedBayesiana RB = new RedBayesiana();
        RB.setAdyacentes(p.getVertices());
        System.out.println(RB.toString());
        
        //ahora debo graficar la red 
        
        graficarRed();
        
        
    }
    
    public void graficarRed(){
        
        //primero debo dibujar los vertices
        
        Graphics G1 = lienzo.getGraphics();
        
        for (Vertice vertice : RB.vertices) {
            G1.drawOval(vertice.getPosX() - 8, vertice.getPosY(), 20, 20);
            G1.drawString(vertice.getTag(), vertice.getPosX(), vertice.getPosY() + 15);
        }
        
        //ahora graficar las aristas
        
        for (Vertice vertice : RB.vertices) {
            LinkedList<Adyacente> adys = vertice.getAdyacentes();
            for (Adyacente ady : adys) {
                String vs = ady.getVerticeU();
                Vertice v = RB.getVertice(vs);
                if (v != null) {
                    //existe
                    //dibujo la arista
                    G1.drawLine(vertice.getPosX(), vertice.getPosY(), v.getPosX(), v.getPosY());
                    G1.drawString(String.valueOf(ady.getProbabilidad()), (vertice.getPosX() + v.getPosX()) /2, (vertice.getPosY() + v.getPosY())/2);
                }
            }
        }

        

            //G1.drawString(G.L1.getLast(), G.PosX.getLast(), G.PosY.getLast() + 15);
//        
//        Graphics G1 = lienzo.getGraphics();
//        G1.drawString(dato, v.getPosX(), v.getPosY() - 10);
//        
//        G1.drawLine(vposX, vposY, uposX, uposY);
//        G1.drawString(dato, (vposX + uposX)/2, (vposY + uposY )/ 2);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JPRedBayesiana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPRedBayesiana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPRedBayesiana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPRedBayesiana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPRedBayesiana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProbabilidadButton;
    private javax.swing.JButton addVerticeButton;
    private javax.swing.JMenuItem cargarRedButton;
    private javax.swing.JMenuItem guardarRedButton;
    private javax.swing.JButton inferenciaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lienzo;
    private javax.swing.JMenuItem limpiarLienzoButton;
    private javax.swing.JTextArea resultadosTextArea;
    private javax.swing.JTextField verticeDestino;
    private javax.swing.JTextField verticeOrigen;
    // End of variables declaration//GEN-END:variables
}
