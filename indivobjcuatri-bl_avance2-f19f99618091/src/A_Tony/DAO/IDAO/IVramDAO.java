package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM.VRAM;

import java.util.ArrayList;
public interface IVramDAO {
    public String registrarVram(VRAM vram) throws Exception;
    public ArrayList<VRAM> listarVram() throws Exception;
    public VRAM encontrarVram(int codigo) throws Exception;
    public ArrayList<VRAM> retornarVram() throws Exception;
}
