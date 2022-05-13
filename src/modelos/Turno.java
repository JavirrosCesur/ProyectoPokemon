package src.modelos;

public class Turno {
    
    private int numeroTurno;
    private String accionJugador;
    private String accionRival;
    private static int contadorTurnos = 0;

    public Turno(String accionJugador, String accionRival){
        this.addContadorTurnos();
        this.numeroTurno = contadorTurnos;
        this.accionJugador = accionJugador;
        this.accionRival = accionRival;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }
    public String getAccionJugador() {
        return accionJugador;
    }
    public String getAccionRival() {
        return accionRival;
    }

    public static int getContadorTurnos() {
        return contadorTurnos;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
    public void setAccionJugador(String accionJugador) {
        this.accionJugador = accionJugador;
    }
    public void setAccionRival(String accionRival) {
        this.accionRival = accionRival;
    }

    public void addContadorTurnos(){
        contadorTurnos++;
    }

    public void resetContadorTurnos(){
        contadorTurnos = 0;
    }
}