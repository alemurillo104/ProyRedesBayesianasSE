
package models;

import java.util.LinkedList;

public class RedBayesiana {
    
    public LinkedList<Vertice> vertices;
    
    public RedBayesiana(){
        this.vertices = new LinkedList<>();
    }
    
    public void setAdyacentes(LinkedList<Vertice> v){
        this.vertices = v;
    }
    
    public int length(){
        return this.vertices.size();
    }
    
    public void addVertice(String tag){
        Vertice v = new Vertice(tag);
        vertices.add(v); //no admite repetidos
    }
    
    public Vertice getVertice(String tag){
        for (Vertice vertice : vertices) {
            if (vertice.getTag().compareTo(tag) == 0) {
                return vertice;
            }
        }
        return null; //
    }
    
    public void setVerticeCF(Vertice v, float dato){
        for (Vertice vertice : vertices) {
            if (vertice == v) {
                vertice.setCF(dato);
                break;
            }
        }
    }
    public void setVerticeCF(String v, float dato){
        for (Vertice vertice : vertices) {
            if (vertice.getTag().compareTo(v) == 0) {
                vertice.setCF(dato);
                break;
            }
        }
    }
    
    public void setAdyacenteProb(String v, String u, float prob){
        for (Vertice vertice : vertices) {
            if (vertice.getTag().compareTo(v) == 0) {
                //ya no es hecho nativo
                vertice.setIsHecho(false);
                
                //u ya no puede ser meta, porque esta siendo añadido como adyacente 
                
                setMeta(u, false);
                //si existe la arista adyacente y la probabilidad tambien, solo la actualizo
                int index = existeAdyacente(vertice, u);
                
                if (index == -1) { //no existe, añado uno nuevo
                    vertice.setAdyacente(u, prob);
                }else{ //existe, lo actualizo 
                    vertice.setAdyacenteI(index, prob);
                }
                
                break; //lo encontre, lo añado y bye
            }
        }
    }
    
    public int existeAdyacente(Vertice v, String u){
        
        LinkedList<Adyacente> adys = v.getAdyacentes();
        for (int i = 0; i < adys.size(); i++) {
            if (adys.get(i).getVerticeU().compareTo(u) == 0) { //el adyacent existe
                return i;
            }
        }
        return -1;
    }

    public void setMeta(String u, boolean sw){
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);
            if (v.getTag().compareTo(u) == 0) {
                v.setIsMeta(sw);
                break;
            }
        }
    }
     
    //-------------------------------------------------
    
    public float CFHecho(Vertice v){
        //Pre: es un hecho
        return v.getCF();
    }
    
    public boolean isHecho(Vertice v){ //idk
        return v.isHecho();
    }
    
    public float CF(Vertice v){
        
        if (isHecho(v)) {
            return CFHecho(v);
        }
        LinkedList<Adyacente> A = getAdyacentes(v);
        
        float ac = 0;

        for (int i = 0; i < A.size(); i++) {
            String adyString = A.get(i).getVerticeU();
            Vertice ady = getVertice(adyString);
            if (ady.getCF() == -1) {
                ady.setCF(CF(ady));
            }

            float prob = getProb(ady, v);
            float nuevo = ady.getCF() * prob;
            ac += nuevo;
        }
        v.setCF(ac);
        return ac;

    }
    
    public float CF_Fun(String m) {
        Vertice v = getVertice(m);
        return CF(v);
    }
    
    public float getProb(Vertice u, Vertice v){
        
        LinkedList<Adyacente> A = getAdyacentes(v);
        for (int i = 0; i < A.size(); i++) {
            String adyS = A.get(i).getVerticeU();
            if (adyS.compareTo(u.getTag()) == 0 ) {
                return A.get(i).getProbabilidad();
            }
        }
        return -1;
    }
 
    public LinkedList<Adyacente> getAdyacentes(Vertice v){
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == v) {
                return v.getAdyacentes();
            }
        }
        return null;//idk
    }
    
    //---------Para la inferencia--------
    
    public String Inferencia(){
        String resp = "";
        if (verificarRed()) {
            LinkedList<String> metas = getMetas();
            for (int i = 0; i < metas.size(); i++) {
              float res = CF_Fun(metas.get(i));
              
              double resporcentual = redondear2Decimales(res * 100);
              
              resp += "La Meta " + metas.get(i) +" se cumple al: " + resporcentual + "% \n";
              
              System.out.println("Resultado para " + metas.get(i) +" es: " + res);  
            }
           
        }else{
            System.out.println("Inserte bien su red");
            resp = "Inserte bien su red, no se realizó la inferencia";
        }
        
        System.out.println(resp);
        return resp;
    }
    
    public boolean verificarRed() {
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);
            LinkedList<Adyacente> adys = v.getAdyacentes();
            float ac = 0;
            
            for (Adyacente ady : adys) {
                ac += ady.getProbabilidad();
            }
            if ( !isHecho(v) && ac != 1) {
                return false;
            }
        }
        return true;
    }
    
    public double redondear2Decimales(double d){
        return Math.round(d*100.0)/100.0;
    }
    
    public void todosMenosUno(){
        for (Vertice vertice : vertices) {
            vertice.setCF(-1);
        }
    }
    
    //-------para la o las metas---------

    public LinkedList<String> getMetas(){
        LinkedList<String> metasS = new LinkedList<>();
        
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);
            if (v.isMeta()) {
                metasS.add(v.getTag());
            }
        }
        return metasS;
    }
    
    //Para imprimir la RB
    
    @Override
    public String toString(){
        String ac = "";
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);
            ac += v.getTag();
            LinkedList<Adyacente> adys = getAdyacentes(v);
            if (adys.isEmpty()) {
                ac += "[]";
            }else{
                for (int j = 0; j < adys.size(); j++) {
                    ac += " -> [" +adys.get(j).getVerticeU() + " | " + adys.get(j).getProbabilidad() + ", " ;
                }                
            }
            ac+= "\n";
        }
        
        return ac;
    }
    
}
