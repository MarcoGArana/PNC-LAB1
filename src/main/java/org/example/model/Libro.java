package org.example.model;

public class Libro {
    //Atributos comunes
    private String identificacion;
    private String nombre;
    private String autor;
    private String anio;
    private String genero;
    private Boolean estado;


    // Atributos opcionales para manga y periodico
    private String estiloDibujo;
    private String ambientacion;
    private String estiloPapel;
    private Integer numeroHojas;

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

    public Libro(String identificacion, String nombre, String autor, String anio, String genero, Boolean estado) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.estado = estado;
    }

    public void setEstiloDibujo(String estiloDibujo) {
        this.estiloDibujo = estiloDibujo;
    }

    public void setAmbientacion(String ambientacion) {
        this.ambientacion = ambientacion;
    }

    public void setEstiloPapel(String estiloPapel) {
        this.estiloPapel = estiloPapel;
    }

    public void setNumeroHojas(Integer numeroHojas) {
        this.numeroHojas = numeroHojas;
    }

    public void setEstado(Boolean estado) {this.estado = estado;}
}

