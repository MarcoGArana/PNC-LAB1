package org.example.repository;

import org.example.model.Libro;
import org.example.model.Prestamo;

import java.util.*;

public class LibroRepository {
    private List<Libro> libros = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private static final Scanner scan = new Scanner(System.in);

    private String generarIdentificacion(int tipo){
        String id = "";
        Random random = new Random();

        switch(tipo){

            case 1:
                // ID para LC
                id = "MG";
                break;
            case 2:
                //ID para manga
                id = "PR";
                break;
            case 3:
                //ID para periodico
                id = "LC";
                break;

        }

        String digitos = String.format("%04d", new Random().nextInt(10000));

        char c1 = (char) ('A' + random.nextInt(26));
        char c2 = (char) ('A' + random.nextInt(26));

        id += "-" + digitos + "-" + c1 + c2;

        return id;
    }

    public void findAll(){
        char identifier;
        String estado;

        System.out.println("\n----------Inventario de libros----------\n");
        for(Libro libro : libros){
            identifier = libro.getIdentificacion().charAt(0);
            estado = (libro.getEstado()) ? "Prestado" : "Disponible";

            switch (identifier){
                case 'L':
                    System.out.println("Tipo: Convencional");
                    break;
                case 'M':
                    System.out.println("Tipo: Manga");
                    break;
                case 'P':
                    System.out.println("Tipo: Periodico");
                    break;
                default:
                    break;
            }

            System.out.println("id: " + libro.getIdentificacion());
            System.out.println("Titulo: " + libro.getNombre());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Estado actual: " + estado);
            System.out.println("\n----------  ---------- ----------\n");
        }
    }

    public void findPrestados(){
        Optional<Libro> libroPrestado;
        System.out.println("\n----------Libros prestados----------\n");
        for(Prestamo prestamo : prestamos){
            libroPrestado =
                    libros.stream()
                            .filter(l -> Objects.equals(l.getIdentificacion(), prestamo.getIdentificacion()))
                            .findFirst();
            if(libroPrestado.isPresent()){
                Libro _libro = libroPrestado.get();
                System.out.println("Identificador: " + prestamo.getIdentificacion());
                System.out.println("Titulo del libro: " + _libro.getNombre());
                System.out.println("Nombre del prestatario: " + prestamo.getNombrePersona());
                System.out.println("Fecha de inicio: " + prestamo.getFechaInicio());
                System.out.println("Fecha de fin: " + prestamo.getFechaFin());
                System.out.println("Identificacion del prestatario: " + prestamo.getDUI());
            }

            System.out.println("\n----------  ---------- ----------\n");
        }
    }

    public void findDisponibles(){
        char identifier;
        List<Libro> librosDisponibles = libros.stream().filter(l -> !l.getEstado()).toList();

        System.out.println("\n----------Libros disponibles----------\n");
        for(Libro libro : librosDisponibles){
            identifier = libro.getIdentificacion().charAt(0);

            switch (identifier){
                case 'L':
                    System.out.println("Tipo: Convencional");
                    break;
                case 'M':
                    System.out.println("Tipo: Manga");
                    break;
                case 'P':
                    System.out.println("Tipo: Periodico");
                    break;
                default:
                    break;
            }

            System.out.println("Titulo: " + libro.getNombre());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("\n----------  ---------- ----------\n");
        }
    }

    //Para agregar el libro a la lista
    public void addLibro(Libro libro){
        libros.add(libro);
    }

    public void addPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    //Para crear el libro y guardarlo en la lista
    public void agregarLibro(){
        System.out.println("\n----------Agregar libro----------\n");

        System.out.println("Que tipo de libro desea agregar?");
        System.out.println("1. Manga, 2. Periodico, 3. Convencional\n");
        int tipo = scan.nextInt();
        scan.nextLine();

        System.out.println("Ingrese el nombre del libro");
        String nombre = scan.nextLine();

        System.out.println("Ingrese el autor del libro");
        String autor = scan.nextLine();

        System.out.println("Ingrese el anio del libro");
        String anio = scan.nextLine();

        System.out.println("Ingrese el genero del libro");
        String genero = scan.nextLine();

        String identifier = generarIdentificacion(tipo);

        Libro nuevoLibro = new Libro(identifier, nombre, autor, anio, genero, false);

        switch (tipo){
            case 1:
                //Manga
                System.out.println("Ingrese el estilo de dibujo");
                String estilo = scan.nextLine();

                System.out.println("Ingrese la ambientacion del libro");
                String ambientacion = scan.nextLine();

                nuevoLibro.setEstiloDibujo(estilo);
                nuevoLibro.setAmbientacion(ambientacion);
                break;
            case 2:
                //Periodico
                System.out.println("Ingrese el estilo de papel");
                String estiloPapel = scan.nextLine();

                System.out.println("Ingrese el numero de hojas del libro");
                Integer numHojas = scan.nextInt();

                nuevoLibro.setEstiloPapel(estiloPapel);
                nuevoLibro.setNumeroHojas(numHojas);
                break;
            default:
                break;
        }
        addLibro(nuevoLibro);
        System.out.println("\n----------Libro guardado exitosamente----------\n");
    }
}
