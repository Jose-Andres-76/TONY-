package bl_avance2.src.A_Tony.BL.Entidades.Computadoras;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento.Almacenamiento;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder.FuenteDePoder;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador.Procesador;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM.RAM;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre.TarjetaMadre;
import bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM.VRAM;
import bl_avance2.src.A_Tony.BL.Entidades.Reglas.Reglas;

import java.util.ArrayList;

public class Computadoras{
    private Reglas reglas;
    private RAM ram;
    private Almacenamiento almacenamiento;
    private Procesador procesador;
    private TarjetaMadre tarjetaMadre;
    private FuenteDePoder fuentePoder;
    private VRAM vram;
    private int cantSticks;
    private int cantHDD;
    private int cantSSD;
    private double rating;

    public Computadoras(Reglas reglas, RAM ram, Almacenamiento almacenamiento, Procesador procesador, TarjetaMadre tarjetaMadre, FuenteDePoder fuentePoder, VRAM vram, int cantSticks, int cantHDD, int cantSSD, double rating) {
        this.reglas = reglas;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.procesador = procesador;
        this.tarjetaMadre = tarjetaMadre;
        this.fuentePoder = fuentePoder;
        this.vram = vram;
        this.cantSticks = cantSticks;
        this.cantHDD = cantHDD;
        this.cantSSD = cantSSD;
        this.rating = rating;
    }

    public Computadoras(){}

    public Reglas getReglas() {
        return reglas;
    }

    public void setReglas(Reglas reglas) {
        this.reglas = reglas;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Almacenamiento getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public Procesador getProcesador() {
        return procesador;
    }

    public void setProcesador(Procesador procesador) {
        this.procesador = procesador;
    }

    public TarjetaMadre getTarjetaMadre() {
        return tarjetaMadre;
    }

    public void setTarjetaMadre(TarjetaMadre tarjetaMadre) {
        this.tarjetaMadre = tarjetaMadre;
    }

    public FuenteDePoder getFuentePoder() {
        return fuentePoder;
    }

    public void setFuentePoder(FuenteDePoder fuentePoder) {
        this.fuentePoder = fuentePoder;
    }

    public VRAM getVram() {
        return vram;
    }

    public void setVram(VRAM vram) {
        this.vram = vram;
    }

    public int getCantSticks() {
        return cantSticks;
    }

    public void setCantSticks(int cantSticks) {
        this.cantSticks = cantSticks;
    }

    public int getCantHDD() {
        return cantHDD;
    }

    public void setCantHDD(int cantHDD) {
        this.cantHDD = cantHDD;
    }

    public int getCantSSD() {
        return cantSSD;
    }

    public void setCantSSD(int cantSSD) {
        this.cantSSD = cantSSD;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Nombre de familia: " + reglas.getNombreFamilia() +
                "\nProcesador: " + procesador +
                "\nTarjeta madre: " + tarjetaMadre +
                "\nFuente de poder: " + fuentePoder +
                "\nVRAM: " + vram +
                "\nRating: " + rating;
    }
}