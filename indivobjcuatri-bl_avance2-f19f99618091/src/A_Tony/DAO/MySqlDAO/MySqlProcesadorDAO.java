package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador.Procesador;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.DAO.IDAO.IProcesadorDAO;
import bl_avance2.src.A_Tony.DL.AccessBD;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlProcesadorDAO implements IProcesadorDAO {
    private String sqlQuery;

    public String registrarProcesador(Procesador procesador) throws Exception {
        sqlQuery = "INSERT INTO procesadores (socket, codigo)" +
                "VALUES ('" + procesador.getSocket() + "', '" + procesador.getCodigo()+ "')";
        Conector.getConector().ejecutarSQL(sqlQuery);

        return "Procesador registrado correctamente";
    }

    public ArrayList<Procesador> listarProcesador() throws Exception {
        ArrayList<Procesador> listaProcesador = new ArrayList<>();

        sqlQuery = "SELECT * FROM componentes " +
                "JOIN procesadores ON " +
                "componentes.codigo = procesadores.codigo";

        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while (rs.next()) {
            Procesador procesador = new Procesador();
            procesador.setCodigo(rs.getInt("codigo"));
            procesador.setSocket(rs.getString("socket"));
            procesador.setNombre(rs.getString("nombre"));
            procesador.setPrecioElemento(rs.getInt("precio"));
            procesador.setRatingElemento(rs.getInt("rating"));

            listaProcesador.add(procesador);
        }

        return listaProcesador;
    }

    public Procesador encontrarProcesador(int codigo) throws Exception {
        Procesador procesador = new Procesador();
        sqlQuery = "SELECT COMPONENTES.CODIGO, COMPONENTES.NOMBRE, PROCESADORES.SOCKET FROM COMPONENTES " +
                "JOIN PROCESADORES ON COMPONENTES.CODIGO = PROCESADORES.CODIGO WHERE COMPONENTES.CODIGO = " + codigo;
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            procesador.setCodigo(rs.getInt("CODIGO"));
            procesador.setNombre(rs.getString("NOMBRE"));
            procesador.setSocket(rs.getString("SOCKET"));
        }

        return procesador;
    }

    public ArrayList<Procesador> retornarProcesador() throws Exception {
        ArrayList<Procesador> listaProcesador = new ArrayList<>();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, procesadores.socket FROM componentes JOIN procesadores ON componentes.codigo = procesadores.codigo";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            Procesador procesador = new Procesador();
            procesador.setCodigo(rs.getInt("codigo"));
            procesador.setNombre(rs.getString("nombre"));
            procesador.setSocket(rs.getString("socket"));

            listaProcesador.add(procesador);
        }

        return listaProcesador;
    }

    public String actualizarProcesador(Procesador procesador) throws Exception {
        try{
            sqlQuery = "UPDATE procesadores SET socket = '"+procesador.getSocket()+"', codigo = "+procesador.getCodigo()+" WHERE codigo = "+procesador.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    public String eliminarProcesador(int codigo) throws Exception{
        try{
            sqlQuery = "DELETE FROM procesadores WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }
}
