package com.uniajc.taller.modelo;

public class calificaciones {

    private int calificacionId;
    private int estudianteId;
    private int componenteEvaluacionId;
    private double nota;
    private String comentariosCalificacion;

    public calificaciones() {}

    public calificaciones(int calificacionId, int estudianteId, int componenteEvaluacionId,
                        double nota, String comentariosCalificacion) {
        this.calificacionId = calificacionId;
        this.estudianteId = estudianteId;
        this.componenteEvaluacionId = componenteEvaluacionId;
        this.nota = nota;
        this.comentariosCalificacion = comentariosCalificacion;
    }

    // Getters y Setters
    public int getCalificacionId() { return calificacionId; }
    public void setCalificacionId(int calificacionId) { this.calificacionId = calificacionId; }
    public int getEstudianteId() { return estudianteId; }
    public void setEstudianteId(int estudianteId) { this.estudianteId = estudianteId; }
    public int getComponenteEvaluacionId() { return componenteEvaluacionId; }
    public void setComponenteEvaluacionId(int componenteEvaluacionId) { this.componenteEvaluacionId = componenteEvaluacionId; }
    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }
    public String getComentariosCalificacion() { return comentariosCalificacion; }
    public void setComentariosCalificacion(String comentariosCalificacion) { this.comentariosCalificacion = comentariosCalificacion; }

    public void setComponente_evaluacion_id(int compId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setComponente_evaluacion_id'");
    }
}
