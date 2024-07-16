package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador.Procesador;

import java.util.ArrayList;
public interface IProcesadorDAO {
    public String registrarProcesador(Procesador procesador) throws Exception;
    public ArrayList<Procesador> listarProcesador() throws Exception;
    public Procesador encontrarProcesador(int codigo) throws Exception;
    public ArrayList<Procesador> retornarProcesador() throws Exception;
}
