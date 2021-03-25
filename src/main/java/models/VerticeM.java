
package models;

public class VerticeM {
    
    private String tag;
    private float CF;
    private boolean isHecho;
    
    private boolean isMeta;
    
    private int PosX, PosY;
    private Adyacente[] adys;
    
    public VerticeM(String tag){
        this.tag = tag;
        this.CF = -1f;
        this.isHecho = true; //no tiene adyacentes
        this.isMeta = true; //idk false
        this.adys = new Adyacente[]{};
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

    public boolean isIsHecho() {
        return isHecho;
    }

    public void setIsHecho(boolean isHecho) {
        this.isHecho = isHecho;
    }

    public boolean isIsMeta() {
        return isMeta;
    }

    public void setIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
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

    public Adyacente[] getAdys() {
        return adys;
    }

    public void setAdys(Adyacente[] adys) {
        this.adys = adys;
    }
      
}
