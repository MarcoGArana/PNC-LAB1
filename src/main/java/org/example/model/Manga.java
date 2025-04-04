package org.example.model;

public class Manga extends Libro{
    private String estiloDibujo;
    private String ambientacion;

    public Manga(String identificacion, String nombre, String autor, String anio, String genero, String estiloDibujo, String ambientacion, Boolean estado) {
        super(identificacion, nombre, autor, anio, genero, estado);
        this.estiloDibujo = estiloDibujo;
        this.ambientacion = ambientacion;
    }

    public String getEstiloDibujo() {
        return estiloDibujo;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Estilo de dibujo: " + estiloDibujo);
        System.out.println("Ambientacion: " + ambientacion);
    }
}
