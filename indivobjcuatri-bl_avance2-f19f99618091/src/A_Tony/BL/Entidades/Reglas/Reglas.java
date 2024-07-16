package bl_avance2.src.A_Tony.BL.Entidades.Reglas;

import java.util.ArrayList;

public class Reglas {
    private String nombreFamilia;
    private int cantSticks; // Se refiere a la cantidad de sticks de RAM que puedes agregar
    private int maxHDD; // Se refiere al maximo de HDDs que puedes agregar
    private int minHDD; // Se refiere al minimo de HDDs que puedes agregar
    private int maxSSD; // Se refiere al maximo de SSDs que puedes agregar
    private int minSSD; // Se refiere al minimo de SSDs que puedes agregar
    private int admitirVRAM; // Se refiere a si admite VRAM
    private int admitirFPoder;

    public Reglas(){
        this.nombreFamilia = "";
        this.cantSticks = 0;
        this.maxHDD = 0;
        this.minHDD = 0;
        this.maxSSD = 0;
        this.minSSD = 0;
        this.admitirVRAM = 0;
        this.admitirFPoder = 0;
    }

    public Reglas(String nombreFamilia, int cantSticks, int maxHDD, int minHDD, int maxSSD, int minSSD, int admitirVRAM, int admitirFPoder) {
        this.nombreFamilia = nombreFamilia;
        this.cantSticks = cantSticks;
        this.maxHDD = maxHDD;
        this.minHDD = minHDD;
        this.maxSSD = maxSSD;
        this.minSSD = minSSD;
        this.admitirVRAM = admitirVRAM;
        this.admitirFPoder = admitirFPoder;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public int getCantSticks() {
        return cantSticks;
    }

    public void setCantSticks(int cantSticks) {
        this.cantSticks = cantSticks;
    }

    public int getMaxHDD() {
        return maxHDD;
    }

    public void setMaxHDD(int maxHDD) {
        this.maxHDD = maxHDD;
    }

    public int getMinHDD() {
        return minHDD;
    }

    public void setMinHDD(int minHDD) {
        this.minHDD = minHDD;
    }

    public int getMaxSSD() {
        return maxSSD;
    }

    public void setMaxSSD(int maxSSD) {
        this.maxSSD = maxSSD;
    }

    public int getMinSSD() {
        return minSSD;
    }

    public void setMinSSD(int minSSD) {
        this.minSSD = minSSD;
    }

    public int getAdmititrVRAM() {
        return this.admitirVRAM;
    }

    public void setAdmitirVRAM(int admitirVRAM) {
        this.admitirVRAM = admitirVRAM;
    }

    public int getAdmitirFPoder() {
        return this.admitirFPoder;
    }

    public void setAdmitirFPoder(int admitirFPoder) {
        this.admitirFPoder = admitirFPoder;
    }

    @Override
    public String toString() {
        return "\nNombre de familia: " + nombreFamilia + '\'' +
                "\nCantidad de Sticks: " + cantSticks +
                "\nMaximo de HDD: " + maxHDD +
                "\nMinimo de HDD: " + minHDD +
                "\nMaximo de SSD: " + maxSSD +
                "\nMinimo de SSD: " + minSSD;
    }


}
