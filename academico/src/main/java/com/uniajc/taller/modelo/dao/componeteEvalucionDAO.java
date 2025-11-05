package com.uniajc.taller.modelo.dao;
import com.uniajc.taller.modelo.*;
import java.sql.*;
import javafx.collections.*;

public class componeteEvalucionDAO {


public class ComponenteEvaluacionDAO {

    // ➕ Agregar componente
    public void agregarComponente(componetesEvalucion c) {
        String sql = "INSERT INTO componentes_evaluacion (corte_evaluacion_id, nombre_componente, porcentaje) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getCorteEvaluacionId());
            ps.setString(2, c.getNombreComponente());
            ps.setDouble(3, c.getPorcentaje());
            ps.executeUpdate();

            System.out.println("✅ Componente agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar componente: " + e.getMessage());
        }
    }

    // 📋 Listar componentes por corte
    public ObservableList<componetesEvalucion> listarComponentesPorCorte(int corteId) {
        ObservableList<componetesEvalucion> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM componentes_evaluacion WHERE corte_evaluacion_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, corteId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new componetesEvalucion(
                        rs.getInt("componente_evaluacion_id"),
                        rs.getInt("corte_evaluacion_id"),
                        rs.getString("nombre_componente"),
                        rs.getDouble("porcentaje")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar componentes: " + e.getMessage());
        }
        return lista;
    }

    // 🗑️ Eliminar componente
    public void eliminarComponente(int id) {
        String sql = "DELETE FROM componentes_evaluacion WHERE componente_evaluacion_id=?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Componente eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar componente: " + e.getMessage());
        }
    }
}

    
}
