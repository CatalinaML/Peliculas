package Negocio;

import Clases.Pelicula;
import Datos.*;
import Excepciones.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogoPeliculas implements ICatalogoPeliculas {

    //Atributos
    private final IAccesoDatos datos;//se usa la interfaz para despues ver que implementacion se usa
    //Constructor

    public CatalogoPeliculas() {
        this.datos = new AccesoDatos();
    }

    @Override
    public void agregarPelicula(String nombre) {
        try {
            Pelicula pelicula = new Pelicula(nombre);
            boolean anexar = false; //si no existe el archivo se sobreescribe
            anexar = this.datos.existe(ARCHIVO); //si existe se anexa
            this.datos.escribir(pelicula, ARCHIVO, anexar);
            System.out.println("Pelicula agregada con exito");
        } catch (AccesoDatosEx ex) {
            ex.getMessage();
        }
    }

    @Override
    public void listarPelicula() {
        try {
            var peliculas = this.datos.listar(ARCHIVO);

            for (var pelicula : peliculas) {
                System.out.println(pelicula.toString());
            }
        } catch (LecturaDatosEx ex) {
            ex.getMessage();
        }
    }

    @Override
    public void buscarPelicular(String nombre) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(ARCHIVO, nombre);
            System.out.println("resultado = " + resultado);
        } catch (LecturaDatosEx ex) {
            ex.getMessage();
        }
    }

    @Override
    public void iniciarArchivo() {
        try {
            if (this.datos.existe(ARCHIVO)) {
                this.datos.borrar(ARCHIVO);
                this.datos.crear(ARCHIVO);
                System.out.println("Archivo creado con exito");
            } else {
                this.datos.crear(ARCHIVO);
                System.out.println("Archivo creado con exito");
            }
        } catch (AccesoDatosEx ex) {
            ex.getMessage();
        }
    }

}
