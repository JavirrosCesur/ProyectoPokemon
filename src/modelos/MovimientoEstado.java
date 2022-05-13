package src.modelos;

public class MovimientoEstado extends Movimiento {

    private int duracion;
    private EstadoPrincipal estadoPrincipal;
    private EstadoSecundario estadoSecundario;

    public MovimientoEstado(String nombreHabilidad, int consumo, int duracion,
    EstadoPrincipal estadoPrincipal, EstadoSecundario estadoSecundario) {
        super(nombreHabilidad, consumo);
        this.duracion = duracion;
        this.estadoPrincipal = estadoPrincipal;
        this.estadoSecundario = estadoSecundario;
    }
    
    public int getDuracion() {
        return duracion;
    }
    public EstadoPrincipal getEstadoPrincipal() {
        return estadoPrincipal;
    }
    public EstadoSecundario getEstadoSecundario() {
        return estadoSecundario;
    }
}