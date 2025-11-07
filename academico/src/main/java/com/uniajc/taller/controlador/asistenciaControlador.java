package com.uniajc.taller.controlador;

import com.uniajc.taller.controlador.*;
import com. uniajc.taller.modelo.dao.*;
import com.uniajc.taller.modelo.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;

public class asistenciaControlador {


    @FXML private TextField txtEstudianteId;
    @FXML private TextField txtCursoId;
    @FXML private ComboBox<String> cbEstado;
    @FXML private TableView<asistencia> tablaAsistencias;
    @FXML private TableColumn<asistencia, Integer> colId;
    @FXML private TableColumn<asistencia, Integer> colEstudiante;
    @FXML private TableColumn<asistencia, Integer> colCurso;
    @FXML private TableColumn<asistencia, String> colEstado;

    private asistenciaDAO asistenciaDAO = new asistenciaDAO();

    @FXML
    public void initialize() {
        cbEstado.getItems().addAll("presente", "ausente", "tardanza");
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("asistencia_id"));
        colEstudiante.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estudiante_id"));
        colCurso.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("curso_id"));
        colEstado.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("estado_asistencia"));
        cargarAsistencias();
    }

    private void cargarAsistencias() {
        ObservableList<asistencia> lista = asistenciaDAO.listarAsistenciasPorCurso();
        tablaAsistencias.setItems(lista);
    }

    @FXML
    private void registrarAsistencia() {
        try {
            int estId = Integer.parseInt(txtEstudianteId.getText());
            int curId = Integer.parseInt(txtCursoId.getText());
            String estado = cbEstado.getValue();
            if (estado == null) return;

            asistencia a = new asistencia();
            a.setEstudianteId(estId);
            a.setCursoId(curId);
            a.setEstadoAsistencia(estado);

            asistenciaDAO.insertarAsistencia(a);
            cargarAsistencias();
        } catch (Exception e) {
            System.out.println("⚠️ Error al registrar asistencia: " + e.getMessage());
        }
    }

    @FXML
    private void eliminarAsistencia() {
        asistencia seleccion = tablaAsistencias.getSelectionModel().getSelectedItem();
        if (seleccion != null) {
            asistenciaDAO.eliminarAsistencia(seleccion.getAsistenciaId());
            cargarAsistencias();
        }
    }
}


