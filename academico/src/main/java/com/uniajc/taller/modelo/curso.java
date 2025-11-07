package com.uniajc.taller.modelo;

public class curso {
    private int id;
    private String nombre;
    private int docenteId;

    public curso(int id, String nombre, int docenteId) {
        this.id = id; this.nombre = nombre; this.docenteId = docenteId;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getDocenteId() { return docenteId; }
    @Override public String toString() { return id + " - " + nombre; }

    public void setNombreCurso(String nombre2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombreCurso'");
    }

    public void setDescripcionCurso(String desc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDescripcionCurso'");
    }

    public int getPeriodoAcademicoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPeriodoAcademicoId'");
    }

    public String getDescripcionCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescripcionCurso'");
    }
}
