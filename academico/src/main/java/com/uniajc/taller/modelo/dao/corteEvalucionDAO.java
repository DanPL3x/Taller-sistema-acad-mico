package com.uniajc.taller.modelo.dao;

import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;

public class corteEvalucionDAO {

    // ➕ Agregar corte de evaluación
    public void agregarCorte(corteEvalucion c) {
        String sql = "INSERT INTO cortes_evaluacion (curso_id, periodo_academico_id, nombre_corte, porcentaje, comentarios_corte) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getCursoId());
            ps.setInt(2, c.getPeriodoAcademicoId());
            ps.setString(3, c.getNombreCorte());
            ps.setDouble(4, c.getPorcentaje());
            ps.setString(5, c.getComentariosCorte());
            ps.executeUpdate();

            System.out.println("✅ Corte de evaluación agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar corte: " + e.getMessage());
        }
    }

    // 📋 Listar cortes por curso
    public ObservableList<corteEvalucion> listarCortesPorCurso(int cursoId) {
        ObservableList<corteEvalucion> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM cortes_evaluacion WHERE curso_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cursoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new corteEvalucion(
                        rs.getInt("corte_evaluacion_id"),
                        rs.getInt("curso_id"),
                        rs.getInt("periodo_academico_id"),
                        rs.getString("nombre_corte"),
                        rs.getDouble("porcentaje"),
                        rs.getString("comentarios_corte")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar cortes: " + e.getMessage());
        }
        return lista;
    }

    // 🗑️ Eliminar corte
    public void eliminarCorte(int id) {
        String sql = "DELETE FROM cortes_evaluacion WHERE corte_evaluacion_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Corte de evaluación eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar corte: " + e.getMessage());
        }
    }
}

    
