package bl_avance2.src.A_Tony.BL.Logica;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento.Almacenamiento;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder.FuenteDePoder;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador.Procesador;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre.TarjetaMadre;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM.VRAM;
import bl_avance2.src.A_Tony.BL.Entidades.Computadoras.Computadoras;
import bl_avance2.src.A_Tony.DAO.MySqlDAO.MySqlComputadorasDAO;
import bl_avance2.src.A_Tony.BL.Entidades.Reglas.Reglas;
import bl_avance2.src.A_Tony.DL.Data;

public class ComputadoraGestor {
    private MySqlComputadorasDAO computadorasDAO;
    public ComputadoraGestor() {
        computadorasDAO = new MySqlComputadorasDAO();
    }

    public boolean registrarComputadora(Reglas regla, RAM ram, Procesador procesador, Almacenamiento almacenamiento, FuenteDePoder fPoder, VRAM vram, TarjetaMadre tarjeta, int cantSticks, int cantAlmaSSD, int cantAlmaHDD) throws Exception {
        double rating;

        rating = (ram.getRatingElemento() + almacenamiento.getRatingElemento() + procesador.getRatingElemento() + fPoder.getRatingElemento() + tarjeta.getRatingElemento() + vram.getRatingElemento()) / 6;

        Computadoras computadora = new Computadoras(regla, ram, almacenamiento, procesador, tarjeta, fPoder, vram, cantSticks, cantAlmaHDD, cantAlmaSSD, rating);
        return computadorasDAO.agregarComponentes(computadora);
    }
}
