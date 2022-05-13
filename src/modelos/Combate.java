package src.modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Combate {

    private ArrayList<Turno> turnos;
    private Entrenador jugador;
    private Entrenador rival;
    private int koJugador;
    private int koRival;
    private Entrenador ganador;
    private Entrenador perdedor;
    private static int contadorCombates = 0;
    public static final String PATH = "Pokemon/log/combate" + contadorCombates + ".log";

    Combate(Entrenador jugador, Entrenador rival) {
        this.addContadorCombates();
        this.turnos = new ArrayList<>();
        this.jugador = jugador;
        this.rival = rival;
        this.koJugador = 0;
        this.koRival = 0;
        this.ganador = null;
        this.perdedor = null;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public Entrenador getJugador() {
        return jugador;
    }

    public Entrenador getRival() {
        return rival;
    }

    public int getKoJugador() {
        return koJugador;
    }

    public int getKoRival() {
        return koRival;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public Entrenador getPerdedor() {
        return perdedor;
    }

    public static int getContadorCombates() {
        return contadorCombates;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setJugador(Entrenador jugador) {
        this.jugador = jugador;
    }

    public void setRival(Entrenador rival) {
        this.rival = rival;
    }

    public void setKoJugador(int koJugador) {
        this.koJugador = koJugador;
    }

    public void setKoRival(int koRival) {
        this.koRival = koRival;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    public void setPerdedor(Entrenador perdedor) {
        this.perdedor = perdedor;
    }

    public void addContadorCombates(){
        contadorCombates++;
    }

    public void addTurno(){
        this.turnos.add(new Turno("Acción Jugador", "Acción Rival"));
    }

    public void koPokemon(){
        if(this.jugador.getPrimerPokemon().getVitalidadActual() <= 0){
            this.koRival++;
        }
        else if(this.rival.getPrimerPokemon().getVitalidadActual() <= 0){
            this.koJugador++;
        }
    }

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

    public void huir() {
        this.setGanador(this.getRival());
        this.setPerdedor(this.getJugador());
        System.out.println("Te retiras. ¡" + this.getRival().getNombre() + " ha ganado el combate!");
        this.getPerdedor().setPokedollar(this.getPerdedor().getPokedollar() / 3);
    }

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