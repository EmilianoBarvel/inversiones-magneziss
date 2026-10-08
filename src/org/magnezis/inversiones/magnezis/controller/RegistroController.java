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

public class RegistroController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContrasena;

    private UsuarioService usuarioService;

    public RegistroController() {
        usuarioService = new UsuarioService();
    }

    @FXML
    private void registrarUsuario() {

        String usuario = txtUsuario.getText();

        String contrasena = txtContrasena.getText();

        boolean resultado
                = usuarioService.registrarUsuario(
                        usuario,
                        contrasena
                );

        if (resultado) {

            mostrarMensaje(
                    Alert.AlertType.INFORMATION,
                    "Registro",
                    "Usuario registrado correctamente"
            );

            volverLogin();

        } else {

            mostrarMensaje(
                    Alert.AlertType.ERROR,
                    "Registro",
                    "No se pudo registrar el usuario"
            );
        }
    }

    @FXML
    private void volverLogin() {

        try {

            FXMLLoader loader
                    = new FXMLLoader(
                            getClass().getResource(
                                    "/view/login-view.fxml"
                            )
                    );

            Parent root = loader.load();

            Stage stage
                    = (Stage) txtUsuario
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
