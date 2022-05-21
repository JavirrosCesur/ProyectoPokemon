package modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Creacion de la clase Combate 
 */
public class Combate {

    /**
     * Creacion de los atributos necesarios de la clase Combate
     */
    private ArrayList<Turno> turnos;
    private Entrenador jugador;
    private Entrenador rival;
    private int koJugador;
    private int koRival;
    private Entrenador ganador;
    private Entrenador perdedor;
    private static int contadorCombates = 0;
    public static String PATH = "Pokemon/log/combate" + contadorCombates + ".log";

    /**
     * Creacion del constructor de Combate añadiendo un contador de turnos, el PATH, un array list en turnos, establecemos los valores de ko en 0
     * y los valores de ganador y perdedor a null
     * @param jugador que es el jugador 
     * @param rival que es el rival
     */
    Combate(Entrenador jugador, Entrenador rival) {
        this.addContadorCombates();
        this.refreshPATH();
        this.turnos = new ArrayList<>();
        this.jugador = jugador;
        this.rival = rival;
        this.koJugador = 0;
        this.koRival = 0;
        this.ganador = null;
        this.perdedor = null;
    }

    /**
     * Metodo get de turnos
     * @return la lista de turnos
     */
    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    /**
     * Metodo get de jugador
     * @return el jugador 
     */
    public Entrenador getJugador() {
        return jugador;
    }

    /**
     * Metodo get de rival
     * @return el rival
     */
    public Entrenador getRival() {
        return rival;
    }

    /**
     * Metodo get de koJugador
     * @return
     */
    public int getKoJugador() {
        return koJugador;
    }

    /**
     * Metodo get de rival
     * @return el ko del rival
     */
    public int getKoRival() {
        return koRival;
    }

    /**
     * Metodo get de ganador 
     * @return
     */
    public Entrenador getGanador() {
        return ganador;
    }

    /**
     * Metodo get de perdedor
     * @return el perdedor del combate
     */
    public Entrenador getPerdedor() {
        return perdedor;
    }

    /**
     * Metodo get de contadorCombates static
     * @return el contador del combate
     */
    public static int getContadorCombates() {
        return contadorCombates;
    }

    /**
     * Metodo set de turnos
     * @param turnos establece los turnos en las listas
     */
    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    /**
     * Metodo set de jugador
     * @param jugador establece el jugador del combate
     */
    public void setJugador(Entrenador jugador) {
        this.jugador = jugador;
    }

    /**
     * Metodo set de rival
     * @param rival establece el rival del combate
     */
    public void setRival(Entrenador rival) {
        this.rival = rival;
    }

    /**
     * Metodo set de koJugador
     * @param koJugador establece el ko del jugador
     */
    public void setKoJugador(int koJugador) {
        this.koJugador = koJugador;
    }

    /**
     * Metodo set de koRival
     * @param koRival establece el ko del rival
     */
    public void setKoRival(int koRival) {
        this.koRival = koRival;
    }

    /**
     * Metodo set de ganador 
     * @param ganador establece el ganador del combate
     */
    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    /**
     * Metodo set de perdedor
     * @param perdedor establece el perdedor del combate
     */
    public void setPerdedor(Entrenador perdedor) {
        this.perdedor = perdedor;
    }

    /**
     * Metodo void addContadorCombates que aumenta el valor del contador del combate
     */
    public void addContadorCombates(){
        contadorCombates++;
    }

    /**
     * Metodo void refreshPATH que actualiza el log del combate
     */
    public void refreshPATH(){
        PATH = "./log/combate" + contadorCombates + ".log";
    }

    /**
     * Metodo void addTurnos que añade al turno la accion del jugador y la accion del rival
     */
    public void addTurno(){
        this.turnos.add(new Turno("Acción Jugador", "Acción Rival"));
    }

    /**
     * Metodo void koPokemon que aumenta en funcion de la condicion sobre el jugador o el rival
     */
    public void koPokemon(){
        if(this.jugador.getPrimerPokemon().getVitalidadActual() <= 0){
            this.koRival++;
        }
        else if(this.rival.getPrimerPokemon().getVitalidadActual() <= 0){
            this.koJugador++;
        }
    }

    /**
     * Metodo void checkGanador que comprueba quien ha ganado y perdido el combate y quien recibira o perdera los pokedollares
     */
    public void checkGanador() {
        if (this.getKoJugador() == 4) {
            this.setGanador(this.getJugador());
            this.setPerdedor(this.getRival());
            System.out.println("¡Has ganado el combate!");
            this.getGanador().setPokedollar(this.getGanador().getPokedollar() + (this.getPerdedor().getPokedollar() / 3) * 2);

        } else if (this.getKoRival() == 4) {
            this.setGanador(this.getRival());
            this.setPerdedor(this.getGanador());
            System.out.println("¡" + this.getRival().getNombre() + " ha ganado el combate!");
            this.getPerdedor().setPokedollar(this.getPerdedor().getPokedollar() / 3);
        }

    }

    /**
     * Metodo huir que te hara retirarte del combate dandole la victoria al rival y quitandote pokedollares
     */
    public void huir() {
        this.setGanador(this.getRival());
        this.setPerdedor(this.getJugador());
        System.out.println("Te retiras. ¡" + this.getRival().getNombre() + " ha ganado el combate!");
        this.getPerdedor().setPokedollar(this.getPerdedor().getPokedollar() / 3);
    }

    /**
     * Metodo void logCombate que creara un nuevo fichero donde ira almacenando el log del combate a cada turno 
     */
    public void logCombate(){
        File fichero = new File(PATH);
        try {
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Turno turno : turnos) {
                bw.write("Turno " + turno.getNumeroTurno() + ":\n" +
                "Jugador: " + turno.getAccionJugador() + ".\n" + 
                "Rival: " + turno.getAccionRival() + ".\n\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}