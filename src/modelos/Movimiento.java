package modelos;

/**
 * Creacion de la clase abstracta Movimiento
 */
public abstract class Movimiento {

    /**
     * Creacion de los atributos nombreHabilidad y consumo
     */
    private String nombreHabilidad;
    private int consumo;

    /**
     * Creacion del constructor Movimiento con los siguientes parametros
     * @param nombreHabilidad que sera el nombre de la habilidad
     * @param consumo que sera el consumo de energiua de la habilidad
     */
    public Movimiento(String nombreHabilidad, int consumo){
        this.nombreHabilidad = nombreHabilidad;
        this.consumo = consumo;
    }
    
    /**
     * Metodo get de nombreHabilidad
     * @return el nombre de la habilidad
     */
    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    /**
     * Metodo get de consumo 
     * @return el consumo de la habilidad
     */
    public int getConsumo() {
        return consumo;
    }

    /**
     * Metodo set de nombreHabilidad
     * @param nombreHabilidad que establecera el nombre de la habilidad
     */
    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    /**
     * Metodo set de consumo
     * @param consumo que establecera el consumo de la habilidad
     */
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
}