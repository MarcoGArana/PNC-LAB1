package org.example.model;

public class Prestamo {
    private String identificacion;
    private String nombrePersona;
    private Integer edad;
    private String DUI;
    private String fechaInicio;
    private String fechaFin;

    public Prestamo(String identificacion, String nombrePersona, Integer edad, String DUI, String fechaInicio, String fechaFin) {
        this.identificacion = identificacion;
        this.nombrePersona = nombrePersona;
        this.edad = edad;
        this.DUI = DUI;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getDUI() {
        return DUI;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void printPrestamoDetails(){
        System.out.println("Identificador: " + identificacion);
        System.out.println("Nombre del prestatario: " + nombrePersona);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + fechaFin);
        System.out.println("Identificacion del prestatario: " + DUI);
    }
}
