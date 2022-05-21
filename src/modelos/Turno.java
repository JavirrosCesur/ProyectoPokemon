package modelos;

/**
 * Creacion clase Turno
 */
public class Turno {

    /**
     * Creacion de los metodos de la clase Turno
     */
    private int numeroTurno;
    private String accionJugador;
    private String accionRival;
    private static int contadorTurnos = 0;

    /**
     * Creacion del constructor de la clase Turno añadiendo el metodo addContadorTurnos
     * @param accionJugador es la accion del juagdor 
     * @param accionRival es la accion del rival
     */
    public Turno(String accionJugador, String accionRival){
        this.addContadorTurnos();
        this.numeroTurno = contadorTurnos;
        this.accionJugador = accionJugador;
        this.accionRival = accionRival;
    }

    /**
     * Metodo get de numeroTurno
     * @return el numero de turno 
     */
    public int getNumeroTurno() {
        return numeroTurno;
    }

    /**
     * Metodo get de accionJugador
     * @return la accionJugador
     */
    public String getAccionJugador() {
        return accionJugador;
    }

    /**
     * Metodo get accionRiva
     * @return la accion del rival
     */
    public String getAccionRival() {
        return accionRival;
    }

    /**
     * Metodo get de contadorTurnos
     * @return el contador de turnos
     */
    public static int getContadorTurnos() {
        return contadorTurnos;
    }

    /**
     * Metodo set de numeroTurno
     * @param numeroTurno establece el numero del turno
     */
    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    /**
     * Metodo set de accionJugador
     * @param accionJugador establece la accion del jugador
     */
    public void setAccionJugador(String accionJugador) {
        this.accionJugador = accionJugador;
    }

    /**
     * Metodo set de accionRival
     * @param accionRival establece la accion del rival
     */
    public void setAccionRival(String accionRival) {
        this.accionRival = accionRival;
    }

    /**
     * Metodo void de addContadorTurnos que servira para ir amuentando el numero del turno
     */
    public void addContadorTurnos(){
        contadorTurnos++;
    }

    /**
     * Metodo void de resetContadorTurnos para establecer el contador a 0 nuevamente
     */
    public void resetContadorTurnos(){
        contadorTurnos = 0;
    }
}