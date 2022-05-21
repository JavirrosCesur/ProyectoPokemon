package modelos;

import java.util.ArrayList;

/**
 * Creacion de la clase Pokemon
 */
public class Pokemon {

    /**
     * Creacion de los metodos pertinentes de Pokemon
     */
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
    private EstadoSecundario estadoSecundario;
    private int contadorEstadoP;
    private int contadorEstadoS;
    private Mejora mejora1;
    private Mejora mejora2;
    private int contadorMejoraAtaque;
    private int contadorMejoraDefensa;
    private int contadorMejoraAtEspecial;
    private int contadorMejoraDefEspecial;
    private int contadorMejoraVelocidad;
    private ArrayList<Movimiento> habilidades;

    /**
     * Creacion del constructor de pokemon donde mote sera introducido por el
     * usuario, el nivel por defecto sera 1, la experiencia por defecto sera 0
     * la estamina maxima por defecto sera 100, la fertilidad sera 5 por defecto,
     * genero llamara al metodo inicarGenero, el estado principal sera NINGUNO por
     * defecto
     * la mejora 1 y la mejora 2 seran NINGUNA por defecto y se creara una lista
     * para las habilidades
     * 
     * @param nombre          es el nombre del pokemon
     * @param vitalidadMaxima es la vitalidad maxima del pokemon
     * @param ataque          es el valor de ataque del pokemon
     * @param defensa         es el valor de defensa del pokemon
     * @param ataqueEspecial  es el valor de ataque especial del pokemon
     * @param defensaEspecial es el valor de defensa especial del pokemon
     * @param velocidad       es el valor de velocidad del pokemon
     * @param tipo1           es el tipo 1 del pokemon
     * @param tipo2           es el tipo 2 del pokemon en caso de tener alguno
     */
    public Pokemon(String nombre, int vitalidadMaxima, int ataque, int defensa,
            int ataqueEspecial, int defensaEspecial, int velocidad, Tipo tipo1, Tipo tipo2) {
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

    /**
     * Metodo get de nombre
     * 
     * @return el nombre del pokemon
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo get de mote
     * 
     * @return el mote del pokemon
     */
    public String getMote() {
        return mote;
    }

    /**
     * Metodo get de nivel
     * 
     * @return el nivel del pokemon
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Metodo get de experiencia
     * 
     * @return la experiencia del pokemon
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Metodo get de vitalidadMaxima
     * 
     * @return la vitalidad maxima del pokemon
     */
    public int getVitalidadMaxima() {
        return vitalidadMaxima;
    }

    /**
     * Metodo get de vitalidadActual
     * 
     * @return la vitalidad actual del pokemon
     */
    public int getVitalidadActual() {
        return vitalidadActual;
    }

    /**
     * Metodo get de estaminaMaxima
     * 
     * @return la estamina maxima del pokemon
     */
    public int getEstaminaMaxima() {
        return estaminaMaxima;
    }

    /**
     * Metodo get de estaminaActual
     * 
     * @return la estamina actual del pokemon
     */
    public int getEstaminaActual() {
        return estaminaActual;
    }

    /**
     * Metodo get de Ataque
     * 
     * @return valor de ataque del pokemon
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Metodo get de ataqueMejora
     * 
     * @return el valor de mejora del ataque del pokemon
     */
    public int getAtaqueMejora() {
        return ataqueMejora;
    }

    /**
     * Metodo get de defensa
     * 
     * @return el valor de defensa del pokemon
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Metodo get de defensaMejora
     * 
     * @return el valor de mejora de la defensa del pokemon
     */
    public int getDefensaMejora() {
        return defensaMejora;
    }

    /**
     * Metodo get de ataqueEspecial
     * 
     * @return el valor de ataque especial del pokemon
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    /**
     * Metodo get de ataqueEspecialMejora
     * 
     * @return el valor de mejora del ataque especial del pokemon
     */
    public int getAtaqueEspecialMejora() {
        return ataqueEspecialMejora;
    }

    /**
     * Metodo get de defensaEspecial
     * 
     * @return el valor de defensa especial del pokemon
     */
    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    /**
     * Metodo get de defensaEspecialMejora
     * 
     * @return el valor de mejora de la defensa especial del pokemon
     */
    public int getDefensaEspecialMejora() {
        return defensaEspecialMejora;
    }

    /**
     * Metodo get de velocidad
     * 
     * @return el valor de velocidad del pokemon
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Metodo get de velocidadMejora
     * 
     * @return el valor de mejora de la velocidad del pokemon
     */
    public int getVelocidadMejora() {
        return velocidadMejora;
    }

    /**
     * Metodo get de fertilidad
     * 
     * @return el valor de la fertilidad del pokemon
     */
    public int getFertilidad() {
        return fertilidad;
    }

    /**
     * Metodo get de Genero
     * 
     * @return el valor de Genero del pokemon
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Metodo get de tipo1
     * 
     * @return el primer tipo del pokemon
     */
    public Tipo getTipo1() {
        return tipo1;
    }

    /**
     * Metodo get tipo2
     * 
     * @return el segundo tipo del pokemon
     */
    public Tipo getTipo2() {
        return tipo2;
    }

    /**
     * Metodo get de estadoPrincipal
     * 
     * @return el estado principal del pokemon
     */
    public EstadoPrincipal getEstadoPrincipal() {
        return estadoPrincipal;
    }

    /**
     * Metodo get de estadoSecundario
     * 
     * @return el estadoSecundario del pokemon
     */
    public EstadoSecundario getEstadoSecundario() {
        return estadoSecundario;
    }

    /**
     * Metodo get de contadorEstadoP
     * 
     * @return el contador del estado principal del pokemon
     */
    public int getContadorEstadoP() {
        return contadorEstadoP;
    }

    /**
     * Metodo get de contadorEstadoS
     * 
     * @return el contador del estado secundario del pokemon
     */
    public int getContadorEstadoS() {
        return contadorEstadoS;
    }

    /**
     * Metodo get de mejora1
     * 
     * @return el valor de la primera mejora del pokemon
     */
    public Mejora getMejora1() {
        return mejora1;
    }

    /**
     * Metodo get de mejora2
     * 
     * @return el valor de la segunda mejora del pokemon
     */
    public Mejora getMejora2() {
        return mejora2;
    }

    /**
     * Metodo get de contadorMejoraAtaque
     * 
     * @return el contador de mejora del ataque del pokemon
     */
    public int getContadorMejoraAtaque() {
        return contadorMejoraAtaque;
    }

    /**
     * Metodo get de contadorMejoraDefensa
     * 
     * @return el contador de mejora de la defensa del pokemon
     */
    public int getContadorMejoraDefensa() {
        return contadorMejoraDefensa;
    }

    /**
     * Metodo get de contadorMejoraEspecial
     * 
     * @return el contador de mejora del ataque especial del pokemon
     */
    public int getContadorMejoraAtEspecial() {
        return contadorMejoraAtEspecial;
    }

    /**
     * Metodo get de contadorDefensaEspecial
     * 
     * @return el contador de mejora de la defensa especial del pokemon
     */
    public int getContadorMejoraDefEspecial() {
        return contadorMejoraDefEspecial;
    }

    /**
     * Metodo get de contadorMejoraVelocidad
     * 
     * @return el contador de la mejora de velocidad del pokemon
     */
    public int getContadorMejoraVelocidad() {
        return contadorMejoraVelocidad;
    }

    /**
     * Metodo get de habilidades
     * 
     * @return un arrayList de habilidades del pokemon
     */
    public ArrayList<Movimiento> getHabilidades() {
        return habilidades;
    }

    /**
     * Metodo set de nombre
     * 
     * @param nombre establece el nombre del pokemon
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo set de Mote
     * 
     * @param mote establece el mote del pokemon
     */
    public void setMote(String mote) {
        this.mote = mote;
    }

    /**
     * Metodo int subirVitalidad que servira para equiparar la vitalidad del pokemon
     * rival con el de nuestro pokemon
     * 
     * @param nivel es el nivel de nuestro pokemon
     * @return el valor de la vitalidad a aumentar del pokemon rival
     */
    public int subirVitalidad(int nivel) {
        int sumaVitalidad = 0;
        for (int i = 2; i <= nivel; i++) {
            sumaVitalidad += (int) (Math.random() * 3 + 3);
        }
        return sumaVitalidad;
    }

    /**
     * Metodo int subirEstamina que servira para equiparar la estamina del pokemon
     * rival con el de nuestro pokemon
     * 
     * @param nivel es el nivel de nuestro pokemon
     * @return el valor de la estamina a aumentar del pokemon
     */
    public int subirEstamina(int nivel) {
        int sumaEstamina = 0;
        for (int i = 2; i <= nivel; i++) {
            sumaEstamina += (int) (Math.random() * 3 + 1);
        }
        return sumaEstamina;
    }

    /**
     * Metodo subirAtributos que serviara para equipar todas las estadisticas
     * basicas del pokemon rival con el de nuestro pokemon
     * 
     * @param nivel es el nivel de nuestro pokemon
     * @return el valor de los atributos a aumentar del pokemon
     */
    public int subirAtributos(int nivel) {
        int sumaAtributos = 0;
        for (int i = 2; i <= nivel; i++) {
            sumaAtributos += (int) (Math.random() * 4 + 1);
        }
        return sumaAtributos;
    }

    /**
     * Metodo void nivelarNivel con el que estableceremos las mejoras al pokemon
     * rival
     * 
     * @param nivel es el nivel de nuestro pokemon
     */
    public void nivelarNivel(int nivel) {
        this.setVitalidadMaxima(this.vitalidadMaxima + this.subirVitalidad(nivel));
        this.setEstaminaMaxima(this.estaminaMaxima + this.subirEstamina(nivel));
        this.setAtaque(this.ataque + this.subirAtributos(nivel));
        this.setDefensa(this.defensa + this.subirAtributos(nivel));
        this.setAtaqueEspecial(this.ataqueEspecial + this.subirAtributos(nivel));
        this.setDefensaEspecial(this.defensaEspecial + this.subirAtributos(nivel));
        this.setVelocidad(this.velocidad + this.subirAtributos(nivel));
    }

    /**
     * Metodo void setNivel que servira para aumentar la experiencia de los pokemons
     * salvajes o rivales (Sirve como trampas para el usuario)
     * 
     * @param nivel es el nivel
     */
    public void setNivel(int nivel) {
        this.setNivel(nivel);
        this.nivelarNivel(nivel);
        this.setExperiencia(((this.nivel - 1) * 10) + 1);
    }

    /**
     * Metodo set de experiencia
     * 
     * @param experiencia establece el valor de experiencia del pokemon
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Metodo set de vitalidadMaxima
     * 
     * @param vitalidadMaxima establece el valor de vitalidad maxima del pokemon
     */
    public void setVitalidadMaxima(int vitalidadMaxima) {
        this.vitalidadMaxima = vitalidadMaxima;
    }

    /**
     * Metodo set de vitalidadActual que utiliza el metodo gestionarVitalidad
     * 
     * @param vitalidadActual establece el valor de vitalidad actual del pokemon
     */
    public void setVitalidadActual(int vitalidadActual) {
        this.vitalidadActual = vitalidadActual;
        this.gestionarVitalidad(); // Método de control explicado más abajo.
    }

    /**
     * Metodo set de estaminaMaxima
     * 
     * @param estaminaMaxima que establece la estamina maxima
     */
    public void setEstaminaMaxima(int estaminaMaxima) {
        this.estaminaMaxima = estaminaMaxima;
    }

    /**
     * Metodo set de estaminaActual que utiliza el metodo gestionarEstamina
     * 
     * @param estaminaActual establece la estamina actual del pokemon
     */
    public void setEstaminaActual(int estaminaActual) {
        this.estaminaActual = estaminaActual;
        this.gestionarEstamina(); // Método de control explicado más abajo.
    }

    /**
     * Metodo set de ataque
     * 
     * @param ataque establece el valor de ataque del pokemon
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
        this.ataqueMejora = this.ataque;
    }

    /**
     * Metodo set de ataqueMejora
     * 
     * @param ataqueMejora establece el valor de mejora del ataque del pokemon
     */
    public void setAtaqueMejora(int ataqueMejora) {
        this.ataqueMejora = ataqueMejora;
    }

    /**
     * Metodo set de defensa
     * 
     * @param defensa establece el valor de la defensa del pokemon
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
        this.defensaMejora = this.defensa;
    }

    /**
     * Metodo set de defensaMejora
     * 
     * @param defensaMejora es el valor de la mejora de la defensa del pokemon
     */
    public void setDefensaMejora(int defensaMejora) {
        this.defensaMejora = defensaMejora;
    }

    /**
     * Metodo set de ataqueEspecial
     * 
     * @param ataqueEspecial establece del valor de ataque especial del pokemon
     */
    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
        this.ataqueEspecialMejora = this.ataqueEspecial;
    }

