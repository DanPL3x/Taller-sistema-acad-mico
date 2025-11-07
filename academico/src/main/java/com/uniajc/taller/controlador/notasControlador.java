package com.uniajc.taller.controlador;

import com.uniajc.taller.modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import com.uniajc.taller.modelo.dao.*;

public class notasControlador {

    @FXML private TextField txtEstudianteId;
    @FXML private TextField txtComponenteId;
    @FXML private TextField txtNota;
    @FXML private TableView<calificaciones> tablaNotas;
    @FXML private TableColumn<calificaciones, Integer> colId;
    @FXML private TableColumn<calificaciones, Integer> colEstudiante;
    @FXML private TableColumn<calificaciones, Integer> colComponente;
    @FXML private TableColumn<calificaciones, Double> colNota;

    private calificacionDAO calificacionDAO = new calificacionDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("calificacion_id"));
        colEstudiante.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estudiante_id"));
        colComponente.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("componente_evaluacion_id"));
        colNota.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nota"));
        cargarNotas();
    }

    private void cargarNotas() {
        ObservableList<calificaciones> lista = calificacionDAO.listarCalificaciones();
        tablaNotas.setItems(lista);
    }

    @FXML
    private void registrarNota() {
        try {
            int estId = Integer.parseInt(txtEstudianteId.getText());
            int compId = Integer.parseInt(txtComponenteId.getText());
            double nota = Double.parseDouble(txtNota.getText());

            calificaciones c = new calificaciones();
            c.setEstudianteId(estId);
            c.setComponente_evaluacion_id(compId);
            c.setNota(nota);

            calificacionDAO.insertarCalificacion(c);
            cargarNotas();
        } catch (Exception e) {
            System.out.println("⚠️ Error al registrar nota: " + e.getMessage());
        }
    }

    @FXML
    private void eliminarNota() {
        calificaciones seleccion = tablaNotas.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            calificacionDAO.eliminarCalificacion(seleccion.getCalificacionId());
            cargarNotas();
        }
    }
}

