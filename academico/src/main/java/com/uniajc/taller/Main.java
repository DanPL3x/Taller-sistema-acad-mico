package com.uniajc.taller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;

public class Main {
    private static Stage primaryStage;

    public static void main(String[] args) {
        Application.launch(FxApp.class, args);
    }

    // Permite cambiar escenas desde controladores
    public static void showScene(String resourcePath, String title) throws Exception {
        URL fxml = Objects.requireNonNull(
                FxApp.class.getResource(resourcePath),
                "No se encontró el recurso FXML: " + resourcePath
        );
        FXMLLoader loader = new FXMLLoader(fxml);
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        if (title != null) primaryStage.setTitle(title);
        primaryStage.centerOnScreen();
    }

    public static class FxApp extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            try {
                primaryStage = stage;
                URL fxml = Objects.requireNonNull(
                        FxApp.class.getResource("/vista/login.fxml"),
                        "No se encontró el recurso FXML: /vista/login.fxml. Verifica src/main/resources/vista/login.fxml"
                );
                FXMLLoader loader = new FXMLLoader(fxml);
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
                primaryStage.setTitle("Sistema Control Académico - Login");
                primaryStage.centerOnScreen();
                primaryStage.show();
            } catch (Throwable ex) {
                ex.printStackTrace();
                var alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitle("Error cargando UI");
                alert.setHeaderText("Fallo al cargar login.fxml");
                alert.setContentText(ex.getClass().getSimpleName() + ": " + ex.getMessage());
                alert.showAndWait();
            }
        }
    }
}
