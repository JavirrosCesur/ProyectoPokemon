package src.modelos;

import java.util.ArrayList;

public class MainLogTest {
    public static void main(String[] args) {
        
        Combate primerCombate = new Combate(new Entrenador("Pepe", new ArrayList<>(), new ArrayList<>(), null), new Entrenador("Pedro", new ArrayList<>(), new ArrayList<>(), null));
        primerCombate.addTurno();
        primerCombate.addTurno();
        primerCombate.logCombate();
        primerCombate.getTurnos().get(0).resetContadorTurnos();

        Combate segundoCombate = new Combate(new Entrenador("Pepe", new ArrayList<>(), new ArrayList<>(), null), new Entrenador("Izan", new ArrayList<>(), new ArrayList<>(), null));
        segundoCombate.addTurno();
        segundoCombate.addTurno();
        segundoCombate.addTurno();
        segundoCombate.logCombate();
        segundoCombate.getTurnos().get(0).resetContadorTurnos();

    }
}