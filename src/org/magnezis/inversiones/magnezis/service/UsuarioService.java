package org.magnezis.inversiones.magnezis.service;

import org.magnezis.inversiones.magnezis.model.Usuario;
import org.magnezis.inversiones.magnezis.repository.UsuarioRepository;

public class UsuarioService {
 
   private UsuarioRepository usuarioRepository;
 
    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }
 
    public boolean registrarUsuario(
            String nombreUsuario,
            String contrasena) {
 
        Usuario usuario = new Usuario(
                nombreUsuario,
                contrasena
        );
 
        return usuarioRepository.registrarUsuario(usuario);
    }
 
    public boolean iniciarSesion(
            String nombreUsuario,
            String contrasena) {
 
        return usuarioRepository.iniciarSesion(
                nombreUsuario,
                contrasena
        );
    } 

}

