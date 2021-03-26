
package views;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import models.Adyacente;
import models.Constantes;
import models.RedBayesiana;
import models.Vertice;


public class JPRedBayesiana extends javax.swing.JFrame {
    
    private RedBayesiana RB;
    
    private String action;
    private String actualVertice;
    private String vOrigen, vDestino;
    private float vprobabilidad;
    private boolean archivoExiste;
    private String nombreArchivo;
    private int vsizeX, vsizeY;
    
    public JPRedBayesiana() {
        initComponents();
        RB = new RedBayesiana();
        action = Constantes.INICIAL;
        
        archivoExiste = false;
        nombreArchivo = "";
        vsizeX = Constantes.VERTICE_SIZE_X;
        vsizeY = Constantes.VERTICE_SIZE_Y;
        
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
        probabilidadText = new javax.swing.JTextField();
        probLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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

        probLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        probLabel.setText("Probabilidad:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Añadir / Editar Arista Probabilidad");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addVerticeButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(verticeOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(probLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(verticeDestino)
                                                        .addComponent(probabilidadText))))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addProbabilidadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inferenciaButton)))
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
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(verticeOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(verticeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(probabilidadText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(probLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addProbabilidadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inferenciaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                System.out.println("Añadiendo vertice...");

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
            G1.drawOval(evt.getX() - (vsizeX /2) - 2, evt.getY(), vsizeX, vsizeY);
            
            Vertice v = RB.getVertice(actualVertice);
            v.setPosX(evt.getX());
            v.setPosY(evt.getY());
            
            G1.drawString(actualVertice, v.getPosX() - 5, v.getPosY()+(vsizeY - 5));
            
            action = Constantes.INICIAL;
        }
        
    }//GEN-LAST:event_lienzoOnMouseClicked

    private void addProbabilidadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProbabilidadButtonActionPerformed
        
        if ( action.equals(Constantes.INICIAL) ) {
            
            String vorigen = verticeOrigen.getText();
            String vdestino = verticeDestino.getText();
            String vprob = probabilidadText.getText();

            if (vorigen.length() == 0 || vdestino.length() == 0) {
                JOptionPane.showConfirmDialog(rootPane, "Ingrese correctamente los vertices");
            }else if(vprob.length() == 0){
                JOptionPane.showConfirmDialog(rootPane, "Ingrese la probabilidad!!!");
            }else{

                String dato = vprob;
                //String dato = JOptionPane.showInputDialog("Ingrese la probalidad");
                if (!dato.isEmpty()) {
                    System.out.println(dato + " - lo tomeee");
                    try {
                        float prob = Float.parseFloat(dato);
                        
                        if (prob >= 0 && prob <= 1) {
                            
                            vprobabilidad = prob;
                            Vertice v = RB.getVertice(vorigen.toUpperCase());
                            Vertice u = RB.getVertice(vdestino.toUpperCase());
                            if (v == null || u == null ) {
                                
                                if (RB.vertices.isEmpty()) {
                                    JOptionPane.showConfirmDialog(rootPane, "Ingrese vertices, la Red Bayesiana esta vacia");
                                }else{
                                    JOptionPane.showConfirmDialog(rootPane, "Ingrese vertices válidos");
                                }
                            }else{

                                //añade adyacents no duplicados, solo actualiza el valor 
                                RB.setAdyacenteProb(u.getTag(), v.getTag(), vprobabilidad); //verificar tambien, este me funciono primero

                                Graphics G1 = lienzo.getGraphics();

                                int vposX = v.getPosX(); int vposY = v.getPosY();
                                int uposX = u.getPosX(); int uposY = u.getPosY();

                                //si existe la probabilidad es actualizarla nomas

                                G1.setColor(this.getBackground());
                                G1.fillRect((vposX + uposX)/2, ((vposY + uposY )/2) - 10, 20, 12);

                                //esto es para borrar la arista, seria en otro boton
                                //G1.fillRect(vposX, vposY, uposX - vposX,12);

                                G1.setColor(Color.black);
                                G1.drawLine(vposX, vposY, uposX, uposY);
                                G1.drawString(dato, (vposX + uposX)/2, (vposY + uposY )/ 2);

                            }    
                        }else{
                            JOptionPane.showConfirmDialog(rootPane, "Ingrese una probabilidad válida (De 0 a 1)");
                        }
                    } catch (Exception e) {
                        System.out.println("Error en la probabilidad");
                        JOptionPane.showConfirmDialog(rootPane, "Ingrese una probabilidad válida (De 0 a 1)");
                    }
                }
            }
        }
        
        verticeOrigen.setText("");
        verticeDestino.setText("");
        probabilidadText.setText("");
    }//GEN-LAST:event_addProbabilidadButtonActionPerformed

  
    
    private void inferenciaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inferenciaButtonActionPerformed
       
        if ( action.equals(Constantes.INICIAL) ) {
            
            resultadosTextArea.setText("");
            
            RB.todosMenosUno(); //poner todos los CFs en -1
            
            String res = "";
            if (RB.verificarRed()) {
                 
                boolean b = darValoresHN();
                
                if (b) { //le dimos valores correctos a los CFs
                    res = RB.Inferencia();
                }
                
                resultadosTextArea.append("\n");//hago un espacio ñe
                resultadosTextArea.append(res); //lo va a poner abajito   
                
            }else{
                System.out.println("Inserte bien su red");
                res = "Inserte bien su red, no se realizó la inferencia";
                JOptionPane.showConfirmDialog(rootPane, res);
            }
        }
    }//GEN-LAST:event_inferenciaButtonActionPerformed

      private boolean darValoresHN(){
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
                        
                        //EL CF le pudo haber dado un valor mayor
                        if (cf < 0 || cf > 1) {
                            
                        //}
                        //if (cf >= 0 && cf <= 1) { //en rango 0 - 1
                            
                        //}else{
                            JOptionPane.showConfirmDialog(rootPane, "Ingrese un valor de CF válido entre 0 - 1");
                            return false;
                        }
                        
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(rootPane, "Ingrese el valor de un CF válido");
                        return false;
                        //break;
                    }
                }
                Graphics G1 = lienzo.getGraphics();
                
                //borrar lo anterior
                
                G1.setColor(this.getBackground());
                G1.fillRect(v.getPosX()- 10, v.getPosY() - 20, 20, 12);
                G1.setColor(Color.BLACK);
                G1.drawString(String.valueOf(cf), v.getPosX() - 10, v.getPosY() - 10); //dato
                
                v.setCF(cf); //actualizado
            }
        }
        return true;
    }
      
    private void cargarRedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarRedButtonActionPerformed
        
        //limpiar el lienzo
        limpiarLienzoButtonActionPerformed(evt);
        
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setCurrentDirectory(new File(".").getAbsoluteFile()); //proyecto path
        int returnVal = fileChooser.showOpenDialog(this); //idk
    
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            cargarRedArchivo(file);
        }
    }//GEN-LAST:event_cargarRedButtonActionPerformed

     public void cargarRedArchivo(File file){
        String json = "";
        try {
        
            FileReader fr = new FileReader(file);
    
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            while ( (linea = br.readLine())!= null ) {                
                json+= linea;
            }
            archivoExiste = true;
            nombreArchivo = file.getName(); // creo probar
            System.out.println("nombre del archivo = "+nombreArchivo);
            
            //Cargar la red del archivo json
            Gson g = new Gson();
            
            RB = g.fromJson(json, RedBayesiana.class); 

            System.out.println(RB.toString());

            //ahora debo graficar la red 
            graficarRed();
        
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(rootPane, "Error. No se encontro el archivo, probar de nuevo.");
        } catch (IOException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(rootPane, "Error, probar de nuevo.");
        }
    }
    
    public void graficarRed(){
        
        //primero debo dibujar los vertices
        
        Graphics G1 = lienzo.getGraphics();
        
        for (Vertice vertice : RB.vertices) {
            G1.drawOval(vertice.getPosX() - (vsizeX /2) - 2 , vertice.getPosY(), vsizeX, vsizeY); 
            G1.drawString(vertice.getTag(), vertice.getPosX() - 5, vertice.getPosY() +(vsizeY - 5));
            
        }
        
        //ahora graficar las aristas
        
        for (Vertice vertice : RB.vertices) {
            LinkedList<Adyacente> adys = vertice.getAdyacentes();
            for (Adyacente ady : adys) {
                String vs = ady.getVerticeU();
                Vertice v = RB.getVertice(vs);
                if (v != null) { //existe
                    
                    //dibujo la arista
                    G1.drawLine(vertice.getPosX(), vertice.getPosY(), v.getPosX(), v.getPosY());
                    G1.drawString(String.valueOf(ady.getProbabilidad()), (vertice.getPosX() + v.getPosX()) /2, (vertice.getPosY() + v.getPosY())/2);
                }
            }
        }
    }
    
    
    private void guardarRedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarRedButtonActionPerformed
        
        try {
            Gson g = new Gson();

            String datos = g.toJson(RB); //parsear la RED a un json en un string
            
            String filename = "";

            if (archivoExiste) {
                filename = nombreArchivo;
            }else{
                String archivoName = JOptionPane.showInputDialog("Nombre del archivo:" );
                
                if (archivoName.isEmpty()) {
                    UUID uniqid = UUID.randomUUID();
                    filename = "red"+uniqid+".json";
                }else{
                    filename = archivoName+".json";
                }
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                writer.write(datos);

                writer.close();

                JOptionPane.showConfirmDialog(rootPane, "Gráfica de la Red Bayesiana guardada en el directorio del proyecto! :)");

                if (!archivoExiste) {
                    archivoExiste = true;
                    nombreArchivo = filename;
                }
                
                //Aqui creo que deberia limpiar el lienzo automaticamente
                limpiarLienzoButtonActionPerformed(evt);

            } catch (IOException ex) {
                Logger.getLogger(JPRedBayesiana.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showConfirmDialog(rootPane, "Ups! Algo salió mal con el guardado del gráfico de la red :(");
            }
            
        } catch (Exception e) {
            System.out.println("le dio a cancelar");
        }
    }//GEN-LAST:event_guardarRedButtonActionPerformed

    private void limpiarLienzoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarLienzoButtonActionPerformed
        
        //Limpiar lienzo =  RB vacia
        
        lienzo.repaint();
        RB = new RedBayesiana();
        //Limpio los inputs que estaba mostrando tambien
        verticeOrigen.setText("");
        verticeDestino.setText("");
        resultadosTextArea.setText(""); //limpio los resultados tambien
        probabilidadText.setText("");
        
        //no tengo archivo para cargar o actualizarlo
        archivoExiste = false;
        nombreArchivo = "";
        
    }//GEN-LAST:event_limpiarLienzoButtonActionPerformed

    
   

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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lienzo;
    private javax.swing.JMenuItem limpiarLienzoButton;
    private javax.swing.JLabel probLabel;
    private javax.swing.JTextField probabilidadText;
    private javax.swing.JTextArea resultadosTextArea;
    private javax.swing.JTextField verticeDestino;
    private javax.swing.JTextField verticeOrigen;
    // End of variables declaration//GEN-END:variables
}
