package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Computadoras.Computadoras;

public interface IComputadorasDAO {
    public boolean agregarComponentes(Computadoras computadora) throws Exception;
}
