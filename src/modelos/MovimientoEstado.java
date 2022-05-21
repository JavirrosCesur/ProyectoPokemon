package modelos;

/**
 * Creacion de la clase MovimientoEstado que hereda de Movimiento
 */
public class MovimientoEstado extends Movimiento {

    /**
     * Creacion de los atributos duracion, estadoPrincipal, estadoSecundario
     */
    private int duracion;
    private EstadoPrincipal estadoPrincipal;
    private EstadoSecundario estadoSecundario;

    /**
     * Creacion del constructor MovimientoEstado con los siguientes parametros
     * @param nombreHabilidad que es el nombre de la habilidad
     * @param consumo que es el consumo de la habilidad
     * @param duracion que es la duracion de la habilidad 
     * @param estadoPrincipal que es el estado principal de la habilidad
     * @param estadoSecundario que es el estado secundario de la habilidad
     */
    public MovimientoEstado(String nombreHabilidad, int consumo, int duracion,
    EstadoPrincipal estadoPrincipal, EstadoSecundario estadoSecundario) {
        super(nombreHabilidad, consumo);
        this.duracion = duracion;
        this.estadoPrincipal = estadoPrincipal;
        this.estadoSecundario = estadoSecundario;
    }
    
    /**
     * Metodo get de duracion
     * @return la duracion de la habilidad
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Metodo get de EstadoPrincipal
     * @return el estado principal de la habilidad
     */
    public EstadoPrincipal getEstadoPrincipal() {
        return estadoPrincipal;
    }

    /**
     * Metodo get de EstadoSecundario
     * @return el estado secundario de la habilidad
     */
    public EstadoSecundario getEstadoSecundario() {
        return estadoSecundario;
    }

    /**
     * Metodo set de duracion
     * @param duracion establece la duracion de la habilidad
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo set de estadoPrincipal
     * @param estadoPrincipal establece el estado principal de la habilidad
     */
    public void setEstadoPrincipal(EstadoPrincipal estadoPrincipal) {
        this.estadoPrincipal = estadoPrincipal;
    }

    /**
     * Metodo set de estadoSecundario
     * @param estadoSecundario establece el estado secundario de la habilidad
     */
    public void setEstadoSecundario(EstadoSecundario estadoSecundario) {
        this.estadoSecundario = estadoSecundario;
    }
}