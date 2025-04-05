package org.example;

import org.example.model.Libro;
import org.example.model.Manga;
import org.example.model.Periodico;
import org.example.model.Prestamo;
import org.example.repository.LibroRepository;

import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        LibroRepository libroRepository = new LibroRepository();




        Libro libro1 = new Libro("LC", "Cien Años de Soledad", "Gabriel García Márquez", "1967", "Realismo mágico", true);
        libroRepository.addLibro(libro1);

        Manga manga1 = new Manga("MG", "Naruto", "Masashi Kishimoto", "1999", "Shonen", "Manga japonés", "Mundo ninja", false);
        libroRepository.addLibro(manga1);

        Periodico periodico1 = new Periodico("PR", "The New York Times", "Varios", "2024", "Noticias","Papel reciclado", 50, true);
        libroRepository.addLibro(periodico1);

        Prestamo prestamo = new Prestamo("PR", "JOSE MIGUEL", 18, "00037822", "22/03/25", "25/05/25");
        libroRepository.addPrestamo(prestamo);
        Prestamo prestamo2 = new Prestamo("LC", "JOSE MIGUEL", 20, "00037825", "22/07/28", "25/05/29");
        libroRepository.addPrestamo(prestamo2);



        do {
            System.out.println("\n----------Menu de la biblioteca----------\n");
            System.out.println("1. Agregar un libro al inventario");
            System.out.println("2. Mostrar todos los libros en el inventario");
            System.out.println("3. Mostrar los libros en estado de prestamo");
            System.out.println("4. Mostrar los libros disponibles");
            System.out.println("5. Realizar un prestamo");
            System.out.println("6. Mostrar los detalles de un libro");
            System.out.println("7. Salir del sistema\n");
            System.out.print("Opcion: ");
            try {
                option = Integer.parseInt(scan.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Usted no ha ingresado un valor entero");
                option=0;
            }

            switch (option){
                case 1:
                    libroRepository.agregarLibro();
                    break;
                case 2:
                    libroRepository.findAll();
                    break;
                case 3:
                    libroRepository.findPrestados();
                    break;
                case 4:
                    libroRepository.findDisponibles();
                    break;
                case 5:
                    libroRepository.agregarPrestamo();
                    break;
                case 6:
                    libroRepository.detallesLibro();
                    break;
                case 7:
                    System.out.println("\nSaliendo del sistema...\n");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        } while(option != 7);

        scan.close();
    }
}