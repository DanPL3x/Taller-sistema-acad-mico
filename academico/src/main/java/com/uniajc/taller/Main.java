package com.uniajc.taller;

import java.sql.Connection;

import com.uniajc.taller.modelo.Conexion;

public class Main {
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();

        if (con != null) {
            System.out.println("Conexión a MySQL establecida correctamente ");
        } else {
            System.out.println("Error al conectar con la base de datos ");
        }

        Conexion.cerrarConexion();
    }
}
