package bl_avance2.src.A_Tony.BL.Logica;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento.Almacenamiento;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder.FuenteDePoder;
import bl_avance2.src.A_Tony.DAO.IDAO.*;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador.Procesador;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre.TarjetaMadre;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM.VRAM;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;
import bl_avance2.src.A_Tony.DAO.DAOFactory;
import bl_avance2.src.A_Tony.DAO.MySqlDAO.*;


import java.util.ArrayList;

public class ComponenteGestor {
    private DAOFactory daoFactory;
    private MySqlComponentesDAO componentesDAO;
    private MySqlAlmacenamientoDAO almacenamientoDAO;
    private MySqlFuenteDePoderDAO fuenteDePoderDAO;
    private MySqlProcesadorDAO procesadorDAO;
    private MySqlRamDAO ramDAO;
    private MySqlTarjetaMadreDAO tarjetaMadreDAO;
    private MySqlVramDAO vramDAO;
    public ComponenteGestor () throws Exception {
        daoFactory = DAOFactory.getDAOFactory(1);
        componentesDAO = new MySqlComponentesDAO();
        almacenamientoDAO = new MySqlAlmacenamientoDAO();
        fuenteDePoderDAO = new MySqlFuenteDePoderDAO();
        procesadorDAO = new MySqlProcesadorDAO();
        ramDAO = new MySqlRamDAO();
        tarjetaMadreDAO = new MySqlTarjetaMadreDAO();
        vramDAO = new MySqlVramDAO();
    }

    public ArrayList<Componentes> listarComponentes() throws Exception {
        return componentesDAO.listarComponentes();
    }

    public String registrarRAM(String nombre, int codigo, double precioElemento, int rating, int cantRAM) throws Exception {
        if (verificarCodigoRAM(codigo)) {
            return "Ya hay un componente existente con ese codigo";
        }

        Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
        String componentesGuardado = componentesDAO.registrarComponentes(componentes);

        RAM ram = new RAM(nombre, codigo, precioElemento, rating, cantRAM);
        String ramGuardada = ramDAO.registrarRam(ram);


        return "RAM guardada" + ramGuardada + "Componente Guardado" + componentesGuardado;

    }

    public ArrayList<RAM> listarRam() throws Exception{
        return ramDAO.listarRam();
    }

    public RAM encontrarRAM(int opcion) throws Exception {
        return ramDAO.encontrarRam(opcion);
    }

    public String modificarRAM(String nombre, int codigo, double precioElemento, int rating, int cantRAM) throws Exception {
        if (verificarCodigoRAM(codigo)) {
            Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
            String componentesActualizado = componentesDAO.actualizarComponentes(componentes);

            RAM ram = new RAM(nombre, codigo, precioElemento, rating, cantRAM);
            String ramActualizada = ramDAO.actualizarRam(ram);


            return "RAM actualizada" + ramActualizada + "Componente Actualizado" + componentesActualizado;
        } else {
            return "No hay un componente con ese codigo registrado";
        }
    }

    public String modificarProcesador(String nombre, int codigo, double precioElemento, int rating, String socket) throws Exception {
        if (verificarCodigoProcesador(codigo)) {
            Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
            String componentesActualizado = componentesDAO.actualizarComponentes(componentes);

            Procesador procesador = new Procesador(nombre, codigo, precioElemento, rating, socket);
            String procesadorActualizado = procesadorDAO.actualizarProcesador(procesador);


            return "Procesador actualizado" + procesadorActualizado + "Componente Actualizado" + componentesActualizado;
        } else {
            return "No hay un componente con ese codigo registrado";
        }
    }

    public String modificarAlmacenamiento(String nombre, int codigo, double precioElemento, int rating, String tipoAlmacenamiento, String cantAlmacenamiento) throws Exception {
        if (verificarCodigoProcesador(codigo)) {
            Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
            String componentesActualizado = componentesDAO.actualizarComponentes(componentes);

            Almacenamiento almacenamiento = new Almacenamiento(nombre, codigo, precioElemento, rating, tipoAlmacenamiento, cantAlmacenamiento);
            String almacenamientoActualizado = almacenamientoDAO.actualizarAlmacenamiento(almacenamiento);


            return "Almacenamiento actualizado" + almacenamientoActualizado + "Componente Actualizado" + componentesActualizado;
        } else {
            return "No hay un componente con ese codigo registrado";
        }
    }

    public String modificarFPoder(String nombre, int codigo, double precioElemento, int rating, int horasDeDuracion) throws Exception{
        if (verificarCodigoFPoder(codigo)) {
            Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
            String componentesActualizado = componentesDAO.actualizarComponentes(componentes);

            FuenteDePoder fpoder = new FuenteDePoder(nombre, codigo, precioElemento, rating, horasDeDuracion);
            String fpoderActualizado = fuenteDePoderDAO.actualizarFuenteDePoder(fpoder);


            return "Fuente de poder actualizado" + fpoderActualizado + "Componente Actualizado" + componentesActualizado;
        } else {
            return "No hay un componente con ese codigo registrado";
        }
    }

