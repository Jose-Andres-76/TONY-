package bl_avance2.src.A_Tony.DAO.MySqlDAO;

import bl_avance2.src.A_Tony.DAO.IDAO.IPortatilesDAO;
import bl_avance2.src.A_Tony.BL.Entidades.Portatiles.Portatiles;
import bl_avance2.src.A_Tony.DL.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPortatilesDAO implements IPortatilesDAO {
    private String sqlQuery;

    public boolean registrarPortatiles(Portatiles portatiles) throws Exception {
        try {
            sqlQuery = "INSERT INTO portatiles (cantidadRAM, procesador, cantidadAlmacenamiento, vram, cantidadBateria, tarjetaMadre, peso, rating)" +
                    "VALUES ('" + portatiles.getCantRAM() + "', '" + portatiles.getProcesador() + "', '" + portatiles.getCantAlmacenamiento() + "', '" + portatiles.getVRAM() + "', '" + portatiles.getCantBateria() + "', '" + portatiles.getTarjetaMadre() + "', '" + portatiles.getPeso() + "', '" + portatiles.getRating() + "')";
            Conector.getConector().ejecutarSQL(sqlQuery);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Portatiles> retornarListaPortatiles() throws Exception {
        ArrayList<Portatiles> listaPortatiles = new ArrayList<>();
        sqlQuery = "SELECT * FROM portatiles";
        ResultSet rs = Conector.getConector().ejecutarQuery(sqlQuery);

        while(rs.next()){
            Portatiles portatiles = new Portatiles();
            portatiles.setCantRAM(rs.getInt("cantidadRAM"));
            portatiles.setProcesador(rs.getString("procesador"));
            portatiles.setCantAlmacenamiento(rs.getInt("cantidadAlmacenamiento"));
            portatiles.setVRAM(rs.getString("vram"));
            portatiles.setCantBateria(rs.getInt("cantidadBateria"));
            portatiles.setTarjetaMadre(rs.getString("tarjetaMadre"));
            portatiles.setPeso(rs.getInt("peso"));
            portatiles.setRating(rs.getInt("rating"));

            listaPortatiles.add(portatiles);
        }

        return listaPortatiles;
    }

}
