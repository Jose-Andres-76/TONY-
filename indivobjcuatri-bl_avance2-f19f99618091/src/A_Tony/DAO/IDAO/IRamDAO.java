package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;

import java.util.ArrayList;
public interface IRamDAO {
    public String registrarRam(RAM ram) throws Exception;
    public ArrayList<RAM> listarRam() throws Exception;
    public RAM encontrarRam(int codigo) throws Exception;
    public ArrayList<RAM> retornarRam() throws Exception;
}