package com.uniajc.taller.controlador ;
import com.uniajc.taller.modelo.dao.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import com.uniajc.taller.modelo.*;

public class cursoControlador {

    @FXML private TextField txtNombreCurso;
    @FXML private TextField txtDescripcion;
    @FXML private TableView<curso> tablaCursos;
    @FXML private TableColumn<curso, Integer> colId;
    @FXML private TableColumn<curso, String> colNombre;
    @FXML private TableColumn<curso, String> colDescripcion;

    private cursoDAO cursoDAO = new cursoDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("curso_id"));
        colNombre.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nombre_curso"));
        colDescripcion.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("descripcion_curso"));

        cargarCursos();
    }

    private void cargarCursos() {
        ObservableList<curso> lista = cursoDAO.listarCursos();
        tablaCursos.setItems(lista);
    }

    @FXML
    private void agregarCurso() {
        String nombre = txtNombreCurso.getText();
        String desc = txtDescripcion.getText();
        if (!nombre.isEmpty()) {
            curso c = new curso(0, desc, 0);
            c.setNombreCurso(nombre);
            c.setDescripcionCurso(desc);
            cursoDAO.insertarCurso(c);
            cargarCursos();
            txtNombreCurso.clear();
            txtDescripcion.clear();
        }
    }

    @FXML
    private void eliminarCurso() {
        curso seleccionado = tablaCursos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            cursoDAO.eliminarCurso(seleccionado.getId());
            cargarCursos();
        }
    }

    @FXML
    private void actualizarCurso() {
        curso seleccionado = tablaCursos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombreCurso(txtNombreCurso.getText());
            seleccionado.setDescripcionCurso(txtDescripcion.getText());
            cursoDAO.agregarCurso(seleccionado);
            cargarCursos();
        }
    }
}
