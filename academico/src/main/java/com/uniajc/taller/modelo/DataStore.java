package com.uniajc.taller.modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStore {
    private static DataStore INSTANCE = new DataStore();

    private ObservableList<estudiante> estudiantes = FXCollections.observableArrayList();
    private ObservableList<docente> docentes = FXCollections.observableArrayList();
    private ObservableList<curso> cursos = FXCollections.observableArrayList();

    private DataStore() {
        // Datos de ejemplo
        estudiantes.addAll(
                new estudiante(1, "María Pérez"),
                new estudiante(2, "Juan González")
        );
        docentes.addAll(
                new docente(1, "Dr. Carlos Ruiz"),
                new docente(2, "Ing. Ana López")
        );
        cursos.addAll(
                new curso(1, "Matemáticas I", 1),
                new curso(2, "Programación", 2)
        );
    }

    public static DataStore getInstance() {
        return INSTANCE;
    }

    public ObservableList<estudiante> getestudiantes() { return estudiantes; }
    public ObservableList<docente> getdocentes() { return docentes; }
    public ObservableList<curso> getCursos() { return cursos; }
}
