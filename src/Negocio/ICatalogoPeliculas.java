
package Negocio;

public interface ICatalogoPeliculas {
    
    String ARCHIVO = "peliculas.txt";
    
    void agregarPelicula(String nombre);
    void listarPelicula();
    void buscarPelicular(String nombre);
    void iniciarArchivo();
}
