package bl_avance2.src.A_Tony.BL.Entidades.Componentes.SubComponentes.Procesador;

import bl_avance2.src.A_Tony.BL.Entidades.Componentes.Componentes;

public class Procesador extends Componentes {
    private String socket;
    public Procesador(String nombre, int codigo, double precioElemento, int rating, String socket){
        super.setNombre(nombre);
        super.setCodigo(codigo);
        super.setPrecioElemento(precioElemento);
        super.setRatingElemento(rating);
        this.socket = socket;
    }
    public Procesador(){
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
        return
                        "Socket: " +
                        socket +
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