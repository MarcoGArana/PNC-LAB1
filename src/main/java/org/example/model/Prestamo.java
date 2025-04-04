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

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
