package bl_avance2.src.A_Tony.DL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccessBD {
    private Connection conn = null;
    private Statement stmt = null;

    /** Constructor que se encarga de establecer coneccion con la base de datos**/
    public AccessBD(String URL, String user, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(URL, user, password);
    }

    /** Metodo encargado de ejecutar query's de tipo SELECT **/
    public ResultSet ejecutarQuery(String query) throws Exception {
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        return rs;
    }

    /** Metodo encargado de ejecutar query's de tipo INSERT, UPDATE, DELETE **/
    public void ejecutarSQL(String query) throws Exception {
        stmt = conn.createStatement();
        stmt.executeUpdate(query);;
    }
}
