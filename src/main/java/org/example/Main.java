package org.example;

import org.example.model.Libro;
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

        Libro manga1 = new Libro("MG", "Naruto", "Masashi Kishimoto", "1999", "Shonen", false);
        manga1.setEstiloDibujo("Manga japonés");
        manga1.setAmbientacion("Mundo ninja");
        libroRepository.addLibro(manga1);

        Libro periodico1 = new Libro("PR", "The New York Times", "Varios", "2024", "Noticias", true);
        periodico1.setEstiloPapel("Papel reciclado");
        periodico1.setNumeroHojas(50);
        libroRepository.addLibro(periodico1);

        Prestamo prestamo = new Prestamo("PR", "JOSE MIGUEL", 18, "00037822", "22/03/25", "25/05/25");
        libroRepository.addPrestamo(prestamo);
        Prestamo prestamo2 = new Prestamo("LC", "JOSE MIGUEL", 20, "00037825", "22/07/28", "25/05/29");
        libroRepository.addPrestamo(prestamo2);



        do {
            option = scan.nextInt();

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
                    //TODO salir
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        } while(option != 7);

        scan.close();
    }
}