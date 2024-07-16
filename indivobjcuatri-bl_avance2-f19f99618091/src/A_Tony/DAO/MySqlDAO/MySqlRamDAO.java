package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.DAO.IDAO.IRamDAO;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;
public class MySqlRamDAO implements IRamDAO {
    private String sqlQuery;

    public String registrarRam(RAM ram) throws Exception {
        try {
            sqlQuery = "INSERT INTO ram (cantidadRAM, codigo)" +
                    "VALUES (" + ram.getCantRam() + ", " + ram.getCodigo() + ")";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente registrado correctamente";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error al registrar componente...";
        }

    }

    public ArrayList<RAM> listarRam() throws Exception {
        ArrayList<RAM> listaRam = new ArrayList<>();

        sqlQuery = "SELECT * FROM componentes " +
                "JOIN ram ON " +
                "componentes.codigo = ram.codigo";

        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while (rs.next()) {
            RAM ram = new RAM();
            ram.setCodigo(rs.getInt("codigo"));
            ram.setCantRam(rs.getInt("cantidadRAM"));
            ram.setNombre(rs.getString("nombre"));
            ram.setPrecioElemento(rs.getInt("precio"));
            ram.setRatingElemento(rs.getInt("rating"));

            listaRam.add(ram);
        }

        return listaRam;
    }

    public RAM encontrarRam(int codigo) throws Exception {
        try {

        } catch (Exception e) {

        }
        RAM ram = new RAM();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, ram.cantidadRAM FROM componentes JOIN ram ON componentes.codigo = ram.codigo WHERE componentes.codigo = " + codigo;
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while (rs.next()) {
            ram.setCodigo(rs.getInt("CODIGO"));
            ram.setNombre(rs.getString("NOMBRE"));
            ram.setCantRam(rs.getInt("cantidadRAM"));
        }

        return ram;
    }

    public ArrayList<RAM> retornarRam() throws Exception {
        ArrayList<RAM> listaRam = new ArrayList<>();
        sqlQuery = "SELECT componentes.codigo, componentes.nombre, ram.cantidadRAM FROM componentes JOIN ram ON componentes.codigo = ram.codigo";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            RAM ram = new RAM();
            ram.setCodigo(rs.getInt("codigo"));
            ram.setNombre(rs.getString("nombre"));
            ram.setCantRam(rs.getInt("cantidadRAM"));

            listaRam.add(ram);
        }

        return listaRam;
    }

    public String actualizarRam(RAM ram) throws Exception {
        try{
            sqlQuery = "UPDATE ram SET cantidadRAM = "+ram.getCantRam()+", codigo = "+ram.getCodigo()+" WHERE codigo = "+ram.getCodigo();
            Conector.getConector().ejecutarSQL(sqlQuery);

            return "Componente actualizado Correctamente!";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al actualizar componente";
        }
    }

    public String eliminarRAM(int codigo) throws Exception {
        try{
            sqlQuery = "DELETE FROM ram WHERE codigo = " + codigo;
            Conector.getConector().ejecutarSQL(sqlQuery);
            return "Componente eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Error al eliminar componente";
        }
    }

}
