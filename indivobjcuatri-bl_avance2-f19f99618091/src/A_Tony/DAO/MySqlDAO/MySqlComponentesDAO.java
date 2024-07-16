package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;
import bl_avance2.src.A_Tony.DAO.IDAO.IComponentesDAO;
import bl_avance2.src.A_Tony.DL.AccessBD;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlComponentesDAO implements IComponentesDAO {
    private String sqlQuery;

    public String registrarComponentes(Componentes componentes) throws Exception {
        try {
            sqlQuery = "INSERT INTO componentes (codigo, nombre, precio, rating)" +
                    "VALUES (" + componentes.getCodigo() + ", '" + componentes.getNombre() + "', " + componentes.getPrecioElemento() + "," + componentes.getRatingElemento() + ")";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente registrado correctamente";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Hubo un error al registrar el componente";
        }

    }

    public ArrayList<Componentes> listarComponentes() throws Exception {
        ArrayList<Componentes> listaComponentes = new ArrayList<>();
        sqlQuery = "SELECT * FROM componentes";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            Componentes componentes = new Componentes();
            componentes.setNombre(rs.getString("nombre"));
            componentes.setCodigo(rs.getInt("codigo"));
            componentes.setPrecioElemento(rs.getInt("precio"));
            componentes.setRatingElemento(rs.getInt("rating"));

            listaComponentes.add(componentes);
        }

        return listaComponentes;
    }

    public String actualizarComponentes(Componentes componentes) throws Exception {
        try{
            sqlQuery = "UPDATE componentes SET codigo = "+componentes.getCodigo()+", " +
                    " nombre = '"+componentes.getNombre()+"', precio = "+componentes.getPrecioElemento()+", rating = "+ componentes.getRatingElemento() +" WHERE codigo = "+componentes.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    public String eliminarComponentes(int codigo) throws Exception {
        try{
            sqlQuery = "DELETE FROM componentes WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado con exito";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }
}