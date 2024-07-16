package bl_avance2.src.A_Tony.BL.Entidades.Usuarios;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private String rol;

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = "usuario";
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario {" +
                "Nombre de usuario: " + getNombreUsuario() +
                "Rol: " + getRol() + "}";
    }
}
