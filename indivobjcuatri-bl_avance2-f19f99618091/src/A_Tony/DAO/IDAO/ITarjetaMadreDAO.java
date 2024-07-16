package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre.TarjetaMadre;

import java.util.ArrayList;
public interface ITarjetaMadreDAO {
    public String registrarTarjetaMadre(TarjetaMadre tarjetaMadre) throws Exception;
    public ArrayList<TarjetaMadre> listarTarjetaMadre() throws Exception;
    public TarjetaMadre encontrarTarjetaMadre(int codigo) throws Exception;
    public ArrayList<TarjetaMadre> retornarTarjetaMadre() throws Exception;
}