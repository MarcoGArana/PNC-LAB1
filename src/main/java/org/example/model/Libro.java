package org.example.model;

public class Libro {
    private String identificacion;
    private String nombre;
    private String autor;
    private String anio;
    private String genero;
    private Boolean estado;

    public Libro(String identificacion, String nombre, String autor, String anio, String genero, Boolean estado) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.estado = estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {this.estado = estado;}

    public void printDetails() {
        switch (identificacion.charAt(0)){
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

        System.out.println("Título: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("Género: " + genero);
        System.out.println("Estado: " + (estado ? "Disponible" : "No disponible"));
    }

    public void printBasics(){
        switch (identificacion.charAt(0)){
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
        System.out.println("id: " + identificacion);
        System.out.println("Titulo: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Estado: " + (!estado ? "Disponible" : "No disponible"));
    }
}

