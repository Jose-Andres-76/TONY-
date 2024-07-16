package bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Almacenamiento;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

public class Almacenamiento extends Componentes {
    private String tipo;
    private String cantAlmacenamiento;

    public Almacenamiento(String nombre, int codigo, double precioElemento, int rating, String tipo, String cantAlmacenamiento) {
        super.setNombre(nombre);
        super.setCodigo(codigo);
        super.setPrecioElemento(precioElemento);
        super.setRatingElemento(rating);
        this.tipo = tipo;
        this.cantAlmacenamiento = cantAlmacenamiento;
    }
    public Almacenamiento() {
        super.setNombre("");
        super.setCodigo(0);
        super.setPrecioElemento(0);
        super.setRatingElemento(0);
        this.tipo = "";
        this.cantAlmacenamiento = "";
    }

    public String getTipo() {
        return tipo;
    }

    public String getCantAlmacenamiento() {
        return cantAlmacenamiento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantAlmacenamiento(String cantAlmacenamiento) {
        this.cantAlmacenamiento = cantAlmacenamiento;
    }

    @Override
    public String toString() {
        return "Tipo:  " +
                tipo +
                "\nCantidad de Almacenamiento = " +
                cantAlmacenamiento +
                "\nNombre " +
                super.getNombre() +
                "\nCodigo " +
                super.getCodigo() +
                "\nPrecio: " +
                super.getPrecioElemento() +
                "\nRating: " +
                super.getRatingElemento();
    }

    public String getTipoAlmacenamiento() {
        return tipo;
    }
}