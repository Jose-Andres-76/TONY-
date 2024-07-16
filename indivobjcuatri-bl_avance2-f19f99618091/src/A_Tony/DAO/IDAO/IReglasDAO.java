package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Reglas.Reglas;

import java.util.ArrayList;

public interface IReglasDAO {
    public boolean registrarReglas(Reglas regla) throws Exception;
    public ArrayList<Reglas> retornarListaReglas() throws Exception;
    public boolean borrarRegla(Reglas regla) throws Exception;
    public boolean modificarReglas(Reglas regla, Reglas newRegla) throws Exception;
}
