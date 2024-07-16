package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM.VRAM;
import bl_avance2.src.A_Tony.DAO.IDAO.IVramDAO;
import bl_avance2.src.A_Tony.DL.AccessBD;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlVramDAO implements IVramDAO {
    private String sqlQuery;

    public String registrarVram(VRAM vram) throws Exception {
        try {
            sqlQuery = "INSERT INTO vram (tipo, codigo) " +
                    "VALUES ('" + vram.getTipo() + "', "+ vram.getCodigo() + ")";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Vram registrado correctamente";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Hubo un error al registrar el componente";
        }

    }

    public ArrayList<VRAM> listarVram() throws Exception {
        ArrayList<VRAM> listaVram = new ArrayList<>();

        sqlQuery = "SELECT * FROM componentes " +
                "JOIN vram ON " +
                "componentes.codigo = vram.codigo";

        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            VRAM vram = new VRAM();
            vram.setCodigo(rs.getInt("CODIGO"));
            vram.setTipo(rs.getString("tipo"));
            vram.setNombre(rs.getString("nombre"));
            vram.setPrecioElemento(rs.getInt("precio"));
            vram.setRatingElemento(rs.getInt("rating"));

            listaVram.add(vram);
        }
        return listaVram;
    }

    public VRAM encontrarVram(int codigo) throws Exception {
        VRAM vram = new VRAM();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, VRAM.TIPO FROM COMPONENTES " +
                "JOIN VRAM ON COMPONENTES.CODIGO = VRAM.CODIGO WHERE COMPONENTES.CODIGO = " + codigo;
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            vram.setCodigo(rs.getInt("CODIGO"));
            vram.setNombre(rs.getString("NOMBRE"));
            vram.setTipo(rs.getString("TIPO"));
        }

        return vram;
    }

    public ArrayList<VRAM> retornarVram() throws Exception {
        ArrayList<VRAM> listaVram = new ArrayList<>();
        sqlQuery = "SELECT COMPONENTES.CODIGO, COMPONENTES.NOMBRE, VRAM.TIPO FROM COMPONENTES " +
                "JOIN VRAM ON COMPONENTES.CODIGO = VRAM.CODIGO";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            VRAM vram = new VRAM();
            vram.setCodigo(rs.getInt("CODIGO"));
            vram.setNombre(rs.getString("NOMBRE"));
            vram.setTipo(rs.getString("TIPO"));

            listaVram.add(vram);
        }

        return listaVram;
    }

    public String actualizarVram(VRAM vram) throws Exception {
        try{
            sqlQuery = "UPDATE vram SET tipo = '"+vram.getTipo()+"', codigo = "+vram.getCodigo()+" WHERE codigo = "+vram.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    //    public String eliminarRAM(int codigo) throws Exception {
//        try{
//            sqlQuery = "DELETE FROM ram WHERE codigo = " + codigo;
//            Conector.getConector().ejecutarSQL(sqlQuery);
//            return "Componente eliminado correctamente";
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return "Error al eliminar componente";
//        }
//    }

    public String eliminarVram(int codigo) throws Exception{
        try{
            sqlQuery = "DELETE FROM vram WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }
}
