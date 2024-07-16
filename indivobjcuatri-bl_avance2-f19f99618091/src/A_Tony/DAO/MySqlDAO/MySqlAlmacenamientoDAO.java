package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento.Almacenamiento;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.DAO.IDAO.IAlmacenamientoDAO;
import bl_avance2.src.A_Tony.DL.AccessBD;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlAlmacenamientoDAO implements IAlmacenamientoDAO {
    private String sqlQuery;

    public String registrarAlmacenamiento(Almacenamiento almacenamiento) throws Exception {
        try {
            sqlQuery = "INSERT INTO almacenamiento (tipo, cantidadAlmacenamiento, codigo)" +
                    " VALUES ('" + almacenamiento.getTipo() + "', '" + almacenamiento.getCantAlmacenamiento() + "', " + almacenamiento.getCodigo() + ")";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Almacenamiento registrado correctamente";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Hubo un error al registrar el componente";
        }

    }

    public ArrayList<Almacenamiento> listarAlmacenamiento() throws Exception {
        ArrayList<Almacenamiento> listaAlmacenamiento = new ArrayList<>();

        sqlQuery = "SELECT * FROM componentes " +
                "JOIN almacenamiento ON " +
                "almacenamiento.codigo = componentes.codigo";

        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while (rs.next()) {
            Almacenamiento almacenamiento = new Almacenamiento();
            almacenamiento.setCodigo(rs.getInt("codigo"));
            almacenamiento.setNombre(rs.getString("nombre"));
            almacenamiento.setPrecioElemento(rs.getInt("precio"));
            almacenamiento.setRatingElemento(rs.getInt("rating"));
            almacenamiento.setCantAlmacenamiento(rs.getString("cantidadAlmacenamiento"));
            almacenamiento.setTipo(rs.getString("tipo"));

            listaAlmacenamiento.add(almacenamiento);
        }

        return listaAlmacenamiento;
    }

    public Almacenamiento encontrarAlmacenamiento(int codigo) throws Exception {
        Almacenamiento almacenamiento = new Almacenamiento();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, almacenamiento.tipo, almacenamiento.cantidadAlmacenamiento FROM componentes" +
                " JOIN almacenamiento ON componentes.codigo = almacenamiento.codigo WHERE componentes.codigo = " + codigo;
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            almacenamiento.setCodigo(rs.getInt("CODIGO"));
            almacenamiento.setNombre(rs.getString("NOMBRE"));
            almacenamiento.setTipo(rs.getString("TIPO"));
            almacenamiento.setCantAlmacenamiento(rs.getString("cantidadAlmacenamiento"));
        }

        return almacenamiento;
    }

    public ArrayList<Almacenamiento> retornarAlmacenamiento() throws Exception {
        ArrayList<Almacenamiento> listaAlmacenamiento = new ArrayList<>();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, almacenamiento.tipo, almacenamiento.cantidadAlmacenamiento FROM componentes " +
                "JOIN almacenamiento ON componentes.codigo = almacenamiento.codigo";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            Almacenamiento almacenamiento = new Almacenamiento();
            almacenamiento.setCodigo(rs.getInt("CODIGO"));
            almacenamiento.setNombre(rs.getString("NOMBRE"));
            almacenamiento.setTipo(rs.getString("TIPO"));
            almacenamiento.setCantAlmacenamiento(rs.getString("cantidadAlmacenamiento"));

            listaAlmacenamiento.add(almacenamiento);
        }

        return listaAlmacenamiento;
    }

    public String actualizarAlmacenamiento(Almacenamiento almacenamiento) throws Exception {
        try{
            sqlQuery = "UPDATE almacenamiento SET tipo = '"+almacenamiento.getTipo()+"', cantidadAlmacenamiento = '"+almacenamiento.getCantAlmacenamiento()+"', codigo = "+almacenamiento.getCodigo()+" WHERE codigo = "+almacenamiento.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    public String eliminarAlmacenamiento(int codigo) throws Exception{
        try{
            sqlQuery = "DELETE FROM almacenamiento WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }
}
