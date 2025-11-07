package com.uniajc.taller.controlador;

import com.uniajc.taller.modelo.dao.*;
import com.uniajc.taller.modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;


public class MenuDocenteController {

    @FXML
    private TableView tablaDocente;

    private claseDAO claseDAO = new claseDAO();
    private asistenciaDAO asistenciaDAO = new asistenciaDAO();
    private calificacionDAO calificacionDAO = new calificacionDAO();

    @FXML
    private void registrarClase() {
        ObservableList<clase> lista = claseDAO.listarClasesPorCurso(31); // ejemplo de curso
        tablaDocente.setItems(lista);
        System.out.println("📘 Clases mostradas/registradas");
    }

    @FXML
    private void registrarAsistencia() {
        ObservableList<asistencia> lista = asistenciaDAO.listarAsistenciasPorCurso();
        tablaDocente.setItems(lista);
        System.out.println("🧾 Asistencias mostradas");
    }

    @FXML
    private void registrarCalificacion() {
        ObservableList<calificaciones> lista = calificacionDAO.listarCalificacionesPorEstudiante(47);
        tablaDocente.setItems(lista);
        System.out.println("📝 Calificaciones mostradas");
    }
}

