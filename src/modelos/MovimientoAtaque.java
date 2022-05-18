package modelos;

public class MovimientoAtaque extends Movimiento {

    int potencia;
    Tipo tipoMovimiento;
    FisicoEspecial fisEsp;
    float ventaja1;
    float ventaja2;
    float ventajaTotal;
    int danyo;

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

    public int getPotencia() {
        return potencia;
    }
    public Tipo getTipoMovimiento() {
        return tipoMovimiento;
    }
    public FisicoEspecial getFisEsp() {
        return fisEsp;
    }
    public float getVentaja1() {
        return ventaja1;
    }
    public float getVentaja2() {
        return ventaja2;
    }
    public float getVentajaTotal() {
        return ventajaTotal;
    }
    public int getDanyo() {
        return danyo;
    }

    public void setVentaja1(float ventaja1) {
        this.ventaja1 = ventaja1;
    }
    public void setVentaja2(float ventaja2) {
        this.ventaja2 = ventaja2;
    }
    public void setVentajaTotal(float ventajaTotal) {
        this.ventajaTotal = ventajaTotal;
    }
    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }

    public void resetVentajas(){
        this.setVentaja1(1);
        this.setVentaja2(1);
        this.setVentajaTotal(1);
        this.setDanyo(0);
    }
}