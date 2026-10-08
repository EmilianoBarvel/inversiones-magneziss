/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.magnezis.inversiones.magnezis.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.magnezis.inversiones.magnezis.config.DataBaseConnection;
import org.magnezis.inversiones.magnezis.model.Usuario;
 
public class UsuarioRepository {
 
    public boolean registrarUsuario(Usuario usuario) {
 
        String sql = """
                INSERT INTO usuario (nombre_usuario, contrasena)
                VALUES (?, ?)
                """;
 
        try (
                Connection connection =
                        DataBaseConnection.getConnection();
 
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
 
            statement.setString(
                    1,
                    usuario.getNombreUsuario()
            );
 
            statement.setString(
                    2,
                    usuario.getContrasena()
            );
 
            statement.executeUpdate();
 
            return true;
 
        } catch (SQLException e) {
 
            System.out.println(
                    "Error al registrar usuario: "
                    + e.getMessage()
            );
 
            return false;
        }
    }
 
    public boolean iniciarSesion(
            String nombreUsuario,
            String contrasena) {
 
        String sql = """
                SELECT * FROM usuario
                WHERE nombre_usuario = ?
                AND contrasena = ?
                """;
 
        try (
                Connection connection =
                        DataBaseConnection.getConnection();
 
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {
 
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);
 
            ResultSet resultSet =
                    statement.executeQuery();
 
            return resultSet.next();
 
        } catch (SQLException e) {
 
            System.out.println(
                    "Error al iniciar sesión: "
                    + e.getMessage()
            );
 
            return false;
        }
    }
}
 