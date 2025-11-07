package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import com.uniajc.taller.modelo.DataStore;
import com.uniajc.taller.modelo.estudiante;
import com.uniajc.taller.Main;

public class AdminController {
    @FXML private TableView tablaDatos;

    @FXML
    private void initialize() {
        // Mostrar estudiantes por defecto como ejemplo
        tablaDatos.getItems().setAll(DataStore.getInstance().getestudiantes());
    }

    @FXML
    private void verEstudiantes() {
        tablaDatos.getItems().setAll(DataStore.getInstance().getestudiantes());
    }

    @FXML
    private void verDocentes() {
        tablaDatos.getItems().setAll(DataStore.getInstance().getdocentes());
    }

    @FXML
    private void verCursos() {
        tablaDatos.getItems().setAll(DataStore.getInstance().getCursos());
    }

    @FXML
    private void cerrarSesion() {
        try {
            Main.showScene("/vista/login.fxml", "Sistema Control Académico - Login");
        } catch (Exception e) {
            e.printStackTrace();
            var alert = new Alert(Alert.AlertType.ERROR, "No se pudo cerrar sesión: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
