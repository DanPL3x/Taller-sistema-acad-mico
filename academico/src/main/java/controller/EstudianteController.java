package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import com.uniajc.taller.modelo.DataStore;
import com.uniajc.taller.Main;

public class EstudianteController {
    @FXML private TableView tablaDatos;

    @FXML
    private void initialize() {
        tablaDatos.getItems().setAll(DataStore.getInstance().getestudiantes());
    }

    @FXML
    private void verMisCursos() {
        tablaDatos.getItems().setAll(DataStore.getInstance().getCursos());
    }

    @FXML
    private void verAsistencias() {
        var alert = new Alert(Alert.AlertType.INFORMATION, "Aquí se mostrarían las asistencias del estudiante (prototipo).");
        alert.showAndWait();
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
