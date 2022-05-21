package src.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainProyecto {
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement sttmt = con.createStatement();
        String randomPokemon = "SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX;";
        String randomRival = "SELECT NOMBRE_ENTRENADOR FROM entrenador";
        ResultSet rs = null;
        String palabra = new String();
        int sw = 0;
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
        rs = sttmt.executeQuery("SELECT * FROM movimiento WHERE TIPO_MOVIMIENTO = " + "'" + pikachu.getTipo1() + "';");
        while(rs.next()){
            if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoAtaque")){
                pikachu.getHabilidades().add(new MovimientoAtaque(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("POTENCIA_MOVIMIENTO"), Tipo.valueOf(rs.getString("TIPO_MOVIMIENTO")), FisicoEspecial.valueOf(rs.getString("FISESP_MOVIMIENTO"))));

            }else if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoEstado")){
                pikachu.getHabilidades().add(new MovimientoEstado(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("DURACION_MOVIMIENTO"), EstadoPrincipal.valueOf(rs.getString("ESTADO_MOVIMIENTO"))));

            }else if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoMejora")){
                pikachu.getHabilidades().add(new MovimientoMejora(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("DURACION_MOVIMIENTO"), Mejora.valueOf(rs.getString("BUFF_MOVIMIENTO")), rs.getInt("NIVEL_BUFF")));
            }    
        }
        jugador.getEquipo().add(pikachu);
        pikachu.setMote(teclado.next());
        teclado.nextLine();
        System.out.println(pikachu.getMote() + " dispone de las siguientes habilidades:");
        for (Movimiento m : pikachu.getHabilidades()) {
            System.out.println(m.getNombreHabilidad());
        }
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
                        rs = sttmt.executeQuery("SELECT * FROM movimiento WHERE TIPO_MOVIMIENTO = '" + salvaje.getTipo1() + "' OR TIPO_MOVIMIENTO = '" + salvaje.getTipo2() + "';");
                            while(rs.next()){
                                if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoAtaque")){
                                    salvaje.getHabilidades().add(new MovimientoAtaque(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("POTENCIA_MOVIMIENTO"), Tipo.valueOf(rs.getString("TIPO_MOVIMIENTO")), FisicoEspecial.valueOf(rs.getString("FISESP_MOVIMIENTO"))));
                    
                                }else if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoEstado")){
                                    salvaje.getHabilidades().add(new MovimientoEstado(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("DURACION_MOVIMIENTO"), EstadoPrincipal.valueOf(rs.getString("ESTADO_MOVIMIENTO"))));
                    
                                }else if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoMejora")){
                                    salvaje.getHabilidades().add(new MovimientoMejora(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("DURACION_MOVIMIENTO"), Mejora.valueOf(rs.getString("BUFF_MOVIMIENTO")), rs.getInt("NIVEL_BUFF")));
                                }
                            }
                        if(jugador.capturarPokemon(salvaje) == false){
                            System.out.println("El POKEMON ha escapado...");
                        }else{
                            System.out.println("Ponle un mote a tu nuevo POKEMON: ");
                            salvaje.setMote(teclado.next());
                            System.out.println(salvaje.getMote() + " dispone de las siguientes habilidades:");
                            for (Movimiento m : salvaje.getHabilidades()) {
                                System.out.println(m.getNombreHabilidad());
                            }
                            teclado.nextLine();
                        }
                        break;
                    }
                
                case 2:
                    System.out.println("Tienes " + jugador.getPokedollar() + " pokedollares.");
                    System.out.println("Elige un tipo de entrenamiento:\n1. Entrenamiento Pesado\n" + 
                    "2. Entrenamiento Fuerte\n3. Entrenamiento Funcional\n4. Entrenamiento Onírico\n" + 
                    "5. Salir");
                    numero = teclado.nextInt();
                    if(numero == 5){
                        break;
                    }else {
                        System.out.println("¿Qué POKEMON entrenarás?");
                        sw = 0;
                        for (Pokemon p : jugador.getEquipo()) {
                            System.out.println(p.getMote() + ": " + sw);
                            sw++;
                        }
                    jugador.entrenarPokemon(numero, teclado.nextInt());
                    break;
                    }

                case 3:
                    System.out.println("Elige una opción:\n1. Dejar un POKEMON de tu equipo en la caja\n" + 
                    "2. Sacar un POKEMON de la caja a tu equipo\n3. Cambiar la posición de los POKEMON de tu equipo\n" + 
                    "4. Liberar un POKEMON de la caja\n5. Salir");
                    numero = teclado.nextInt();
                    if(numero == 1){
                        System.out.println("¿Qué POKEMON dejas en la caja?");
                        sw = 0;
                        for (Pokemon p : jugador.getEquipo()) {
                            System.out.println(p.getMote() + ": " + sw);
                            sw++;
                        }
                        jugador.dejarPokemon(teclado.nextInt());
                        break;

                    }else if(numero == 2){
                        System.out.println("¿Qué POKEMON añadirás a tu equipo?");
                        sw = 0;
                        for (Pokemon p : jugador.getCaja()) {
                            System.out.println(p.getMote() + ": " + sw);
                            sw++;
                        }
                        jugador.sacarPokemon(teclado.nextInt());
                        break;

                    }else if(numero == 3){
                        System.out.println("¿Qué POKEMON intercambiarán sus posiciones?");
                        sw = 0;
                        for (Pokemon p : jugador.getEquipo()) {
                            System.out.println(p.getMote() + ": " + sw);
                            sw++;
                        }
                        jugador.cambiarPosiciones(teclado.nextInt(), teclado.nextInt());
                        break;

                    }else if(numero == 4){
                        System.out.println("¿Qué POKEMON vas a dejar libre? No volverás a verlo...");
                        sw = 0;
                        for (Pokemon p : jugador.getCaja()) {
                            System.out.println(p.getMote() + ": " + sw);
                            sw++;
                        }
                        jugador.liberarPokemon(teclado.nextInt());
                        break;

                    }else if(numero == 5){
                        break;
                    }

                case 4:
                    numero = (int)(Math.random()*3+1);
                    rs = sttmt.executeQuery(randomRival);
                    for(int i = 1; i <= numero; i++){
                        rs.next();
                    }
                    Entrenador entRival = new Entrenador(rs.getString("NOMBRE_ENTRENADOR"));
                    Pokemon pokRival = null;
                    for(int i = 0; i < jugador.getEquipo().size(); i++){
                        numero = (int)(Math.random()*16+1);
                        rs = sttmt.executeQuery(randomPokemon);
                        for(int j = 1; j <= numero; j++){
                            rs.next();
                        }
                        entRival.getEquipo().add(pokRival = new Pokemon(rs.getString("NOMBRE"), rs.getInt("VITALIDAD"), rs.getInt("ATAQUE"), rs.getInt("DEFENSA"), rs.getInt("ATK_ESPECIAL"), rs.getInt("DEF_ESPECIAL"), rs.getInt("VELOCIDAD"), Tipo.valueOf(rs.getString("TIPO1")), Tipo.valueOf(rs.getString("TIPO2"))));
                        rs = sttmt.executeQuery("SELECT * FROM movimiento WHERE TIPO_MOVIMIENTO = '" + pokRival.getTipo1() + "' OR TIPO_MOVIMIENTO = '" + pokRival.getTipo2() + "';");
                            while(rs.next()){
                                if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoAtaque")){
                                    pokRival.getHabilidades().add(new MovimientoAtaque(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("POTENCIA_MOVIMIENTO"), Tipo.valueOf(rs.getString("TIPO_MOVIMIENTO")), FisicoEspecial.valueOf(rs.getString("FISESP_MOVIMIENTO"))));
                    
                                }else if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoEstado")){
                                    pokRival.getHabilidades().add(new MovimientoEstado(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("DURACION_MOVIMIENTO"), EstadoPrincipal.valueOf(rs.getString("ESTADO_MOVIMIENTO"))));
                    
                                }else if(rs.getString("CLASE_MOVIMIENTO").equals("MovimientoMejora")){
                                    pokRival.getHabilidades().add(new MovimientoMejora(rs.getString("NOM_MOVIMIENTO"), rs.getInt("CONSUMO_MOVIMIENTO"), rs.getInt("DURACION_MOVIMIENTO"), Mejora.valueOf(rs.getString("BUFF_MOVIMIENTO")), rs.getInt("NIVEL_BUFF")));
                                }
                            }
                        entRival.getEquipo().get(i).setNivel(jugador.getEquipo().get(0).getNivel());
                    }
                    System.out.println("Lucharás contra " + entRival.getNombre() + " y su equipo compuesto por:\n");
                    for (Pokemon p : entRival.getEquipo()) {
                        System.out.println(p.getNombre() + " nivel " + p.getNivel());
                    }

                    Combate combate = new Combate(jugador, entRival);
                    jugador.primerPokemon();
                    entRival.primerPokemon();
                    System.out.println("Comienza " + jugador.getPrimerPokemon().getMote());
                    while(combate.getKoJugador() < combate.getJugador().getEquipo().size() || combate.getKoRival() < combate.getJugador().getEquipo().size()){
                        combate.addTurno();
                        combate.setCuantosTurnos(combate.getCuantosTurnos() + 1);
                        
                        System.out.println("Te toca, " + jugador.getNombre() + "\nLuchará " + jugador.getPrimerPokemon().getMote());
                        System.out.println("\nElige una acción:\n1. Cambiar POKEMON\n2. Usar un movimiento\n3. Huir\n");
                        numero = teclado.nextInt();
                        teclado.nextLine();
                        switch (numero){
                            case 1:
                                opt = 0;
                                System.out.println("¿Qué POKEMON luchará?");
                                for (Pokemon p : jugador.getEquipo()) {
                                    System.out.println(p.getMote() + ": " + opt);
                                    opt++;
                                }
                                numero = teclado.nextInt();
                                if(jugador.cambiarPosicionesCombate(numero) == 1){
                                    System.out.println(jugador.getEquipo().get(0).getMote() + " y " + 
                                    jugador.getEquipo().get(teclado.nextInt()).getMote() + " cambian de posición");
                                    combate.getTurnos().get(combate.getCuantosTurnos()-1).setAccionJugador(jugador.getEquipo().get(0).getMote() + " y " + 
                                    jugador.getEquipo().get(teclado.nextInt()).getMote() + " cambian de posicion");
                                    System.out.println(" ");
                                    break;
                                }else{
                                    System.out.println("No se pudo cambiar de posición a los POKEMON");
                                    combate.getTurnos().get(combate.getCuantosTurnos()-1).setAccionJugador("No se pudo cambiar de posicion a los POKEMON");
                                    System.out.println(" ");
                                    break;
                                }

                            case 2:
                                opt = 0;
                                System.out.println("Elige un movimiento:");
                                for (Movimiento m : jugador.getPrimerPokemon().getHabilidades()) {
                                    System.out.println(m.getNombreHabilidad() + ": " + opt);
                                    opt++;
                                }
                                numero = teclado.nextInt();
                                jugador.ordenPokemon(numero, entRival.getPrimerPokemon());
                                System.out.println(jugador.getPrimerPokemon().getMote() + " usó " + jugador.getPrimerPokemon().getHabilidades().get(numero).getNombreHabilidad());
                                System.out.println(entRival.getPrimerPokemon().getNombre() + ": " + 
                                entRival.getPrimerPokemon().getVitalidadActual() + " / " + entRival.getPrimerPokemon().getVitalidadMaxima());
                                combate.getTurnos().get(combate.getCuantosTurnos()-1).setAccionJugador(jugador.getPrimerPokemon().getMote() + " usa " + jugador.getPrimerPokemon().getHabilidades().get(numero).getNombreHabilidad());
                                System.out.println(" ");
                                combate.koPokemonR();
                                entRival.primerPokemon();
                                break;

                            case 3:
                                combate.huir();
                                combate.getTurnos().get(combate.getCuantosTurnos()-1).setAccionJugador("Huye!\n");
                                break;
                            
                            }
                        System.out.println("Le toca a tu RIVAL");
                        System.out.println("Luchará " + entRival.getPrimerPokemon().getNombre() + "\n");
                        combate.getRival().ordenPokemon(0, jugador.getPrimerPokemon());
                        System.out.println(entRival.getPrimerPokemon().getNombre() + " usó " + entRival.getPrimerPokemon().getHabilidades().get(0).getNombreHabilidad());
                        System.out.println(jugador.getPrimerPokemon().getMote() + ": " + 
                        jugador.getPrimerPokemon().getVitalidadActual() + " / " + jugador.getPrimerPokemon().getVitalidadMaxima());
                        combate.getTurnos().get(combate.getCuantosTurnos()-1).setAccionRival(entRival.getPrimerPokemon().getNombre() + " usó " + entRival.getPrimerPokemon().getHabilidades().get(0).getNombreHabilidad());
                        System.out.println(" ");
                        combate.koPokemonJ();
                        jugador.primerPokemon();

                        combate.logCombate();

                        if(combate.checkGanador() == true){
                            break;
                        }
                    }
                    break;

                case 5:
                    break;

                case 6:
                    for (Pokemon p : jugador.getEquipo()) {
                        System.out.println(p.getMote() + ". Vida: " + p.getVitalidadActual() + " / " + p.getVitalidadMaxima());
                    }
                    jugador.recuperacion();
                    for (Pokemon p : jugador.getEquipo()) {
                        System.out.println(p.getMote() + ". Vida: " + p.getVitalidadActual() + " / " + p.getVitalidadMaxima());
                    }
                    break;    

                case 7:
                    for (Pokemon p : jugador.getEquipo()) {
                        System.out.println(p);
                    }
                    break;
                
                case 8:
                    for (Pokemon p : jugador.getCaja()) {
                        System.out.println(p);
                    }
                    break;

                case 9:
                    System.out.println("Hasta Pronto");
                    break;
            }
        }
        teclado.close();
    }
}
