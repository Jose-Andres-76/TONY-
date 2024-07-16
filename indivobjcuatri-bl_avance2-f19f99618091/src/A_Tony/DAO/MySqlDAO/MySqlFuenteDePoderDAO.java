package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder.FuenteDePoder;
import bl_avance2.src.A_Tony.DAO.IDAO.IFuenteDePoderDAO;
import bl_avance2.src.A_Tony.DL.AccessBD;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlFuenteDePoderDAO implements IFuenteDePoderDAO {
    private String sqlQuery;

    public String registrarFuenteDePoder(FuenteDePoder fuenteDePoder) throws Exception {
        try {
            sqlQuery = "INSERT INTO fuentepoder (horasDuracion, codigo) " +
                    "VALUES (" + fuenteDePoder.getHorasDeDuracion() + ", " + fuenteDePoder.getCodigo() +")";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Fuente de poder registrada correctamente";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Hubo un error al registrar el componente";
        }

    }

    public ArrayList<FuenteDePoder> listarFuenteDePoder() throws Exception {
        ArrayList<FuenteDePoder> listaFuenteDePoder = new ArrayList<>();

        sqlQuery = "SELECT * FROM componentes " +
                "JOIN fuentepoder ON " +
                "componentes.codigo = fuentepoder.codigo";

        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){

            FuenteDePoder fuenteDePoder = new FuenteDePoder();
            fuenteDePoder.setCodigo(rs.getInt("CODIGO"));
            fuenteDePoder.setHorasDeDuracion(rs.getInt("horasDuracion"));
            fuenteDePoder.setNombre(rs.getString("nombre"));
            fuenteDePoder.setPrecioElemento(rs.getInt("precio"));
            fuenteDePoder.setRatingElemento(rs.getInt("rating"));

            listaFuenteDePoder.add(fuenteDePoder);
        }

        return listaFuenteDePoder;
    }

    public FuenteDePoder encontrarFuenteDePoder(int codigo) throws Exception {
        FuenteDePoder fuenteDePoder = new FuenteDePoder();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, fuentepoder.horasDuracion FROM componentes JOIN " +
                "fuentepoder ON componentes.codigo = fuentepoder.codigo WHERE componentes.codigo = " + codigo;
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            fuenteDePoder.setCodigo(rs.getInt("CODIGO"));
            fuenteDePoder.setNombre(rs.getString("NOMBRE"));
            fuenteDePoder.setHorasDeDuracion(rs.getInt("horasDuracion"));
        }

        return fuenteDePoder;
    }

    public ArrayList<FuenteDePoder> retornarFuenteDePoder() throws Exception {
        ArrayList<FuenteDePoder> listaFuenteDePoder = new ArrayList<>();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, fuentepoder.horasDuracion FROM componentes" +
                " JOIN fuentepoder ON componentes.codigo = fuentepoder.codigo";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            FuenteDePoder fuenteDePoder = new FuenteDePoder();
            fuenteDePoder.setCodigo(rs.getInt("CODIGO"));
            fuenteDePoder.setNombre(rs.getString("NOMBRE"));
            fuenteDePoder.setHorasDeDuracion(rs.getInt("horasDuracion"));

            listaFuenteDePoder.add(fuenteDePoder);
        }

        return listaFuenteDePoder;
    }

    public String actualizarFuenteDePoder(FuenteDePoder fuenteDePoder) throws Exception {
        try{
            sqlQuery = "UPDATE fuentepoder SET horasDuracion = '"+fuenteDePoder.getHorasDeDuracion()+"', codigo = "+fuenteDePoder.getCodigo()+" WHERE codigo = "+fuenteDePoder.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    public String eliminarFuenteDePoder(int codigo) throws Exception{
        try{
            sqlQuery = "DELETE FROM fuentepoder WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }
}
