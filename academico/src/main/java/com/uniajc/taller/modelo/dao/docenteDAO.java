package com.uniajc.taller.modelo.dao;
import com.uniajc.taller.modelo.docente;
import com.uniajc.taller.modelo.Conexion;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class docenteDAO {

    public void agregarDocente(docente d) {
        String sql = "INSERT INTO docentes (nombre_docente, identificacion, tipo_identificacion, genero, correo, titulo_estudios, idiomas, certificaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, d.getNombreDocente());
            ps.setString(2, d.getIdentificacion());
            ps.setString(3, d.getTipoIdentificacion());
            ps.setString(4, d.getGenero());
            ps.setString(5, d.getCorreo());
            ps.setString(6, d.getTituloEstudios());
            ps.setString(7, d.getIdiomas());
            ps.setString(8, d.getCertificaciones());
            ps.executeUpdate();

            System.out.println("✅ Docente agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar docente: " + e.getMessage());
        }
    }

    public ObservableList<docente> listarDocentes() {
        ObservableList<docente> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM docentes";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new docente(
                        rs.getInt("docente_id"),
                        rs.getString("nombre_docente"),
                        rs.getString("identificacion"),
                        rs.getString("tipo_identificacion"),
                        rs.getString("genero"),
                        rs.getString("correo"),
                        rs.getString("titulo_estudios"),
                        rs.getString("idiomas"),
                        rs.getString("certificaciones")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar docentes: " + e.getMessage());
        }
        return lista;
    }

    public void actualizarCorreo(int docenteId, String nuevoCorreo) {
        String sql = "UPDATE docentes SET correo=? WHERE docente_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoCorreo);
            ps.setInt(2, docenteId);
            ps.executeUpdate();
            System.out.println("✏️ Correo actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar correo: " + e.getMessage());
        }
    }

    public void eliminarDocente(int docenteId) {
        String sql = "DELETE FROM docentes WHERE docente_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, docenteId);
            ps.executeUpdate();
            System.out.println("🗑️ Docente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar docente: " + e.getMessage());
        }
    }
}
