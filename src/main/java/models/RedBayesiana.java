
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
        //probar que no admite repetidos tamb, hacer esa distincion, aqui no esta hecha aun
        vertices.add(v);
    }
    
    public Vertice getVertice(String tag){
        for (Vertice vertice : vertices) {
            if (vertice.getTag().compareTo(tag) == 0) {
                return vertice;
            }
        }
        return null; //creo, probar
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
    
    
    public void setAdyacenteProbV(Vertice v, Vertice u, float prob){
        for (Vertice vertice : vertices) {
            if (vertice == v) {
                
                //lo mismo
                vertice.setIsHecho(false);
                setMeta(u.getTag());
                
                vertice.setAdyacente(u.getTag(), prob);
                break; //lo encontre, lo añado y bye
            }
        }
    }
    
     public void setAdyacenteProb(String v, String u, float prob){
        for (Vertice vertice : vertices) {
            if (vertice.getTag().compareTo(v) == 0) {
                //ya no es hecho nativo
                vertice.setIsHecho(false);
                
                //u ya no puede ser meta, porque esta siendo añadido como adyacente 
                
                setMeta(u);
                //si existe la arista adyacente y la probabilidad tambien, solo la actualizo
                int index = existeAdyacente(vertice, u);
                
                if (index == -1) { //no existe, añado uno nuevo
                    vertice.setAdyacente(u, prob);
                }else{ //existe, lo actualizo 
                    vertice.setAdyacenteI(index, prob);
                    //vertice.getAdyacentes().get(index).setProbabilidad(prob);
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

    public void setMeta(String u){
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);
            if (v.getTag().compareTo(u) == 0) {
                v.setIsMeta(false);
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
        //if (A != null) { //ese vertice existe o algo asi
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
        //}
        //return -1;
    }
    
       private float CF_Fun(String m) {
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
    public void Inferencia(){
        if (verificarRed()) {
            LinkedList<String> metas = getMetas();
            for (int i = 0; i < metas.size(); i++) {
              float res = CF_Fun(metas.get(i));
              System.out.println("Resultado para " + metas.get(i) +" es: " + res);  
            }
            /*float res = CF_Fun("M");
            System.out.println("Resultado es: " + res);*/
        }else{
            System.out.println("Inserte bien su red");
        }
    }
    
    public String InferenciaStr(){
        String resp = "";
        if (verificarRed()) {
            LinkedList<String> metas = getMetas();
            for (int i = 0; i < metas.size(); i++) {
              float res = CF_Fun(metas.get(i));
              double d = res * 100;
              double res2 = Math.round(d*100.0)/100.0;
              
              resp += "La Meta " + metas.get(i) +" se cumple al: " + res2 + "% \n";
              //resp += "La Meta " + metas.get(i) +" se cumple al: " + (res * 100) + "% \n";
              //resp += "Resultado para " + metas.get(i) +" es: " + ( Math.round(res * 100)) + "% \n";
              System.out.println("Resultado para " + metas.get(i) +" es: " + res);  
            }
            /*float res = CF_Fun("M");
            System.out.println("Resultado es: " + res);*/
        }else{
            System.out.println("Inserte bien su red");
            resp = "Inserte bien su red, no se realizó la inferencia";
        }
        return resp;
    }
    
     public void Inferencia2(){
        if (verificarRed()) {
          
            float res = CF_Fun("M");
            System.out.println("Resultado es: " + res);
        }else{
            System.out.println("Inserte bien su red");
        }
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
    
    public void todosMenosUno(){
        for (Vertice vertice : vertices) {
            vertice.setCF(-1);
        }
    }
    
    //-----------------------------------

    
    //-------para la o las metas---------

    public LinkedList<String> getMetas(){
        //LinkedList<Vertice> metas = new LinkedList<>();
        LinkedList<String> metasS = new LinkedList<>();
        
        for (int i = 0; i < vertices.size(); i++) {
            Vertice v = vertices.get(i);
            if (v.isMeta()) {
                //metas.add(v);
                metasS.add(v.getTag());
            }
        }
        
        return metasS;
 
    }
    
    //-----------------------------------
    
    
    
    //Para printear
    
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
