package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.BL.Entidades.Reglas.Reglas;
import bl_avance2.src.A_Tony.DAO.IDAO.IReglasDAO;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlReglasDAO implements IReglasDAO {

    private String sqlQuery;

    @Override
    public boolean registrarReglas(Reglas regla) throws Exception {
        try {
            sqlQuery = "INSERT INTO reglas (nombreFamilia, cantidadSticks, maxHDD, minHDD, maxSSD, minSSD, admitirVRAM, admitirFuentePoder) " +
                    "VALUES ('" + regla.getNombreFamilia() + "', '" + regla.getCantSticks() + "', '" +
                    regla.getMaxHDD() + "', '" + regla.getMinHDD() + "', '" + regla.getMaxSSD() + "', '" + regla.getMinSSD() +
                    "', '" + regla.getAdmititrVRAM() + "', '" + regla.getAdmitirFPoder() + "')";

            Conector.getConector().ejecutarSQL(sqlQuery);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public ArrayList<Reglas> retornarListaReglas() throws Exception {
        ArrayList<Reglas> listaReglas = new ArrayList<>();
        sqlQuery = "SELECT * FROM reglas";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            Reglas regla = new Reglas();
            regla.setNombreFamilia(rs.getString("nombreFamilia"));
            regla.setCantSticks(rs.getInt("cantidadSticks"));
            regla.setMaxHDD(rs.getInt("maxHDD"));
            regla.setMinHDD(rs.getInt("minSSD"));
            regla.setMaxSSD(rs.getInt("maxSSD"));
            regla.setMinSSD(rs.getInt("minSSD"));
            regla.setAdmitirVRAM(rs.getInt("admitirVRAM"));
            regla.setAdmitirFPoder(rs.getInt("admitirFuentePoder"));

            listaReglas.add(regla);
        }

        return listaReglas;
    }

    @Override
    public boolean borrarRegla(Reglas regla) throws Exception {
        try {
            sqlQuery = "DELETE FROM reglas WHERE nombreFamilia = '" + regla.getNombreFamilia() + "'";
            Conector.getConector().ejecutarSQL(sqlQuery);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean modificarReglas(Reglas regla, Reglas newRegla) throws Exception {
        try {
            sqlQuery = "UPDATE reglas " +
                    "SET nombreFamilia = '" + newRegla.getNombreFamilia() + "', cantidadSticks = " + newRegla.getCantSticks() + ", " +
                    "maxHDD = " + newRegla.getMaxHDD() + ", minHDD = " + newRegla.getMinHDD() + ", maxSSD = " + newRegla.getMaxSSD() +
                    ", admitirVRAM = " + newRegla.getAdmititrVRAM() + ", admitirFuentePoder = " + newRegla.getAdmitirFPoder() + " " +
                    "WHERE nombreFamilia = '" + regla.getNombreFamilia() + "'";
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
