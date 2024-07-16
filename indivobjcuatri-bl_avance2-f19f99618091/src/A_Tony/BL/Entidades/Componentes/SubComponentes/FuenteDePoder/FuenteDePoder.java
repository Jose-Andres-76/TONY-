package bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.FuenteDePoder;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

public class FuenteDePoder extends Componentes {

    private int horasDeDuracion;

    public FuenteDePoder(String nombre, int codigo, double precioElemento, int rating, int horasDeDuracion){
        super.setNombre(nombre);
        super.setCodigo(codigo);
        super.setPrecioElemento(precioElemento);
        super.setRatingElemento(rating);
        this.horasDeDuracion = horasDeDuracion;
    }
    public FuenteDePoder(){
        super.setNombre("");
        super.setCodigo(0);
        super.setPrecioElemento(0);
        super.setRatingElemento(0);
        this.horasDeDuracion = 0;
    }

    public int getHorasDeDuracion() {
        return horasDeDuracion;
    }

    public void setHorasDeDuracion(int horasDeDuracion) {
        this.horasDeDuracion = horasDeDuracion;
    }
    @Override
    public String toString(){
        return "Horas de duracion:" +
                horasDeDuracion +
                "\nNombre: " +
                super.getNombre() +
                "\nCodigo: " +
                super.getCodigo() +
                "\nPrecio: " +
                super.getPrecioElemento() +
                "\nRating: " +
                super.getRatingElemento();
    }

}
