package com.EcoMarket.cl.EcoMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class ConexionBD {
        public static void main(String[] args) {
            // Datos de conexión a Oracle
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Cambia el puerto o servicio si es necesario
            String usuario = "ECOMARKET"; // Tu usuario de Oracle
            String clave = "ECOMARKET"; // Tu contraseña de Oracle

            try {
                // Conexión a la base de datos
                Connection conn = DriverManager.getConnection(url, usuario, clave);
                System.out.println("Conexión exitosa a la base de datos Oracle.");

                // Inserción de un usuario
                String sqlUsuario = "INSERT INTO USUARIOS (id_usuario, nombre, contraseña) VALUES (?, ?, ?)";
                PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario);
                System.out.println("Usuario insertado correctamente.");

                // Inserción de un producto
                String sqlProducto = "INSERT INTO PRODUCTOS (id_producto,  nombre_producto, precio,  stock ) VALUES (?, ?, ?, ?)";
                PreparedStatement stmtProducto = conn.prepareStatement(sqlProducto);
                System.out.println("Producto insertado correctamente.");

                // Cerrar la conexión
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error de conexión o consulta: " + e.getMessage());
            }
        }
    }

