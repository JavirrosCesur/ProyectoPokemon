package src.modelos;

public class MovimientoEstado extends Movimiento {

    private int duracion;
    private EstadoPrincipal estadoPrincipal;

    public MovimientoEstado(String nombreHabilidad, int consumo, int duracion,
    EstadoPrincipal estadoPrincipal) {
        super(nombreHabilidad, consumo);
        this.duracion = duracion;
        this.estadoPrincipal = estadoPrincipal;
    }
    
    public int getDuracion() {
        return duracion;
    }
    public EstadoPrincipal getEstadoPrincipal() {
        return estadoPrincipal;
    }
}