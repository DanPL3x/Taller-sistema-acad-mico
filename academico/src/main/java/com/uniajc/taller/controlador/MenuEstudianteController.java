package com.uniajc.taller.controlador;
import com.uniajc.taller.modelo.dao.*;
import com.uniajc.taller.modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;

public class MenuEstudianteController {

    @FXML
    private TableView tablaEstudiante;

    private calificacionDAO calificacionDAO = new calificacionDAO();
    private asistenciaDAO asistenciaDAO = new asistenciaDAO();

    @FXML
    private void verCalificaciones() {
        ObservableList<calificaciones> lista = calificacionDAO.listarCalificacionesPorEstudiante(47);
        tablaEstudiante.setItems(lista);
        System.out.println("📊 Calificaciones del estudiante mostradas");
    }

    @FXML
    private void verAsistencias() {
        ObservableList<asistencia> lista = asistenciaDAO.listarAsistenciasPorCurso(31);
        tablaEstudiante.setItems(lista);
        System.out.println("📋 Asistencias del estudiante mostradas");
    }
}

