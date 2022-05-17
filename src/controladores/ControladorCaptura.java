package src.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import src.modelos.Captura;
import src.modelos.Entrenador;
import src.modelos.Genero;
import src.modelos.Movimiento;
import src.modelos.Pokemon;
import src.modelos.Tipo;

import javafx.scene.Node;

public class ControladorCaptura implements Initializable{
    
    Pokemon salvaje;
 
    Stage stage;
	Scene scene;
	Parent root;

   /* public ControladorCaptura(Pokemon salvaje)
    {
        this.salvaje = new Pokemon(salvaje);

        Image myImage = new Image(getClass().getResourceAsStream("../../rsc/VenusaurEspalda.gif"));
        capturaImagePokemon.setImage(myImage);
    }*/

    @FXML
    Button capturarBtn;

    @FXML
    Button huirBtn;

    @FXML
    ImageView capturaImagePokemon;

   

   

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }


    

    @FXML
    private void capturar(ActionEvent event) throws SQLException
    {
        System.out.println("tirando pokeball");
       // Captura captura = new Captura();
        Entrenador entrenador1;
        ArrayList<Pokemon> equipo1 = new ArrayList<>();
        ArrayList<Pokemon> equipo2 = new ArrayList<>();


        String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/pokemon";
		Connection con = DriverManager.getConnection(url, usuario, "");;
		Statement stmt = con.createStatement();
		//ResultSet rs;
        ResultSet rs2;
        String nombreEntrenador = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {

			rs2 = stmt.executeQuery("SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX INNER JOIN entrenador ON entrenador.ID_ENTRENADOR = pokemon.ID_ENTRENADOR WHERE entrenador.ID_ENTRENADOR = 1;");
            rs2.next();

            nombreEntrenador = rs2.getString("NOMBRE_ENTRENADOR");

            do {
                System.out.println("principio");
				Pokemon pokemon = new Pokemon(rs2.getString("NOMBRE"), rs2.getInt("VITALIDAD"), rs2.getInt("ATAQUE"), rs2.getInt("DEFENSA"), rs2.getInt("ATK_ESPECIAL"), rs2.getInt("DEF_ESPECIAL"), rs2.getInt("VELOCIDAD"),Genero.valueOf("HEMBRA"), Tipo.valueOf(rs2.getString("TIPO1")),Tipo.valueOf(rs2.getString("TIPO2")), new ArrayList<Movimiento>());

                if(rs2.getInt("ID_EQUIPO") == 1)
                    equipo1.add(pokemon);
                else
                    equipo2.add(pokemon);
                    System.out.println("fin");

			}while(rs2.next());

            System.out.println("tras el do while");


		} catch (SQLException e) {
			e.printStackTrace();
		}
        entrenador1 = new Entrenador(nombreEntrenador, equipo1, equipo2, equipo1.get(0));
        System.out.println("tras todo");

        boolean resultado = entrenador1.capturarPokemon(entrenador1.getPrimerPokemon());


        Pokemon miPokemon = entrenador1.getPrimerPokemon();

      //  String direccion = "../../rsc/" +miPokemon.getNombre() +"Cara.gif";
       // System.out.println(direccion);

      //  rsc/VenusaurEspalda.gif

       // Image myImage = new Image(getClass().getResourceAsStream(direccion));
       // capturaImagePokemon.setImage(myImage);

        if(resultado)
        {

            System.out.println("dentro del if");

            //TODO
            // insertar codigo para que se incremente el idpokemon

            String sentencia = "INSERT INTO POKEMON (ID_POKEMON, ID_ENTRENADOR, ID_POKEDEX, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATK_ESPECIAL, DEF_ESPECIAL, VELOCIDAD, ESTAMINA, NIVEL, ID_EQUIPO) VALUES("+ 569
                                +","+ 1
                                +","+ 3
                                +",'" + miPokemon.getMote()
                                +"'," + miPokemon.getVitalidadMaxima()
                                +"," + miPokemon.getAtaque()
                                +"," + miPokemon.getDefensa()
                                +"," + miPokemon.getAtaqueEspecial()
                                +"," + miPokemon.getDefensaEspecial()
                                +"," + miPokemon.getVelocidad()
                                +"," + miPokemon.getEstaminaMaxima()
                                +"," + miPokemon.getNivel()
                                +"," + 1
                                +")"; 


            Statement statement2 = null;

            System.out.println(sentencia);

            try {
                System.out.println("dentro del try");
                statement2 = con.createStatement();
                System.out.println("------");
                statement2.executeUpdate(sentencia);
                System.out.println("detras de la ejecucion de la sentencia");
                System.out.println("pokemon insertado" + miPokemon.getNombre());

            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }

    @FXML
    private void huir(ActionEvent e) throws IOException
    {
        System.out.println("huyendo");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/MenuPrincipal.fxml"));
        System.out.println("cargando");
			root = loader.load();	
            System.out.println("cargado");
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    public void setImagen(Image imagen)
    {

        capturaImagePokemon.setImage(imagen);

    }

}
