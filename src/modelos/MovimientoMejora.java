package src.modelos;

public class MovimientoMejora extends Movimiento {

    private int duracion;
    private Mejora buff;
    private int nivelDeBuff;

    public MovimientoMejora(String nombreHabilidad, int consumo, int duracion, Mejora buff, int nivelDeBuff) {
        super(nombreHabilidad, consumo);
        this.duracion = duracion;
        this.buff = buff;
        this.nivelDeBuff = nivelDeBuff;
    }

    public int getDuracion() {
        return duracion;
    }
    public Mejora getBuff() {
        return buff;
    }
    public int getNivelDeBuff() {
        return nivelDeBuff;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public void setBuff(Mejora buff) {
        this.buff = buff;
    }
    public void setNivelDeBuff(int nivelDeBuff) {
        this.nivelDeBuff = nivelDeBuff;
    }
}