package org.example.repository;

import org.example.model.Libro;
import org.example.model.Manga;
import org.example.model.Periodico;
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
        System.out.println("\n----------Inventario de libros----------\n");
        for(Libro libro : libros){
            libro.printBasics();
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
                System.out.println("Titulo del libro: " + _libro.getNombre());
                prestamo.printPrestamoDetails();
            }
            System.out.println("\n----------  ---------- ----------\n");
        }
    }

    public void findDisponibles(){
        List<Libro> librosDisponibles = libros.stream().filter(l -> !l.getEstado()).toList();

        System.out.println("\n----------Libros disponibles----------\n");
        for(Libro libro : librosDisponibles){
            libro.printBasics();
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


    public void agregarPrestamo(){
        Libro myObject;
        Boolean myStatus;

        System.out.println("\n----------Estas a punto de hacer un prestamo----------\n");

        System.out.println("Ingresa la identificacion del libro a prestar");
        String identificacion = scan.nextLine();


        if(findLibro(identificacion) != null){
            String dui = "";
            myObject= findLibro(identificacion);
            myStatus= myObject.getEstado();
            if (myStatus){
                System.out.println("El prestamo esta activo, no puede prestarlo");
            } else {
                System.out.println("Ingrese el nombre de la persona responsable");
                String nombre = scan.nextLine();

                System.out.println("Ingrese la edad de la persona responsable");
                int edad = scan.nextInt();
                scan.nextLine();

                if (edad >= 18){System.out.println("Ingrese el DUI de la persona responsable");
                   dui = scan.nextLine();
                } else {
                    System.out.println("Se ha asignado como DUI default 00000000-0");
                   dui = "00000000-0";
                }

                System.out.println("Ingrese la fecha de inicio del prestamo");
                String fechaInicio = scan.nextLine();

                System.out.println("Ingrese la fecha de fin del prestamo");
                String fechaFin = scan.nextLine();

                Prestamo prestamo = new Prestamo(identificacion, nombre, edad, dui, fechaInicio, fechaFin);

                addPrestamo(prestamo);
                myObject.setEstado(true);
            }
        }
    }

    public Libro findLibro(String id){
        Optional<Libro> myLibro ;
        myLibro = libros.stream().filter(l -> l.getIdentificacion().equals(id)).findFirst();
        if(myLibro.isPresent()){
            Libro _libro = myLibro.get();
            return _libro;
        } else{
            System.out.println("No se encontro el libro");
            return null;
        }

    }

    public void  detallesLibro(){
        System.out.println("\n---------- Ingrese el id del libro que quiere obtener -----------\n");
        String id = scan.nextLine();

        if(findLibro(id)!= null){
            Libro myLibro = findLibro(id);
            System.out.println("----------------------------------------------------------------");
            myLibro.printDetails();
        }
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

        switch (tipo){
            case 1:
                //Manga
                System.out.println("Ingrese el estilo de dibujo");
                String estilo = scan.nextLine();

                System.out.println("Ingrese la ambientacion del libro");
                String ambientacion = scan.nextLine();

                Manga nuevoManga = new Manga(identifier, nombre, autor, anio, genero, estilo, ambientacion, false);
                addLibro(nuevoManga);
                break;
            case 2:
                //Periodico
                System.out.println("Ingrese el estilo de papel");
                String estiloPapel = scan.nextLine();

                System.out.println("Ingrese el numero de hojas del libro");
                Integer numHojas = scan.nextInt();

                Periodico nuevoPeriodico = new Periodico(identifier, nombre, autor, anio, genero, estiloPapel, numHojas, false);
                addLibro(nuevoPeriodico);
                break;
            case 3:
                //Libro convencional
                Libro nuevoLibro = new Libro(identifier, nombre, autor, anio, genero, false);
                addLibro(nuevoLibro);
                break;
            default:
                break;
        }
        System.out.println("\n----------Libro guardado exitosamente----------\n");
    }
}
