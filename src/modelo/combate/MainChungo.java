package Pokemon.src.modelo.combate;

public class MainChungo {
    public static void main(String[] args) {
        
        Combate c = new Combate(null, null);

        c.addTurno();

        c.logCombate();
    }
}
