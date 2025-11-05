package com.uniajc.taller.modelo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static Connection connection = null;

    public static Connection getConexion() {
        if (connection != null) return connection;

        try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println(" No se encontró el archivo config.properties en resources");
                return null;
            }

            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("URL");
            String user = props.getProperty("USERNAME");
            String password = props.getProperty("PASSWORD");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Conexión exitosa a la base de datos.");
            return connection;

        } catch (Exception e) {
            System.out.println(" Error al conectar: " + e.getMessage());
        }
        return null;
    }

    public static void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println(" Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println(" Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
