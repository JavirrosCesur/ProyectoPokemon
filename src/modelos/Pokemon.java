package src.modelos;

import java.util.ArrayList;

public class Pokemon {

    private String nombre;
    private String mote;
    private int nivel;
    private int experiencia;
    private int vitalidadMaxima;
    private int vitalidadActual;
    private int estaminaMaxima;
    private int estaminaActual;
    private int ataque;
    private int ataqueMejora;
    private int defensa;
    private int defensaMejora;
    private int ataqueEspecial;
    private int ataqueEspecialMejora;
    private int defensaEspecial;
    private int defensaEspecialMejora;
    private int velocidad;
    private int velocidadMejora;
    private int fertilidad;
    private Genero genero;
    private Tipo tipo1;
    private Tipo tipo2;
    private EstadoPrincipal estadoPrincipal;
    private int contadorEstadoP;
    private Mejora mejora1;
    private Mejora mejora2;
    private int contadorMejoraAtaque;
    private int contadorMejoraDefensa;
    private int contadorMejoraAtEspecial;
    private int contadorMejoraDefEspecial;
    private int contadorMejoraVelocidad;
    private ArrayList<Movimiento> habilidades;

    public Pokemon(String nombre, int vitalidadMaxima, int ataque, int defensa, 
    int ataqueEspecial, int defensaEspecial, int velocidad, Tipo tipo1, Tipo tipo2){
        this.nombre = nombre;
        this.mote = new String();
        this.nivel = 1;
        this.experiencia = 0;
        this.vitalidadMaxima = vitalidadMaxima;
        this.vitalidadActual = vitalidadMaxima;
        this.estaminaMaxima = 100;
        this.estaminaActual = estaminaMaxima;
        this.ataque = ataque;
        this.ataqueMejora = this.ataque; // TODOS los atributos Mejora se igualan a los "originales".
        this.defensa = defensa;
        this.defensaMejora = this.defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.ataqueEspecialMejora = this.ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.defensaEspecialMejora = this.defensaEspecial;
        this.velocidad = velocidad;
        this.velocidadMejora = this.velocidad;
        this.fertilidad = 5;
        this.genero = this.iniciarGenero();
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.estadoPrincipal = EstadoPrincipal.NINGUNO;
        this.contadorEstadoP = 0;
        this.mejora1 = Mejora.NINGUNO;
        this.mejora2 = Mejora.NINGUNO;
        this.contadorMejoraAtaque = 0;
        this.contadorMejoraDefensa = 0;
        this.contadorMejoraAtEspecial = 0;
        this.contadorMejoraDefEspecial = 0;
        this.contadorMejoraVelocidad = 0;
        this.habilidades = new ArrayList<Movimiento>();
    }

