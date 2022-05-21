package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainTesterJuego {
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/pokemon";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement sttmt = con.createStatement();
        String randomPokemon = "SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX;";
        ResultSet rs = null;
        String palabra = new String();
        int opt = 0;
        int numero = 0;
        Scanner teclado = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("... ... ...\nConexión establecida\n... ... ...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("ACABAS DE CUMPLIR 10 AÑOS, FELICIDADES\nAhora puedes ser entrenador de POKEMON. ¿Cuál es tu nombre?");
        Entrenador jugador = new Entrenador(teclado.next());
        teclado.nextLine();
        System.out.println("Muy bien, " + jugador.getNombre() + ". Es hora de ir de aventuras, pero para ello deberás" +
        " escoger un POKEMON para que luche por ti. Tienes suerte, acabo de robar 3. Elige uno de ellos:");


        for(int i = 1; i <= 3; i++){
            numero = (int)(Math.random()*16+1);
            rs = sttmt.executeQuery("SELECT NOMBRE FROM pokedex INNER JOIN pokemon ON pokedex.ID_POKEDEX = pokemon.ID_POKEDEX WHERE pokemon.ID_POKEMON = " + numero + ";");
            while(rs.next()){
                System.out.println(i + ": " + rs.getString("NOMBRE") + ".");
            }
        }
        teclado.nextInt();

        System.out.println("\n¡¡EXCELENTE!! Añadire a Pikachu a tu equipo :)\nPonle un mote a tu Pikachu:");
        rs = sttmt.executeQuery("SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX WHERE pokedex.ID_POKEDEX = 25;");
        Pokemon pikachu = null;
        while(rs.next()){
            pikachu = new Pokemon(rs.getString("NOMBRE"), rs.getInt("VITALIDAD"), rs.getInt("ATAQUE"), rs.getInt("DEFENSA"), rs.getInt("ATK_ESPECIAL"), rs.getInt("DEF_ESPECIAL"), rs.getInt("VELOCIDAD"), Tipo.valueOf(rs.getString("TIPO1")), Tipo.valueOf(rs.getString("TIPO2")));
        }
        jugador.getEquipo().add(pikachu);
        jugador.setPrimerPokemon(pikachu);
        pikachu.setMote(teclado.next());
        teclado.nextLine();
        System.out.println(pikachu.getMote() + " y tú ya estáis listos para la aventura. ¡Buena suerte!\n\n");

        while(opt != 9){

            System.out.println("Elige:\n1. Para capturar POKEMON\n2. Para entrenar a tus POKEMON\n" + 
            "3. Para dejar / sacar / cambiar / liberar tus POKEMON\n4. Para combatir con otros ENTRENADORES\n" + 
            "5. Para criar POKEMON\n6. Para hacer descansar a tus POKEMON\n" + 
            "7. Para ver tu equipo POKEMON\n8. Para ver tus POKEMON de la caja\n9. Para salir");
        
            switch(opt = teclado.nextInt()) {
                case 1:
                    numero = (int)(Math.random()*16+1);
                    rs = sttmt.executeQuery(randomPokemon);
                    for(int i = 1; i <= numero; i++){
                        rs.next();
                    }
                    System.out.println("Un " + rs.getString("NOMBRE") + " salvaje apareció." + 
                    "\n¿Quieres atraparlo? s / n");
                    palabra = teclado.next();
                    teclado.nextLine();
                    if(palabra.equals("n")){
                        break;
                    }else{
                        Pokemon salvaje = new Pokemon(rs.getString("NOMBRE"), rs.getInt("VITALIDAD"), rs.getInt("ATAQUE"), rs.getInt("DEFENSA"), rs.getInt("ATK_ESPECIAL"), rs.getInt("DEF_ESPECIAL"), rs.getInt("VELOCIDAD"), Tipo.valueOf(rs.getString("TIPO1")), Tipo.valueOf(rs.getString("TIPO2")));
                        if(jugador.capturarPokemon(salvaje) == false){
                            System.out.println("El POKEMON ha escapado...");
                        }else{
                            System.out.println("Ponle un mote a tu nuevo POKEMON: ");
                            salvaje.setMote(teclado.next());
                            teclado.nextLine();
                        }
                        break;
                    }
                
                case 2:
                    System.out.println("Elige un tipo de entrenamiento:\n1. Entrenamiento Pesado\n" + 
                    "2. Entrenamiento Fuerte\n3. Entrenamiento Funcional\n4. Entrenamiento Onírico");
                    numero = teclado.nextInt();
                    opt = 0;
                    System.out.println("¿Qué POKEMON entrenarás?");
                    for (Pokemon p : jugador.getEquipo()) {
                        System.out.println(p.getMote() + ": " + opt);
                        opt++;
                    }
                    jugador.entrenarPokemon(numero, teclado.nextInt());
                    break;

                case 5:
                System.out.println("Elige que pokemons quieres criar:");

                int pokemon1 = numero;
                int pokemon2 = numero;

                pokemon1 = teclado.nextInt();
                pokemon2 = teclado.nextInt();

                jugador.criarPokemon(jugador.getEquipo().get(pokemon1), jugador.getEquipo().get(pokemon2));
                break;
                case 7:
                    for (Pokemon p : jugador.getEquipo()) {
                        System.out.println(p.toString());
                    }
                    break;
                
                case 8:

                case 9:
                    System.out.println("Acuérdate de ponerme un 10 al salir.");
                    break;
            }
        }
        teclado.close();

    }
}