package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Portatiles.Portatiles;

import java.util.ArrayList;
public interface IPortatilesDAO {
    public boolean registrarPortatiles(Portatiles portatiles) throws Exception;
    public ArrayList<Portatiles> retornarListaPortatiles() throws Exception;
}
