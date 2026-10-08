/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.magnezis.inversiones.magnezis.controller;

import java.io.IOException;
 
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.magnezis.inversiones.magnezis.service.UsuarioService;
  
public class LoginController {
 
    @FXML
    private TextField txtUsuario;
 
    @FXML
    private PasswordField txtContrasena;
 
    private UsuarioService usuarioService;
 
    public LoginController() {
        usuarioService = new UsuarioService();
    }
 
    @FXML
    private void iniciarSesion() {
 
        String usuario = txtUsuario.getText();
 
        String contrasena = txtContrasena.getText();
 
        boolean resultado =
                usuarioService.iniciarSesion(
                        usuario,
                        contrasena
                );
 
        if (resultado) {
 
            mostrarMensaje(
                    Alert.AlertType.INFORMATION,
                    "Login",
                    "Inicio de sesión correcto"
            );
 
        } else {
 
            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Login",
                    "Usuario o contraseña incorrectos"
            );
        }
    }
 
    @FXML
    private void irRegistro() {
 
        try {
 
            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/view/registro-view.fxml"
                            )
                    );
 
            Parent root = loader.load();
 
            Stage stage =
                    (Stage) txtUsuario
                            .getScene()
                            .getWindow();
 
            stage.setScene(new Scene(root));
 
            stage.show();
 
        } catch (IOException e) {
 
            e.printStackTrace();
        }
    }
 
    private void mostrarMensaje(
            Alert.AlertType tipo,
            String titulo,
            String mensaje) {
 
        Alert alert = new Alert(tipo);
 
        alert.setTitle(titulo);
 
        alert.setHeaderText(null);
 
        alert.setContentText(mensaje);
 
        alert.showAndWait();
    }
}
