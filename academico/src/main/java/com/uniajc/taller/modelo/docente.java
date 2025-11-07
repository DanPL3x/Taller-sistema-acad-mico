package com.uniajc.taller.modelo;

public class docente {
    private int id;
    private String nombre;

    public docente(int id, String nombre) { this.id = id; this.nombre = nombre; }
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    @Override public String toString() { return id + " - " + nombre; }
    public String getIdentificacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdentificacion'");
    }
    public String getGenero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGenero'");
    }
    public String getCorreo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCorreo'");
    }
    public String getTituloEstudios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTituloEstudios'");
    }
    public String getCertificaciones() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCertificaciones'");
    }
}


