package src.modelos;

import java.util.ArrayList;
import java.util.Collections;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> equipo;
    private ArrayList<Pokemon> caja;
    private Pokemon primerPokemon;
    private int pokedollar;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<Pokemon>();
        this.caja = new ArrayList<Pokemon>();
        this.primerPokemon = null;
        this.pokedollar = (int) (Math.random() * 201 + 800);
    }

    // Para Entrenador Rival.
    public Entrenador(String nombre, ArrayList<Pokemon> equipo, Pokemon primerPokemon) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.primerPokemon = primerPokemon;
        this.pokedollar = (int) (Math.random() * 201 + 800);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getEquipo() {
        return equipo;
    }

    public ArrayList<Pokemon> getCaja() {
        return caja;
    }

    public Pokemon getPrimerPokemon() {
        return primerPokemon;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEquipo(ArrayList<Pokemon> equipo) {
        this.equipo = equipo;
    }

    public void setCaja(ArrayList<Pokemon> caja) {
        this.caja = caja;
    }

    public void setPrimerPokemon(Pokemon primerPokemon) {
        this.primerPokemon = primerPokemon;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

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

    public boolean liberarPokemon(int numero){
        if(this.getCaja().size() == 0) {
            System.out.println("No hay POKEMON en tu caja");
            return false;
        }else {
            System.out.println(this.caja.get(numero).getNombre() + " ha sido liberado.");
            this.caja.remove(numero);
            return true;
        }
    }

    public void nombrarPokemon(Pokemon pokemon, String nombre) {
        pokemon.setMote(nombre);
    }

    public boolean capturarPokemon(Pokemon pokemon) {
        int ratio = (int) (Math.random() * 3);
        if (ratio == 0) {
            return false;
        }else {
            if (this.equipo.size() == 4) {
                this.caja.add(pokemon);
                System.out.println(pokemon.getNombre() + " ha sido añadido a la caja.");
            }else {
                this.equipo.add(pokemon);
                System.out.println(pokemon.getNombre() + " ha sido añadido a tu equipo.");
            }
            return true;
        }
    }

    public void ordenPokemon(int numero, Pokemon pokemon) {
        this.primerPokemon.usarMovimiento(numero, pokemon);
    }

    public int cambiarPosicionesCombate(int numero) {
        if(this.equipo.get(numero).getVitalidadActual() <= 0){
            System.out.println("El POKEMON que quieres usar está debilitado...");
            return 0;

        }else{
            System.out.println("¡" + this.equipo.get(0).getNombre() + " regresa!");
            System.out.println("¡Sal " + this.equipo.get(numero).getNombre() + " !");
            Collections.swap(this.equipo, 0, numero);
            this.primerPokemon = this.equipo.get(0);
            return 1;
        }
        
    }
    public void cambiarPosiciones(int numeroUno, int numeroDos) {
        Collections.swap(this.equipo, numeroUno, numeroDos);
        System.out.println(this.getEquipo().get(numeroUno).getMote() + " y " + 
        this.getEquipo().get(numeroDos).getMote() + " han intercambiado posiciones.");
    }

    public void primerPokemon() {
        if (this.getEquipo().get(0).getVitalidadActual() > 0) {
            this.setPrimerPokemon(this.getEquipo().get(0));

        }else if (this.getEquipo().get(1).getVitalidadActual() > 0) {
            this.setPrimerPokemon(this.getEquipo().get(1));

        }else if (this.getEquipo().get(2).getVitalidadActual() > 0) {
            this.setPrimerPokemon(this.getEquipo().get(2));

        }else if (this.getEquipo().get(3).getVitalidadActual() > 0) {
            this.setPrimerPokemon(this.getEquipo().get(3));

        }
    }

    public void cambiarMovimientos(Movimiento habilidad) {
        this.primerPokemon.aprenderMovimiento(habilidad);
    }

    public String recuperacion(){
        this.getEquipo().get(0).descansar();
        this.getEquipo().get(1).descansar();
        this.getEquipo().get(2).descansar();
        this.getEquipo().get(3).descansar();

        return "Tu equipo esta fresco como una rosa.";
    }

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
                System.out.println("El entrenamiento se ha realizado con exito.");
                return true;
            }
        }
        else if(tipoEntrenamiento == 4){
            System.out.println("Has elegido el entrenamiento Onírico");

            if(this.getPokedollar() < this.getEquipo().get(numPokemon).getNivel() * 40){
                System.out.println("¡No tienes suficiente dinero!");
                return false;
            }
            else{
                this.getEquipo().get(numPokemon).setVelocidad(this.getEquipo().get(numPokemon).getVelocidad() + 3);
                this.getEquipo().get(numPokemon).setAtaqueEspecial(this.getEquipo().get(numPokemon).getAtaqueEspecial() + 3);
                this.getEquipo().get(numPokemon).setDefensaEspecial(this.getEquipo().get(numPokemon).getDefensaEspecial() + 3);
                this.getEquipo().get(numPokemon).setVitalidadMaxima(this.getEquipo().get(numPokemon).getVitalidadMaxima() + 3);
                System.out.println("El entrenamiento se ha realizado con exito.");
                return true;
            }
        }
        return false;
    }

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
            nombreCria = pokemonUno.getNombre().substring(1, 4) + pokemonDos.getNombre().substring(4, pokemonDos.getNombre().length());
            System.out.println("Ha nacido " + nombreCria);
            
        }
        else{
            nombreCria = pokemonDos.getNombre().substring(1, 4) + pokemonUno.getNombre().substring(4, pokemonUno.getNombre().length());
            System.out.println("Ha nacido " + nombreCria);
        }

        System.out.println(" ");

        if(aleatorio2 == 0){
            habilidadesCria.add(pokemonUno.getHabilidades().get(0));
            habilidadesCria.add(pokemonUno.getHabilidades().get(1));
            habilidadesCria.add(pokemonDos.getHabilidades().get(2));
            habilidadesCria.add(pokemonDos.getHabilidades().get(3));
            System.out.println("Con dos habilidades de " + pokemonUno.getNombre() + " y dos de " + pokemonDos.getNombre());
        }
        else{
            habilidadesCria.add(pokemonDos.getHabilidades().get(0));
            habilidadesCria.add(pokemonDos.getHabilidades().get(1));
            habilidadesCria.add(pokemonUno.getHabilidades().get(2));
            habilidadesCria.add(pokemonUno.getHabilidades().get(3));
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
        System.out.println(nombreCria + " ha sido añadido al Pc.");
    }
}