package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import com.uniajc.taller.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class LoginController {
    @FXML
    private TextField txtUsuario;

    @FXML
    private ComboBox<String> cbRol;

    // Properties cargadas desde src/main/resources/config.properties
    private static final Properties DB_PROPS = new Properties();
    static {
        try (InputStream in = LoginController.class.getResourceAsStream("/config.properties")) {
            if (in != null) {
                DB_PROPS.load(in);
            } else {
                System.err.println("Warning: config.properties no encontrado en resources.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        // Poblar roles por defecto para pruebas
        cbRol.getItems().addAll("Estudiante", "Docente", "Administrador");
        cbRol.getSelectionModel().selectFirst();
    }

    // Este nombre debe coincidir exactamente con onAction="#ingresarSistema" del FXML
    @FXML
    private void ingresarSistema(ActionEvent event) {
        String usuario = txtUsuario.getText() == null ? "" : txtUsuario.getText().trim();
        String rol = cbRol.getValue();

        if (usuario.isEmpty()) {
            showError("Debe ingresar el usuario (identificación o correo).");
            return;
        }
        if (rol == null || rol.isEmpty()) {
            showError("Seleccione un rol.");
            return;
        }

        try {
            boolean ok = validarUsuarioEnBD(usuario, rol);
            if (!ok) {
                showError("Usuario no encontrado para el rol seleccionado.");
                return;
            }

            switch (rol) {
                case "Administrador":
                    Main.showScene("/vista/admin.fxml", "Administrador - Sistema Académico");
                    break;
                case "Docente":
                    Main.showScene("/vista/docente.fxml", "Docente - Sistema Académico");
                    break;
                case "Estudiante":
                    Main.showScene("/vista/estudiante.fxml", "Estudiante - Sistema Académico");
                    break;
                default:
                    showError("Rol no soportado: " + rol);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Error al validar usuario: " + ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
    }

    private boolean validarUsuarioEnBD(String usuario, String rol) throws SQLException {
        String dbUrl = DB_PROPS.getProperty("URL");
        String dbUser = DB_PROPS.getProperty("USERNAME");
        String dbPass = DB_PROPS.getProperty("PASSWORD");

        if (dbUrl == null || dbUser == null) {
            throw new SQLException("Propiedades de BD incompletas. Verifica config.properties.");
        }

        // Si tu driver no se carga automáticamente, descomenta la siguiente línea:
        // try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException e) { /* manejar */ }

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            PreparedStatement ps;
            ResultSet rs;

            if ("Docente".equalsIgnoreCase(rol) || "Administrador".equalsIgnoreCase(rol)) {
                // Buscamos en la tabla docentes por identificacion o correo
                ps = conn.prepareStatement("SELECT docente_id FROM docentes WHERE identificacion = ? OR correo = ? LIMIT 1");
                ps.setString(1, usuario);
                ps.setString(2, usuario);
                rs = ps.executeQuery();
                boolean found = rs.next();
                rs.close();
                ps.close();
                return found;
            } else if ("Estudiante".equalsIgnoreCase(rol)) {
                // Buscamos en la tabla estudiantes por identificacion o correos
                ps = conn.prepareStatement("SELECT estudiante_id FROM estudiantes WHERE identificacion = ? OR correo_institucional = ? OR correo_personal = ? LIMIT 1");
                ps.setString(1, usuario);
                ps.setString(2, usuario);
                ps.setString(3, usuario);
                rs = ps.executeQuery();
                boolean found = rs.next();
                rs.close();
                ps.close();
                return found;
            } else {
                return false;
            }
        }
    }

    private void showError(String msg) {
        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
