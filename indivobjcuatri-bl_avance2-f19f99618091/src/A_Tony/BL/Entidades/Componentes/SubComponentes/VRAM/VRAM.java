package bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.VRAM;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

public class VRAM extends Componentes {
    private String tipo;
    public VRAM(String nombre, int codigo, double precioElemento, int rating, String tipo){
        super.setNombre(nombre);
        super.setCodigo(codigo);
        super.setPrecioElemento(precioElemento);
        super.setRatingElemento(rating);
        this.tipo = tipo;
    }
    public VRAM(){
        super.setNombre("");
        super.setCodigo(0);
        super.setPrecioElemento(0);
        super.setRatingElemento(0);
        this.tipo = "";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "Tipo: " +
                tipo +
                "\nNombre = " +
                super.getNombre() +
                "\nCodigo = " +
                super.getCodigo() +
                "\nPrecio: " +
                super.getPrecioElemento() +
                "\nRating: " +
                super.getRatingElemento();
    }
}