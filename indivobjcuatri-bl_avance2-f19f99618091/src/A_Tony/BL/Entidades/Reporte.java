package A_Tony.BL.Entidades;

public class Reporte {
    private String RatingIventario;
    private String PreciosInventario;
    private String ComponentesVendidos;
    private String CantidadComputadoras;

    public Reporte(){
        this.RatingIventario = "";
        this.PreciosInventario = "";
        this.ComponentesVendidos = "";
        this.CantidadComputadoras = "";
    }

    public Reporte(String RatingIventario, String PreciosInventario, String ComponentesVendidos, String CantidadComputadoras){
        this.RatingIventario = RatingIventario;
        this.PreciosInventario = PreciosInventario;
        this.ComponentesVendidos = ComponentesVendidos;
        this.CantidadComputadoras = CantidadComputadoras;
    }

    public String getRatingIventario(){
        return RatingIventario;
    }

    @Override

    public String toString(){
        return "Reporte{" +
                "RatingIventario=" + RatingIventario +
                ", PreciosInventario=" + PreciosInventario +
                ", ComponentesVendidos=" + ComponentesVendidos +
                ", CantidadComputadoras=" + CantidadComputadoras + '}';
    }

}