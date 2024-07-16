package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder.FuenteDePoder;

import java.util.ArrayList;
public interface IFuenteDePoderDAO {

    public String registrarFuenteDePoder(FuenteDePoder fuenteDePoder) throws Exception;
    public ArrayList<FuenteDePoder> listarFuenteDePoder() throws Exception;
    public FuenteDePoder encontrarFuenteDePoder(int codigo) throws Exception;
    public ArrayList<FuenteDePoder> retornarFuenteDePoder() throws Exception;
}
