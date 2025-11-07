package com.uniajc.taller.modelo.dao;
import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;

public class calificacionDAO {



public class CalificacionDAO {

    // ➕ Agregar calificación
    public void agregarCalificacion(calificaciones c) {
        String sql = "INSERT INTO calificaciones (estudiante_id, componente_evaluacion_id, nota, comentarios_calificacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getEstudianteId());
            ps.setInt(2, c.getComponenteEvaluacionId());
            ps.setDouble(3, c.getNota());
            ps.setString(4, c.getComentariosCalificacion());
            ps.executeUpdate();
            System.out.println("✅ Calificación registrada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al registrar calificación: " + e.getMessage());
        }
    }

    // 📋 Listar calificaciones por estudiante
    public ObservableList<calificaciones> listarCalificacionesPorEstudiante(int estudianteId) {
        ObservableList<calificaciones> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM calificaciones WHERE estudiante_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, estudianteId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new calificaciones(
                        rs.getInt("calificacion_id"),
                        rs.getInt("estudiante_id"),
                        rs.getInt("componente_evaluacion_id"),
                        rs.getDouble("nota"),
                        rs.getString("comentarios_calificacion")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar calificaciones: " + e.getMessage());
        }
        return lista;
    }

    // ✏️ Actualizar nota
    public void actualizarNota(int calificacionId, double nuevaNota) {
        String sql = "UPDATE calificaciones SET nota=? WHERE calificacion_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, nuevaNota);
            ps.setInt(2, calificacionId);
            ps.executeUpdate();
            System.out.println("✏️ Nota actualizada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar nota: " + e.getMessage());
        }
    }

    // 🗑️ Eliminar calificación
    public void eliminarCalificacion(int id) {
        String sql = "DELETE FROM calificaciones WHERE calificacion_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Calificación eliminada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar calificación: " + e.getMessage());
        }
    }
}

public ObservableList<calificaciones> listarCalificacionesPorEstudiante(int i) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listarCalificacionesPorEstudiante'");
}

public ObservableList<calificaciones> listarCalificaciones() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listarCalificaciones'");
}

public void insertarCalificacion(calificaciones c) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insertarCalificacion'");
}

public void eliminarCalificacion(int calificacionId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'eliminarCalificacion'");
}

    
}
