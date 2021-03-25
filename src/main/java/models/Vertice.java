
package models;

import java.util.LinkedList;

public class Vertice {
    
    private String tag;
    private float CF;
    private boolean isHecho;
    
    private boolean isMeta;
    
    private int PosX, PosY;
    private LinkedList<Adyacente> adys;
    
    public Vertice(String tag){
        this.tag = tag;
        this.CF = -1f;
        this.isHecho = true; //no tiene adyacentes
        this.isMeta = true; //idk false
        this.adys = new LinkedList<>(); //adys vacio, lo que significa isHecho = true;
    }
    
    
    public LinkedList<Adyacente> getAdyacentes(){
        return this.adys;
    }
    
    public void setAdyacente(String u, float prob){
        Adyacente a = new Adyacente(u, prob);
        adys.add(a);// no admite repetidos
    }
    
    public void setAdyacenteI(int i, float prob){
        adys.get(i).setProbabilidad(prob);
    }
  
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public float getCF() {
        return CF;
    }

    public void setCF(float CF) {
        this.CF = CF;
    }

    public boolean isHecho() {
        return isHecho;
    }

    public void setIsHecho(boolean isHecho) {
        this.isHecho = isHecho;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int PosX) {
        this.PosX = PosX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int PosY) {
        this.PosY = PosY;
    }
    
    public boolean isMeta() {
        return isMeta;
    }

    public void setIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
    }
}
