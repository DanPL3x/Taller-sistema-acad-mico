package com.uniajc.taller.modelo;

public class estudiante {
    private int id;
    private String nombre;

    public estudiante(int id, String nombre) { this.id = id; this.nombre = nombre; }
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    @Override public String toString() { return id + " - " + nombre; }
    public String getIdentificacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdentificacion'");
    }
    public String getCorreoInstitucional() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCorreoInstitucional'");
    }
    public String getTelefono() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTelefono'");
    }
    public boolean isEsVocero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEsVocero'");
    }
    public String getComentarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComentarios'");
    }
    public String getTipoDocumento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipoDocumento'");
    }
    public String getGenero() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGenero'");
    }
}

