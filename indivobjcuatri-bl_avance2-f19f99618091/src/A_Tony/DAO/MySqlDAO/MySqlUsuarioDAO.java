package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.DAO.IDAO.IUsuarioDAO;
import bl_avance2.src.A_Tony.BL.Entidades.Usuarios.Usuario;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlUsuarioDAO implements IUsuarioDAO {
    private String sqlQuery;
    @Override
    public boolean registrarUsuario(Usuario usuario) throws Exception {
        try {
            sqlQuery = "INSERT INTO usuarios (nombreUsuario, password, rol)" +
                        " VALUES ('" + usuario.getNombreUsuario() + "', '" + usuario.getPassword() + "', '" + usuario.getRol() +"')";
            Conector.getConector().ejecutarSQL(sqlQuery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<Usuario> iniciarSesion() throws Exception {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            sqlQuery = "SELECT * FROM usuarios";
            ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

            while (rs.next()) {
                Usuario usuario = new Usuario("", "");
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRol(rs.getString("rol"));

                usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No funciona");
        }
        return usuarios;
    }
}
