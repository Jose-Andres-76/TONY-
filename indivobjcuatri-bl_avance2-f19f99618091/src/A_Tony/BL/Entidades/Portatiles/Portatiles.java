package bl_avance2.src.A_Tony.BL.Entidades.Portatiles;

public class Portatiles {
    private int cantRAM;
    private String procesador;
    private int cantAlmacenamiento;
    private String VRAM;
    private int cantBateria;
    private String tarjetaMadre;
    private int peso;
    private int rating;

    public Portatiles() {
    }

    public Portatiles(int cantRam, String procesador, int cantAlmacenamiento, String VRAM, int cantBateria, String tarjetaMadre, int peso, int rating) {
        this.cantRAM = cantRam;
        this.procesador = procesador;
        this.cantAlmacenamiento = cantAlmacenamiento;
        this.VRAM = VRAM;
        this.cantBateria = cantBateria;
        this.tarjetaMadre = tarjetaMadre;
        this.peso = peso;
        this.rating = rating;
    }


    public int getCantRAM() {
        return cantRAM;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getCantAlmacenamiento() {
        return cantAlmacenamiento;
    }

    public String getVRAM() {
        return VRAM;
    }

    public int getCantBateria() {
        return cantBateria;
    }

    public String getTarjetaMadre() {
        return tarjetaMadre;
    }

    public int getPeso() {
        return peso;
    }

    public int getRating() {
        return rating;
    }

    public void setCantRAM(int cantRAM) {
        this.cantRAM = cantRAM;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setCantAlmacenamiento(int cantAlmacenamiento) {
        this.cantAlmacenamiento = cantAlmacenamiento;
    }

    public void setVRAM(String VRAM) {
        this.VRAM = VRAM;
    }

    public void setCantBateria(int cantBateria) {
        this.cantBateria = cantBateria;
    }

    public void setTarjetaMadre(String tarjetaMadre) {
        this.tarjetaMadre = tarjetaMadre;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Cantidad de Ram:" + getCantRAM() + "\n" +
                "Procesador:" + getProcesador() + "\n" +
                "Cantidad de Almacenamiento: " + getCantAlmacenamiento() + "\n" +
                "Tarjeta de Video: " + getVRAM() + "\n" +
                "Cantidad de bateria: " + getCantBateria() + "\n" +
                "Tarjeta Madre: " + getTarjetaMadre() + "\n" +
                "Peso: " + getPeso() + "\n" +
                "Rating: " + getRating();
    }
}

