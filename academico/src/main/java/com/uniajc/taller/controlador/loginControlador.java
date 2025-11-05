package com.uniajc.taller.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class loginControlador {

    @FXML
    private TextField txtUsuario;
    @FXML
    private ComboBox<String> cbRol;

    @FXML
    public void initialize() {
        cbRol.getItems().addAll("Administrador", "Docente", "Estudiante");
    }

    @FXML
    private void ingresarSistema() {
        String rol = cbRol.getValue();

        if (rol == null) {
            mostrarAlerta("Seleccione un rol antes de ingresar.");
            return;
        }

        try {
            Stage stageActual = (Stage) txtUsuario.getScene().getWindow();
            FXMLLoader loader;

            switch (rol) {
                case "Administrador":
                    loader = new FXMLLoader(getClass().getResource("/vista/menuAdministrador.fxml"));
                    break;
                case "Docente":
                    loader = new FXMLLoader(getClass().getResource("/vista/menuDocente.fxml"));
                    break;
                case "Estudiante":
                    loader = new FXMLLoader(getClass().getResource("/vista/menuEstudiante.fxml"));
                    break;
                default:
                    mostrarAlerta("Rol no reconocido.");
                    return;
            }

            Scene scene = new Scene(loader.load());
            Stage nuevoStage = new Stage();
            nuevoStage.setScene(scene);
            nuevoStage.setTitle("Panel " + rol);
            nuevoStage.show();
            stageActual.close();

        } catch (Exception e) {
            mostrarAlerta("Error al cargar la vista: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