    /**
     * Metodo set de ataqueEspecialMejora
     * 
     * @param ataqueEspecialMejora es el valor de la mejora del ataque especial del
     *                             pokemon
     */
    public void setAtaqueEspecialMejora(int ataqueEspecialMejora) {
        this.ataqueEspecialMejora = ataqueEspecialMejora;
    }

    /**
     * Metodo set de defensaEspecial
     * 
     * @param defensaEspecial establece del valor de defensa espcial del pokemon
     */
    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
        this.defensaEspecialMejora = this.defensaEspecial;
    }

    /**
     * Metodo set de defensaEspecialMejora
     * 
     * @param defensaEspecialMejora establece el valor de mejora de la defensa
     *                              espcial del pokemon
     */
    public void setDefensaEspecialMejora(int defensaEspecialMejora) {
        this.defensaEspecialMejora = defensaEspecialMejora;
    }

    /**
     * Metodo set de velocidad
     * 
     * @param velocidad establece el valor de velocidad del pokemon
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
        this.velocidadMejora = this.velocidad;
    }

    /**
     * Metodo set de velocidadMejora
     * 
     * @param velocidadMejora establece el valor de mejora de la velocidad del
     *                        pokemon
     */
    public void setVelocidadMejora(int velocidadMejora) {
        this.velocidadMejora = velocidadMejora;
    }

    /**
     * Metodo set fertilidad
     * 
     * @param fertilidad establece la fertilidad del pokemon
     */
    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    /**
     * Metodo set de genero
     * 
     * @param genero establece el genero del pokemon
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Metodo set de tipo1
     * 
     * @param tipo1 esatablece el primer tipo del pokemon
     */
    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    /**
     * Metodo set de tipo2
     * 
     * @param tipo2 establece el segundo tipo del pokemon
     */
    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }

    /**
     * Metodo set de estadoPrincipal
     * 
     * @param estadoPrincipal establece el estado principal del pokemon
     */
    public void setEstadoPrincipal(EstadoPrincipal estadoPrincipal) {
        this.estadoPrincipal = estadoPrincipal;
    }

    /**
     * Metodo set de estadosUnidos
     * 
     * @param estadoSecundario establece el estado secundario del pokemon
     */
    public void setEstadoSecundario(EstadoSecundario estadoSecundario) {
        this.estadoSecundario = estadoSecundario;
    }

    /**
     * Metodo set de controladorEstadoP
     * 
     * @param contadorEstadoP establece el valor del contador de estado principal
     *                        del pokemon
     */
    public void setContadorEstadoP(int contadorEstadoP) {
        this.contadorEstadoP = contadorEstadoP;
    }

    /**
     * Metodo set de contadorEstadoS
     * 
     * @param contadorEstadoS establece el contador de estado secundario del pokemon
     */
    public void setContadorEstadoS(int contadorEstadoS) {
        this.contadorEstadoS = contadorEstadoS;
    }

    /**
     * Metodo set de mejora1
     * 
     * @param mejora1 establece el valor de la primera mejora del pokemon
     */
    public void setMejora1(Mejora mejora1) {
        this.mejora1 = mejora1;
    }

    /**
     * Metodo set de mejora2
     * 
     * @param mejora2 establece el valor de la segunda mejora del pokemon
     */
    public void setMejora2(Mejora mejora2) {
        this.mejora2 = mejora2;
    }

    /**
     * Metodo set de contadorMejoraAtaque
     * 
     * @param contadorMejoraAtaque establece el valor del contador de mejora del
     *                             ataque del pokemon
     */
    public void setContadorMejoraAtaque(int contadorMejoraAtaque) {
        this.contadorMejoraAtaque = contadorMejoraAtaque;
    }

    /**
     * Metodo set de contadorMejoraDefensa
     * 
     * @param contadorMejoraDefensa establece el valor del contador de mejora de
     *                              defensa del pokemon
     */
    public void setContadorMejoraDefensa(int contadorMejoraDefensa) {
        this.contadorMejoraDefensa = contadorMejoraDefensa;
    }

    /**
     * Metodo set de contadorMejoraAtEspecial
     * 
     * @param contadorMejoraAtEspecial establece el valor del conmtador de mejora
     *                                 del ataque espcial del pokemon
     */
    public void setContadorMejoraAtEspecial(int contadorMejoraAtEspecial) {
        this.contadorMejoraAtEspecial = contadorMejoraAtEspecial;
    }

    /**
     * Metodo set de conmtadorMejoraDefEspecial
     * 
     * @param contadorMejoraDefEspecial establece el valor del contador de defensa
     *                                  espcial del pokemon
     */
    public void setContadorMejoraDefEspecial(int contadorMejoraDefEspecial) {
        this.contadorMejoraDefEspecial = contadorMejoraDefEspecial;
    }

    /**
     * Metodo set contadorMejoraVelocidad
     * 
     * @param contadorMejoraVelocidad establece el valor del contador de mejora de
     *                                velocidad del pokemon
     */
    public void setContadorMejoraVelocidad(int contadorMejoraVelocidad) {
        this.contadorMejoraVelocidad = contadorMejoraVelocidad;
    }

    /**
     * Metodo set de habilidades
     * 
     * @param habilidades establece las habilidades del pokemon
     */
    public void setHabilidades(ArrayList<Movimiento> habilidades) {
        this.habilidades = habilidades;
    }

    /**
     * Metodo toString que muestra todas las estadisticas actuales del pokemon que
     * sean necesarias
     */
    @Override
    public String toString() {
        return this.getMote() + ": " + this.getNombre() + " " + this.getGenero().toString().toLowerCase() +
                " de nivel " + this.getNivel() + "\nTipo: " + this.getTipo1().toString() + ", "
                + this.getTipo2().toString() +
                "\nVitalidad: " + this.getVitalidadActual() + "/" + this.getVitalidadMaxima() + "\nAtaque: "
                + this.getAtaque() +
                "  - Defensa: " + this.getDefensa() + "\nAtaque Especial: " + this.getAtaqueEspecial()
                + "  - Defensa Especial: " +
                this.getDefensaEspecial() + "\nVelocidad: " + this.getVelocidad() + "  - Fertilidad: "
                + this.getFertilidad() + "\n";
    }

    /**
     * Metodo void ganarexperiencia que servira para llenar la barra de experiencia
     * de un pokemon en vista de subir de nivel utilizando el metodo subirDeNivel
     * 
     * @param cantidadExperiencia es la cantidad de experiencia ganada para el
     *                            pokemon
     */
    public void ganarExperiencia(int cantidadExperiencia) {
        this.setExperiencia(this.experiencia + cantidadExperiencia);
        this.subirDeNivel();
    }

    /**
     * Metodo boolean subirDeNivel que subira de nivel a un pokemon cuando este
     * llene su barra de experiencia. Tambien aumentara las estadisticas conforme la
     * subida de nivel
     * 
     * @return
     */
    public boolean subirDeNivel() {
        if (this.experiencia < (this.nivel * 10)) {
            return false;
        } else {
            System.out.println("¡Tu POKEMON ha subido de nivel!");
            this.nivel++;

            int subida;
            subida = (int) (Math.random() * 3 + 3);
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

    /**
     * Metodo void gestionarVitalidad que se ocupara de que la vida no puedar ser
     * inferior a 0 ni superior al maximo
     */
    public void gestionarVitalidad() {
        if (this.vitalidadActual <= 0) {
            this.vitalidadActual = 0;
        } else if (this.vitalidadActual > this.vitalidadMaxima) {
            this.vitalidadActual = this.vitalidadMaxima;
        }
    }

    /**
     * Metodo void gestionarEstamina que se ocupara de que la estamina no pueda ser
     * inferior a 0 ni superior al maximo
     */
    public void gestionarEstamina() {
        if (this.estaminaActual <= 0) {
            this.estaminaActual = 0;
        } else if (this.estaminaActual > this.estaminaMaxima) {
            this.estaminaActual = this.estaminaMaxima;
        }
    }

    /**
     * Metodo void resultadoMovimiento que serviar para diferenciar entre tipos a la
     * hora de realizar un ataque. Posteriormente de comprobar la compatibilidad
     * realizara un ataque indicando si es efectivo
     * 
     * @param habilidad es la habilidad a usar del pokemon
     * @param pokemon   es el pokemon que recibira el movimiento
     */
    public void resultadoMovimientoAtaque(MovimientoAtaque habilidad, Pokemon pokemon) {
        if (habilidad.getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.AGUA
                || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.FUEGO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo1() == Tipo.HADA
                || pokemon.getTipo1() == Tipo.HIELO
                || pokemon.getTipo1() == Tipo.ROCA) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo1() == Tipo.AGUA
                || pokemon.getTipo1() == Tipo.DRAGON
                || pokemon.getTipo1() == Tipo.PLANTA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.ROCA
                || pokemon.getTipo1() == Tipo.TIERRA) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.FANTASMA || pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.HADA
                || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.VENENO
                || pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo1() == Tipo.PLANTA
                || pokemon.getTipo1() == Tipo.PSIQUICO || pokemon.getTipo1() == Tipo.SINIESTRO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo1() == Tipo.HADA) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo1() == Tipo.ACERO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo1() == Tipo.DRAGON) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo1() == Tipo.TIERRA) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo1() == Tipo.DRAGON
                || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.PLANTA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo1() == Tipo.AGUA
                || pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo1() == Tipo.NORMAL) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo1() == Tipo.SINIESTRO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo1() == Tipo.FANTASMA
                || pokemon.getTipo1() == Tipo.PSIQUICO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo1() == Tipo.AGUA
                || pokemon.getTipo1() == Tipo.DRAGON || pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.ROCA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.BICHO || pokemon.getTipo1() == Tipo.HIELO
                || pokemon.getTipo1() == Tipo.PLANTA) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HADA && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.FUEGO || pokemon.getTipo1() == Tipo.VENENO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HADA && pokemon.getTipo1() == Tipo.DRAGON
                || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.SINIESTRO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.AGUA || pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.HIELO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo1() == Tipo.DRAGON
                || pokemon.getTipo1() == Tipo.PLANTA || pokemon.getTipo1() == Tipo.TIERRA
                || pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo1() == Tipo.FANTASMA) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo1() == Tipo.BICHO
                || pokemon.getTipo1() == Tipo.HADA || pokemon.getTipo1() == Tipo.PSIQUICO
                || pokemon.getTipo1() == Tipo.VENENO
                || pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.HIELO || pokemon.getTipo1() == Tipo.NORMAL
                || pokemon.getTipo1() == Tipo.ROCA
                || pokemon.getTipo1() == Tipo.SINIESTRO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo1() == Tipo.FANTASMA) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.ROCA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.BICHO || pokemon.getTipo1() == Tipo.DRAGON
                || pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.PLANTA || pokemon.getTipo1() == Tipo.VENENO
                || pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo1() == Tipo.AGUA
                || pokemon.getTipo1() == Tipo.ROCA || pokemon.getTipo1() == Tipo.TIERRA) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo1() == Tipo.SINIESTRO) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.PSIQUICO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo1() == Tipo.LUCHA
                || pokemon.getTipo1() == Tipo.VENENO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.LUCHA
                || pokemon.getTipo1() == Tipo.TIERRA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo1() == Tipo.BICHO
                || pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.HIELO || pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo1() == Tipo.HADA
                || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.SINIESTRO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo1() == Tipo.FANTASMA
                || pokemon.getTipo1() == Tipo.PSIQUICO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo1() == Tipo.VOLADOR) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo1() == Tipo.BICHO
                || pokemon.getTipo1() == Tipo.PLANTA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo1() == Tipo.ROCA
                || pokemon.getTipo1() == Tipo.VENENO) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo1() == Tipo.ACERO) {
            habilidad.setVentaja1(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo1() == Tipo.FANTASMA
                || pokemon.getTipo1() == Tipo.ROCA || pokemon.getTipo1() == Tipo.TIERRA
                || pokemon.getTipo1() == Tipo.VENENO) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo1() == Tipo.HADA
                || pokemon.getTipo1() == Tipo.PLANTA) {
            habilidad.setVentaja1(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo1() == Tipo.ELECTRICO || pokemon.getTipo1() == Tipo.ROCA) {
            habilidad.setVentaja1(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo1() == Tipo.BICHO
                || pokemon.getTipo1() == Tipo.LUCHA || pokemon.getTipo1() == Tipo.PLANTA) {
            habilidad.setVentaja1(2f);

        } else {
            habilidad.setVentaja1(1f);
        }

        if (habilidad.getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.AGUA
                || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.FUEGO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ACERO && pokemon.getTipo2() == Tipo.HADA
                || pokemon.getTipo2() == Tipo.HIELO
                || pokemon.getTipo2() == Tipo.ROCA) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo2() == Tipo.AGUA
                || pokemon.getTipo2() == Tipo.DRAGON
                || pokemon.getTipo2() == Tipo.PLANTA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.AGUA && pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.ROCA
                || pokemon.getTipo2() == Tipo.TIERRA) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.FANTASMA || pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.HADA
                || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.VENENO
                || pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.BICHO && pokemon.getTipo2() == Tipo.PLANTA
                || pokemon.getTipo2() == Tipo.PSIQUICO || pokemon.getTipo2() == Tipo.SINIESTRO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo2() == Tipo.HADA) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo2() == Tipo.ACERO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.DRAGON && pokemon.getTipo2() == Tipo.DRAGON) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo2() == Tipo.TIERRA) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo2() == Tipo.DRAGON
                || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.PLANTA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ELECTRICO && pokemon.getTipo2() == Tipo.AGUA
                || pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo2() == Tipo.NORMAL) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo2() == Tipo.SINIESTRO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FANTASMA && pokemon.getTipo2() == Tipo.FANTASMA
                || pokemon.getTipo2() == Tipo.PSIQUICO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo2() == Tipo.AGUA
                || pokemon.getTipo2() == Tipo.DRAGON || pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.ROCA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.FUEGO && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.BICHO || pokemon.getTipo2() == Tipo.HIELO
                || pokemon.getTipo2() == Tipo.PLANTA) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HADA && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.FUEGO || pokemon.getTipo2() == Tipo.VENENO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HADA && pokemon.getTipo2() == Tipo.DRAGON
                || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.SINIESTRO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.AGUA || pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.HIELO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.HIELO && pokemon.getTipo2() == Tipo.DRAGON
                || pokemon.getTipo2() == Tipo.PLANTA || pokemon.getTipo2() == Tipo.TIERRA
                || pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo2() == Tipo.FANTASMA) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo2() == Tipo.BICHO
                || pokemon.getTipo2() == Tipo.HADA || pokemon.getTipo2() == Tipo.PSIQUICO
                || pokemon.getTipo2() == Tipo.VENENO
                || pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.LUCHA && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.HIELO || pokemon.getTipo2() == Tipo.NORMAL
                || pokemon.getTipo2() == Tipo.ROCA
                || pokemon.getTipo2() == Tipo.SINIESTRO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo2() == Tipo.FANTASMA) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.NORMAL && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.ROCA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.BICHO || pokemon.getTipo2() == Tipo.DRAGON
                || pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.PLANTA || pokemon.getTipo2() == Tipo.VENENO
                || pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PLANTA && pokemon.getTipo2() == Tipo.AGUA
                || pokemon.getTipo2() == Tipo.ROCA || pokemon.getTipo2() == Tipo.TIERRA) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo2() == Tipo.SINIESTRO) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.PSIQUICO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.PSIQUICO && pokemon.getTipo2() == Tipo.LUCHA
                || pokemon.getTipo2() == Tipo.VENENO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.LUCHA
                || pokemon.getTipo2() == Tipo.TIERRA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.ROCA && pokemon.getTipo2() == Tipo.BICHO
                || pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.HIELO || pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo2() == Tipo.HADA
                || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.SINIESTRO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.SINIESTRO && pokemon.getTipo2() == Tipo.FANTASMA
                || pokemon.getTipo2() == Tipo.PSIQUICO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo2() == Tipo.VOLADOR) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo2() == Tipo.BICHO
                || pokemon.getTipo2() == Tipo.PLANTA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.TIERRA && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.ROCA
                || pokemon.getTipo2() == Tipo.VENENO) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo2() == Tipo.ACERO) {
            habilidad.setVentaja2(0f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo2() == Tipo.FANTASMA
                || pokemon.getTipo2() == Tipo.ROCA || pokemon.getTipo2() == Tipo.TIERRA
                || pokemon.getTipo2() == Tipo.VENENO) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VENENO && pokemon.getTipo2() == Tipo.HADA
                || pokemon.getTipo2() == Tipo.PLANTA) {
            habilidad.setVentaja2(2f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo2() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.ELECTRICO || pokemon.getTipo2() == Tipo.ROCA) {
            habilidad.setVentaja2(0.5f);

        } else if (habilidad.getTipoMovimiento() == Tipo.VOLADOR && pokemon.getTipo2() == Tipo.BICHO
                || pokemon.getTipo2() == Tipo.LUCHA || pokemon.getTipo2() == Tipo.PLANTA) {
            habilidad.setVentaja2(2f);

        } else {
            habilidad.setVentaja2(1f);
        }

        habilidad.setVentajaTotal(habilidad.getVentaja1() * habilidad.getVentaja2());

        if (habilidad.getVentajaTotal() < 1) {
            System.out.println("No es efectivo.");
        } else if (habilidad.getVentajaTotal() > 1) {
            System.out.println("¡Es súper efectivo!");
        }

        if (habilidad.getFisEsp() == FisicoEspecial.FISICO) {
            habilidad.setDanyo((int) (habilidad.getPotencia() * habilidad.getVentajaTotal() + this.getAtaqueMejora()));
            if (habilidad.getDanyo() - pokemon.getDefensaMejora() > 0) {
                pokemon.setVitalidadActual(pokemon.getVitalidadActual() -
                        (habilidad.getDanyo() - pokemon.getDefensaMejora()));
            }

        } else {
            habilidad.setDanyo(
                    (int) (habilidad.getPotencia() * habilidad.getVentajaTotal() + this.getAtaqueEspecialMejora()));
            if (habilidad.getDanyo() - pokemon.getDefensaEspecialMejora() > 0) {
                pokemon.setVitalidadActual(pokemon.getVitalidadActual() -
                        (habilidad.getDanyo() - pokemon.getDefensaEspecialMejora()));
            }
        }

        habilidad.resetVentajas();
    }

    /**
     * Metodo void resultadoMovimientoEstado que serviara para probar si el pokemon
     * puede recibir el estado del movimiento. En caso de
     * afectar al pokemon le introducira un estado
     * 
     * @param habilidad
     * @param pokemon
     */
    public void resultadoMovimientoEstado(MovimientoEstado habilidad, Pokemon pokemon) {
        if (habilidad.getEstadoPrincipal() == EstadoPrincipal.CONGELADO && pokemon.getTipo1() == Tipo.HIELO
                || pokemon.getTipo2() == Tipo.HIELO) {
            System.out.println("No es efectivo.");

        } else if (habilidad.getEstadoPrincipal() == EstadoPrincipal.ENVENENADO && pokemon.getTipo1() == Tipo.VENENO
                || pokemon.getTipo2() == Tipo.VENENO || pokemon.getTipo1() == Tipo.ACERO
                || pokemon.getTipo2() == Tipo.ACERO) {
            System.out.println("No es efectivo.");

        } else if (habilidad.getEstadoPrincipal() == EstadoPrincipal.PARALIZADO && pokemon.getTipo1() == Tipo.ELECTRICO
                || pokemon.getTipo2() == Tipo.ELECTRICO) {
            System.out.println("No es efectivo.");

        } else if (habilidad.getEstadoPrincipal() == EstadoPrincipal.QUEMADO && pokemon.getTipo1() == Tipo.FUEGO
                || pokemon.getTipo2() == Tipo.FUEGO) {
            System.out.println("No es efectivo.");

        } else if (habilidad.getEstadoSecundario() == EstadoSecundario.ENAMORADO
                && (this.getGenero().equals(pokemon.getGenero())
                        && this.getNombre() != pokemon.getNombre())) {
            System.out.println("No es efectivo.");

        } else {
            if (habilidad.getEstadoPrincipal() == EstadoPrincipal.NINGUNO) {
                pokemon.setEstadoSecundario(habilidad.getEstadoSecundario());
                pokemon.setContadorEstadoS(habilidad.getDuracion());
            } else {
                pokemon.setEstadoPrincipal(habilidad.getEstadoPrincipal());
                pokemon.setContadorEstadoP(habilidad.getDuracion());
            }
        }
    }

    /**
     * Metodo void resultadoMovimientoMejora que servira para establecer una mejora
     * del movimiento al pokemon en caso de poderse
     * 
     * @param habilidad es la habilidad a usar sobre el pokemon
     */
    public void resultadoMovimientoMejora(MovimientoMejora habilidad) {
        if (habilidad.getBuff() == Mejora.ATAQUE_FISICO) {
            if (habilidad.getNivelDeBuff() == 2) {
                this.setAtaqueMejora((int) (this.ataqueMejora * 1.4));
            } else {
                this.setAtaqueMejora((int) (this.ataqueMejora * 1.2));
            }
            this.setContadorMejoraAtaque(habilidad.getDuracion());
            System.out.println("El Ataque de " + this.mote + " subio.");

        } else if (habilidad.getBuff() == Mejora.ATAQUE_ESPECIAL) {
            if (habilidad.getNivelDeBuff() == 2) {
                this.setAtaqueEspecialMejora((int) (this.ataqueEspecialMejora * 1.4));
            } else {
                this.setAtaqueEspecialMejora((int) (this.ataqueEspecialMejora * 1.2));
            }
            this.setContadorMejoraAtEspecial(habilidad.getDuracion());
            System.out.println("El Ataque Especial de " + this.mote + " subio.");

        } else if (habilidad.getBuff() == Mejora.DEFENSA_FISICA) {
            if (habilidad.getNivelDeBuff() == 2) {
                this.setDefensaMejora((int) (this.defensaMejora * 1.4));
            } else {
                this.setDefensaMejora((int) (this.defensaMejora * 1.2));
            }
            this.setContadorMejoraDefensa(habilidad.getDuracion());
            System.out.println("La defensa de " + this.mote + " subio.");

        } else if (habilidad.getBuff() == Mejora.DEFENSA_ESPECIAL) {
            if (habilidad.getNivelDeBuff() == 2) {
                this.setDefensaEspecialMejora((int) (this.defensaEspecialMejora * 1.4));
            } else {
                this.setDefensaEspecialMejora((int) (this.defensaEspecialMejora * 1.2));
            }
            this.setContadorMejoraDefEspecial(habilidad.getDuracion());
            System.out.println("La defensa Especial de " + this.mote + " subio.");

        } else if (habilidad.getBuff() == Mejora.VELOCIDAD) {
            if (habilidad.getNivelDeBuff() == 2) {
                this.setVelocidadMejora((int) (this.velocidadMejora * 1.4));
            } else {
                this.setVelocidadMejora((int) (this.velocidadMejora * 1.2));
            }
            this.setContadorMejoraVelocidad(habilidad.getDuracion());
            System.out.println("La Velocidad de " + this.mote + " subio.");
        }
    }

    /**
     * Metodo boolean usarMovimiento que ordenara al pokemon usar un movimiento
     * contra el pokemon rival utilizando "instanceof" para
     * actuar en consecuencia con el tipo de Movimiento usado
     * 
     * @param numHab  es el numero de la habilidad del pokemon
     * @param pokemon es el pokemon que recibe la habilidad
     * @return la habilidad usada por el pokemon
     */
    public boolean usarMovimiento(int numHab, Pokemon pokemon) {
        if (this.estaminaActual < this.habilidades.get(numHab).getConsumo()) {
            System.out.println(this.getMote() + " no tiene suficiente estamina.");
            return false;
        } else {
            this.setEstaminaActual(this.estaminaActual - this.habilidades.get(numHab).getConsumo());
            System.out.println(this.getMote() + " usó " + this.habilidades.get(numHab).getNombreHabilidad() + "...");

            if (this.habilidades.get(numHab) instanceof MovimientoAtaque) {
                this.resultadoMovimientoAtaque((MovimientoAtaque) this.habilidades.get(numHab), pokemon);

            } else if (this.habilidades.get(numHab) instanceof MovimientoEstado) {
                this.resultadoMovimientoEstado((MovimientoEstado) this.habilidades.get(numHab), pokemon);

            } else if (this.habilidades.get(numHab) instanceof MovimientoMejora) {
                this.resultadoMovimientoMejora((MovimientoMejora) this.habilidades.get(numHab));

            }
            return true;
        }
    }

    /**
     * Metodo void de descansar que restablecera la vitalidad del pokemon
     * selecionado
     */
    public void descansar() {
        this.setVitalidadActual(this.vitalidadMaxima);
        this.setEstaminaActual(this.estaminaMaxima);
    }

    /**
     * Metodo boolean aprenderMovimiento que permitira al pokemon aprender nuevos
     * movimientos
     * 
     * @param habilidad es la habilidad a aprender
     * @return si ha aprendido o no la habilidad
     */
    public boolean aprenderMovimiento(Movimiento habilidad) {
        if (this.habilidades.size() > 3) {
            System.out.println(
                    this.getMote() + " debe olvidar un Movimiento para aprender " + habilidad.getNombreHabilidad());
            return false;

        } else {
            this.habilidades.add(habilidad);
            System.out.println(this.getMote() + " aprendió " + habilidad.getNombreHabilidad());
            return true;
        }
    }

    /**
     * Metodo iniciarGenero para estblecer aleatoriamente un genero al pokemon
     * 
     * @return el genero selecionado para el pokemon
     */
    public Genero iniciarGenero() { // Para el constructor.
        int randomGen = (int) (Math.random() * 2);
        if (randomGen == 0) {
            return Genero.HEMBRA;
        } else {
            return Genero.MACHO;
        }
    }
}