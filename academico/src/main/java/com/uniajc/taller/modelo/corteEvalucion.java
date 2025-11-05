package com.uniajc.taller.modelo;

public class corteEvalucion {

    private int corteEvaluacionId;
    private int cursoId;
    private int periodoAcademicoId;
    private String nombreCorte;
    private double porcentaje;
    private String comentariosCorte;

    public corteEvalucion() {}

    public corteEvalucion(int corteEvaluacionId, int cursoId, int periodoAcademicoId, String nombreCorte,
                           double porcentaje, String comentariosCorte) {
        this.corteEvaluacionId = corteEvaluacionId;
        this.cursoId = cursoId;
        this.periodoAcademicoId = periodoAcademicoId;
        this.nombreCorte = nombreCorte;
        this.porcentaje = porcentaje;
        this.comentariosCorte = comentariosCorte;
    }

    // Getters y Setters
    public int getCorteEvaluacionId() { return corteEvaluacionId; }
    public void setCorteEvaluacionId(int corteEvaluacionId) { this.corteEvaluacionId = corteEvaluacionId; }
    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public int getPeriodoAcademicoId() { return periodoAcademicoId; }
    public void setPeriodoAcademicoId(int periodoAcademicoId) { this.periodoAcademicoId = periodoAcademicoId; }
    public String getNombreCorte() { return nombreCorte; }
    public void setNombreCorte(String nombreCorte) { this.nombreCorte = nombreCorte; }
    public double getPorcentaje() { return porcentaje; }
    public void setPorcentaje(double porcentaje) { this.porcentaje = porcentaje; }
    public String getComentariosCorte() { return comentariosCorte; }
    public void setComentariosCorte(String comentariosCorte) { this.comentariosCorte = comentariosCorte; }
}