    public String modificarTarjetaMadre(String nombre, int codigo, double precioElemento, int rating, String socket) throws Exception{
        if (verificarCodigoTarjeta(codigo)) {
            Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
            String componentesActualizado = componentesDAO.actualizarComponentes(componentes);

            TarjetaMadre tarjetaMadre = new TarjetaMadre(nombre, codigo, precioElemento, rating, socket);
            String TMadreActualizado = tarjetaMadreDAO.actualizarTarjetaMadre(tarjetaMadre);


            return "Tarjeta Madre actualizada" + TMadreActualizado + "Componente Actualizado" + componentesActualizado;
        } else {
            return "No hay un componente con ese codigo registrado";
        }
    }

    public String modificarVRAM(String nombre, int codigo, double precioElemento, int rating, String tipo) throws Exception{
        if (verificarCodigoVRAM(codigo)) {
            Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
            String componentesActualizado = componentesDAO.actualizarComponentes(componentes);

            VRAM vram = new VRAM(nombre, codigo, precioElemento, rating, tipo);
            String vramActualizado = vramDAO.actualizarVram(vram);


            return "VRAM actualizado" + vramActualizado + "Componente Actualizado" + componentesActualizado;
        } else {
            return "No hay un componente con ese codigo registrado";
        }
    }



    public String eliminarRAM(int codigo) throws Exception {
        if (verificarCodigoRAM(codigo)){
            componentesDAO.eliminarComponentes(codigo);
            return ramDAO.eliminarRAM(codigo);
        }else{
            System.out.println("No se ha eliminado");
            return null;
        }
    }

    public String eliminarAlmacenamiento(int codigo) throws Exception{
        if (verificarCodigoAlmacenamiento(codigo)){
            componentesDAO.eliminarComponentes(codigo);
            return almacenamientoDAO.eliminarAlmacenamiento(codigo);
        }else{
            System.out.println("No se ha eliminado");
            return null;
        }
    }

    public String eliminarFPoder(int codigo) throws Exception{
        if (verificarCodigoFPoder(codigo)){
            componentesDAO.eliminarComponentes(codigo);
            return fuenteDePoderDAO.eliminarFuenteDePoder(codigo);
        }else{
            System.out.println("No se ha eliminado");
            return null;
        }
    }

    public String eliminarProcesador(int codigo) throws Exception{
        if (verificarCodigoProcesador(codigo)){
            componentesDAO.eliminarComponentes(codigo);
            return procesadorDAO.eliminarProcesador(codigo);
        }else{
            System.out.println("No se ha eliminado");
            return null;
        }
    }

    public String eliminarTarjeta(int codigo) throws Exception{
        if (verificarCodigoTarjeta(codigo)){
            componentesDAO.eliminarComponentes(codigo);
            return tarjetaMadreDAO.eliminarTarjetaMadre(codigo);
        }else{
            System.out.println("No se ha eliminado");
            return null;
        }
    }

    public String eliminarVRAM(int codigo) throws Exception{
        if (verificarCodigoVRAM(codigo)){
            componentesDAO.eliminarComponentes(codigo);
            return vramDAO.eliminarVram(codigo);
        }else{
            System.out.println("No se ha eliminado");
            return null;
        }
    }

    public String registrarProcesador(String nombre, int codigo, int precioElemento, int rating, String socket) throws Exception {
        if (verificarCodigoProcesador(codigo)) {
            return "Ya hay un componente con ese codigo, intentelo de nuevo...";
        }
        Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
        String componentesGuardado = componentesDAO.registrarComponentes(componentes);

        Procesador procesador = new Procesador(nombre, codigo, precioElemento, rating, socket);
        String procesadorGuardado = procesadorDAO.registrarProcesador(procesador);

        return "Procesador guardado" + procesadorGuardado + "Componente Guardado" + componentesGuardado;

    }

    public ArrayList<Procesador> listarProcesadores() throws Exception {
        return procesadorDAO.listarProcesador();
    }

    public Procesador encontrarProcesador(int opcion) throws Exception{
        return procesadorDAO.encontrarProcesador(opcion);
    }

    public String registrarAlmacenamiento(String nombreComponente, int codigoComponente, double precioComponente, int ratingComponente, String tipoAlmacenamiento, String cantAlmacenamiento) throws Exception {
        if (verificarCodigoAlmacenamiento(codigoComponente)) {
            return "Ya hay un componente con ese codigo, intentelo de nuevo...";
        }
        Componentes componentes = new Componentes(nombreComponente, codigoComponente, precioComponente, ratingComponente);
        String guardarComponente = componentesDAO.registrarComponentes(componentes);

        Almacenamiento almacenamiento = new Almacenamiento(nombreComponente, codigoComponente, precioComponente, ratingComponente,tipoAlmacenamiento, cantAlmacenamiento);
        String guardarAlmacenamiento = almacenamientoDAO.registrarAlmacenamiento(almacenamiento);

        return "Almacenamiento guardado" + guardarAlmacenamiento + "Componente Guardado" + guardarComponente;
    }

