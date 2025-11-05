package com.uniajc.taller.modelo.dao;

import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;


public class EstudianteDAO {
    


    public void agregarEstudiante(estudiante e) {
        String sql = "INSERT INTO estudiantes (identificacion, nombre, correo_institucional, correo_personal, telefono, es_vocero, comentarios, tipo_documento, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getIdentificacion());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getCorreoInstitucional());
            ps.setString(4, e.getCorreoPersonal());
            ps.setString(5, e.getTelefono());
            ps.setBoolean(6, e.isEsVocero());
            ps.setString(7, e.getComentarios());
            ps.setString(8, e.getTipoDocumento());
            ps.setString(9, e.getGenero());
            ps.executeUpdate();

            System.out.println("✅ Estudiante agregado correctamente.");
        } catch (SQLException ex) {
            System.out.println("❌ Error al agregar estudiante: " + ex.getMessage());
        }
    }

    public ObservableList<estudiante> listarEstudiantes() {
        ObservableList<estudiante> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM estudiantes";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement( );
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new estudiante(
                        rs.getInt("estudiante_id"),
                        rs.getString("identificacion"),
                        rs.getString("nombre"),
                        rs.getString("correo_institucional"),
                        rs.getString("correo_personal"),
                        rs.getString("telefono"),
                        rs.getBoolean("es_vocero"),
                        rs.getString("comentarios"),
                        rs.getString("tipo_documento"),
                        rs.getString("genero")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar estudiantes: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarEstudiante(int id) {
        String sql = "DELETE FROM estudiantes WHERE estudiante_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Estudiante eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar estudiante: " + e.getMessage());
        }
    }
}
