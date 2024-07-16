package bl_avance2.src.A_Tony.DAO;

import bl_avance2.src.A_Tony.DAO.IDAO.*;
import bl_avance2.src.A_Tony.DAO.IDAO.IPortatilesDAO;

public abstract class DAOFactory {

    public static final int MYSQL = 1;

    public static DAOFactory getDAOFactory(int repositorio){
        switch (repositorio){
            case MYSQL:
                return new MySqlDaoFactory();
            default:
                return null;
        }
    }
    public abstract IPortatilesDAO getIPortatilesDao();
    public abstract IComponentesDAO getIComponentesDao();
    public abstract IAlmacenamientoDAO getIAlmacenamientoDao();
    public abstract IFuenteDePoderDAO getIFuenteDePoderDao();
    public abstract IProcesadorDAO getIProcesadorDao();
    public abstract IRamDAO getIRamDao();
    public abstract ITarjetaMadreDAO getITarjetaMadreDao();
    public abstract IVramDAO getIVramDao();
}
