package modelos;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Creacion clase Entrenador 
 */
public class Entrenador {

    /**
     * Creacion de los atributos nombre, equipo, caja, pokedollar, primerPokemon
     */
    private String nombre;
    private ArrayList<Pokemon> equipo;
    private ArrayList<Pokemon> caja;
    private int pokedollar;
    private Pokemon primerPokemon;

    /**
     * Creacion del constructor Entrenador 
     * @param nombre que sera el nombre del entrenador 
     */
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<Pokemon>();
        this.caja = new ArrayList<Pokemon>();
        this.primerPokemon = null;
        this.pokedollar = (int) (Math.random() * 201 + 800);
    }

    /**
     * Metodo get de Nombre
     * @return el nombre del entrenador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo get de equipo
     * @return el equipo del entrenador 
     */
    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    /**
     * Metodo get de caja
     * @return la caja del entrenador
     */
    public ArrayList<Pokemon> getCaja() {
        return caja;
    }

    /**
     * Metodo get de primerPokemon
     * @return el primer pokemon del entrenador 
     */
    public Pokemon getPrimerPokemon() {
        return primerPokemon;
    }

    /**
     * Metodo get de pokedollar
     * @return los pokedollares del entrenador
     */
    public int getPokedollar() {
        return pokedollar;
    }

    /**
     * Metodo set de nombre
     * @param nombre que establece el nombre del entrenador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo set de equipo
     * @param equipo establece el equipo del entrenador 
     */
    public void setEquipo(ArrayList<Pokemon> equipo) {
        this.equipo = equipo;
    }

    /**
     * Metodo set de caja
     * @param caja establece la caja del entrenador
     */
    public void setCaja(ArrayList<Pokemon> caja) {
        this.caja = caja;
    }

    /**
     * Metodo set de primerPokemon
     * @param primerPokemon establece el primer pokemon
     */
    public void setPrimerPokemon(Pokemon primerPokemon) {
        this.primerPokemon = primerPokemon;
    }

    /**
     * Metodo set de pokedollar
     * @param pokedollar establece los pokedollares del entrenador
     */
    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    /**
     * Metodo boolean de dejarPokemon que servira para dejar pokemons en la caja en caso de poder
     * @param numero que hace referencia a la posicion del pokemon a elegir
     * @return si puede o no dejar un pokemon
     */
    public boolean dejarPokemon(int numero) {
        if (this.equipo.size() < 2) {
            System.out.println("No puedes tener menos de un pokemon en el equipo.");
            return false;
        }
        else {
            System.out.println("Has dejado a " + this.equipo.get(numero).getMote() + " en la caja.");
            this.caja.add(this.equipo.get(numero));
            this.equipo.remove(numero);
            return true;
        }
    }

    /**
     * Metodo boolean de sacarPokemon que servira para sacar pokemons de la caja en caso de poder
     * @param numero que es el numero que hace referencia a la posicion del pokemona elegir
     * @return si puede o no sacar al pokemon
     */
    public boolean sacarPokemon(int numero) {
        if(this.caja.size() == 0){
            System.out.println("No tienes pokemons en la caja.");
            return false;
        }
        else{
            if (this.equipo.size() == 4) {
                System.out.println("No puedes llevar mas pokemons");
                return false;
            } else if (this.equipo.size() <= 3) {
                this.equipo.add(this.caja.get(numero));
                this.caja.remove(numero);
                System.out.println(this.caja.get(numero).getMote() + " fue añadido al equipo.");
                return true;
            }
            return false;
        }
    }

    /**
     * Metodo boolean de liberarPokemon con el que eliminaremos de nuestra caja a un pokemon
     * @param numero que es el numero que hace referencia al pokemon
     * @return
     */
    public boolean liberarPokemon(int numero){
        System.out.println(this.caja.get(numero).getNombre() + " ha sido liberado.");
        this.caja.remove(numero);
        return true;
    }

    /**
     * Metodo void de nombrarPokemon con el que le pondremos un mote a nuestro pokemon
     * @param pokemon es el pokemon con el que interactuaremos
     * @param nombre es el nombre que le daremos
     */
    public void nombrarPokemon(Pokemon pokemon, String nombre) {
        pokemon.setMote(nombre);
    }

    /**
     * Metodo boolean de capturarPokemon con el que intentaremos capturar a un pokemon
     * @param pokemon es el pokemon a capturar
     * @return si ha sido o no capturado
     */
    public boolean capturarPokemon(Pokemon pokemon) {
        int ratio = (int) (Math.random() * 3);
        if (ratio == 0) {
            return false;
        } 
        
        else {
            System.out.println("¡Has capturado al pokemon!");
            if (this.equipo.size() == 4) {
                this.caja.add(pokemon);
                System.out.println(pokemon.getNombre() + " ha sido añadido a la caja.");
            } 
            
            else {
                this.equipo.add(pokemon);
                System.out.println(pokemon.getNombre() + " ha sido añadido a tu equipo.");
            }
            return true;
        }
    }

    /**
     * Metodo void de ordenPokemon que llamara al metodo usarMovimiento en la clase pokemon
     * @param numero es la posicion del movimiento en la array
     * @param pokemon es el pokemon que recibira el movimiento
     */
    public void ordenPokemon(int numero, Pokemon pokemon) {
        this.primerPokemon.usarMovimiento(numero, pokemon);
    }

    /**
     * Metodo boolean de cambiarPosiciones con el que podremos cambiar de pokemon en medio del combate
     * @param numero es la posicion del pokemon  a cambiar
     * @return el cambio efectuado 
     */
    public Boolean cambiarPosiciones(int numero) {
        if(this.equipo.get(numero).getVitalidadActual() <= 0){
            System.out.println("El POKEMON está debilitado...");
            return false;
        }else
        System.out.println("¡" + this.equipo.get(0).getNombre() + " regresa!");
        System.out.println("¡Sal " + this.equipo.get(numero).getNombre() + " !");
        Collections.swap(this.equipo, 0, numero);
        return true;
    }

    /**
     * Metodo void de primerPokemon con el que estableceremos el pokemon que se encontrara en combate y realizara las acciones
     */
    public void primerPokemon() {
        if (this.equipo.get(0).getVitalidadActual() > 0) {
            this.primerPokemon = this.equipo.get(0);
        }

        else {
            if (this.equipo.get(1).getVitalidadActual() > 0) {
                this.primerPokemon = this.equipo.get(1);
            }

            else {
                if (this.equipo.get(2).getVitalidadActual() > 0) {
                    this.primerPokemon = this.equipo.get(2);
                }

                else {
                    if (this.equipo.get(3).getVitalidadActual() > 0) {
                        this.primerPokemon = this.equipo.get(3);

                    }
                }
            }
        }
    }

    /**
     * Metodo void de cambiarMovimientos con el que llamaremos al metodo aprenderMovimiento de la clase pokemon
     * @param habilidad es la habilidad a aprender 
     */
    public void cambiarMovimientos(Movimiento habilidad) {
        this.primerPokemon.aprenderMovimiento(habilidad);
    }

    /**
     * Metodo String de recuperacion con el que recuperaremos la salud de nuestro equipo llamando al metodo descansar de la clase pokemon
     * @return la recuperacion de tu equipo
     */
    public String recuperacion(){
        this.getEquipo().get(0).descansar();
        this.getEquipo().get(1).descansar();
        this.getEquipo().get(2).descansar();
        this.getEquipo().get(3).descansar();

        return "Tu equipo esta fresco como una rosa.";
    }

    /**
     * Metodo boolean de entrenarPokemon que sirve para entrenar a tu pokemon
     * @param tipoEntrenamiento
     * @param numPokemon
     * @return
     */
    public boolean entrenarPokemon(int tipoEntrenamiento, int numPokemon){
    
        if(tipoEntrenamiento == 1){
            System.out.println("Has elegido el entrenamiento Pesado.");

            if(this.getPokedollar() < this.getEquipo().get(numPokemon).getNivel() * 20){
                System.out.println("¡No tienes suficiente dinero!");
                return false;
            }
            else{
                this.getEquipo().get(numPokemon).setDefensa(getEquipo().get(numPokemon).getDefensa() + 3);
                this.getEquipo().get(numPokemon).setDefensaEspecial(getEquipo().get(numPokemon).getDefensaEspecial() + 3);
                this.getEquipo().get(numPokemon).setVitalidadMaxima(getEquipo().get(numPokemon).getVitalidadMaxima() + 3);
                System.out.println("El entrenamiento se ha realizado con exito.");
                return true;
            }
        }
        else if(tipoEntrenamiento == 2){
            System.out.println("Has elegido el entrenamiento Furioso");

            if(this.getPokedollar() < this.getEquipo().get(numPokemon).getNivel() * 30){
                System.out.println("¡No tienes suficiente dinero!");
                return false;
            }
            else{
                this.getEquipo().get(numPokemon).setAtaque(getEquipo().get(numPokemon).getAtaque() + 3);
                this.getEquipo().get(numPokemon).setAtaqueEspecial(getEquipo().get(numPokemon).getAtaqueEspecial() + 3);
                this.getEquipo().get(numPokemon).setVelocidad(getEquipo().get(numPokemon).getVelocidad() + 3);
                System.out.println("El entrenamiento se ha realizado con exito.");
                return true;
            }
        }
        else if(tipoEntrenamiento == 3){
            System.out.println("Has elegido el entrenameinto Funcional");

            if(this.getPokedollar() < this.getEquipo().get(numPokemon).getNivel() * 40){
                System.out.println("¡No tienes suficiente dinero!");
                return false;
            }
            else{
                this.getEquipo().get(numPokemon).setVelocidad(this.getEquipo().get(numPokemon).getVelocidad() + 3);
                this.getEquipo().get(numPokemon).setAtaque(this.getEquipo().get(numPokemon).getAtaque() + 3);
                this.getEquipo().get(numPokemon).setDefensa(this.getEquipo().get(numPokemon).getDefensa() + 3);
                this.getEquipo().get(numPokemon).setVitalidadMaxima(this.getEquipo().get(numPokemon).getVitalidadMaxima() + 3);
                System.out.println("El entrenamiento se ha realizdo con exito.");
                return true;
            }
        }
        else if(tipoEntrenamiento == 4){
            System.out.println("Has elegido el entrenamiento Onirico");

            if(this.getPokedollar() < this.getEquipo().get(numPokemon).getNivel() * 40){
                System.out.println("¡No tienes suficiente dinero!");
                return false;
            }
            else{
                this.getEquipo().get(numPokemon).setVelocidad(this.getEquipo().get(numPokemon).getVelocidad() + 3);
                this.getEquipo().get(numPokemon).setAtaqueEspecial(this.getEquipo().get(numPokemon).getAtaqueEspecial() + 3);
                this.getEquipo().get(numPokemon).setDefensaEspecial(this.getEquipo().get(numPokemon).getDefensaEspecial() + 3);
                this.getEquipo().get(numPokemon).setVitalidadMaxima(this.getEquipo().get(numPokemon).getVitalidadMaxima() + 3);
                System.out.println("El entrenamiento se ha realizdo con exito.");
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo void de criarPokemon para criar un nuevo pokemon
     * @param pokemonUno es el padre del pokemon
     * @param pokemonDos es la madre del pokemon
     */
    public void criarPokemon(Pokemon pokemonUno, Pokemon pokemonDos){
        System.out.println(pokemonUno.getNombre() + " y " + pokemonDos.getNombre() + " han procedido a criar, dando lugar al siguiente bicho:");
        System.out.println("");

        pokemonUno.setFertilidad(pokemonUno.getFertilidad() - 1);
        pokemonDos.setFertilidad(pokemonDos.getFertilidad() - 1);

        Pokemon cria = null;
        int aleatorio1 = (int)(Math.random() * 2);
        int aleatorio2 = (int)(Math.random() * 2);
        int aleatorio3 = (int)(Math.random() * 4);
        int aleatorio4 = (int)(Math.random() * 2);
        
        String nombreCria;
        int vitalidadCria;
        int estaminaCria;
        int ataqueFCria;
        int defensaFCria;
        int ataqueECria;
        int defensaECria;
        int velocidadCria;
        Genero generoCria;
        Tipo tipo1Cria;
        Tipo tipo2Cria;
        ArrayList<Movimiento> habilidadesCria = new ArrayList<>();

        if(aleatorio1 == 0){
            nombreCria = pokemonUno.getNombre().substring(1, 3) + pokemonDos.getNombre().substring(4, pokemonDos.getNombre().length());
            System.out.println("Ha nacido " + nombreCria);
            
        }
        else{
            nombreCria = pokemonDos.getNombre().substring(1, 3) + pokemonUno.getNombre().substring(4, pokemonUno.getNombre().length());
            System.out.println("Ha nacido " + nombreCria);
        }

        System.out.println(" ");

        if(aleatorio2 == 0){
            habilidadesCria.add(pokemonUno.getHabilidades().get(0));
            habilidadesCria.add(pokemonUno.getHabilidades().get(1));
            habilidadesCria.add(pokemonDos.getHabilidades().get(0));
            habilidadesCria.add(pokemonDos.getHabilidades().get(1));
            System.out.println("Con dos habilidades de " + pokemonUno.getNombre() + " y dos de " + pokemonDos.getNombre());
        }
        else{
            habilidadesCria.add(pokemonDos.getHabilidades().get(0));
            habilidadesCria.add(pokemonDos.getHabilidades().get(1));
            habilidadesCria.add(pokemonUno.getHabilidades().get(0));
            habilidadesCria.add(pokemonUno.getHabilidades().get(1));
            System.out.println("Con dos habilidades de " + pokemonDos.getNombre() + " y dos de " + pokemonUno.getNombre());
        }

        System.out.println(" ");

        if(aleatorio3 == 0){
            if(pokemonUno.getTipo2() != Tipo.NINGUNO){
                tipo1Cria = pokemonUno.getTipo1();
                tipo2Cria = pokemonUno.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " y " + tipo2Cria + " de su Padre");
            }

            else{
                tipo1Cria = pokemonUno.getTipo1();
                tipo2Cria = pokemonDos.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " de su Padre y " + tipo2Cria + " de su Madre");
            } 
        }
        else if(aleatorio3 == 1){
            if(pokemonDos.getTipo2() != Tipo.NINGUNO){
                tipo1Cria = pokemonDos.getTipo1();
                tipo2Cria = pokemonDos.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " y " + tipo2Cria + " de su Madre");
            }
            else{
                tipo1Cria = pokemonDos.getTipo1();
                tipo2Cria = pokemonUno.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " de su Madre y " + tipo2Cria + " de su Padre");
            }
        }
        else if(aleatorio3 == 2){
            if(pokemonDos.getTipo2() != Tipo.NINGUNO){
                tipo1Cria = pokemonUno.getTipo1();
                tipo2Cria = pokemonDos.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " de su Padre y " + tipo2Cria + " de su Madre");
            }
            else{
                tipo1Cria = pokemonUno.getTipo1();
                tipo2Cria = pokemonUno.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " y " + tipo2Cria + " de su Padre");
            }
           
        }
        else{
            if(pokemonUno.getTipo1() != Tipo.NINGUNO){
                tipo1Cria = pokemonDos.getTipo1();
                tipo2Cria = pokemonUno.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " de su Madre y " + tipo2Cria + " de su Padre");
            }
            else{
                tipo1Cria = pokemonDos.getTipo1();
                tipo2Cria = pokemonDos.getTipo2();
                System.out.println(nombreCria + " ha heredado los tipos " + tipo1Cria + " y " + tipo2Cria + " de su Madre");
            }
            
        }

        if(tipo1Cria == tipo2Cria){
            tipo2Cria = Tipo.NINGUNO;
        }
        
        System.out.println(" ");

        if(aleatorio4 == 0){
            generoCria = pokemonUno.getGenero();
            System.out.println("El genero de " + nombreCria + " es " + generoCria);
        }
        else{
            generoCria = pokemonDos.getGenero();
            System.out.println("El genero de " + nombreCria + " es " + generoCria);
        }

        if(pokemonUno.getVitalidadMaxima() > pokemonDos.getVitalidadMaxima()){
            vitalidadCria = pokemonUno.getVitalidadMaxima();
        }
        else{
            vitalidadCria = pokemonDos.getVitalidadMaxima();
        }
        if(pokemonUno.getEstaminaMaxima() > pokemonDos.getEstaminaMaxima()){
            estaminaCria = pokemonUno.getEstaminaMaxima();
        }
        else{
            estaminaCria = pokemonDos.getEstaminaMaxima();
        }
        if(pokemonUno.getAtaque() > pokemonDos.getAtaque()){
            ataqueFCria = pokemonUno.getAtaque();
        }
        else{
            ataqueFCria = pokemonDos.getAtaque();
        }
        if(pokemonUno.getDefensa() > pokemonDos.getDefensa()){
            defensaFCria = pokemonUno.getDefensa();
        }
        else{
            defensaFCria = pokemonDos.getDefensa();
        }
        if(pokemonUno.getAtaqueEspecial() > pokemonDos.getAtaqueEspecial()){
            ataqueECria = pokemonUno.getAtaqueEspecial();
        }
        else{
            ataqueECria = pokemonDos.getAtaqueEspecial();
        }
        if(pokemonUno.getDefensaEspecial() > pokemonDos.getDefensaEspecial()){
            defensaECria = pokemonUno.getDefensaEspecial();
        }
        else{
            defensaECria = pokemonDos.getDefensaEspecial();
        }
        if(pokemonUno.getVelocidad() > pokemonDos.getVelocidad()){
            velocidadCria = pokemonUno.getVelocidad();
        }
        else{
            velocidadCria = pokemonDos.getVelocidad();
        }
        System.out.println(nombreCria + " ha heredado las siguientes estadisticas: ");
        System.out.println(" ");
        System.out.println("1.Vitalidad = " + vitalidadCria);
        System.out.println("2.Estamina = " + estaminaCria);
        System.out.println("3.Ataque = " + ataqueFCria);
        System.out.println("4.Defensa = " + defensaFCria);
        System.out.println("5.Ataque Especial = " + ataqueECria);
        System.out.println("6.Defensa Especial = " + defensaECria);
        System.out.println("7.Velocidad = " + velocidadCria);

        cria = new Pokemon(nombreCria, vitalidadCria, ataqueFCria, defensaFCria, ataqueECria, defensaECria, velocidadCria, tipo1Cria, tipo2Cria);
        cria.setEstaminaMaxima(estaminaCria);
        cria.setGenero(generoCria);
        cria.setHabilidades(habilidadesCria);
        caja.add(cria);
        System.out.println(nombreCria + " ha sido añadido al Pc.\n");

    }
        
        
}