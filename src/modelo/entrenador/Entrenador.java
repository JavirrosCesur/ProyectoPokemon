package Pokemon.src.modelo.entrenador;

import java.util.ArrayList;
import java.util.Collections;

import Pokemon.src.modelo.pokemon.*;
import Pokemon.src.modelo.pokemon.movimientos.Movimiento;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> equipo;
    private ArrayList<Pokemon> caja;
    private int pokedollar;
    private Pokemon primerPokemon;

    public Entrenador(String nombre, ArrayList<Pokemon> equipo, ArrayList<Pokemon> caja, Pokemon primerPokemon) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.caja = caja;
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
        this.caja.remove(numero);
        return true;
    }

    public void nombrarPokemon(Pokemon pokemon, String nombre) {
        pokemon.setMote(nombre);
    }

    public boolean capturarPokemon(Pokemon pokemon) {
        int ratio = (int) (Math.random() * 3);
        if (ratio == 0) {
            System.out.println("El pokemon se ha escapado.");
            return false;
        } 
        
        else {
            System.out.println("Has capturado al pokemon");
            if (this.equipo.size() == 4) {
                this.caja.add(pokemon);
                System.out.println(pokemon.getNombre() + " ha sido añadido a la caja.");
            } 
            
            else {
                this.equipo.add(pokemon);
                System.out.println(pokemon.getNombre() + " ha sido añadido a tu equipo.");
            }
            System.out.println("Ponle un mote a tu pokemon: ");
            nombrarPokemon(pokemon, nombre);
            return true;
        }
    }

    public void ordenPokemon(int numero, Pokemon pokemon) {
        this.primerPokemon().usarMovimiento(numero, pokemon);
    }

    public Boolean cambiarPosiciones(int numero) {
        Collections.swap(this.equipo, 0, numero);
        return true;
    }

    public void huirCombate() {
        // llamara al metodo huir de la clase Combate
    }

    public Pokemon primerPokemon() {
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

        return primerPokemon;

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

    public boolean entrenarPokemon(int numPokemon, int cantidadPokeDollars){
        return false;
    }

    public boolean criarPokemon(int pokemonUno, int pokemonDos){
        return false;
    }
}