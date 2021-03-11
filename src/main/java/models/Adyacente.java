
package models;


public class Adyacente {

    private String verticeU;
    private float probabilidad;
    
    public Adyacente(String u, float prob){
        this.verticeU = u;
        this.probabilidad = prob;
    }

    public String getVerticeU() {
        return verticeU;
    }

    public void setVerticeU(String verticeU) {
        this.verticeU = verticeU;
    }

    public float getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }    
}


/*

package models;


public class Adyacente {

    private Vertice verticeU;
    private float probabilidad;
    
    public Adyacente(Vertice u, float prob){
        this.verticeU = u;
        this.probabilidad = prob;
    }

    public Vertice getVerticeU() {
        return verticeU;
    }

    public void setVerticeU(Vertice verticeU) {
        this.verticeU = verticeU;
    }

    public float getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }    
}

*/