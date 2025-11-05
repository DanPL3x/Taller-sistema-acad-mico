package com.uniajc.taller.modelo.dao;

import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;
import java.time.LocalDate;

public class claseDAO {
    public void agregarClase(clase c) {
        String sql = "INSERT INTO clases (curso_id, numero_clase, fecha_clase, tema_clase, descripcion_clase, comentarios_clase) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getCursoId());
            ps.setInt(2, c.getNumeroClase());
            ps.setDate(3, Date.valueOf(c.getFechaClase()));
            ps.setString(4, c.getTemaClase());
            ps.setString(5, c.getDescripcionClase());
            ps.setString(6, c.getComentariosClase());
            ps.executeUpdate();

            System.out.println("✅ Clase registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al registrar clase: " + e.getMessage());
        }
    }

    public ObservableList<clase> listarClasesPorCurso(int cursoId) {
        ObservableList<clase> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM clases WHERE curso_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cursoId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new clase(
                        rs.getInt("clase_id"),
                        rs.getInt("curso_id"),
                        rs.getInt("numero_clase"),
                        rs.getDate("fecha_clase").toLocalDate(),
                        rs.getString("tema_clase"),
                        rs.getString("descripcion_clase"),
                        rs.getString("comentarios_clase")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar clases: " + e.getMessage());
        }
        return lista;
    }
}


