package bl_avance2.src.A_Tony.BL.Entidades.Componentes;

public class Componentes {
    private String nombre;
    private int codigo;
    private double precioElemento;
    private int RatingElemento;

    public Componentes() {
    }

    public Componentes(String nombre, int codigo, double precioElemento, int ratingElemento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioElemento = precioElemento;
        RatingElemento = ratingElemento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecioElemento() {
        return precioElemento;
    }

    public int getRatingElemento() {
        return RatingElemento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecioElemento(double precioElemento) {
        this.precioElemento = precioElemento;
    }

    public void setRatingElemento(int ratingElemento) {
        RatingElemento = ratingElemento;
    }

    @Override
    public String toString() {
        return "Componentes{" +
                "nombre=" +
                nombre +
                ", codigo=" +
                codigo +
                ", precioElemento=" +
                precioElemento +
                ", RatingElemento=" +
                RatingElemento + '}';
    }
}