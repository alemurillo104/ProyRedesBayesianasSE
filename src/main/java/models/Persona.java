
package models;


public class Persona {
    
    private String nombre;
    private int edad;
    private String[] aficiones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String[] getAficiones() {
        return aficiones;
    }

    public void setAficiones(String[] aficiones) {
        this.aficiones = aficiones;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", aficiones=" + aficiones + '}';
    }
    
    
}
