package bl_avance2.src.A_Tony.DL;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento.Almacenamiento;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder.FuenteDePoder;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador.Procesador;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre.TarjetaMadre;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM.VRAM;
import bl_avance2.src.A_Tony.BL.Entidades.Computadoras.Computadoras;
import bl_avance2.src.A_Tony.BL.Entidades.Reglas.Reglas;
import bl_avance2.src.A_Tony.BL.Entidades.Usuarios.Usuario;

import java.util.ArrayList;

public class Data {
    private ArrayList<RAM> listaRAM;
    private ArrayList<Procesador> listaProcesadores;
    private ArrayList<Almacenamiento> listaAlmacenamientos;
    private ArrayList<FuenteDePoder> listaFPoder;
    private ArrayList<TarjetaMadre> listaTarjetasMadre;
    private ArrayList<VRAM> listaVRAM;
    private ArrayList<Reglas> listaReglas;
    private ArrayList<Computadoras> listaComputadoras;

    private ArrayList<Usuario> listaUsuarios;

    public Data(){
        listaRAM = new ArrayList<RAM>();
        listaProcesadores = new ArrayList<Procesador>();
        listaAlmacenamientos = new  ArrayList<Almacenamiento>();
        listaFPoder = new ArrayList<FuenteDePoder>();
        listaTarjetasMadre = new ArrayList<TarjetaMadre>();
        listaVRAM = new ArrayList<VRAM>();
        listaReglas = new ArrayList<Reglas>();
        listaComputadoras = new ArrayList<Computadoras>();
        listaUsuarios = new ArrayList<Usuario>();
    }

    public String registrarRAM(RAM ram) {
        listaRAM.add(ram);
        return "Memoria RAM registrada con éxito";
    }

    public ArrayList<String> listarRAM() throws Exception{
        ArrayList<String> rams = new ArrayList<>();
        for (RAM ram : listaRAM) {
            rams.add(ram.toString());
        }
        return rams;
    }

    public RAM encontrarRAM(int opcion) {
        if (opcion <= listaRAM.size() && opcion > 0) {
            return listaRAM.get(opcion - 1);
        }
        return null;
    }

    public ArrayList<RAM> retornarRAM() {
        return listaRAM;
    }

    public String registrarProcesador(Procesador procesador) {
        listaProcesadores.add(procesador);
        return "Procesador registrado con éxito";
    }

    public ArrayList<String> listarProcesadores() throws Exception{
        ArrayList<String> procesadores = new ArrayList<>();
        for (Procesador procesador : listaProcesadores) {
            procesadores.add(procesador.toString());
        }
        return procesadores;
    }

    public Procesador encontrarProcesador(int opcion) {
        if (opcion <= listaProcesadores.size() && opcion > 0) {
            return listaProcesadores.get(opcion - 1);
        }
        return null;
    }

    public ArrayList<Procesador> retornarProcesador() {
        return listaProcesadores;
    }

    public String registrarAlmacenamiento(Almacenamiento almacenamiento) {
        listaAlmacenamientos.add(almacenamiento);
        return "Almacenamiento registrado con éxito";
    }

    public ArrayList<String> listarAlmacenamiento() throws Exception{
        ArrayList<String> almacenamientos = new ArrayList<String>();
        for (Almacenamiento almacenamiento : listaAlmacenamientos) {
            almacenamientos.add(almacenamiento.toString());
        }
        return almacenamientos;
    }

    public Almacenamiento encontrarAlmacenamiento(int opcion) {
        if (opcion <= listaAlmacenamientos.size() && opcion > 0) {
            return listaAlmacenamientos.get(opcion - 1);
        }
        return null;
    }

    public ArrayList<Almacenamiento> retornarAlmacenamiento() {
        return listaAlmacenamientos;
    }

    public String registrarFPoder(FuenteDePoder fPoder) {
        listaFPoder.add(fPoder);
        return "Fuente de poder registrada con exito";
    }

    public ArrayList<String> listarFPoder() {
        ArrayList<String> fPoderes = new ArrayList<String>();
        for (FuenteDePoder fPoder : listaFPoder) {
            fPoderes.add(fPoder.toString());
        }
        return fPoderes;
    }

    public FuenteDePoder encontrarFPoder(int opcion) {
        if (opcion <= listaFPoder.size() && opcion > 0) {
            return listaFPoder.get(opcion - 1);
        }
        return null;
    }

    public ArrayList<FuenteDePoder> retornarFPoder() {
        return listaFPoder;
    }

    public String registrarTarjetaMadre(TarjetaMadre tarjetaMadre) {
        listaTarjetasMadre.add(tarjetaMadre);
        return "Tarjeta Madre registrada con éxito";
    }

    public ArrayList<String> listarTarjetas() {
        ArrayList<String> tarjetas = new ArrayList<String>();
        for (TarjetaMadre tarjeta : listaTarjetasMadre) {
            tarjetas.add(tarjeta.toString());
        }
        return tarjetas;
    }

    public TarjetaMadre encontrarTarjeta(int opcion) {
        if (opcion <= listaTarjetasMadre.size() && opcion > 0) {
            return listaTarjetasMadre.get(opcion - 1);
        }
        return null;
    }

    public ArrayList<TarjetaMadre> retornarTarjeta() {
        return listaTarjetasMadre;
    }

    public String registrarVRAM(VRAM vram) {
        listaVRAM.add(vram);
        return "Tarjeta de video registrada con exito";
    }

    public ArrayList<String> listarVRAM() {
        ArrayList<String> vrams = new ArrayList<String>();
        for (VRAM vram : listaVRAM) {
            vrams.add(vram.toString());
        }
        return vrams;
    }

    public VRAM encontrarVRAM(int opcion) {
        if (opcion <= listaVRAM.size() && opcion > 0) {
            return listaVRAM.get(opcion - 1);
        }
        return null;
    }

    public ArrayList<VRAM> retornarVRAM() {
        return listaVRAM;
    }

    public String registrarReglas(Reglas reglas){
        listaReglas.add(reglas);
        return "Reglas registradas con exito";
    }

    public ArrayList<String> listarReglas() throws Exception{
        ArrayList<String> reglas = new ArrayList<>();
        for (Reglas regla : listaReglas) {
            reglas.add(regla.toString());
        }
        return reglas;
    }

    public Reglas encontrarRegla(int opcion) throws Exception {
        if (opcion <= listaReglas.size() && opcion > 0) {
                return listaReglas.get(opcion - 1);
        }
        return null;
    }

    public String agregarComponentes(Computadoras computadora) {
        listaComputadoras.add(computadora);
        return "Computadora registrada con exito";
    }

    public Usuario verificarUsuario(Usuario usuario) {
        if (listaUsuarios.size() != 0) {
            for (Usuario user : listaUsuarios) {
                if (user.getNombreUsuario() == usuario.getNombreUsuario() && user.getPassword() == usuario.getPassword()) {
                    return user;
                }
            }
            return null;
        }
        return null;
    }
}