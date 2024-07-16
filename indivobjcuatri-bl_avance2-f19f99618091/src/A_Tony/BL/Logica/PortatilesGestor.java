package bl_avance2.src.A_Tony.BL.Logica;

import bl_avance2.src.A_Tony.BL.Entidades.Portatiles.Portatiles;
import bl_avance2.src.A_Tony.DAO.MySqlDAO.MySqlPortatilesDAO;

import java.util.ArrayList;

public class PortatilesGestor {
    private MySqlPortatilesDAO portatilDAO;

    public PortatilesGestor() {
        portatilDAO = new MySqlPortatilesDAO();
    }

    public boolean registrarPortatile(int cantRam, String procesador, int cantAlmacenamiento, String VRAM, int cantBateria, String tarjetaMadre, int peso, int rating) throws Exception {
        Portatiles portatil = new Portatiles(cantRam, procesador, cantAlmacenamiento, VRAM, cantBateria, tarjetaMadre, peso, rating);
        return portatilDAO.registrarPortatiles(portatil);
    }

    public ArrayList<Portatiles> retornarListaPortatiles() throws Exception {
        return portatilDAO.retornarListaPortatiles();
    }
}
