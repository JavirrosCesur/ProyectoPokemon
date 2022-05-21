package modelos;

/**
 * Creacion de la clase MovimientoAtaque que hereda de Movimiento
 */
public class MovimientoAtaque extends Movimiento {

    /**
     * Creacion de los atributos potencia, tipoMovimiento, fisEsp, ventaja1, ventaja2, ventajaTotal y danyo
     */
    int potencia;
    Tipo tipoMovimiento;
    FisicoEspecial fisEsp;
    float ventaja1;
    float ventaja2;
    float ventajaTotal;
    int danyo;

    /**
     * Creacion del constructor de MovimientoAtaque con los siguientes parametros estableciendo por defecto en 1 la ventaja1, ventaja2 y venatajaTotal y en 0 a daño
     * @param nombreHabilidad que sera el nombre de la habilidad
     * @param consumo que sera el consumo de la habiliad 
     * @param potencia que sera la potencia de la habilidad
     * @param tipoMovimiento que sera el tipo del movimiento
     * @param fisEsp que sera Fisico o Especial depende el movimiento
     */
    public MovimientoAtaque(String nombreHabilidad, int consumo, int potencia, Tipo tipoMovimiento, FisicoEspecial fisEsp) {
        super(nombreHabilidad, consumo);
        this.potencia = potencia;
        this.tipoMovimiento = tipoMovimiento;
        this.fisEsp = fisEsp;
        this.ventaja1 = 1;
        this.ventaja2 = 1;
        this.ventajaTotal = 1;
        this.danyo = 0;
    }

    /**
     * Metodo get de Potencia 
     * @return la potencia del movimiento
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * Metodo get de tipoMovimiento
     * @return el tipo del movimiento
     */
    public Tipo getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Metodo get de fisEsp
     * @return si el movimiento es fisico o especial
     */
    public FisicoEspecial getFisEsp() {
        return fisEsp;
    }

    /**
     * Metodo get de ventaja1
     * @return la ventaja de la habilidad contra el primer tipo del pokemon
     */
    public float getVentaja1() {
        return ventaja1;
    }

    /**
     * Metodo get de ventaja2
     * @return la venatja de la habilidad contra el segundo tipo del pokemon (si lo tuviese)
     */
    public float getVentaja2() {
        return ventaja2;
    }

    /**
     * Metodo get de ventajaTotal
     * @return la ventaja total contra los dos tipos del pokemon
     */
    public float getVentajaTotal() {
        return ventajaTotal;
    }

    /**
     * Metodo get de danyo
     * @return el daño que causa el movimiento sobre el pokemon
     */
    public int getDanyo() {
        return danyo;
    }

    /**
     * Metodo set de ventaja1
     * @param ventaja1 que establece el valor para la ventaja contra el primer tipo del pokemon
     */
    public void setVentaja1(float ventaja1) {
        this.ventaja1 = ventaja1;
    }

    /**
     * Metodo set de ventaja2
     * @param ventaja2 que establece el valor para la ventaja contra el segundo tipo del pokemon (si lo tuviese)
     */
    public void setVentaja2(float ventaja2) {
        this.ventaja2 = ventaja2;
    }

    /**
     * Metodo set de ventajaTotal
     * @param ventajaTotal que establece la ventaja total contra los dos tipos del pokemon
     */
    public void setVentajaTotal(float ventajaTotal) {
        this.ventajaTotal = ventajaTotal;
    }

    /**
     * Metodo set de Danyo
     * @param danyo que establece el danyo del movimiento sobre el pokemonn
     */
    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }

    /**
     * Metodo resetVentaja que establecera las ventajas a sus valores por defecto para que no haya conflicto al usar distintos ataques
     */
    public void resetVentajas(){
        this.setVentaja1(1);
        this.setVentaja2(1);
        this.setVentajaTotal(1);
        this.setDanyo(0);
    }
}