package com.uniajc.taller.modelo.dao;

import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;
import java.time.LocalDate;

public class asistenciaDAO {

    // ➕ Registrar asistencia
    public void registrarAsistencia(asistencia a) {
        String sql = "INSERT INTO asistencias (estudiante_id, curso_id, fecha_clase, estado_asistencia, novedades) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, a.getEstudianteId());
            ps.setInt(2, a.getCursoId());
            ps.setDate(3, Date.valueOf(a.getFechaClase()));
            ps.setString(4, a.getEstadoAsistencia());
            ps.setString(5, a.getNovedades());
            ps.executeUpdate();

            System.out.println("✅ asistencia registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al registrar asistencia: " + e.getMessage());
        }
    }

    // 📋 Listar asistencias por curso
    public ObservableList<asistencia> listarAsistenciasPorCurso(int cursoId) {
        ObservableList<asistencia> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM asistencias WHERE curso_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cursoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new asistencia(
                        rs.getInt("asistencia_id"),
                        rs.getInt("estudiante_id"),
                        rs.getInt("curso_id"),
                        rs.getDate("fecha_clase").toLocalDate(),
                        rs.getString("estado_asistencia"),
                        rs.getString("novedades")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar asistencias: " + e.getMessage());
        }
        return lista;
    }

    // ✏️ Actualizar estado de asistencia
    public void actualizarEstado(int asistenciaId, String nuevoEstado) {
        String sql = "UPDATE asistencias SET estado_asistencia=? WHERE asistencia_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, asistenciaId);
            ps.executeUpdate();
            System.out.println("✏️ Estado de asistencia actualizado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar asistencia: " + e.getMessage());
        }
    }

    // 🗑️ Eliminar registro de asistencia
    public void eliminarAsistencia(int id) {
        String sql = "DELETE FROM asistencias WHERE asistencia_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ asistencia eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar asistencia: " + e.getMessage());
        }
    }
}

