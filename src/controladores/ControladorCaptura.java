package src.controladores;

//import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.media.AudioClip;
// import javafx.scene.media.Media;
// import javafx.scene.media.MediaPlayer;
// import javafx.scene.media.MediaView;
import javafx.stage.Stage;
//import src.vistas.*;
import src.modelos.Entrenador;
// import src.modelos.Genero;
// import src.modelos.Movimiento;
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
   // playAudio();
       
    }

   /* public void playAudio()
    {
        AudioClip audio = new AudioClip(this.getClass().getResource("../../rsc/CancionCaptura.mp3").toString());
        audio.play();
    }*/
    

    @FXML
    private void capturar(ActionEvent event) throws SQLException, IOException {
        System.out.println("tirando pokeball");
        Entrenador entrenador1;
        ArrayList<Pokemon> equipo1 = new ArrayList<>();
        ArrayList<Pokemon> equipo2 = new ArrayList<>();


        String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/pokemon";
		Connection con = DriverManager.getConnection(url, usuario, "");
		Statement stmt = con.createStatement();
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
				Pokemon pokemon = new Pokemon(rs2.getString("NOMBRE"), rs2.getInt("VITALIDAD"), rs2.getInt("ATAQUE"), rs2.getInt("DEFENSA"), rs2.getInt("ATK_ESPECIAL"), rs2.getInt("DEF_ESPECIAL"), rs2.getInt("VELOCIDAD"),Tipo.valueOf(rs2.getString("TIPO1")),Tipo.valueOf(rs2.getString("TIPO2")));

                if(rs2.getInt("ID_EQUIPO") == 1)
                    equipo1.add(pokemon);
                else
                    equipo2.add(pokemon);

			}while(rs2.next());

		} catch (SQLException e) {
			e.printStackTrace();
		}
        entrenador1 = new Entrenador(nombreEntrenador, equipo1, equipo1.get(0));
        boolean resultado = entrenador1.capturarPokemon(this.salvaje);

        if(resultado)
        {
            System.out.println("dentro del if");

            //TODO
            // insertar codigo para que se incremente el idpokemon

            
            rs2 = stmt.executeQuery("SELECT MAX(ID_POKEMON) AS MAXIMO FROM pokemon;");
            rs2.next();

            int idPokemon =  rs2.getInt("MAXIMO") + 1;

            String sentencia = "INSERT INTO POKEMON (ID_POKEMON, ID_ENTRENADOR, ID_POKEDEX, MOTE, VITALIDAD, ATAQUE, DEFENSA, ATK_ESPECIAL, DEF_ESPECIAL, VELOCIDAD, ESTAMINA, NIVEL, ID_EQUIPO) VALUES("+ idPokemon
                                +","+ 1
                                +","+ 3
                                +",'" + salvaje.getNombre()
                                +"'," + salvaje.getVitalidadMaxima()
                                +"," + salvaje.getAtaque()
                                +"," + salvaje.getDefensa()
                                +"," + salvaje.getAtaqueEspecial()
                                +"," + salvaje.getDefensaEspecial()
                                +"," + salvaje.getVelocidad()
                                +"," + salvaje.getEstaminaMaxima()
                                +"," + salvaje.getNivel()
                                +"," + 1
                                +")"; 


            Statement statement2 = null;

            System.out.println(sentencia);

            try {
                statement2 = con.createStatement();
                statement2.executeUpdate(sentencia);
                System.out.println("pokemon insertado" + this.salvaje.getNombre());
                Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Pokemon capturado");
		        alert.setHeaderText("Has capturado al pokemon con exito");
		        alert.showAndWait();
                this.huir(event);

            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        
    }

    @FXML
    private void huir(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/MenuPrincipal.fxml"));
			root = loader.load();	
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    public void setPokemon(Pokemon pokemon) {
        this.salvaje = pokemon;
        String direccion = "../../rsc/" +pokemon.getNombre() +"Cara.gif";
        System.out.println(direccion + "a ver loco");

        Image myImage = new Image(getClass().getResourceAsStream(direccion));
        capturaImagePokemon.setImage(myImage);
    }

}