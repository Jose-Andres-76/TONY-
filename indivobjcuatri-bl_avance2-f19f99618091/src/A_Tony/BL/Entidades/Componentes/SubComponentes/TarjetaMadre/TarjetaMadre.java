package bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.TarjetaMadre;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

public class TarjetaMadre extends Componentes {
    private String socket;

    public TarjetaMadre(String nombre, int codigo, double precioElemento, int rating, String socket){
        super.setNombre(nombre);
        super.setCodigo(codigo);
        super.setPrecioElemento(precioElemento);
        super.setRatingElemento(rating);
        this.socket = socket;
    }
    public TarjetaMadre(){
        super.setNombre("");
        super.setCodigo(0);
        super.setPrecioElemento(0);
        super.setRatingElemento(0);
        this.socket = "";
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString(){
        return "Socket: " +
                socket +
                "\n Nombre: " +
                super.getNombre() +
                "\n Codigo: " +
                super.getCodigo() +
                "\n Precio: " +
                super.getPrecioElemento() +
                "\n Rating: " +
                super.getRatingElemento();
    }


}