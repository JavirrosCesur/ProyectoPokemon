package src.modelos;

public abstract class Movimiento {
    
    private String nombreHabilidad;
    private int consumo;

    public Movimiento(String nombreHabilidad, int consumo){
        this.nombreHabilidad = nombreHabilidad;
        this.consumo = consumo;
    }
    
    public String getNombreHabilidad() {
        return nombreHabilidad;
    }
    public int getConsumo() {
        return consumo;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }
    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }
}