    public ArrayList<Almacenamiento> listarAlmacenamientos() throws Exception {
        return almacenamientoDAO.listarAlmacenamiento();
    }

    public Almacenamiento encontrarAlmacenamiento(int opcion) throws Exception{
        return almacenamientoDAO.encontrarAlmacenamiento(opcion);
    }

    public String registrarFPoder(String nombre, int codigo, double precioElemento, int rating, int horasDeDuracion) throws Exception {
        if (verificarCodigoFPoder(codigo)) {
            return "Ya hay un componente con ese codigo, intentelo de nuevo...";
        }

        Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
        String guardarComponente = componentesDAO.registrarComponentes(componentes);

        FuenteDePoder fPoder = new FuenteDePoder(nombre, codigo, precioElemento, rating, horasDeDuracion);
        String guardarFuenteDePoder = fuenteDePoderDAO.registrarFuenteDePoder(fPoder);

        return "Fuente de poder guardada" + guardarFuenteDePoder + "Componente Guardado" + guardarComponente;
    }

    public ArrayList<FuenteDePoder> listarFPoder() throws Exception {
        return fuenteDePoderDAO.listarFuenteDePoder();
    }

    public FuenteDePoder encontrarFPoder(int opcion) throws Exception {
        return fuenteDePoderDAO.encontrarFuenteDePoder(opcion);
    }

    public String registrarTarjetaMadre(String nombreComponente, int codigoComponente, double precioComponente, int ratingComponente, String socket) throws Exception {
        if (verificarCodigoTarjeta(codigoComponente)) {
            return "Ya hay un componente con ese codigo, intentelo de nuevo...";
        }
        Componentes componentes = new Componentes(nombreComponente, codigoComponente, precioComponente, ratingComponente);
        String guardarComponente = componentesDAO.registrarComponentes(componentes);

        TarjetaMadre tarjetaMadre = new TarjetaMadre(nombreComponente, codigoComponente, precioComponente, ratingComponente, socket);
        String guardarTarjetaMadre = tarjetaMadreDAO.registrarTarjetaMadre(tarjetaMadre);

        return "Tarjeta madre guardada" + guardarTarjetaMadre + "Componente Guardado" + guardarComponente;
    }

    public ArrayList<TarjetaMadre> listarTarjetas() throws Exception {
        return tarjetaMadreDAO.listarTarjetaMadre();
    }

    public TarjetaMadre encontrarTarjeta(int opcion) throws Exception {
        return tarjetaMadreDAO.encontrarTarjetaMadre(opcion);
    }

    public String registrarVRAM (String nombre, int codigo, double precioElemento, int rating,String tipo) throws Exception {
        if (verificarCodigoVRAM(codigo)) {
            return "Ya hay un componente con ese codigo, intentelo de nuevo...";
        }

        Componentes componentes = new Componentes(nombre, codigo, precioElemento, rating);
        String componentesGuardado = componentesDAO.registrarComponentes(componentes);

        VRAM vram = new VRAM(nombre, codigo, precioElemento, rating, tipo);
        String vramGuardada = vramDAO.registrarVram(vram);

        return "VRAM guardada" + vramGuardada + "Componente Guardado" + componentesGuardado;
    }

    public ArrayList<VRAM> listarVRAM() throws Exception {
        return vramDAO.listarVram();
    }

    public VRAM encontrarVRAM(int opcion) throws Exception {
        return vramDAO.encontrarVram(opcion);
    }

    public boolean verificarCodigoRAM(int codigo) throws Exception {

        for (RAM ram : ramDAO.retornarRam()) {
            if (ram.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCodigoProcesador(int codigo) throws Exception {
        for (Procesador procesador : procesadorDAO.retornarProcesador()) {
            if (procesador.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCodigoAlmacenamiento(int codigo) throws Exception {
        for (Almacenamiento almacenamiento : almacenamientoDAO.retornarAlmacenamiento()) {
            if (almacenamiento.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCodigoFPoder(int codigo) throws Exception{
        for (FuenteDePoder fpoder : fuenteDePoderDAO.retornarFuenteDePoder()) {
            if (fpoder.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCodigoTarjeta(int codigo) throws Exception {
        for (TarjetaMadre tarjeta : tarjetaMadreDAO.retornarTarjetaMadre()) {
            if (tarjeta.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarCodigoVRAM(int codigo) throws Exception {
        for (VRAM vram : vramDAO.retornarVram()) {
            if (vram.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
}