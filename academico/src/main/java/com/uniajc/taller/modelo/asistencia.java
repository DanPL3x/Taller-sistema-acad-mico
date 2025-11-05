package com.uniajc.taller.modelo;
import java.time.LocalDate;

public class asistencia {

    private int asistenciaId;
    private int estudianteId;
    private int cursoId;
    private LocalDate fechaClase;
    private String estadoAsistencia;
    private String novedades;

    public asistencia() {}

    public asistencia(int asistenciaId, int estudianteId, int cursoId,
                      LocalDate fechaClase, String estadoAsistencia, String novedades) {
        this.asistenciaId = asistenciaId;
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.fechaClase = fechaClase;
        this.estadoAsistencia = estadoAsistencia;
        this.novedades = novedades;
    }

    // Getters y Setters
    public int getAsistenciaId() { return asistenciaId; }
    public void setAsistenciaId(int asistenciaId) { this.asistenciaId = asistenciaId; }
    public int getEstudianteId() { return estudianteId; }
    public void setEstudianteId(int estudianteId) { this.estudianteId = estudianteId; }
    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public LocalDate getFechaClase() { return fechaClase; }
    public void setFechaClase(LocalDate fechaClase) { this.fechaClase = fechaClase; }
    public String getEstadoAsistencia() { return estadoAsistencia; }
    public void setEstadoAsistencia(String estadoAsistencia) { this.estadoAsistencia = estadoAsistencia; }
    public String getNovedades() { return novedades; }
    public void setNovedades(String novedades) { this.novedades = novedades; }
}

