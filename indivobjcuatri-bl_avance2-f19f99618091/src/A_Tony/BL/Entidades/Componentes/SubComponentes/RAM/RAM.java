package bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.RAM;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

public class RAM extends Componentes {
    private int cantRam;

    public RAM(String nombre, int codigo, double precioElemento, int rating, int cantRam) {
        super.setNombre(nombre);
        super.setCodigo(codigo);
        super.setPrecioElemento(precioElemento);
        super.setRatingElemento(rating);
        this.cantRam = cantRam;
    }

    public RAM() {
        this.cantRam = 0;
    }

    public int getCantRam() {
        return cantRam;
    }

    public void setCantRam(int cantRam) {
        this.cantRam = cantRam;
    }

    @Override
    public String toString() {
        return "Cantidad de RAM: " +
                cantRam
                + "\nNombre: " +
                super.getNombre() +
                "\nCodigo: " +
                super.getCodigo() +
                "\nPrecio: " +
                super.getPrecioElemento() +
                "\nRating " +
                super.getRatingElemento();
    }

}