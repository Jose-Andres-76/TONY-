package bl_avance2.src.A_Tony.DAO.IDAO;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento.Almacenamiento;

import java.util.ArrayList;
public interface IAlmacenamientoDAO {
    public String registrarAlmacenamiento(Almacenamiento almacenamiento) throws Exception;
    public ArrayList<Almacenamiento> listarAlmacenamiento() throws Exception;
    public Almacenamiento encontrarAlmacenamiento(int codigo) throws Exception;
    public ArrayList<Almacenamiento> retornarAlmacenamiento() throws Exception;

}
