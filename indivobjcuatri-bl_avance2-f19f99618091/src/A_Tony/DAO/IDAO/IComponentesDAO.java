package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

import java.util.ArrayList;
public interface IComponentesDAO {
    public String registrarComponentes(Componentes componentes) throws Exception;
    public ArrayList<Componentes> listarComponentes() throws Exception;
}
