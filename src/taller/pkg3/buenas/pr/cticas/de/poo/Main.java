package taller.pkg3.buenas.pr.cticas.de.poo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Luis mendoza
 * @author Jaime Hoyos
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Songs> myPlayLists = new ArrayList();
        MainLibrary myLista = new MainLibrary();

        int option;
        boolean exit = false;

        System.out.println("==== Bienvenido a la aplicación Sofka Music ====");
        System.out.println("Aplicación donde podrá ver las ultima canciones lanzadas.");

        while (!exit)
        {
            System.out.println("Menu:\n1. Mostrar todas las canciones de la biblioteca. \n2. Mostrar Canciones por género.");
            System.out.println("3. Mostrar Canciones por año de lanzamiento. \n4. Ordenar canciones por duración");
            System.out.println("5. Ordenar canciones por fecha. \n6. Para salir de la aplicación.");

            try
            {
                myPlayLists.addAll(myLista.defaultPlaylist());

                System.out.println("¿Seleccione una opción?");
                option = scanner.nextInt();

                switch (option)
                {

                    case 1:
                        myLista.showSongList(myPlayLists);
                        break;

                    case 2:
                        for (Songs SongGenre : myLista.filterSonGen("salsa", myPlayLists))
                        {
                            System.out.println(SongGenre);
                        }
                        break;

                    case 3:
                        for (Object SongYear : myLista.filterSonYear(2017))
                        {
                            System.out.println(SongYear);
                        }
                        break;

                    case 4:
                        myLista.SortDuration(myPlayLists);
                        break;

                    case 5:
                        myLista.SortDate(myPlayLists);
                        break;

                    case 6:
                        System.out.println("¡Ha salido de la aplicación, vuelva pronto!");
                        exit = true;
                        break;

                    default:

                        System.out.println("Las opciones son entre 1 y 6");

                }

            } catch (InputMismatchException e)
            {
                System.out.println("Debe ingresar un número");
                scanner.next();
            }

        }

    }
}
