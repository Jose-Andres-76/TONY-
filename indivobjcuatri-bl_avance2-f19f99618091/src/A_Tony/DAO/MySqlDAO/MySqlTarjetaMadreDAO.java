package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre.TarjetaMadre;
import bl_avance2.src.A_Tony.DAO.IDAO.ITarjetaMadreDAO;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlTarjetaMadreDAO implements ITarjetaMadreDAO {
    private String sqlQuery;

    public String registrarTarjetaMadre(TarjetaMadre tarjetaMadre) throws Exception {
        try {
            sqlQuery = "INSERT INTO tarjetamadre (socket, codigo)" +
                    " VALUES ('" + tarjetaMadre.getSocket() + "', " + tarjetaMadre.getCodigo()+ ")";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "TarjetaMadre registrado correctamente";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Hubo un error al registrar el componente";
        }

    }

    public ArrayList<TarjetaMadre> listarTarjetaMadre() throws Exception {
        ArrayList<TarjetaMadre> listaTarjetaMadre = new ArrayList<>();

        sqlQuery = "SELECT * FROM componentes " +
                    "JOIN tarjetamadre ON " +
                    "componentes.codigo = tarjetamadre.codigo";

        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){

            TarjetaMadre tarjetaMadre = new TarjetaMadre();
            tarjetaMadre.setCodigo(rs.getInt("codigo"));
            tarjetaMadre.setSocket(rs.getString("socket"));
            tarjetaMadre.setNombre(rs.getString("nombre"));
            tarjetaMadre.setPrecioElemento(rs.getInt("precio"));
            tarjetaMadre.setRatingElemento(rs.getInt("rating"));

            listaTarjetaMadre.add(tarjetaMadre);
        }
        return listaTarjetaMadre;
    }

    public TarjetaMadre encontrarTarjetaMadre(int codigo) throws Exception {
        TarjetaMadre tarjetaMadre = new TarjetaMadre();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, tarjetamadre.socket FROM componentes " +
                "JOIN tarjetamadre ON componentes.codigo = tarjetamadre.codigo WHERE componentes.codigo =" + codigo;
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            tarjetaMadre.setCodigo(rs.getInt("CODIGO"));
            tarjetaMadre.setNombre(rs.getString("NOMBRE"));
            tarjetaMadre.setSocket(rs.getString("socket"));
        }

        return tarjetaMadre;
    }

    public ArrayList<TarjetaMadre> retornarTarjetaMadre() throws Exception {
        ArrayList<TarjetaMadre> listaTarjetaMadre = new ArrayList<>();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, tarjetamadre.socket FROM componentes " +
                "JOIN tarjetamadre ON componentes.codigo = tarjetamadre.codigo";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            TarjetaMadre tarjetaMadre = new TarjetaMadre();
            tarjetaMadre.setCodigo(rs.getInt("CODIGO"));
            tarjetaMadre.setNombre(rs.getString("NOMBRE"));
            tarjetaMadre.setSocket(rs.getString("socket"));
            listaTarjetaMadre.add(tarjetaMadre);
        }

        return listaTarjetaMadre;
    }

    public String actualizarTarjetaMadre(TarjetaMadre tarjetaMadre) throws Exception {
        try{
            sqlQuery = "UPDATE tarjetamadre SET socket = '"+tarjetaMadre.getSocket()+"', codigo = "+tarjetaMadre.getCodigo()+" WHERE codigo = "+tarjetaMadre.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    public String eliminarTarjetaMadre(int codigo) throws Exception{
        try{
            sqlQuery = "DELETE FROM tarjetamadre WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }
}

