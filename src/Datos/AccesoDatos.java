package Datos;

import Clases.Pelicula;
import Excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatos implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));

            String linea = null;
            linea = entrada.readLine();

            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);

                linea = entrada.readLine();
            }

            entrada.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Archivo no encontrado: " + ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));

            salida.println(pelicula.getNombre());

            salida.close();
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Excepcion de escritura");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));

            String linea = null;
            linea = entrada.readLine();
            
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }

            entrada.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Archivo no encontrado para leer");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Excepcion de lectura");
        }

        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();

        } catch (IOException ex) {
            throw new AccesoDatosEx("Excepcion de acceso");
        } 
    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if(archivo.exists()){
            archivo.delete();
        }
    }

}
