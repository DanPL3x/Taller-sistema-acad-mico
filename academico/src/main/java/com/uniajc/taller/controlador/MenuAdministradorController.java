package com.uniajc.taller.controlador;

import com.uniajc.taller.modelo.dao.*;
import com.uniajc.taller.modelo.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;

public class MenuAdministradorController {

    @FXML
    private TableView tablaDatos;

    private docenteDAO docenteDAO = new docenteDAO();
    private EstudianteDAO estudianteDAO = new EstudianteDAO();
    private cursoDAO cursoDAO = new cursoDAO();

    @FXML
    private void abrirDocentes() {
        ObservableList<docente> lista = docenteDAO.listarDocentes();
        tablaDatos.setItems(lista);
        System.out.println("📘 Mostrando docentes");
    }

    @FXML
    private void abrirEstudiantes() {
        ObservableList<estudiante> lista = estudianteDAO.listarEstudiantes();
        tablaDatos.setItems(lista);
        System.out.println("🎓 Mostrando estudiantes");
    }

    @FXML
    private void abrirCursos() {
        ObservableList<curso> lista = cursoDAO.listarCursos();
        tablaDatos.setItems(lista);
        System.out.println("📖 Mostrando cursos");
    }
}

    
