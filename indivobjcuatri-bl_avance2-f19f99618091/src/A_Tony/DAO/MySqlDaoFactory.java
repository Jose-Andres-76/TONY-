package bl_avance2.src.A_Tony.DAO;

import bl_avance2.src.A_Tony.DAO.IDAO.IPortatilesDAO;
import bl_avance2.src.A_Tony.DAO.MySqlDAO.*;
import bl_avance2.src.A_Tony.DAO.IDAO.*;

public class MySqlDaoFactory extends DAOFactory{
    public IPortatilesDAO getIPortatilesDao() {
        return new MySqlPortatilesDAO();
    }
    public IComponentesDAO getIComponentesDao() {
        return new MySqlComponentesDAO();
    }
    public IAlmacenamientoDAO getIAlmacenamientoDao() {
        return new MySqlAlmacenamientoDAO();
    }
    public IFuenteDePoderDAO getIFuenteDePoderDao() {
        return new MySqlFuenteDePoderDAO();
    }

    public IProcesadorDAO getIProcesadorDao() {
        return new MySqlProcesadorDAO();
    }
    public IRamDAO getIRamDao() {
        return new MySqlRamDAO();
    }
    public ITarjetaMadreDAO getITarjetaMadreDao() {
        return new MySqlTarjetaMadreDAO();
    }
    public IVramDAO getIVramDao() {
        return new MySqlVramDAO();
    }
}
