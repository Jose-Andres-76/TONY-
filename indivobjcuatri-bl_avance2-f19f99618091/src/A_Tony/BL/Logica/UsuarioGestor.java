package bl_avance2.src.A_Tony.BL.Logica;

import bl_avance2.src.A_Tony.DAO.MySqlDAO.MySqlUsuarioDAO;
import bl_avance2.src.A_Tony.BL.Entidades.Usuarios.Usuario;
import bl_avance2.src.A_Tony.DL.Data;

import java.util.ArrayList;

public class UsuarioGestor {
    private MySqlUsuarioDAO usuarioDAO;

    public UsuarioGestor() {
        this.usuarioDAO = new MySqlUsuarioDAO();
    }

    public boolean registrarUsuario(String nombreUsuario, String password) throws Exception {
        Usuario usuario = new Usuario(nombreUsuario, password);
        return usuarioDAO.registrarUsuario(usuario);
    }

    public ArrayList<Usuario> iniciarSesion() throws Exception {
        return usuarioDAO.iniciarSesion();
    }
}
