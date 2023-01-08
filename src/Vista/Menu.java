package Vista;

import Negocio.*;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        ICatalogoPeliculas catalogo = new CatalogoPeliculas();

        while (opcion != 0) {
            System.out.println("----MENU----\n");
            System.out.println("1.- Iniciar catalogo peliculas\n"
                    + "2.- Agregar película\n"
                    + "3.- Listar Películas\n"
                    + "4.- Buscar Película\n"
                    + "0.- Salir");

            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    String nombrePelicula = null;
                    System.out.println("\nIngrese el nombre de la pelicula");
                    nombrePelicula = teclado.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPelicula();
                    break;
                case 4:
                    String buscar = null;
                    System.out.println("\nIngrese el nombre de la pelicula a buscar");
                    buscar = teclado.nextLine();
                    catalogo.buscarPelicular(buscar);
                    break;
                case 0:
                    System.out.println("\n---Hasta pronto---");
                    break;
                default:
                    System.out.println("\nOpcion invalida");
            }
        }
    }
}
