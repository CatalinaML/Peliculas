
package Clases;

public class Pelicula {
    //Atributos
    private String nombre;
    
    //Constructor

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
    
    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Métodos

    @Override
    public String toString() {
        return "\n-------------\n"
                + "Pelicula" + "\nnombre: " + nombre;
    }
    
}