    public String getNombre() {
        return nombre;
    }
    public String getMote() {
        return mote;
    }
    public int getNivel() {
        return nivel;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public int getVitalidadMaxima() {
        return vitalidadMaxima;
    }
    public int getVitalidadActual() {
        return vitalidadActual;
    }
    public int getEstaminaMaxima() {
        return estaminaMaxima;
    }
    public int getEstaminaActual() {
        return estaminaActual;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getAtaqueMejora() {
        return ataqueMejora;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getDefensaMejora() {
        return defensaMejora;
    }
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
    public int getAtaqueEspecialMejora() {
        return ataqueEspecialMejora;
    }
    public int getDefensaEspecial() {
        return defensaEspecial;
    }
    public int getDefensaEspecialMejora() {
        return defensaEspecialMejora;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public int getVelocidadMejora() {
        return velocidadMejora;
    }
    public int getFertilidad() {
        return fertilidad;
    }
    public Genero getGenero() {
        return genero;
    }
    public Tipo getTipo1() {
        return tipo1;
    }
    public Tipo getTipo2() {
        return tipo2;
    }
    public EstadoPrincipal getEstadoPrincipal() {
        return estadoPrincipal;
    }
    public int getContadorEstadoP() {
        return contadorEstadoP;
    }
    public Mejora getMejora1() {
        return mejora1;
    }
    public Mejora getMejora2() {
        return mejora2;
    }
    public int getContadorMejoraAtaque() {
        return contadorMejoraAtaque;
    }
    public int getContadorMejoraDefensa() {
        return contadorMejoraDefensa;
    }
    public int getContadorMejoraAtEspecial() {
        return contadorMejoraAtEspecial;
    }
    public int getContadorMejoraDefEspecial() {
        return contadorMejoraDefEspecial;
    }
    public int getContadorMejoraVelocidad() {
        return contadorMejoraVelocidad;
    }
    public ArrayList<Movimiento> getHabilidades() {
        return habilidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setMote(String mote) {
        this.mote = mote;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /* Métodos necesarios para subir a un POKEMON rival al nivel del nuestro, si es nivel 2 o superior, aumentando
    los valores de atributo aleatorios tantas veces como niveles tenga el POKEMON.*/
    public int subirVitalidad(int nivel){
        int sumaVitalidad = 0;
        if(nivel == 1){
            sumaVitalidad = 0;
        }else{
            for (int i = 2; i <= nivel; i++) {
                sumaVitalidad += (int) (Math.random() * 3 + 3);
            }
        }
        return sumaVitalidad;
    }
    public int subirEstamina(int nivel) {
        int sumaEstamina = 0;
        if(nivel == 1){
            sumaEstamina = 0;
        }else {
            for (int i = 2; i <= nivel; i++) {
                sumaEstamina += (int) (Math.random() * 3 + 1);
            }
        }
        return sumaEstamina;
    }
    public int subirAtributos(int nivel) {
        int sumaAtributos = 0;
        if(nivel == 1){
            sumaAtributos = 0;
        }else {
            for (int i = 2; i <= nivel; i++) {
                sumaAtributos += (int) (Math.random() * 4 + 1);
            }
        }
        return sumaAtributos;
    }

    // Método nivelarNivel, en el que introducimos los métodos anteriores, resultando los valores finales.
    public void nivelarNivel(int nivel){
        this.setVitalidadMaxima(this.vitalidadMaxima + this.subirVitalidad(nivel));
        this.setEstaminaMaxima(this.estaminaMaxima + this.subirEstamina(nivel));
        this.setAtaque(this.ataque + this.subirAtributos(nivel));
        this.setDefensa(this.defensa + this.subirAtributos(nivel));
        this.setAtaqueEspecial(this.ataqueEspecial + this.subirAtributos(nivel));
        this.setDefensaEspecial(this.defensaEspecial + this.subirAtributos(nivel));
        this.setVelocidad(this.velocidad + this.subirAtributos(nivel));
    }

    /* Método setNivel implementando los métodos anteriores comentados y dando un valor válido a la experiencia.
    Sólo se usará en Pokemon salvajes o de Entrenadores rivales... o para hacer trampa.*/
    public void subirNivel(int nivel) {
        this.setNivel(nivel);
        this.nivelarNivel(nivel);
        this.setExperiencia(((this.nivel - 1) * 10) + 1);
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public void setVitalidadMaxima(int vitalidadMaxima) {
        this.vitalidadMaxima = vitalidadMaxima;
    }

    public void setVitalidadActual(int vitalidadActual) {
        this.vitalidadActual = vitalidadActual;
        this.gestionarVitalidad(); // Método de control explicado más abajo.
    }

    public void setEstaminaMaxima(int estaminaMaxima) {
        this.estaminaMaxima = estaminaMaxima;
    }

    public void setEstaminaActual(int estaminaActual) {
        this.estaminaActual = estaminaActual;
        this.gestionarEstamina(); // Método de control explicado más abajo.
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
        this.ataqueMejora = this.ataque;
    }
    public void setAtaqueMejora(int ataqueMejora) {
        this.ataqueMejora = ataqueMejora;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
        this.defensaMejora = this.defensa;
    }
    public void setDefensaMejora(int defensaMejora) {
        this.defensaMejora = defensaMejora;
    }
    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
        this.ataqueEspecialMejora = this.ataqueEspecial;
    }
    public void setAtaqueEspecialMejora(int ataqueEspecialMejora) {
        this.ataqueEspecialMejora = ataqueEspecialMejora;
    }
    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
        this.defensaEspecialMejora = this.defensaEspecial;
    }
    public void setDefensaEspecialMejora(int defensaEspecialMejora) {
        this.defensaEspecialMejora = defensaEspecialMejora;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        this.velocidadMejora = this.velocidad;
    }
    public void setVelocidadMejora(int velocidadMejora) {
        this.velocidadMejora = velocidadMejora;
    }
    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Genero iniciarGenero() { // Para el constructor.
        int randomGen = (int)(Math.random()*2);
        if (randomGen == 0) {
            return Genero.HEMBRA;
        }else {
            return Genero.MACHO;
        }
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }
    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }
    public void setEstadoPrincipal(EstadoPrincipal estadoPrincipal) {
        this.estadoPrincipal = estadoPrincipal;
    }
    public void setContadorEstadoP(int contadorEstadoP) {
        this.contadorEstadoP = contadorEstadoP;
    }
    public void setMejora1(Mejora mejora1) {
        this.mejora1 = mejora1;
    }
    public void setMejora2(Mejora mejora2) {
        this.mejora2 = mejora2;
    }
    public void setContadorMejoraAtaque(int contadorMejoraAtaque) {
        this.contadorMejoraAtaque = contadorMejoraAtaque;
    }
    public void setContadorMejoraDefensa(int contadorMejoraDefensa) {
        this.contadorMejoraDefensa = contadorMejoraDefensa;
    }
    public void setContadorMejoraAtEspecial(int contadorMejoraAtEspecial) {
        this.contadorMejoraAtEspecial = contadorMejoraAtEspecial;
    }
    public void setContadorMejoraDefEspecial(int contadorMejoraDefEspecial) {
        this.contadorMejoraDefEspecial = contadorMejoraDefEspecial;
    }
    public void setContadorMejoraVelocidad(int contadorMejoraVelocidad) {
        this.contadorMejoraVelocidad = contadorMejoraVelocidad;
    }
    public void setHabilidades(ArrayList<Movimiento> habilidades) {
        this.habilidades = habilidades;
    }

    // toString de Pokemon para enseñarlo en el equipo.
    @Override
    public String toString() {
        return this.getMote() + ": " + this.getNombre() + " " + this.getGenero().toString().toLowerCase() + 
        " de nivel " + this.getNivel() + "\nTipo: " + this.getTipo1().toString() + ", " + this.getTipo2().toString() + 
        "\nVitalidad: " + this.getVitalidadActual() + "/" + this.getVitalidadMaxima() + "\nAtaque: " + this.getAtaque() + 
        "  - Defensa: " + this.getDefensa() + "\nAtaque Especial: " + this.getAtaqueEspecial() + "  - Defensa Especial: " + 
        this.getDefensaEspecial() + "\nVelocidad: " + this.getVelocidad() + "  - Fertilidad: " + this.getFertilidad() + "\n";
    }

    // Método ganarExperiencia para un uso adecuado de ésta. Implementa el método subirDeNivel, explicado abajo.
    public void ganarExperiencia(int cantidadExperiencia){
        this.setExperiencia(this.experiencia + cantidadExperiencia);
        this.subirDeNivel();
    }

    /* Método subirDeNivel, aplicando los algoritmos necesarios para la subida de nivel tras ganar experiencia.
    A diferencia de setNivel y nivelarNivel, este método se usa para los POKEMON del jugador, para su desarrollo "normal"
    tras un combate o un entrenamiento. Incluye información para el jugador sobre los aumentos de estadísticas.*/
    public boolean subirDeNivel(){
        if(this.experiencia < (this.nivel * 10)){
            return false;
        }else{
            System.out.println("¡Tu POKEMON ha subido de nivel!");
            this.nivel++;

            int subida;
            subida = (int)(Math.random()*3+3);
            System.out.println("Vitalidad + " + subida);
            this.setVitalidadMaxima(this.vitalidadMaxima + subida);

            subida = (int) (Math.random() * 3 + 1);
            System.out.println("Estamina + " + subida);
            this.setEstaminaMaxima(this.estaminaMaxima + subida);

            subida = (int) (Math.random() * 4 + 1);
            System.out.println("Ataque + " + subida);
            this.setAtaque(this.ataque + subida);

            subida = (int) (Math.random() * 4 + 1);
            System.out.println("Defensa + " + subida);
            this.setDefensa(this.defensa + subida);

            subida = (int) (Math.random() * 4 + 1);
            System.out.println("Ataque especial + " + subida);
            this.setAtaqueEspecial(this.ataqueEspecial + subida);

            subida = (int) (Math.random() * 4 + 1);
            System.out.println("Defensa especial + " + subida);
            this.setDefensaEspecial(this.defensaEspecial + subida);

            subida = (int) (Math.random() * 4 + 1);
            System.out.println("Velocidad + " + subida);
            this.setVelocidad(this.velocidad + subida);

            return true;
        }
    }

    // Método para gestionar la vitalidadActual de los POKEMON.
    public void gestionarVitalidad(){
        if(this.vitalidadActual <= 0){
            this.vitalidadActual = 0;
        }else if(this.vitalidadActual > this.vitalidadMaxima){
            this.vitalidadActual = this.vitalidadMaxima;
        }
    }

    // Método para gestionar la estaminaActual de los POKEMON.
    public void gestionarEstamina(){
        if(this.estaminaActual <= 0){
            this.estaminaActual = 0;
        }else if(this.estaminaActual > this.estaminaMaxima){
            this.estaminaActual = this.estaminaMaxima;
        }
    }

    // Método resultadoMovimientoAtaque para resolver habilidades de la clase MovimientoAtaque.
    public void resultadoMovimientoAtaque(int numHab, Pokemon pokemon){
        if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo1() == Tipo.ACERO || pokemon.getTipo1() == Tipo.AGUA
        || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.FUEGO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo1() == Tipo.HADA || pokemon.getTipo1() == Tipo.HIELO
        || pokemon.getTipo1() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo1() == Tipo.AGUA || pokemon.getTipo1() == Tipo.DRAGON
        || pokemon.getTipo1() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.ROCA
        || pokemon.getTipo1() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);
            
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.FANTASMA || pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.HADA
        || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.VENENO || pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);
        
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo1() == Tipo.PLANTA
        || pokemon.getTipo1() == Tipo.PSIQUICO || pokemon.getTipo1() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo1() == Tipo.HADA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo1() == Tipo.ACERO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo1() == Tipo.DRAGON){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo1() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo1() == Tipo.DRAGON
        || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo1() == Tipo.AGUA
        || pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo1() == Tipo.NORMAL){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo1() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo1() == Tipo.FANTASMA
        || pokemon.getTipo1() == Tipo.PSIQUICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo1() == Tipo.AGUA
        || pokemon.getTipo1() == Tipo.DRAGON || pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.BICHO || pokemon.getTipo1() == Tipo.HIELO || pokemon.getTipo1() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HADA && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HADA && pokemon.getTipo1() == Tipo.DRAGON
        || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.AGUA || pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.HIELO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo1() == Tipo.DRAGON
        || pokemon.getTipo1() == Tipo.PLANTA || pokemon.getTipo1() == Tipo.TIERRA || pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);
            
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo1() == Tipo.FANTASMA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo1() == Tipo.BICHO
        || pokemon.getTipo1() == Tipo.HADA || pokemon.getTipo1() == Tipo.PSIQUICO || pokemon.getTipo1() == Tipo.VENENO
        || pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.HIELO || pokemon.getTipo1() == Tipo.NORMAL || pokemon.getTipo1() == Tipo.ROCA
        || pokemon.getTipo1() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo1() == Tipo.FANTASMA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.BICHO || pokemon.getTipo1() == Tipo.DRAGON || pokemon.getTipo1() == Tipo.FUEGO
        || pokemon.getTipo1() == Tipo.PLANTA || pokemon.getTipo1() == Tipo.VENENO || pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo1() == Tipo.AGUA
        || pokemon.getTipo1() == Tipo.ROCA || pokemon.getTipo1() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo1() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.PSIQUICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo1() == Tipo.LUCHA
        || pokemon.getTipo1() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo1() == Tipo.ACERO || pokemon.getTipo1() == Tipo.LUCHA
        || pokemon.getTipo1() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo1() == Tipo.BICHO || pokemon.getTipo1() == Tipo.FUEGO
        || pokemon.getTipo1() == Tipo.HIELO || pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo1() == Tipo.HADA
        || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo1() == Tipo.FANTASMA
        || pokemon.getTipo1() == Tipo.PSIQUICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo1() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo1() == Tipo.BICHO
        || pokemon.getTipo1() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.ROCA
        || pokemon.getTipo1() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo1() == Tipo.ACERO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo1() == Tipo.FANTASMA
        || pokemon.getTipo1() == Tipo.ROCA || pokemon.getTipo1() == Tipo.TIERRA || pokemon.getTipo1() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo1() == Tipo.HADA
        || pokemon.getTipo1() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo1() == Tipo.ACERO
        || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo1() == Tipo.BICHO
        || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(2f);

        }else{
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja1(1f);
        }

        if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo2() == Tipo.ACERO || pokemon.getTipo2() == Tipo.AGUA
        || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.FUEGO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo2() == Tipo.HADA || pokemon.getTipo2() == Tipo.HIELO
        || pokemon.getTipo2() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo2() == Tipo.AGUA || pokemon.getTipo2() == Tipo.DRAGON
        || pokemon.getTipo2() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.ROCA
        || pokemon.getTipo2() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);
            
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.FANTASMA || pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.HADA
        || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.VENENO || pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);
        
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo2() == Tipo.PLANTA
        || pokemon.getTipo2() == Tipo.PSIQUICO || pokemon.getTipo2() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo2() == Tipo.HADA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo2() == Tipo.ACERO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo2() == Tipo.DRAGON){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo2() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo2() == Tipo.DRAGON
        || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo2() == Tipo.AGUA
        || pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo2() == Tipo.NORMAL){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo2() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo2() == Tipo.FANTASMA
        || pokemon.getTipo2() == Tipo.PSIQUICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo2() == Tipo.AGUA
        || pokemon.getTipo2() == Tipo.DRAGON || pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.BICHO || pokemon.getTipo2() == Tipo.HIELO || pokemon.getTipo2() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HADA && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HADA && pokemon.getTipo2() == Tipo.DRAGON
        || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.AGUA || pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.HIELO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo2() == Tipo.DRAGON
        || pokemon.getTipo2() == Tipo.PLANTA || pokemon.getTipo2() == Tipo.TIERRA || pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);
            
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo2() == Tipo.FANTASMA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo2() == Tipo.BICHO
        || pokemon.getTipo2() == Tipo.HADA || pokemon.getTipo2() == Tipo.PSIQUICO || pokemon.getTipo2() == Tipo.VENENO
        || pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.HIELO || pokemon.getTipo2() == Tipo.NORMAL || pokemon.getTipo2() == Tipo.ROCA
        || pokemon.getTipo2() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo2() == Tipo.FANTASMA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.BICHO || pokemon.getTipo2() == Tipo.DRAGON || pokemon.getTipo2() == Tipo.FUEGO
        || pokemon.getTipo2() == Tipo.PLANTA || pokemon.getTipo2() == Tipo.VENENO || pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo2() == Tipo.AGUA
        || pokemon.getTipo2() == Tipo.ROCA || pokemon.getTipo2() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo2() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.PSIQUICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo2() == Tipo.LUCHA
        || pokemon.getTipo2() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo2() == Tipo.ACERO || pokemon.getTipo2() == Tipo.LUCHA
        || pokemon.getTipo2() == Tipo.TIERRA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo2() == Tipo.BICHO || pokemon.getTipo2() == Tipo.FUEGO
        || pokemon.getTipo2() == Tipo.HIELO || pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo2() == Tipo.HADA
        || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.SINIESTRO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo2() == Tipo.FANTASMA
        || pokemon.getTipo2() == Tipo.PSIQUICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo2() == Tipo.VOLADOR){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo2() == Tipo.BICHO
        || pokemon.getTipo2() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.ROCA
        || pokemon.getTipo2() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo2() == Tipo.ACERO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo2() == Tipo.FANTASMA
        || pokemon.getTipo2() == Tipo.ROCA || pokemon.getTipo2() == Tipo.TIERRA || pokemon.getTipo2() == Tipo.VENENO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo2() == Tipo.HADA
        || pokemon.getTipo2() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo2() == Tipo.ACERO
        || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.ROCA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(0.5f);

        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo2() == Tipo.BICHO
        || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.PLANTA){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(2f);

        }else{
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentaja2(1f);
        }

        ((MovimientoAtaque) this.getHabilidades().get(numHab)).setVentajaTotal(((MovimientoAtaque) this.getHabilidades().get(numHab)).getVentaja1() * ((MovimientoAtaque) this.getHabilidades().get(numHab)).getVentaja2());
        if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getVentajaTotal() < 1){
            System.out.println("No es efectivo.");
        }else if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getVentajaTotal() > 1){
            System.out.println("¡Es súper efectivo!");
        }

        if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getFisEsp() == FisicoEspecial.FISICO){
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setDanyo((int)(((MovimientoAtaque) this.getHabilidades().get(numHab)).getPotencia() * ((MovimientoAtaque) this.getHabilidades().get(numHab)).getVentajaTotal() + this.getAtaqueMejora()));
            if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getDanyo() - pokemon.getDefensaMejora() > 0){
                pokemon.setVitalidadActual(pokemon.getVitalidadActual() - 
                (((MovimientoAtaque) this.getHabilidades().get(numHab)).getDanyo() - pokemon.getDefensaMejora()));
            }

        }else{
            ((MovimientoAtaque) this.getHabilidades().get(numHab)).setDanyo((int)(((MovimientoAtaque) this.getHabilidades().get(numHab)).getPotencia() * ((MovimientoAtaque) this.getHabilidades().get(numHab)).getVentajaTotal() + this.getAtaqueEspecialMejora()));
            if(((MovimientoAtaque) this.getHabilidades().get(numHab)).getDanyo() - pokemon.getDefensaEspecialMejora() >  0){
                pokemon.setVitalidadActual(pokemon.getVitalidadActual() - 
                (((MovimientoAtaque) this.getHabilidades().get(numHab)).getDanyo() - pokemon.getDefensaEspecialMejora()));
            }
        }

        ((MovimientoAtaque) this.getHabilidades().get(numHab)).resetVentajas();
    }

    // Método resultadoMovimientoEstado para resolver habilidades de la clase MovimientoEstado.
    public void resultadoMovimientoEstado(int numHab, Pokemon pokemon){
        if(((MovimientoEstado) this.getHabilidades().get(numHab)).getEstadoPrincipal() == EstadoPrincipal.CONGELADO && pokemon.getTipo1() == Tipo.HIELO
        || pokemon.getTipo2() == Tipo.HIELO){
            System.out.println("No es efectivo.");

        }else if(((MovimientoEstado) this.getHabilidades().get(numHab)).getEstadoPrincipal() == EstadoPrincipal.ENVENENADO && pokemon.getTipo1() == Tipo.VENENO
        || pokemon.getTipo2() == Tipo.VENENO || pokemon.getTipo1() == Tipo.ACERO || pokemon.getTipo2() == Tipo.ACERO){
            System.out.println("No es efectivo.");

        }else if(((MovimientoEstado) this.getHabilidades().get(numHab)).getEstadoPrincipal() == EstadoPrincipal.PARALIZADO && pokemon.getTipo1() == Tipo.ELECTRICO
        || pokemon.getTipo2() == Tipo.ELECTRICO){
            System.out.println("No es efectivo.");

        }else if(((MovimientoEstado) this.getHabilidades().get(numHab)).getEstadoPrincipal() == EstadoPrincipal.QUEMADO && pokemon.getTipo1() == Tipo.FUEGO
        || pokemon.getTipo2() == Tipo.FUEGO){
            System.out.println("No es efectivo.");

        }else{
                pokemon.setEstadoPrincipal(((MovimientoEstado) this.getHabilidades().get(numHab)).getEstadoPrincipal());
                pokemon.setContadorEstadoP(((MovimientoEstado) this.getHabilidades().get(numHab)).getDuracion());
        }
    }

    // Método resultadoMovimientoMejora para resolver habilidades de la clase MovimientoMejora.
    public void resultadoMovimientoMejora(int numHab){
        if(((MovimientoMejora) this.getHabilidades().get(numHab)).getBuff() == Mejora.ATAQUE_FISICO){
            if(((MovimientoMejora) this.getHabilidades().get(numHab)).getNivelDeBuff() == 2){
                this.setAtaqueMejora((int)(this.ataqueMejora * 1.4));
            }else{
                this.setAtaqueMejora((int)(this.ataqueMejora * 1.2));
            }
            this.setContadorMejoraAtaque(((MovimientoMejora) this.getHabilidades().get(numHab)).getDuracion());
            System.out.println("El Ataque de " + this.getMote() + " subió.");
            
        }else if(((MovimientoMejora) this.getHabilidades().get(numHab)).getBuff() == Mejora.ATAQUE_ESPECIAL){
            if(((MovimientoMejora) this.getHabilidades().get(numHab)).getNivelDeBuff() == 2){
                this.setAtaqueEspecialMejora((int)(this.ataqueEspecialMejora * 1.4));
            }else{
                this.setAtaqueEspecialMejora((int)(this.ataqueEspecialMejora * 1.2));
            }
            this.setContadorMejoraAtEspecial(((MovimientoMejora) this.getHabilidades().get(numHab)).getDuracion());
            System.out.println("El Ataque Especial de " + this.getMote() + " subió.");

        }else if(((MovimientoMejora) this.getHabilidades().get(numHab)).getBuff() == Mejora.DEFENSA_FISICA){
            if(((MovimientoMejora) this.getHabilidades().get(numHab)).getNivelDeBuff() == 2){
                this.setDefensaMejora((int)(this.defensaMejora * 1.4));
            }else{
                this.setDefensaMejora((int)(this.defensaMejora * 1.2));
            }
            this.setContadorMejoraDefensa(((MovimientoMejora) this.getHabilidades().get(numHab)).getDuracion());
            System.out.println("La Defensa de " + this.getMote() + " subió.");

        }else if(((MovimientoMejora) this.getHabilidades().get(numHab)).getBuff() == Mejora.DEFENSA_ESPECIAL){
            if(((MovimientoMejora) this.getHabilidades().get(numHab)).getNivelDeBuff() == 2){
                this.setDefensaEspecialMejora((int)(this.defensaEspecialMejora * 1.4));
            }else{
                this.setDefensaEspecialMejora((int)(this.defensaEspecialMejora * 1.2));
            }
            this.setContadorMejoraDefEspecial(((MovimientoMejora) this.getHabilidades().get(numHab)).getDuracion());
            System.out.println("La Defensa Especial de " + this.getMote() + " subió.");

        }else if(((MovimientoMejora) this.getHabilidades().get(numHab)).getBuff() == Mejora.VELOCIDAD){
            if(((MovimientoMejora) this.getHabilidades().get(numHab)).getNivelDeBuff() == 2){
                this.setVelocidadMejora((int)(this.velocidadMejora * 1.4));
            }else{
                this.setVelocidadMejora((int)(this.velocidadMejora * 1.2));
            }
            this.setContadorMejoraVelocidad(((MovimientoMejora) this.getHabilidades().get(numHab)).getDuracion());
            System.out.println("La Velocidad de " + this.getMote() + " subió.");
        }
    }

    // El método usarMovimiento utiliza "instanceof" para actuar en consecuencia con el tipo de Movimiento usado.
    public void usarMovimiento(int numHab, Pokemon pokemon){
        if(this.estaminaActual < this.habilidades.get(numHab).getConsumo()){
            System.out.println(this.getMote() + " no tiene suficiente Estamina.");

        }else{

            this.setEstaminaActual(this.estaminaActual - this.habilidades.get(numHab).getConsumo());
            
            if(this.habilidades.get(numHab) instanceof MovimientoAtaque){
                this.resultadoMovimientoAtaque(numHab, pokemon);

            }else if(this.habilidades.get(numHab) instanceof MovimientoEstado){
                this.resultadoMovimientoEstado(numHab, pokemon);

            }else if(this.habilidades.get(numHab) instanceof MovimientoMejora){
                this.resultadoMovimientoMejora(numHab);

            }
        }
    }

    public void descansar(){
        this.setVitalidadActual(this.vitalidadMaxima);
        this.setEstaminaActual(this.estaminaMaxima);
    }

    /* Se necesita una Lista de Movimientos para completar el método, que llevaría a su vez, si se da el primer caso,
    un método 'olvidarMovimiento' */
    public boolean aprenderMovimiento(Movimiento habilidad){
        if(this.habilidades.size() > 3){
            System.out.println(this.getMote() + " debe olvidar un Movimiento para aprender " + habilidad.getNombreHabilidad());
            return false;
            
        }else{
            this.habilidades.add(habilidad);
            System.out.println(this.getMote() + " aprendió " + habilidad.getNombreHabilidad());
            return true;
        }
    }
}