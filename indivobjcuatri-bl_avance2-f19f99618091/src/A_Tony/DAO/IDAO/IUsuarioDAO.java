package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Usuarios.Usuario;

import java.util.ArrayList;

public interface IUsuarioDAO {
    public boolean registrarUsuario(Usuario usuario) throws Exception;

    public ArrayList<Usuario> iniciarSesion() throws Exception;
}
