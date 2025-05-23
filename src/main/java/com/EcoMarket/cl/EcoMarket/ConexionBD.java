package com.EcoMarket.cl.EcoMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionBD {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "ECOMARKET";
        String clave = "ECOMARKET";

        Connection conn = null;
        PreparedStatement stmtUsuario = null;
        PreparedStatement stmtProducto = null;

        try {
            conn = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa a la base de datos Oracle.");

            // Insertar usuario
            String sqlUsuario = "INSERT INTO USUARIOS (id_usuario, nombre, contraseña) VALUES (?, ?, ?)";
            stmtUsuario = conn.prepareStatement(sqlUsuario);

            // Insertar producto
            String sqlProducto = "INSERT INTO PRODUCTOS (id_producto, nombre_producto, precio, stock) VALUES (?, ?, ?, ?)";
            stmtProducto = conn.prepareStatement(sqlProducto);

            conn.commit(); // Confirmar las transacciones

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback(); // Revertir en caso de error
                } catch (SQLException ex) {
                    System.out.println("Error al hacer rollback: " + ex.getMessage());
                }
            }
        } finally {
            try {
                if (stmtUsuario != null) stmtUsuario.close();
                if (stmtProducto != null) stmtProducto.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}