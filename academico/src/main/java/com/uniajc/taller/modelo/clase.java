package com.uniajc.taller.modelo;

import java.time.LocalDate;

public class clase {

    private int claseId;
    private int cursoId;
    private int numeroClase;
    private LocalDate fechaClase;
    private String temaClase;
    private String descripcionClase;
    private String comentariosClase;

    public clase() {}

    public clase(int claseId, int cursoId, int numeroClase, LocalDate fechaClase, String temaClase,
                 String descripcionClase, String comentariosClase) {
        this.claseId = claseId;
        this.cursoId = cursoId;
        this.numeroClase = numeroClase;
        this.fechaClase = fechaClase;
        this.temaClase = temaClase;
        this.descripcionClase = descripcionClase;
        this.comentariosClase = comentariosClase;
    }

    // Getters y Setters
    public int getClaseId() { return claseId; }
    public void setClaseId(int claseId) { this.claseId = claseId; }
    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public int getNumeroClase() { return numeroClase; }
    public void setNumeroClase(int numeroClase) { this.numeroClase = numeroClase; }
    public LocalDate getFechaClase() { return fechaClase; }
    public void setFechaClase(LocalDate fechaClase) { this.fechaClase = fechaClase; }
    public String getTemaClase() { return temaClase; }
    public void setTemaClase(String temaClase) { this.temaClase = temaClase; }
    public String getDescripcionClase() { return descripcionClase; }
    public void setDescripcionClase(String descripcionClase) { this.descripcionClase = descripcionClase; }
    public String getComentariosClase() { return comentariosClase; }
    public void setComentariosClase(String comentariosClase) { this.comentariosClase = comentariosClase; }
}

