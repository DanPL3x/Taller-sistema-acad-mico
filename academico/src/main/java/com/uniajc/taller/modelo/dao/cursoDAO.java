package com.uniajc.taller.modelo.dao;

import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;


public class cursoDAO {

    public void agregarCurso(curso c) {
        String sql = "INSERT INTO cursos (nombre_curso, periodo_academico_id, docente_id, descripcion_curso) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getNombreCurso());
            ps.setInt(2, c.getPeriodoAcademicoId());
            ps.setInt(3, c.getDocenteId());
            ps.setString(4, c.getDescripcionCurso());
            ps.executeUpdate();

            System.out.println("✅ curso agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar curso: " + e.getMessage());
        }
    }

    public ObservableList<curso> listarCursos() {
        ObservableList<curso> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM cursos";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new curso(
                        rs.getInt("curso_id"),
                        rs.getString("nombre_curso"),
                        rs.getInt("periodo_academico_id"),
                        rs.getInt("docente_id"),
                        rs.getString("descripcion_curso")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar cursos: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarCurso(int id) {
        String sql = "DELETE FROM cursos WHERE curso_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ curso eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar curso: " + e.getMessage());
        }
    }
}

