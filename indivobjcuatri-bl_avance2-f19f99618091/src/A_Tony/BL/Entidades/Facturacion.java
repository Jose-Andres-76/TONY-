package A_Tony.BL.Entidades;

public class Facturacion {
    private String precioEnsamblado;
    private String ratingEnsamblado;
    private String DescripcionFacturacion;

    public Facturacion(String precioEnsamblado, String ratingEnsamblado, String DescripcionFacturacion) {
        this.precioEnsamblado = precioEnsamblado;
        this.ratingEnsamblado = ratingEnsamblado;
        this.DescripcionFacturacion = DescripcionFacturacion;
    }

    public Facturacion() {
        this.precioEnsamblado = "";
        this.ratingEnsamblado = "";
        this.DescripcionFacturacion = "";
    }

    @Override
    public String toString() {
        return "Facturacion{" +
                "precioEnsamblado=" +
                precioEnsamblado +
                ", ratingEnsamblado=" +
                ratingEnsamblado +
                ", DescripcionFacturacion=" +
                DescripcionFacturacion + '}';
    }
}
