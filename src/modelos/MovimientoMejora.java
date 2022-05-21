package modelos;

/**
 * Creacion de la clase MovimientoMejora que hereda de Movimiento
 */
public class MovimientoMejora extends Movimiento {

    /**
     * Creacion de los atributos duracion, buff, nivelDeBuff
     */
    private int duracion;
    private Mejora buff;
    private int nivelDeBuff;

    /**
     * Creacion del constructor de MovimientoMejora con los siguientes parametros 
     * @param nombreHabilidad que es el nombre de la habilidad
     * @param consumo que es el consumo de la habilidad
     * @param duracion que es la duracion de la habilidad
     * @param buff que es el buff de la habilidad
     * @param nivelDeBuff que es el grado del buff
     */
    public MovimientoMejora(String nombreHabilidad, int consumo, int duracion, Mejora buff, int nivelDeBuff) {
        super(nombreHabilidad, consumo);
        this.duracion = duracion;
        this.buff = buff;
        this.nivelDeBuff = nivelDeBuff;
    }

    /**
     * Metodo get de duracion
     * @return la duracion de la habilidad
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Metodo get de buff
     * @return el buff de la habilidad
     */
    public Mejora getBuff() {
        return buff;
    }

    /**
     * Metodo get de nivelDeBuff
     * @return el grado del buff de la habilidad
     */
    public int getNivelDeBuff() {
        return nivelDeBuff;
    }

    /**
     * Metodo set de duracion
     * @param duracion establece la duracion de la habilidad
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Metodo set de buff
     * @param buff establece el buff de la habilidad
     */
    public void setBuff(Mejora buff) {
        this.buff = buff;
    }

    /**
     * Metodo set de nivelDeBuff
     * @param nivelDeBuff establece el grado del buff de la habilidad
     */
    public void setNivelDeBuff(int nivelDeBuff) {
        this.nivelDeBuff = nivelDeBuff;
    }
}