package org.example.model;

public class Periodico extends Libro{
    private String estiloPapel;
    private Integer numeroHojas;

    public Periodico(String identificacion, String nombre, String autor, String anio, String genero, String estiloPapel, Integer numeroHojas, Boolean estado) {
        super(identificacion, nombre, autor, anio, genero, estado);
        this.estiloPapel = estiloPapel;
        this.numeroHojas = numeroHojas;
    }

    public String getEstiloPapel() {
        return estiloPapel;
    }

    public Integer getNumeroHojas() {
        return numeroHojas;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Estilo de papel: " + estiloPapel);
        System.out.println("Numero de hojas: " + numeroHojas);
    }
}
