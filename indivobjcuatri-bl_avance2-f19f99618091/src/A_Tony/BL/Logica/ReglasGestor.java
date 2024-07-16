package bl_avance2.src.A_Tony.BL.Logica;

import bl_avance2.src.A_Tony.BL.Entidades.Reglas.Reglas;
import bl_avance2.src.A_Tony.DAO.MySqlDAO.MySqlReglasDAO;
import bl_avance2.src.A_Tony.DL.Data;

import java.util.ArrayList;

public class ReglasGestor {
    private Data datos;
    private MySqlReglasDAO reglasDAO;
    public ReglasGestor(){
        datos = new Data();
        reglasDAO = new MySqlReglasDAO();
    }

    public boolean registrarReglas(String nombreFamilia, int cantSticks, int maxHDD, int minHDD, int maxSSD, int minSSD, int admitirVRAM, int admitirFPoder) throws Exception {
        Reglas reglas = new Reglas(nombreFamilia, cantSticks, maxHDD, minHDD, maxSSD, minSSD, admitirVRAM, admitirFPoder);
        return reglasDAO.registrarReglas(reglas);
    }

    public ArrayList<Reglas> retornarListaReglas() throws Exception {
        return reglasDAO.retornarListaReglas();
    }

    public boolean borrarRegla(Reglas regla) throws Exception {
        return reglasDAO.borrarRegla(regla);
    }

    public boolean modificarRegla(Reglas regla, Reglas newRegla) throws Exception {
        return reglasDAO.modificarReglas(regla, newRegla);
    }
}
