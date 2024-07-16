package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Computadoras.Computadoras;
import bl_avance2.src.A_Tony.DAO.IDAO.IComputadorasDAO;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlComputadorasDAO implements IComputadorasDAO {
    private String sqlQuery;

    public boolean agregarComponentes(Computadoras computadoras) throws Exception {
        int idRegla;

        idRegla = obtenerCodigoReglas(computadoras);

        try {
            sqlQuery = "INSERT INTO computadoras (cantidadSticks, cantidadHDD, cantidadSSD, idRegla, codigoRAM, codigoAlmacenamiento, " +
                    "codigoFPoder, codigoProcesador, codigoTarjeta, codigoVRAM) " +
                    "VALUES (" + computadoras.getCantSticks() + ", " + computadoras.getCantHDD() + ", " + computadoras.getCantSSD() +
                    ", " + idRegla + ", " + computadoras.getRam().getCodigo() + ", " + computadoras.getAlmacenamiento().getCodigo() +
                    ", " + computadoras.getFuentePoder().getCodigo() + ", " + computadoras.getProcesador().getCodigo() +
                    ", " + computadoras.getTarjetaMadre().getCodigo() + ", " + computadoras.getVram().getCodigo() + ")";

            Conector.getConector().ejecutarSQL(sqlQuery);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int obtenerCodigoReglas(Computadoras computadoras) throws Exception {

        sqlQuery = "SELECT * FROM reglas " +
                "WHERE nombreFamilia = '" + computadoras.getReglas().getNombreFamilia() + "'";
        ResultSet rs = null;
        rs = Conector.getConector().ejecutarQuery(sqlQuery);

        int codigoRegla = 0;

        while (rs.next()) {
            codigoRegla = rs.getInt("idRegla");
        }

        return codigoRegla;
    }
}
